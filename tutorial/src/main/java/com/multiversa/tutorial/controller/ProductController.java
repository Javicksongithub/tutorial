package com.multiversa.tutorial.controller;



import com.multiversa.tutorial.model.Product;
import com.multiversa.tutorial.service.ProductService; // vai dar erro por enquanto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> saveproduct(@RequestBody Product product) {
        Product savedProduct = productService.saveproduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productService.getproduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getproducts();
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateproduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productService.deleteproduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products-by-name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.getproductsByName(name);
    }
}

