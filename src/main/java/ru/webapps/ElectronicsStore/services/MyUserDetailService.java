package ru.webapps.ElectronicsStore.services;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.webapps.ElectronicsStore.config.MyUserDetails;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private final MyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<MyUser> user = userRepository.findByEmail(email);
       return user.map(MyUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(email + " not found"));
    }
}
