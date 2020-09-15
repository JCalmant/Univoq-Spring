package com.spring.henallux.firstSpringProject;

import com.spring.henallux.firstSpringProject.dataAccess.dao.LocalityDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.entity.LocalityEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LocalityRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Locality;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestComponentMock {

    private LocalityDAO localityDAO;

    @InjectMocks
    private ProviderConverter providerConverter;

    @Mock
    private LocalityRepository localityRepository;

    @Before
    public void setUp() throws Exception {
        localityDAO = new LocalityDAO(localityRepository, providerConverter);
    }

    @Test
    public void getAllLocalityTest()
    {
        ArrayList<LocalityEntity> mockedLocalityEntities = new ArrayList<>();
        LocalityEntity loc1 = new LocalityEntity("Anvers", 2000);
        LocalityEntity loc2 = new LocalityEntity("Arlon", 6700);
        mockedLocalityEntities.add(loc1);
        mockedLocalityEntities.add(loc2);

        when(localityRepository.findAll()).thenReturn(mockedLocalityEntities);
        ArrayList<Locality> results = new ArrayList<>();
        results.add(providerConverter.localityEntityToLocalityModel(loc1));
        results.add(providerConverter.localityEntityToLocalityModel(loc2));

        assertThat(localityDAO.getAllLocality()).isEqualTo(results);

    }

}
