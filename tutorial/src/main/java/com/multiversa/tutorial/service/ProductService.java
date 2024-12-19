package com.multiversa.tutorial.service;



import com.multiversa.tutorial.model.Product;
import com.multiversa.tutorial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

   @Autowired
   private ProductRepository productrepository;

   // Método para salvar um produto no banco de dados
   public Product saveproduct(Product product) {
       return productrepository.save(product);
   }

   // Método para obter um produto específico pelo seu ID
   public Product getproduct(long productId) {
       return productrepository.findById(productId)
           .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
   }

   // Método para obter todos os produtos no banco de dados
   public List<Product> getproducts() {
       return productrepository.findAll();
   }

   // Método para atualizar um produto existente no banco de dados
   public Product updateproduct(long productId, Product product) {
       Product existingproduct = productrepository.findById(productId)
           .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       existingproduct.setProductName(product.getProductName());
       existingproduct.setColor(product.getColor());
       existingproduct.setPrice(product.getPrice());
       productrepository.save(existingproduct);
       return existingproduct;
   }

   // Método para excluir um produto existente no banco de dados
   public Product deleteproduct(long productId) {
       Product existingproduct = productrepository.findById(productId)
           .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
       productrepository.deleteById(productId);
       return existingproduct;
   }

   // Método para obter produtos pelo nome usando uma consulta personalizada
   public List<Product> getproductsByName(String productName) {
       return productrepository.getproductsByName(productName);
   }
}
