package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.OrderDetails;
import com.spring.henallux.firstSpringProject.model.TranslationProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TranslationProductDAO {
    private TranslationProductRepository translationProductRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationProductDAO(TranslationProductRepository translationProductRepository, ProviderConverter providerConverter){
        this.translationProductRepository = translationProductRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<TranslationProduct> getAll(String locale, int category){
        List<TranslationProductEntity> productEntities = translationProductRepository.findAll();
        ArrayList<TranslationProduct> products =new ArrayList<>();
        for(TranslationProductEntity entity : productEntities){
            if(locale.equals("fr") && entity.getLanguage().getName().equals("Français") && entity.getProduct().getCategory().getId()==category) {
                products.add(providerConverter.translationProductEntityToTranslationProductModel(entity));
            }
            else{
                if(locale.equals("en") && entity.getLanguage().getName().equals("English") && entity.getProduct().getCategory().getId()==category)
                    products.add(providerConverter.translationProductEntityToTranslationProductModel(entity));
            }
        }
        return products;
    }

    public TranslationProduct getById (Integer id){
        TranslationProductEntity productEntity = translationProductRepository.findOne(id);
        return providerConverter.translationProductEntityToTranslationProductModel(productEntity);
    }

    public ArrayList<TranslationProduct> getBestSales(ArrayList<OrderDetails> orderDetails, String locale){
        List<TranslationProductEntity> productEntities = translationProductRepository.findAll();
        ArrayList<TranslationProduct> products = new ArrayList<>();
        for(OrderDetails orderDetail : orderDetails){
            for(TranslationProductEntity entity : productEntities){
                if(locale.equals("en") && entity.getLanguage().getName().equals("English")
                        && entity.getProduct().getId().equals(orderDetail.getProduct().getId())){
                    products.add(providerConverter.translationProductEntityToTranslationProductModel(entity));
                }
                else{
                    if(locale.equals("fr") && entity.getLanguage().getName().equals("Français") &&
                            entity.getProduct().getId().equals(orderDetail.getProduct().getId()))
                        products.add(providerConverter.translationProductEntityToTranslationProductModel(entity));
                }
            }
        }
        return products;
    }

}