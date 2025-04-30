package org.example.shopkart.Product;

import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    private  List<Product> productList;

    public ProductService() {
        productList = new LinkedList<>();
    }

    // Create
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    // Read
    public List<Product> getProductList() {
        return productList;
    }

    //Read -SingleProduct
    public Product getProduct(long id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update
    public Product updatePrice(Product product) {
        productList.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst()
                .ifPresent(p -> p.setPrice(product.getPrice()));
        return product;
    }


    // Delete

public boolean deleteProduct(Product product) {
    productList.remove(product);
    return true;
    }
}
