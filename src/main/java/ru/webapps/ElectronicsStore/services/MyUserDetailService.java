package ru.webapps.ElectronicsStore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.webapps.ElectronicsStore.config.MyUserDetails;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<MyUser> user = userRepository.findByName(username);
       return user.map(MyUserDetails::new)
       .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
    }

}
