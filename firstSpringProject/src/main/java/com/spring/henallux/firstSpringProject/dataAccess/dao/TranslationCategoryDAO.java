package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationCategoryRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.TranslationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TranslationCategoryDAO {
    private TranslationCategoryRepository translationCategoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationCategoryDAO(TranslationCategoryRepository translationCategoryRepository, ProviderConverter providerConverter){
        this.translationCategoryRepository = translationCategoryRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<TranslationCategory> getAllCategory(String locale){
        List<TranslationCategoryEntity> categoryEntities = translationCategoryRepository.findAll();
        ArrayList<TranslationCategory> categories= new ArrayList<>();
        for(TranslationCategoryEntity entity : categoryEntities){
            if(locale.equals("fr") && entity.getLanguage().getName().equals("Français")){
                categories.add(providerConverter.translationCategoryEntityToTranslationCategoryModel(entity));
            }
            else{
                if(locale.equals("en") && entity.getLanguage().getName().equals("English"))
                    categories.add(providerConverter.translationCategoryEntityToTranslationCategoryModel(entity));
            }
        }
        return categories;
    }
}