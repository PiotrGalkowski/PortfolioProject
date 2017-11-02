package pl.javaprogrammer.portfolio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javaprogrammer.portfolio.UserInfo;
import pl.javaprogrammer.portfolio.entity.User;
import pl.javaprogrammer.portfolio.repository.UserRepository;

import java.util.Optional;


@Controller
public class SecureController {

    @Autowired
    UserInfo userInfo;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/checkuser")
    @ResponseBody
    public String checkUser() {
        return "Czy user jest zalogowany?" + userInfo.isLogged();
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (userInfo.isLogged()) {
            return "redirect:/adminView";
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {

        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent() && password.equals(user.get().getPassword())) {

            userInfo.setLogged(true);
            userInfo.setUser(user.get());

            return "redirect:/adminView";
        }

        model.addAttribute("info", true);

        return "login";
    }


    @GetMapping("/logout")
    public String logout() {

        userInfo.setLogged(false);

        return "redirect:/";
    }
}

