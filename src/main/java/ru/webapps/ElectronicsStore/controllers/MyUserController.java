package ru.webapps.ElectronicsStore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;
import ru.webapps.ElectronicsStore.services.MyUserService;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MyUserController {
    private MyUserRepository userRepository;
	private MyUserService userService;

    @GetMapping("/all_users")
    List<MyUser> allUsers(){
        return this.userRepository.findAll();
    }

	@PostMapping("/new_user")
	public String addUser(@RequestBody MyUser user) {
		userService.addUser(user);
		return "User is saved";
	}

}

// import java.util.Arrays;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// @Bean
	// CommandLineRunner runner(MyUserRepository ur){
	// 	return args->{
	// 		Arrays.asList("MM, AA, WW, QQ".split(","))
	// 		.forEach(n->ur.save(new MyUser(n)));
	// 		ur.findAll().forEach(System.out::println);
	// 	};
	// }