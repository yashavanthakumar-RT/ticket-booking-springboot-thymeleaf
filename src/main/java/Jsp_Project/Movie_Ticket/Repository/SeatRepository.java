package Jsp_Project.Movie_Ticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Screen;
import Jsp_Project.Movie_Ticket.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	List<Seat> findByScreenOrderBySeatRowAscSeatColumnAsc(Screen screen);

	 
}
