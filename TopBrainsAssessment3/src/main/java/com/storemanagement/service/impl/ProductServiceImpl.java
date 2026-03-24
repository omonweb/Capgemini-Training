package com.storemanagement.service.impl;

import com.storemanagement.dto.request.ProductRequest;
import com.storemanagement.entity.Product;
import com.storemanagement.repository.ProductRepository;
import com.storemanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequest request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setCompany(request.getCompany());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setCompany(request.getCompany());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository
                .findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrCompanyContainingIgnoreCase(
                        keyword, keyword, keyword
                );
    }


    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
