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
    public String contactForm(@ModelAttribute("contactForm") ContactForm contact, Model model) {

        model.addAttribute("contactForm", new ContactForm());

        Context context = new Context();

        context.setVariable("name", contact.getName());
        context.setVariable("email", contact.getEmail());
        context.setVariable("phoneNumber", contact.getPhoneNumber());
        context.setVariable("message", contact.getMessage());

        mailService.sendEmail(contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getMessage());

        return "redirect:/";
    }

}
