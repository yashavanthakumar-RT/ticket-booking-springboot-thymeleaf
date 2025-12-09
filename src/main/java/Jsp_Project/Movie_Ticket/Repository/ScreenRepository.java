package Jsp_Project.Movie_Ticket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Screen;
import Jsp_Project.Movie_Ticket.entity.Theater;
 

public interface ScreenRepository extends JpaRepository<Screen, Long> {

	List<Screen> findByTheater(Theater theater);

	boolean existsByNameAndTheater(String name, Theater theater);

}