package com.willshuhua.adibioadmin.service.impl;

import com.willshuhua.adibioadmin.dao.ProductDao;
import com.willshuhua.adibioadmin.entity.product.Product;
import com.willshuhua.adibioadmin.entity.product.ProductGroup;
import com.willshuhua.adibioadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductGroup> selectAllProductGroup() {
        return productDao.selectAllProductGroup();
    }

    @Override
    public void updateProductGroup(ProductGroup productGroup) {
        productDao.updateProductGroup(productGroup);
    }

    @Override
    public void addProductGroup(ProductGroup productGroup) {
        productDao.addProductGroup(productGroup);
    }

    @Override
    public void deleteProductGroup(String productGroupId) {
        productDao.deleteProductGroup(productGroupId);
    }

    @Override
    public List<Product> selectAGroupProducts(String productGroupId) {
        return productDao.selectAGroupProducts(productGroupId);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
