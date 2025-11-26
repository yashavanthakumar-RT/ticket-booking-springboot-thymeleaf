package Jsp_Project.Movie_Ticket.controller;

import java.io.ObjectInputStream.GetField;
import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import Jsp_Project.Movie_Ticket.servies.UserServise;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
class UserController {
	 private final UserServise userServise;

	@GetMapping("/")
	public String load() {
		return "main.html";
	}

	@GetMapping("/register")
	public String loadregister(UserDto userDto) {
		return "register.html";
	}
	@PostMapping("/register")
	public String  register(@Valid UserDto userDto,BindingResult bindingResult )
	{
		return userServise.register(userDto, bindingResult);
	}

	@GetMapping("/login")
	public String loadlogin() {
		return "login.html";
	}
 @PostMapping("/login")
 public String loginpage(LoginDto  Dto,RedirectAttributes attributes,HttpSession session)
 {
	 return userServise.login(Dto, attributes, session);
 }
}
