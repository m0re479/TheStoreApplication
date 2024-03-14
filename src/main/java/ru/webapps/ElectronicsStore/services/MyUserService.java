package ru.webapps.ElectronicsStore.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;

@Service
@AllArgsConstructor
public class MyUserService {
    private MyUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
