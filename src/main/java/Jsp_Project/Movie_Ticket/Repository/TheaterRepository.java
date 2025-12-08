package Jsp_Project.Movie_Ticket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.Theater;

 

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	boolean existsByNameAndAddress(String name, String address);

}
