package com.zerobase.market.basket.controller;

import com.zerobase.market.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

}
