package Jsp_Project.Movie_Ticket.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String languages;
	@Column(nullable = false)
	private String genre;
	@NotNull(message = "* It is Required")
	private LocalTime duration;
	@Column(nullable = false)
	private String imageLink;
	@Column(nullable = false)
	private String trailerLink;
	@Column(nullable = false, length = 500)
	private String description;
	@Column(nullable = false)
	private LocalDate releaseDate;
	@Column(nullable = false)
	private String cast;
}