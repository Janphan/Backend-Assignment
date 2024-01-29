package handling_lists.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import handling_lists.domain.Student;

@Controller
public class StudentController {
    @GetMapping("/hello")
    public String handlingStudentList(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Hong", "Phan"));
        students.add(new Student("John", "Smith"));
        students.add(new Student("Joe", "Doe"));

        model.addAttribute("studentlistInHTML", students);
        return "studentlist";
    }

}
