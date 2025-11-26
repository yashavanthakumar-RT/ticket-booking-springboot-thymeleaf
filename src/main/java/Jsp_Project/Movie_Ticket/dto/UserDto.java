package Jsp_Project.Movie_Ticket.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

	@Size(min = 3, max = 25, message = "* Enter Between  3 ~ 25 Character")
	private String name;
	@NotBlank(message = "* Enter the Email")
	@Email(message = "* Enter the Proper Email")
	private String email;
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Select a Stronger Password")
	private String password;
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "* Select a Stronger Password")
	private String confirmpassword;
	@DecimalMin(value = "6000000000", message = "* Enter The proper Mobile Number")
	@DecimalMax(value = "9999999999", message = "* Enter The proper Mobile Number")
	private Long mobile;
	@AssertTrue(message = "* Seletct thee cheak box oeder to continue")
	private boolean terms;

}
