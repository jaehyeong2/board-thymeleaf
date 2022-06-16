package jjfactory.boardthymeleaf.business.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class AuthController {

    @GetMapping("/")
    public String index(Model model){
        return "board/list";
    }

    @GetMapping("/auth/login")
    public String login(Model model){
        return "auth/login";
    }

    @GetMapping("/auth/signup")
    public String signUp(Model model){
        return "auth/signup";
    }
}
