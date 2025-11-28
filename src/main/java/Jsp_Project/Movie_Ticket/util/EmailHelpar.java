package Jsp_Project.Movie_Ticket.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;
import io.lettuce.core.dynamic.annotation.Command;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EmailHelpar {

	 

	private final JavaMailSender mailSender;
	private final TemplateEngine templateEngine;

	public void sendOtp(int otp, String name, String email) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setFrom("bookmy-ticket.com", "Book-My-Ticket");
			helper.setTo(email);
			helper.setSubject("Otp for Creating Account with BookMyTicket");
			Context context = new  Context();
			context.setVariable("name", name);
			context.setVariable("otp", otp);
			String text = templateEngine.process("email-templet.html", context);
			helper.setText(text, true);
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			System.err.println("Failed to Send OTP : " + otp);
		}
	}

}
