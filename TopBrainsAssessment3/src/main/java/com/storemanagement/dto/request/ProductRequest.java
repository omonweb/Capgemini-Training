package com.storemanagement.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    @Size(max = 255)
    private String name;

    @NotBlank(message = "Product name is required")
    private String category;

    @NotBlank(message = "Product name is required")
    private String company;

    @Min(value = 0, message = "Quantity can not be negative")
    private int quantity;

    @Positive(message = "Price  must be greater than 0")
    private double price;
}
