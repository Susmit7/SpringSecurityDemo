package com.susmit.bankapp.config;

import com.susmit.bankapp.entity.UserLogin;
import com.susmit.bankapp.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserLoginConfig implements UserDetailsService {
    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserLogin> userList=userLoginRepository.findByUsername(username);
        if(userList.isEmpty()){
            throw new UsernameNotFoundException("User does not exist"+username);
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userList.get(0).getPermissions()));

        return new User(userList.get(0).getUsername(),userList.get(0).getPassword(),authorities);
    }
}
