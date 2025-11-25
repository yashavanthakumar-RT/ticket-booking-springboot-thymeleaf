package Jsp_Project.Movie_Ticket.controller;

import java.io.ObjectInputStream.GetField;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class UserController {

 @GetMapping("/")
 public String load()
 {
	 return "main.html";
 }

}
