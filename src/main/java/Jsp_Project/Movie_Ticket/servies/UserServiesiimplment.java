package Jsp_Project.Movie_Ticket.servies;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import Jsp_Project.Movie_Ticket.entity.User;
import Jsp_Project.Movie_Ticket.repocitroy.UserRepository;
import Jsp_Project.Movie_Ticket.util.AES;
import Jsp_Project.Movie_Ticket.util.EmailHelpar;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiesiimplment implements UserServise {

	private final UserRepository userRepository;
	
	private final SecureRandom random;
	private final EmailHelpar emailHelper;

	@Override
	public String register(UserDto userDto, BindingResult bindingResult) {
		if (userDto.getPassword().equals(userDto.getConfirmpassword()))
			bindingResult.rejectValue("Confirmpassword", "error.Confirmpassword", "* Enter Password is miss macthing");
		if(userRepository.existsByEmail(userDto.getEmail()))
			bindingResult.rejectValue("email", "error.email", "* Email Should be unique");
		if(userRepository.existsByMobile(userDto.getMobile()))
			bindingResult.rejectValue("mobile", "error.mobile", "* Mobile Number Should be unique");
		
	 
		if (bindingResult.hasErrors())
			return "register.html";
		else {
			int otp=random.nextInt(100000,1000000);
			emailHelper.sendOtp(otp,userDto.getName(),userDto.getEmail());
			
			return "main.html";
		}
	}

	@Override
	public String login(LoginDto dto, RedirectAttributes attributes, HttpSession session) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			attributes.addFlashAttribute("fail", "Invalid Email");
			return "redirect:/login";
		} else {
			if (AES.decrypt(user.getPassword()).equals(dto.getPassword())) {
				session.setAttribute("user", user);
				attributes.addFlashAttribute("pass", "Login Success");
				return "redirect:/";
			} else {
				attributes.addFlashAttribute("fail","Invalid Password");
				return "redirect:/login";
			}
		}

	}

	@Override
	public String logout(HttpSession session, RedirectAttributes attributes) {
		session.removeAttribute("user");
		attributes.addFlashAttribute("pass", "Logout Success");
		return "redirect:/";
	}

	 
}
