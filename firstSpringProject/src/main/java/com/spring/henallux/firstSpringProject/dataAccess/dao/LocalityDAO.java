package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LocalityEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LocalityRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LocalityDAO {
    private LocalityRepository localityRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public LocalityDAO(LocalityRepository localityRepository,ProviderConverter providerConverter){
        this.localityRepository=localityRepository;
        this.providerConverter=providerConverter;
    }

    public ArrayList<Locality> getAllLocality(){
        List<LocalityEntity> localityEntities = localityRepository.findAll();
        ArrayList<Locality> localities= new ArrayList<>();
        for(LocalityEntity entity : localityEntities){
            localities.add(providerConverter.localityEntityToLocalityModel(entity));
        }
        return localities;
    }
}
