package com.storemanagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CartItemRequest {

    @NotNull(message = "Product id required")
    private int productId;

    @Min(value = 0, message = "Quantity can not be negative")
    private int quantity;
}
