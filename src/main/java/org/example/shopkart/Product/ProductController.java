package org.example.shopkart.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Common base path
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create - POST
    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }

    // Read - GET
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProductList(); // ✅ Fixed method name
    }

    //Read     //Read
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    // Update - put

    @PutMapping("/products")
    public Product updatePrice(@RequestBody Product product) {
        return productService.updatePrice(product);

    }

    // Delete
    @DeleteMapping("/products")
   public void deleteProduct(Product product) {
        productService.deleteProduct(product);


    }
    //Request - HTTP Method & URl
     //Response - HTTP Status & Response Key
}

