package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.jpa.model.Mail;

@Service
@Transactional
public class SendMailService {
	@Autowired
	private JavaMailSender javaMailSender;
	//@Autowired
	//MailRepository repository;
	
	public void sendMail(Mail mail) throws MailException{
		System.out.println("send email..");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(mail.getDestination());
		msg.setFrom("professorcherker@gmail.com");
		msg.setSubject(mail.getObjet());
		msg.setText(mail.getMessage());
		javaMailSender.send(msg);
		//return repository.save(mail.getId());
	}
	
}
