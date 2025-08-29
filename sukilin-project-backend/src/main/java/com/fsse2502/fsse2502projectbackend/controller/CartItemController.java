package com.fsse2502.fsse2502projectbackend.controller;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.CartItemResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.dto.response.CartItemResponseDto;
import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.service.CartItemService;
import com.fsse2502.fsse2502projectbackend.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    public void putCartItem(JwtAuthenticationToken token,
                            @PathVariable Integer pid,
                            @PathVariable @Positive Integer quantity) {
        FirebaseUserData firebaseUserData = JwtUtil.toFirebaseUserData(token);

        cartItemService.putCartItem(firebaseUserData, pid, quantity);
    }

    @GetMapping
    public List<CartItemResponseDto> getCartItem(JwtAuthenticationToken jwt) {
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();

        for (CartItemResponseData cartItemResponseData : cartItemService.getCartItemList(JwtUtil.getFirebaseUserData(jwt))) {
            cartItemResponseDtoList.add(new CartItemResponseDto(cartItemResponseData));
        }
        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCartItem(JwtAuthenticationToken jwt,
                                              @PathVariable int pid,
                                              @PathVariable int quantity){
        return new CartItemResponseDto(
                cartItemService.updateItem(pid,quantity,JwtUtil.getFirebaseUserData(jwt))
        );
    }

    @DeleteMapping("/{pid}")
    public void deleteCartItem(@PathVariable int pid,
                               JwtAuthenticationToken jwt){
        cartItemService.deleteItem(pid, JwtUtil.getFirebaseUserData(jwt));
    }

}