package ru.webapps.ElectronicsStore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ru.webapps.ElectronicsStore.models.MyUser;

@RepositoryRestResource
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail (String email);
}
