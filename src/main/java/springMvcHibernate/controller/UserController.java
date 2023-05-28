package springMvcHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springMvcHibernate.models.User;
import springMvcHibernate.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping(value = "/")
    public String showUsers(Model model) {

        List<User> listUsers = userServiceImpl.getUsers();
        model.addAttribute("users", listUsers);
        return "users/showAllUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "users/addUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {

        model.addAttribute("user", userServiceImpl.getUser(id));
        return "users/updateUser";
    }

    @RequestMapping("/edit")
    public String edit(@ModelAttribute("user") User user) {

        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {

        userServiceImpl.deleteUser(id);
        return "redirect:/";
    }
}
