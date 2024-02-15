package com.fastcampus.ch2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String main() {
        return "index"; // templates/index.html
    }

    @GetMapping("/test")
    public String test(Model model, HttpServletRequest request) {
        request.setAttribute("year", 2022); // request객체에 저장

        HttpSession session = request.getSession(); // 요청으로부터 session객체를 얻어온다.
        session.setAttribute("id", "asdf"); // session객체에 id를 저장

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "test@test.com");

        model.addAttribute("lastName", "DaeHee");
        model.addAttribute("firstName", "Lee");
        model.addAttribute("list", Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee"));
        model.addAttribute("bno", 123);
        model.addAttribute("user", new User("aaa", 20));
        return "test"; // templates/test.html
    }
}
