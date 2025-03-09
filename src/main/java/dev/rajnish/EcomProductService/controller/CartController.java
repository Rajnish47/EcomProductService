package dev.rajnish.EcomProductService.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.EcomProductService.dto.CreateCartRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductToCartDTO;
import dev.rajnish.EcomProductService.dto.RemoveProductFromCartRequestDTO;
import dev.rajnish.EcomProductService.dto.UpdateCartProductQuantityDTO;
import dev.rajnish.EcomProductService.service.interfaces.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    //All controller methods require user permission to access

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity addNewCart(@RequestBody CreateCartRequestDTO createCartRequestDTO)
    {
        return ResponseEntity.ok(cartService.addNewCart(createCartRequestDTO.getCartName(),createCartRequestDTO.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCartByUserId(@PathVariable("id") UUID userId,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        return ResponseEntity.ok(cartService.getCartDetailsById(userId,token));
    }

    @PostMapping("/product/add")
    public ResponseEntity addProductToCart(@RequestBody ProductToCartDTO productToCartDTO,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        boolean op = cartService.addProductToCart(productToCartDTO,token);
        if(op==false)
        {
            return ResponseEntity.ok("Unable to add product to cart");
        }

        return ResponseEntity.ok("Product added to cart");
    }
    
    @PostMapping("/product/update")
    public ResponseEntity updateProductQuantity(@RequestBody UpdateCartProductQuantityDTO updateCartProductQuantityDTO,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        boolean op = cartService.updateCartProductQuantity(updateCartProductQuantityDTO,token);

        if(op==false)
        {
            return ResponseEntity.ok("Unable to update quantity");
        }

        return ResponseEntity.ok("Quantity updated");
    }

    @DeleteMapping("/product/remove")
    public ResponseEntity removeProductFromCart(@RequestBody RemoveProductFromCartRequestDTO removeProductFromCartRequestDTO,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        boolean op = cartService.removeProductFromCart(removeProductFromCartRequestDTO,token);
        if(op==false)
        {
            return ResponseEntity.ok("Unable to remove product from cart");
        }

        return ResponseEntity.ok("Product removed from cart");
    }
    
}
