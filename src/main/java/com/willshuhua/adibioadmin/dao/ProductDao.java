package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.product.Product;
import com.willshuhua.adibioadmin.entity.product.ProductGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    List<ProductGroup> selectAllProductGroup();

    void updateProductGroup(ProductGroup productGroup);

    void addProductGroup(ProductGroup productGroup);

    void deleteProductGroup(@Param("product_groupid")String productGroupId);

    List<Product> selectAGroupProducts(@Param("product_groupid") String productGroupId);

    void updateProduct(Product product);
}
