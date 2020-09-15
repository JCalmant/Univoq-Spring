package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO {

    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Product> getAll(){
        List<ProductEntity> productEntities = productRepository.findAll();
        ArrayList<Product> products =new ArrayList<>();
        for(ProductEntity entity : productEntities){
            products.add(providerConverter.productEntityToProductModel(entity));
        }
        return products;
    }

    public Product getProductById(int id){
        ProductEntity productEntity = productRepository.findById(id);
        return providerConverter.productEntityToProductModel(productEntity);
    }

}