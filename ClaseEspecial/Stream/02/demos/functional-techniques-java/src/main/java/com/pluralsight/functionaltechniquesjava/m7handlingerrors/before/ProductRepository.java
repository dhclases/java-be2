package com.pluralsight.functionaltechniquesjava.m7handlingerrors.before;

import com.pluralsight.functionaltechniquesjava.m7handlingerrors.Product;

public class ProductRepository {
    public Product getProductById(Long id) {
        // Get product from the database
        return new Product(id);
    }
}
