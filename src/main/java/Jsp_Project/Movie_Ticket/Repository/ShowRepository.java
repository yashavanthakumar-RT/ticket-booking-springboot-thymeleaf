package Jsp_Project.Movie_Ticket.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Screen;
import Jsp_Project.Movie_Ticket.entity.Show;
import Jsp_Project.Movie_Ticket.entity.Movie;

public interface ShowRepository extends JpaRepository<Show, Long> {

	List<Show> findByScreen(Screen screen);
	List<Show> findByShowDateAfter(LocalDate minusDays);
 List<Show> findByMovieAndShowDateAfter(Movie movie, LocalDate minusDays);
	List<Show> findByMovie(Movie movie);

}
