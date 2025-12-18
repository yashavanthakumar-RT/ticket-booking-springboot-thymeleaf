package Jsp_Project.Movie_Ticket.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SeatLayoutForm {
	private List<SeatRowDto> rows = new ArrayList<>();
}