package Jsp_Project.Movie_Ticket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDto {
	@NotBlank
	private String name;
	@NotBlank
	private String type;
	@NotNull
	private Long theaterId;
}