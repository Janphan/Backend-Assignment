package friendlist.exercise.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import friendlist.exercise.domain.Friend;

@Controller
public class FriendController {
    @GetMapping("/index")
    public String handlingStudentList(Model model) {
        List<Friend> students = new ArrayList<>();
        students.add(new Friend("Hong", "Phan"));
        students.add(new Friend("John", "Smith"));
        students.add(new Friend("Joe", "Doe"));

        model.addAttribute("studentlistInHTML", students.toArray());
        return "friendlist";
    }
}
