package ru.webapps.ElectronicsStore.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;
import ru.webapps.ElectronicsStore.response.RestApiException;

@Service
@AllArgsConstructor
public class MyUserService {
    private MyUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void addUser(MyUser user) {
        if (userRepository.findByName(user.getName()).isPresent()){
            throw new RestApiException("Name is busy");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
