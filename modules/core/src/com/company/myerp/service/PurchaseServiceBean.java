package com.company.myerp.service;

import com.company.myerp.entity.PurchaseProduct;
import com.company.myerp.service.exception.PurchaseServiceException;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(PurchaseService.NAME)
public class PurchaseServiceBean implements PurchaseService {

    @Inject
    private Persistence persistence;

    @Override
    public void WriteOutStoreProductsOfPurchase(List<PurchaseProduct> purchaseProducts) throws PurchaseServiceException {
        try (Transaction tx = persistence.createTransaction()) {
            for (PurchaseProduct purchaseProduct : purchaseProducts) {
                if (!updateCountStoreProduct(persistence.getEntityManager(), purchaseProduct)) {
                    String productName = purchaseProduct.getProduct().getName();
                    String message = String.format("Error when buying a product with a name %s. " +
                            "Perhaps the quantity of this product is insufficient.", productName);
                    throw new PurchaseServiceException(message);
                }
            }
            tx.commit();
        }
    }

    private boolean updateCountStoreProduct(EntityManager em, PurchaseProduct purchaseProduct) {
        String query = "update myerp_StoreProduct msp " +
                "set msp.count = msp.count - :count " +
                "where msp.store = :store " +
                "and msp.product = :product " +
                "and msp.count >= :count";

        int countUpdated = em.createQuery(query)
                .setParameter("store", purchaseProduct.getPurchase().getStore())
                .setParameter("product", purchaseProduct.getProduct())
                .setParameter("count", purchaseProduct.getCount())
                .executeUpdate();

        return countUpdated == 1;
    }
}