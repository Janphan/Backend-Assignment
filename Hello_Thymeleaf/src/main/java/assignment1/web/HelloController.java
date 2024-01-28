package assignment1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
// @ResponseBody
public class HelloController {
    @GetMapping("/hello")
    public String helloName(@RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "hello";
        // refer to hello.html
    }
}
