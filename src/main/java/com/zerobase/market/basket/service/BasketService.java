package com.zerobase.market.basket.service;

import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.basket.dto.BasketDto;
import com.zerobase.market.basket.dto.BasketRequest;
import com.zerobase.market.basket.dto.BasketSearch;
import com.zerobase.market.basket.exception.BasketException;
import com.zerobase.market.basket.exception.QuantityExceoption;
import com.zerobase.market.basket.repository.BasketRepository;
import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.domain.Status;
import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.exception.ProductException;
import com.zerobase.market.product.exception.StatusExceoption;
import com.zerobase.market.product.repository.ProductRepository;
import com.zerobase.market.user.domain.User;
import com.zerobase.market.user.exception.UserException;
import com.zerobase.market.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Basket> basketList(Pageable pageable, BasketSearch basketSearch){
        return basketRepository.searchBasket(pageable, basketSearch);
    }

    public BasketDto viewBasket(Long basketId){
        Basket basket = basketRepository.findById(basketId).orElseThrow(() -> new BasketException());
        return BasketDto.from(basket);
    }

    public BasketDto registBasket(BasketDto basketDto){

        User user = userRepository.findById(basketDto.getUserId()).orElseThrow(() -> new UserException());

        Product product = productRepository.findById(basketDto.getProductId()).orElseThrow(() -> new ProductException());

        boolean findBasket = basketRepository.existsById(basketDto.getId());

        if(product.getStatus().equals(Status.UNAVAILABLE)){
            throw new StatusExceoption();
        }

        if(product.getStock() < basketDto.getQuantity()){
            throw new QuantityExceoption();
        }

        if(!findBasket){
            Basket basket = Basket.builder()
                    .quantity(basketDto.getQuantity())
                    .user(user)
                    .product(product)
                    .registDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            return BasketDto.from(basketRepository.registBasket(basket));
        }else{
            throw new BasketException();
        }
    }

    public BasketDto updateBasket(Long basketId, BasketRequest basketRequest){
        Basket basket = basketRepository.findById(basketId).orElseThrow(() -> new BasketException());

        Product product = productRepository.findById(basketRequest.getProductId()).orElseThrow(()-> new ProductException());

        if(product.getStock() < basketRequest.getQuantity()){
            throw new QuantityExceoption();
        }
        basket.updatebasket(basketRequest);
        //재고 - 수량 조회
        product.updateStock(product.getStock()-basketRequest.getQuantity());
        return BasketDto.from(basketRepository.updateBasket(basket));
    }

    public Long deleteBasket(Long baskeetId) {
        Basket basket = basketRepository.findById(baskeetId).orElseThrow(() -> new BasketException());
        return basketRepository.deleteBasket(basket.getId());
    }
}
