package ru.webapps.ElectronicsStore.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ru.webapps.ElectronicsStore.models.MyUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private final MyUser user;

    public MyUserDetails(MyUser User){
        this.user = User;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //учётные данные пользователя действительны (срок не истёк)

    @Override
    public boolean isAccountNonLocked() {
        return true;
    } //незаблокирован ли пользователь

    @Override
    public boolean isCredentialsNonExpired() { 
        return true;
    } //если не истёк срок действия пароля - true

    @Override
    public boolean isEnabled() {
        return true;
    } //включён ли пользователь
}
