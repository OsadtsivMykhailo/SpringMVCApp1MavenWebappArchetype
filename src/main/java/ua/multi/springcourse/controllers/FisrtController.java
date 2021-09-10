package ua.multi.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//        @GetMapping("/goodbye")
//        public String goodByePage(@RequestParam("name") String name,     //без параметрів не паше, 404
//                                  @RequestParam(value = "surname", required = false) String surname) { //без параметрів кладе в параметри null
//
//            System.out.println("Good bye, " + name + " " + surname);
//            return "first/goodbye";
//        }

        @GetMapping("/goodbye")
         public String goodByePage(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "surname", required = false) String surname, Model model) {

             //System.out.println("Good bye, " + name + " " + surname);
            model.addAttribute("message", "Good bye, " + name + " " + surname);
             return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action, Model model) {

        //System.out.println("Good bye, " + name + " " + surname);
        if(action.equals("addition")) {
            model.addAttribute("result", "Result is: " + (a + b));
        }

        if(action.equals("substraction")) {
            model.addAttribute("result", "Result is: " + (a - b));
        }

        if(action.equals("multiplication")) {
            model.addAttribute("result", "Result is: " + (a * b));
        }

        if(action.equals("division")) {
            model.addAttribute("result", "Result is: " + (a / b));
        }
        return "first/calculator";
    }

}
