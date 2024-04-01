package com.fastcampus.ch2;

//  년월일을 입력하면 요일을 알려주는 원격 프로그램
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller {
    @RequestMapping("/getYoil")
//    public void main(String year, String month, String day, HttpServletResponse response) throws IOException {
      public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {

      // 2. 작업 - 요일을 계산
      //char yoil = getYoil(myDate);

      return "yoil"; // yoil.html - 뷰의 이름을 반환

    }

    @ModelAttribute("yoil")
    private char getYoil(MyDate myDate) {
      Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간을 갖는 cal
      cal.clear(); // cal의 모든 필드를 초기화
      cal.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());// 월(mm)은 0부터 11이기 때문에 1을 빼줘야 함

      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1~7을 반환. 1: 일요일, 2: 월요일 ..
      char yoil = "일월화수목금토".charAt(dayOfWeek-1); // 1~7 -> 0~6
      return yoil;
    }
}
