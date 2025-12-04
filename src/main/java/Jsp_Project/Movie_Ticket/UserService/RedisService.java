package Jsp_Project.Movie_Ticket.UserService;

import Jsp_Project.Movie_Ticket.dto.UserDto;

public interface RedisService {

	void saveUserDto(String email, UserDto userDto);

	void saveOtp(String email, int otp);

	UserDto getDtoByEmail(String email);

	int getOtpByEmail(String email);

}