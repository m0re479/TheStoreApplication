package ru.webapps.ElectronicsStore.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.webapps.ElectronicsStore.enums.Role;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(unique = true, name = "Email")
    private String email;
    @Column(name = "Password", length = 1000)
    private String password;
    @Column(name = "Active")
    private boolean active;
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    //@CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = user_id))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    @Column(name = "Date_Of_Create")
    private LocalDateTime dateOfCreate;

    @PrePersist
    private void initDate() {
        dateOfCreate = LocalDateTime.now();
    }

//    public void setRoles(Set<Role> roles) {
//        this.roles.addAll(roles);
//    }
//    public void setRoles(Role role) {
//        this.roles.add(role);
//    }
}
