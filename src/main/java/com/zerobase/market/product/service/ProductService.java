package com.zerobase.market.product.service;

import com.zerobase.market.product.repository.ProductRepository;
import com.zerobase.market.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    //boolean authCheck = userRepository.findAllByRoles(user.getUsername()).stream().anyMatch(user1 -> user1.equals("ADMIN"));
}
