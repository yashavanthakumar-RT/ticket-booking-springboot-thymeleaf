package Jsp_Project.Movie_Ticket.servies;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import jakarta.servlet.http.HttpSession;

public interface UserServise {
	
	public String register(UserDto userDto,BindingResult bindingResult);
	public String login(LoginDto dto,RedirectAttributes  attributes,HttpSession session);
}
