package ru.webapps.ElectronicsStore.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.webapps.ElectronicsStore.enums.Role;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;
//import ru.webapps.ElectronicsStore.response.RestApiException;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(MyUser user){
        String email = user.getEmail();
        if (userRepository.findByEmail(email).isPresent()){
            //throw new RestApiException("Email is busy");
            return false;
        }
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        //user.setRoles(Role.ROLE_USER); //собственная реализация
        userRepository.save(user);
        System.out.println("User is saved, email: " + email);
        return true;
    }

}
