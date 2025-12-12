package Jsp_Project.Movie_Ticket.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	boolean existsByNameAndReleaseDate(String name, LocalDate releaseDate);

}
