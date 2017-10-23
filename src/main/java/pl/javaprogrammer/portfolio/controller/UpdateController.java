package pl.javaprogrammer.portfolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javaprogrammer.portfolio.UserInfo;
import pl.javaprogrammer.portfolio.entity.About;
import pl.javaprogrammer.portfolio.entity.Project;
import pl.javaprogrammer.portfolio.repository.AboutRepository;
import pl.javaprogrammer.portfolio.repository.ProjectRepository;


@Controller
public class UpdateController {

    @Autowired
    AboutRepository aboutRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserInfo userInfo;

    @GetMapping(value = "/adminView", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String adminViewGet(Model model) {

        if (userInfo.isLogged()) {
            model.addAttribute("project", new Project());
            model.addAttribute("about", aboutRepository.findAll());
            model.addAttribute("projects", projectRepository.findAll());

            return "adminView";

        } else {

            return "login";
        }
    }


    @PostMapping(value = "/adminView")
    public String updateAbout(@RequestParam("description") String description) {

        About about = new About();

        //UPDATE ABOUT SECTION
        about.setDescription(description);

        aboutRepository.deleteAll();

        aboutRepository.save(about);

        return "redirect:/adminView";
    }

    @PostMapping(value = "/addProject")
    public String addProject(@ModelAttribute("project") Project project) {

        projectRepository.save(project);

        return "redirect:/adminView";
    }
}
