package Jsp_Project.Movie_Ticket.UserService;


import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.Repository.UserRepository;
import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import Jsp_Project.Movie_Ticket.entity.User;
import Jsp_Project.Movie_Ticket.util.AES;
import Jsp_Project.Movie_Ticket.util.EmailHelper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final SecureRandom random;
	private final EmailHelper emailHelper;
	private final RedisService redisService;
	 
	public String register(UserDto userDto, BindingResult result, RedirectAttributes attributes) {
		if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
			result.rejectValue("confirmPassword", "error.confirmPassword",
					"* Password and ConfirmPassword Should be Same");
		 
		if (userRepository.existsByEmail(userDto.getEmail()))
			result.rejectValue("email", "error.email", "* Email Should be unique");
		 
		if (userRepository.existsByMobile(userDto.getMobile()))
			result.rejectValue("mobile", "error.mobile", "* Mobile Number Should be unique");
		

		if (result.hasErrors())
			return "register.html";
		

		else {
			 
			int otp = random.nextInt(100000, 1000000);
			emailHelper.sendOtp(otp, userDto.getName(), userDto.getEmail());
			redisService.saveUserDto(userDto.getEmail(), userDto);
			redisService.saveOtp(userDto.getEmail(), otp);
			attributes.addFlashAttribute("pass", "Otp Sent Success");
			attributes.addFlashAttribute("email", userDto.getEmail());
			return "redirect:/otp";
		}
	}

	@Override
	public String submitOtp(int otp, String email, RedirectAttributes attributes) {
		UserDto dto = redisService.getDtoByEmail(email);
		if (dto == null) {
			attributes.addFlashAttribute("fail", "Timeout Try Again Creating a New Account");
			return "redirect:/register";
		} else {
			int exOtp = redisService.getOtpByEmail(email);
			if (exOtp == 0) {
				attributes.addFlashAttribute("fail", "OTP Expired, Resend Otp and Try Again");
				attributes.addFlashAttribute("email", email);
				return "redirect:/otp";
			} else {
				if (otp == exOtp) {
					User user = new User(null, dto.getName(), dto.getEmail(), dto.getMobile(),
							AES.encrypt(dto.getPassword()), "USER");
					userRepository.save(user);
					attributes.addFlashAttribute("pass", "Account Registered Success");
					return "redirect:/main";

				} else {
					attributes.addFlashAttribute("fail", "Invalid OTP Try Again");
					attributes.addFlashAttribute("email", email);
					return "redirect:/otp";
				}
			}
		}
	}
	public String logout(HttpSession session, RedirectAttributes attributes) {
		session.removeAttribute("user");
		attributes.addFlashAttribute("pass", "Logout Success");
		return "redirect:/main";
	}
	public String login(LoginDto dto, RedirectAttributes attributes, HttpSession session) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			attributes.addFlashAttribute("fail", "Invalid Email");
			return "redirect:/login";
		} else {
			if (AES.decrypt(user.getPassword()).equals(dto.getPassword())) {
				session.setAttribute("user", user);
				attributes.addFlashAttribute("pass", "Login Success");
				return "redirect:/main";
			} else {
				attributes.addFlashAttribute("fail", "Invalid Password");
				return "redirect:/login";
			}
		}
	}


}
	 

