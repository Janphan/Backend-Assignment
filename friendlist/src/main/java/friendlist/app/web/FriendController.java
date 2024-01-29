package friendlist.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import friendlist.app.domain.Friend;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    List<Friend> friendList = new ArrayList<>();
    // friends.add(new Friend("Hong Phan"));
    // friends.add(new Friend("John Smith"));
    // friends.add(new Friend("Joe Doe"));

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("friendInHTML", new Friend());
        model.addAttribute("friendListInHTML", friendList);
        return "index.html";
    }

    @PostMapping("/addFriend")
    public String addFriend(@ModelAttribute Friend addfriend) {
        friendList.add(addfriend);
        return "redirect:/index";
    }
}
