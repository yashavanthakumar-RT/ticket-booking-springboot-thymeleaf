package Jsp_Project.Movie_Ticket.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.UserService.UserService;
import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

 
	@GetMapping({"/","/main"})
	public String loadMain() {
		return "main.html";
	}

	@GetMapping("/register")
	public String loadRegister(UserDto userDto) {
		return "register.html";
	}
     @PostMapping("/register")
	public String register(@Valid UserDto userDto, BindingResult result, RedirectAttributes attributes) {
		return userService.register(userDto, result, attributes);
	}

	@GetMapping("/login")
	public String loadLogin() {
		return "login.html";
	}

	@PostMapping("/login")
	public String login(LoginDto dto,RedirectAttributes attributes,HttpSession session) {
		return userService.login(dto,attributes,session);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,RedirectAttributes attributes) {
		return userService.logout(session,attributes);
	}
	@GetMapping("/otp")
	public String loadOtpPage() {
		return "otp.html";
	}

	@PostMapping("/otp")
	public String submitOtp(@RequestParam int otp, @RequestParam String email, RedirectAttributes attributes) {
		return userService.submitOtp(otp, email, attributes);
	}
}
 