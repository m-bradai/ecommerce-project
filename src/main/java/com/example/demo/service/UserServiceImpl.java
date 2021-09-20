package com.example.demo.service;

import com.example.demo.pojos.Role;
import com.example.demo.pojos.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final PasswordEncoder passwordEncoder;

    /*@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);

        if(user == null) {
            log.error("User with name {} not found in database.", s);
            throw new UsernameNotFoundException("User name not found in database.");
        }

        log.info("User found in database.");

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add( new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }*/


    @Override
    public User saveUser(User user) {
        log.info("Saving user {} to the database.",user.getUserName());
        log.info("password = ",user.getPassword());
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to the database.", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {} to the database.",roleName,userName);
        User user  = userRepository.findByUserName(userName);
        Role role = roleRepository.findByName(roleName);

        if( user!=null && user.getRoles()!=null && !user.getRoles().contains(role)) {
            user.getRoles().add(role);
        } else{
          throw new IllegalStateException("The role " + roleName + "already defined for user " + userName);
        }

    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {} from the database.",userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users from the database.");
        return userRepository.findAll();
    }
}
