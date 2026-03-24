package com.storemanagement.service;

import com.storemanagement.dto.request.ProductRequest;
import com.storemanagement.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequest request);

    Product updateProduct(int id, ProductRequest request);

    List<Product> getAllProducts();

    List<Product> searchProducts(String keyword);

    void deleteProduct(int id);
}
