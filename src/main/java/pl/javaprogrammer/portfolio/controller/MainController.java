package pl.javaprogrammer.portfolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.Context;
import pl.javaprogrammer.portfolio.form.ContactForm;
import pl.javaprogrammer.portfolio.repository.AboutRepository;
import pl.javaprogrammer.portfolio.repository.ProjectRepository;
import pl.javaprogrammer.portfolio.service.MailService;

@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    AboutRepository aboutRepository;

    @Autowired
    MailService mailService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("about", aboutRepository.findAll());
        model.addAttribute("contactForm", new ContactForm());

        return "index";
    }

    @PostMapping(value = "/")
    public String contactForm(@ModelAttribute("contactForm") ContactForm contact) {

        mailService.sendEmail(contact);

        return "redirect:/";
    }

}
