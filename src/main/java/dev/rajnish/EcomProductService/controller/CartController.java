package dev.rajnish.EcomProductService.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.EcomProductService.dto.ProductToCartDTO;
import dev.rajnish.EcomProductService.dto.RemoveProductFromCartRequestDTO;
import dev.rajnish.EcomProductService.dto.UpdateCartProductQuantityDTO;
import dev.rajnish.EcomProductService.service.interfaces.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{name}")
    public ResponseEntity addNewCart(@PathVariable("name") String cartName)
    {
        return ResponseEntity.ok(cartService.addNewCart(cartName));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCartById(@PathVariable("id") UUID cartId)
    {
        return ResponseEntity.ok(cartService.getCartDetailsById(cartId));
    }

    @PostMapping("/product/add")
    public ResponseEntity addProductToCart(@RequestBody ProductToCartDTO productToCartDTO)
    {
        boolean op = cartService.addProductToCart(productToCartDTO);
        if(op==false)
        {
            return ResponseEntity.ok("Unable to add product to cart");
        }

        return ResponseEntity.ok("Product added to cart");
    }
    
    @PostMapping("/product/update")
    public ResponseEntity updateProductQuantity(@RequestBody UpdateCartProductQuantityDTO updateCartProductQuantityDTO)
    {
        boolean op = cartService.updateCartProductQuantity(updateCartProductQuantityDTO);

        if(op==false)
        {
            return ResponseEntity.ok("Unable to update quantity");
        }

        return ResponseEntity.ok("Quantity updated");
    }

    @DeleteMapping("/product/remove")
    public ResponseEntity removeProductFromCart(@RequestBody RemoveProductFromCartRequestDTO removeProductFromCartRequestDTO)
    {
        boolean op = cartService.removeProductFromCart(removeProductFromCartRequestDTO);
        if(op==false)
        {
            return ResponseEntity.ok("Unable to remove product from cart");
        }

        return ResponseEntity.ok("Product removed from cart");
    }
    
}
