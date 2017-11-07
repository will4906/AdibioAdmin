package com.willshuhua.adibioadmin.service;

import com.willshuhua.adibioadmin.entity.product.ProductGroup;

import java.util.List;

public interface ProductService {

    List<ProductGroup> selectAllProductGroup();

    void updateProductGroup(ProductGroup productGroup);

    void addProductGroup(ProductGroup productGroup);

    void deleteProductGroup(String productGroupId);
}
