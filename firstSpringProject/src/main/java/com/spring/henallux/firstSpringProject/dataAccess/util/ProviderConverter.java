package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class ProviderConverter {


    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user){
        return mapper.map(user,UserEntity.class);
    }

    public User userEntityToUserModel(UserEntity userEntity){
        return mapper.map(userEntity,User.class);
    }

    public LocalityEntity localityModelToLocalityEntity(Locality locality){
        return mapper.map(locality,LocalityEntity.class);
    }

    public Locality localityEntityToLocalityModel(LocalityEntity localityEntity){
        return mapper.map(localityEntity,Locality.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order){
        return mapper.map(order,OrderEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        return mapper.map(orderEntity,Order.class);
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        return mapper.map(category,CategoryEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        return mapper.map(categoryEntity,Category.class);
    }

    public LanguageEntity languageModelToLanguageEntity(Language language){
        return mapper.map(language,LanguageEntity.class);
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
        return mapper.map(languageEntity,Language.class);
    }

    public ProductEntity productModelToProductEntity(Product product){
        return mapper.map(product,ProductEntity.class);
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        return mapper.map(productEntity,Product.class);
    }

    public OrderDetailsEntity orderDetailsModelToOrderDetailsEntity(OrderDetails orderDetails){
        return mapper.map(orderDetails,OrderDetailsEntity.class);
    }

    public OrderDetails orderDetailsEntityToOrderDetailsModel(OrderDetailsEntity orderDetailsEntity){
        return mapper.map(orderDetailsEntity,OrderDetails.class);
    }

    public TranslationProductEntity translationProductModelToTranslationProductEntity(TranslationProduct translationProduct){
        return mapper.map(translationProduct,TranslationProductEntity.class);
    }

    public TranslationProduct translationProductEntityToTranslationProductModel(TranslationProductEntity translationProductEntity){
        return mapper.map(translationProductEntity,TranslationProduct.class);
    }

    public TranslationCategory translationCategoryEntityToTranslationCategoryModel(TranslationCategoryEntity translationProductEntity){
        return mapper.map(translationProductEntity,TranslationCategory.class);
    }

    public TranslationCategoryEntity translationCategoryModelToTranslationCategoryEntity(TranslationCategory translationCategory){
        return mapper.map(translationCategory,TranslationCategoryEntity.class);
    }


    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Mapper getMapper() {
        return mapper;
    }

}