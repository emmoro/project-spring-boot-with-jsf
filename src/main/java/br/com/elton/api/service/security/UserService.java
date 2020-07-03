package br.com.elton.api.service.security;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.elton.api.entity.User;
import br.com.elton.api.entity.UserRole;
import br.com.elton.api.repository.UserRepository;
import br.com.elton.api.repository.UserRoleRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    
    private UserRoleRepository userRoleRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
    				   UserRoleRepository userRoleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        UserRole userRole = userRoleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }
    
}
