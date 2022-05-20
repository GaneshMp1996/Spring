package com.xworkz.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.mail.service.MailService;

@Controller
@RequestMapping("/")
public class MailController {

	@Autowired
	private MailService mailService;

	public MailController() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@RequestMapping("/sendMail.do")
	public String onSendClicked(@RequestParam String to, @RequestParam String subject, @RequestParam String message,
			Model model) {
		System.out.println("Invoked onSendClicked()");
		boolean result = this.mailService.sendMailToFriend(to, subject, message);
		if (result) {
			model.addAttribute("message", "Mail has been sent");
		} else {
			model.addAttribute("message", "Mail has not been sent");
		}

		return "/index.jsp";
	}

}
