package Jsp_Project.Movie_Ticket.repocitroy;

import org.springframework.data.jpa.repository.JpaRepository;

import Jsp_Project.Movie_Ticket.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	void deleteByRole(String string);

	User findByEmail(String email);
}
