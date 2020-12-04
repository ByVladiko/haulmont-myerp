package com.company.myerp.web.screens.store;

import com.company.myerp.config.StoreConfig;
import com.company.myerp.entity.Store;
import com.company.myerp.entity.StoreProduct;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;

@UiController("myerp_Store.edit")
@UiDescriptor("store-edit.xml")
@EditedEntityContainer("storeDc")
@LoadDataBeforeShow
public class StoreEdit extends StandardEditor<Store> {

    @Inject
    private CollectionPropertyContainer<StoreProduct> productsStoreDc;
    @Inject
    private Table<StoreProduct> productsTable;
    @Inject
    private DataContext dataContext;
    @Inject
    protected StoreConfig storeConfig;


    @Subscribe(id = "productsStoreDc", target = Target.DATA_CONTAINER)
    public void onProductsDcCollectionChange(CollectionContainer.CollectionChangeEvent<StoreProduct> event) {
        List<StoreProduct> changesStoreProducts = (List<StoreProduct>) event.getChanges();
        List<StoreProduct> storeProductList = productsStoreDc.getMutableItems();

        if (event.getChangeType().equals(CollectionChangeType.ADD_ITEMS)) {
            StoreProduct changeItem = changesStoreProducts.get(0);
            sumMatchingItems(storeProductList, changeItem);
        }
    }

    private void sumMatchingItems(List<StoreProduct> storeProductList, StoreProduct changeItem) {
        StoreProduct coincidenceStoreProduct = storeProductList.stream()
                .filter(item -> item.getProduct().equals(changeItem.getProduct()) && !item.equals(changeItem))
                .findFirst().orElse(null);
        if (coincidenceStoreProduct != null) {
            coincidenceStoreProduct.setCount(coincidenceStoreProduct.getCount() + changeItem.getCount());
            coincidenceStoreProduct.setPrice(changeItem.getPrice());

            productsStoreDc.replaceItem(coincidenceStoreProduct);
            storeProductList.remove(changeItem);
            dataContext.remove(changeItem);
        }
    }

    @Subscribe
    public void onInit(InitEvent event) {
        int minimalNumberProductsStoreItems = storeConfig.getMinimalNumberProductsStoreItems();
        productsTable.setStyleProvider((storeProduct, property) -> {
            if (storeProduct.getCount() < minimalNumberProductsStoreItems) {
                return "not-enough-items";
            }
            return null;
        });
    }
}