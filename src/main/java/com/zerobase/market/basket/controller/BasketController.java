package com.zerobase.market.basket.controller;

import com.zerobase.market.basket.dto.BasketDto;
import com.zerobase.market.basket.dto.BasketRequest;
import com.zerobase.market.basket.dto.BasketSearch;
import com.zerobase.market.basket.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/")
    public ResponseEntity<?> basketList(Pageable pageable, BasketSearch basketSearch){
        return ResponseEntity.ok(basketService.basketList(pageable, basketSearch));
    }

    @GetMapping("/{basketId}")
    public ResponseEntity<?> viewBasket(@PathVariable Long basketId){
        return ResponseEntity.ok(basketService.viewBasket(basketId));
    }

    @PostMapping("/")
    public ResponseEntity<?> registBasket(BasketDto basketDto){
        return ResponseEntity.ok(basketService.registBasket(basketDto));
    }

    @PostMapping("/{basketId}")
    public ResponseEntity<?> updateBasket(@PathVariable Long basketId, BasketRequest basketRequest){
        return ResponseEntity.ok(basketService.updateBasket(basketId, basketRequest));
    }

    @DeleteMapping("/{baskeetId}")
    public ResponseEntity<?> deleteBasket(@PathVariable Long baskeetId){
        return ResponseEntity.ok(basketService.deleteBasket(baskeetId));
    }

}
