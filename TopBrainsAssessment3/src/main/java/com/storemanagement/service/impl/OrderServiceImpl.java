package com.storemanagement.service.impl;

import com.storemanagement.dto.request.CartItemRequest;
import com.storemanagement.entity.Order;
import com.storemanagement.entity.OrderHistory;
import com.storemanagement.entity.Product;
import com.storemanagement.repository.ProductRepository;
import com.storemanagement.repository.OrderRepository;
import com.storemanagement.repository.OrderHistoryRepository;
import com.storemanagement.service.CartService;
import com.storemanagement.service.OrderService;
import com.storemanagement.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartService cartService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderHistoryRepository orderHistoryRepository;

    @Override
    public String generateBill(){

        List<CartItemRequest> cartItems = cartService.getCartItems();

        double total = 0;

        Order order = new Order();

        order = orderRepository.save(order);

        for(var item: cartItems){

            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if(product.getQuantity() < item.getQuantity()){
                throw new RuntimeException("Insufficient stock for " + product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);

            double price = product.getPrice()*item.getQuantity();
            total += price;

            OrderHistory history = new OrderHistory();
            history.setOrderId(order.getId());
            history.setProductId(product.getId());
            history.setQuantity(item.getQuantity());
            history.setPrice(price);

            orderHistoryRepository.save(history);
            }

        double gst = total*0.18;
        double finalAmount = total+gst;

        order.setTotalPrice(total);
        order.setTotalPriceWithGst(finalAmount);

        orderRepository.save(order);

        cartService.clearCart();

        return "Bill generated. Total: " + finalAmount;
    }
}
