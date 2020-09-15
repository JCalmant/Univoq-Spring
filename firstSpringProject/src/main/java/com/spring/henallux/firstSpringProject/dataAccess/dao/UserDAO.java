package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO {

    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public User save(User user) {
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    public User getUser(String name){
        UserEntity userEntity = userRepository.findByName(name);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    public Boolean connectionValidation(User user){
        UserEntity userEntity = userRepository.findByName(user.getName());
        if(userEntity==null)return false;
        return new BCryptPasswordEncoder().matches(user.getPassword(),userEntity.getPassword());
    }

    public ArrayList<User> getAllUsers(){
        List<UserEntity> userEntities = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities)
        {User user = providerConverter.userEntityToUserModel(userEntity);
            users.add(user);}
        return users;
    }

}
