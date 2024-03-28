package ru.webapps.ElectronicsStore.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.webapps.ElectronicsStore.models.MyUser;
import ru.webapps.ElectronicsStore.services.MyUserService;

@Controller
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MyUserController {
	@Autowired
	private final MyUserService userService;

	@GetMapping("/login")
	public String login(){
		return "signIn";
	}

	@GetMapping("/registration")
	public String registration(){
		return "signUp";
	}

	@PostMapping("/registration")
	public String createUser(MyUser user, Model model){
		if (!userService.createUser(user)) {
			model.addAttribute("errorMessage", "Такой email:" + user.getEmail() +" уже был зарегистрирован");
			return "redirect:/api/v1/registration";
		}
		return "redirect:/api/v1/login";
	}
}