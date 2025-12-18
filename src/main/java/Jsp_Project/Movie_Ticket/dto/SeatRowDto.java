package Jsp_Project.Movie_Ticket.dto;

 import lombok.Data;

@Data
public class SeatRowDto {
	private String rowName;
	private Integer totalSeats;
	private String category;
}