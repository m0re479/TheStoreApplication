package ru.webapps.ElectronicsStore.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.models.Product;
import ru.webapps.ElectronicsStore.repository.MyUserRepository;
import ru.webapps.ElectronicsStore.services.MyUserService;

@Controller
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class MyUserController {
	@Autowired
    private MyUserRepository userRepository;
	private MyUserService userService;

    @GetMapping("/all_users")
    List<MyUser> allUsers(Model model){
		return this.userRepository.findAll();
    }

	@PostMapping("/signUp")
	public String addUser(Model model) {
		//userService.addUser(user);
		return "signUp";
	}

//	@PostMapping("/userSignUp")
//	public String dataToDB(@ModelAttribute("User") MyUser formData, Model model) {
//
//		userRepository.save(new MyUser(formData.getFname(), formData.getLname(), formData.getDob(), formData.getEmail(), formData.getPassword()));
//		model.addAttribute("user", new MyUser());
//		return "welcomeUser";
//	}

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