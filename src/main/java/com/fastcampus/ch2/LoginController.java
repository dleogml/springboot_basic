package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
//    @RequestMapping("/login/login")
//    @RequestMapping("/login/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String showLogin() {
        return "login"; // login.html을 화면에 보여줌
    }

    // 하나의 메서드로 GET, POST를 둘다 처리하는 경우
//    @RequestMapping(value="/login/login", method = {RequestMethod.POST, RequestMethod.GET})
//    @RequestMapping(value="/login/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String login(HttpServletRequest req, String id, String pwd, RedirectAttributes model) throws UnsupportedEncodingException {
        // 1. id, pwd를 확인
        if(loginCheck(id, pwd)) {
            // 2. 일치하면, userInfo.html
            model.addAttribute("id",id);
            model.addAttribute("pwd",pwd);
            return "userInfo";
        } else {
            //    일치 하지 않으면, login.html로 이동
//            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg","일회용 메세지");
            req.setAttribute("msg", "request에 저장된 msg");
//            return "redirect:/login/login?msg="+msg; // GET - URL 재작성
//            return "forward:/login/login"; // /login/login POST
            return "forward:/";
//            return "redirect:/login/login";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}
