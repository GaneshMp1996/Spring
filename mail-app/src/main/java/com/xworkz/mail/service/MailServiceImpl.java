package com.xworkz.mail.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	
	public MailServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	public boolean sendMailToFriend(String to, String subject, String message) {
		System.out.println("Invoked sendMailToFriend()");
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(message);
			mailSender.send(mailMessage);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
