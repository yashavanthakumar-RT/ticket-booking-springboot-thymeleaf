package Jsp_Project.Movie_Ticket.UserService;

import java.io.IOException;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Jsp_Project.Movie_Ticket.dto.LoginDto;
import Jsp_Project.Movie_Ticket.dto.MovieDto;
import Jsp_Project.Movie_Ticket.dto.PasswordDto;
import Jsp_Project.Movie_Ticket.dto.ScreenDto;
import Jsp_Project.Movie_Ticket.dto.SeatLayoutForm;
import Jsp_Project.Movie_Ticket.dto.ShowDto;
import Jsp_Project.Movie_Ticket.dto.TheaterDto;
import Jsp_Project.Movie_Ticket.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

public interface UserService {
	public String register(UserDto userDto, BindingResult result, RedirectAttributes attributes);

	public String submitOtp(int otp, String email, RedirectAttributes attributes);

	public String logout(HttpSession session, RedirectAttributes attributes);

	public String login(LoginDto dto, RedirectAttributes attributes, HttpSession session);

	String resendOtp(String email, RedirectAttributes attributes);

	String forgotPassword(String email, RedirectAttributes attributes);

	String resetPassword(PasswordDto passwordDto, BindingResult result, RedirectAttributes attributes, ModelMap map);

	String manageUsers(HttpSession session, RedirectAttributes attributes, ModelMap map);

	String blockUser(Long id, HttpSession session, RedirectAttributes attributes);

	String unBlockUser(Long id, HttpSession session, RedirectAttributes attributes);

	public String manageTheater(ModelMap map, RedirectAttributes attributes, HttpSession session);

	public String loadAddTheater(HttpSession session, RedirectAttributes attributes, TheaterDto theaterDto);

	public String addTheater(HttpSession session, RedirectAttributes attributes, @Valid TheaterDto theaterDto,
			BindingResult result) throws IOException;

	String deleteTheater(Long id, HttpSession session, RedirectAttributes attributes);

	String editTheater(Long id, HttpSession session, RedirectAttributes attributes, ModelMap map);

	String updateTheater(HttpSession session, RedirectAttributes attributes, @Valid TheaterDto theaterDto,
			BindingResult result, Long id);

	String manageScreens(Long id, HttpSession session, RedirectAttributes attributes, ModelMap map);

	String addScreen(Long id, HttpSession session, RedirectAttributes attributes, ModelMap map, ScreenDto screenDto);

	String addScreen(ScreenDto screenDto, BindingResult result, HttpSession session, RedirectAttributes attributes);

	String deleteScreen(Long id, HttpSession session, RedirectAttributes attributes);

	String editScreen(Long id, HttpSession session, RedirectAttributes attributes, ModelMap map);

	String updateScreen(@Valid ScreenDto screenDto, Long id, BindingResult result, HttpSession session,
			RedirectAttributes attributes, ModelMap map);

	String manageSeats(Long id, HttpSession session, ModelMap map, RedirectAttributes attributes);

	String addSeats(Long id, HttpSession session, ModelMap map, RedirectAttributes attributes);

	public String manageMovies(HttpSession session, RedirectAttributes attributes, ModelMap map);

	String loadAddMovie(MovieDto movieDto, RedirectAttributes attributes, HttpSession session);

	String addMovie(MovieDto movieDto, BindingResult result, RedirectAttributes attributes, HttpSession session);

	public String editmovie(Long id, HttpSession session, ModelMap map, RedirectAttributes attributes);

	public String deleteMovies(Long id, HttpSession session, RedirectAttributes attributes);

	public String updateMovies(@Valid MovieDto movieDto, Long id, BindingResult result, RedirectAttributes attributes,
			HttpSession session);

	String saveSeats(Long id, SeatLayoutForm seatLayoutForm, HttpSession session, RedirectAttributes attributes);
	String manageShows(Long id, ModelMap map, RedirectAttributes attributes, HttpSession session);

	String addShow(Long id, ModelMap map, RedirectAttributes attributes, HttpSession session);

	String addShow(ShowDto showDto, BindingResult result, RedirectAttributes attributes, HttpSession session);
}
