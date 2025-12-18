package Jsp_Project.Movie_Ticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Screen;
import Jsp_Project.Movie_Ticket.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

	List<Show> findByScreen(Screen screen);

}
