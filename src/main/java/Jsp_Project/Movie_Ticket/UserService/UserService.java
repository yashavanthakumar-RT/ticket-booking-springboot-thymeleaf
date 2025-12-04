package Jsp_Project.Movie_Ticket.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import jakarta.servlet.http.HttpSession;

public interface UserService {
	public String register(UserDto userDto, BindingResult result, RedirectAttributes attributes);
	public String submitOtp(int otp, String email, RedirectAttributes attributes) ;
	public String logout(HttpSession session, RedirectAttributes attributes);
	public String login(LoginDto dto, RedirectAttributes attributes, HttpSession session) ;
}