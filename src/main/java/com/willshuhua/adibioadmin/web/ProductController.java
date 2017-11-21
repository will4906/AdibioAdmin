package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.entity.product.Product;
import com.willshuhua.adibioadmin.entity.product.ProductDiscount;
import com.willshuhua.adibioadmin.entity.product.ProductGroup;
import com.willshuhua.adibioadmin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product_groups", method = RequestMethod.GET)
    public Object productGroup(){
        List<ProductGroup> groupList = productService.selectAllProductGroup();
        return new Result(Result.OK, groupList);
    }

    @RequestMapping(value = "/update_product_group", method = RequestMethod.POST)
    public Object updateProductGroup(@ModelAttribute("productGroup") ProductGroup productGroup){
        productService.updateProductGroup(productGroup);
        return new Result();
    }

    @RequestMapping(value = "/add_product_group", method = RequestMethod.POST)
    public Object addProductGroup(@ModelAttribute("productGroup") ProductGroup productGroup){
        productGroup.setProduct_groupid(UUID.randomUUID().toString());
        productService.addProductGroup(productGroup);
        return new Result();
    }

    @RequestMapping(value = "/delete_product_group", method = RequestMethod.POST)
    public Object deleteProductGroup(@RequestParam("product_groupid") String productGroupId){
        productService.deleteProductGroup(productGroupId);
        return new Result();
    }

    @RequestMapping(value = "/product_list", method = RequestMethod.GET)
    public Object productList(@RequestParam("product_groupid")String productGroupId){
        List<Product> productList = productService.selectAGroupProducts(productGroupId);
        return new Result(Result.OK, productList);
    }

    @RequestMapping(value = "/product_discount_list", method = RequestMethod.GET)
    public Object productDiscountList(@RequestParam("product_id")String productId){
        return new Result(Result.OK, productService.selectAProductsProductDiscount(productId));
    }

    @RequestMapping(value = "/update_product",method = RequestMethod.POST)
    public Object updateProduct(@RequestBody Product product){
        if (productService.selectProduct(product.getProduct_id()) == null){
            return new Result(Result.ERR, "Can't find the product");
        }
        productService.updateProduct(product);
        return new Result(Result.OK, product);
    }

    @RequestMapping(value = "/update_product_discount", method = RequestMethod.POST)
    public Object updateProductDiscount(@RequestBody ProductDiscount productDiscount){
        productService.updateProductDiscount(productDiscount);
        return new Result();
    }
}
