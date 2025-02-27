package dev.rajnish.EcomProductService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.dto.CartResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductToCartDTO;
import dev.rajnish.EcomProductService.dto.RemoveProductFromCartRequestDTO;
import dev.rajnish.EcomProductService.dto.UpdateCartProductQuantityDTO;
import dev.rajnish.EcomProductService.entity.Cart;
import dev.rajnish.EcomProductService.entity.CartProduct;
import dev.rajnish.EcomProductService.entity.Product;
import dev.rajnish.EcomProductService.mapper.EntityToDTOMapper;
import dev.rajnish.EcomProductService.repository.CartProductRepository;
import dev.rajnish.EcomProductService.repository.CartRepository;
import dev.rajnish.EcomProductService.repository.ProductRepository;
import dev.rajnish.EcomProductService.service.interfaces.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartProductRepository cartProductRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public CartResponseDTO addNewCart(String name) // This method is only for development purpose. Actual functionality is when account is created, cart must automatically created
    {

        Cart cart = new Cart();
        cart.setCartName(name);
        Cart savedCart = cartRepository.save(cart);
        
        return EntityToDTOMapper.cartToDTOMapper(savedCart);        
    }

    @Override
    public CartResponseDTO getCartDetailsById(UUID cartId) {
        Cart savedCart = cartRepository.findById(cartId).get();

        return EntityToDTOMapper.cartToDTOMapper(savedCart);
    }

    @Override
    public boolean addProductToCart(ProductToCartDTO productToCartDTO) {

        Cart savedCart = cartRepository.findById(productToCartDTO.getCartId()).get();
        CartProduct cartProduct = new CartProduct();
        Product savedProduct = productRepository.findById(productToCartDTO.getProductId()).get();
        cartProduct.setProduct(savedProduct);
        cartProduct.setQuantity(productToCartDTO.getProductQuantity());

        CartProduct savedCartProduct = cartProductRepository.save(cartProduct);
        List<CartProduct> cartProducts = savedCart.getCartProducts();
        if(cartProducts==null)
        {
            cartProducts = new ArrayList<>();
        }

        cartProducts.add(savedCartProduct);
        cartRepository.save(savedCart);

        return true;
    }

    @Override
    public boolean removeProductFromCart(RemoveProductFromCartRequestDTO removeProductFromCartRequestDTO) {

        Cart savedCart = cartRepository.findById(removeProductFromCartRequestDTO.getCartId()).get();
        CartProduct savedCartProduct = cartProductRepository.findById(removeProductFromCartRequestDTO.getCartProductId()).get();

        List<CartProduct> savedCartProducts = savedCart.getCartProducts();
        savedCartProducts.remove(savedCartProduct);
        savedCart.setCartProducts(savedCartProducts);
        cartRepository.save(savedCart);
        cartProductRepository.delete(savedCartProduct);
        return true;
    }

    @Override
    public boolean updateCartProductQuantity(UpdateCartProductQuantityDTO updateCartProductQuantityDTO) {
        CartProduct savedCartProduct = cartProductRepository.findById(updateCartProductQuantityDTO.getCartProductId()).get();
        savedCartProduct.setQuantity(updateCartProductQuantityDTO.getQuantity());
        cartProductRepository.save(savedCartProduct);

        return true;
    }

    
    
}
