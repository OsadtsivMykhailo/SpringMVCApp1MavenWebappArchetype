package ua.multi.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FisrtController {
        @GetMapping("/hello")
        public String helloPage(HttpServletRequest request) {       //без параметрів кладе в параметри null
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            System.out.println("Hello, " + name + " " + surname);
            return "first/hello";
        }

        @GetMapping("/goodbye")
        public String goodByePage(@RequestParam("name") String name,     //без параметрів не паше, 404
                                  @RequestParam(value = "surname", required = false) String surname) { //без параметрів кладе в параметри null

            System.out.println("Good bye, " + name + " " + surname);
            return "first/goodbye";
        }

}
