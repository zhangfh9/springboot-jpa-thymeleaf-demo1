package com.zfh.controller;

import com.zfh.bean.User;
import com.zfh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/")
    public String getList(Model model){
        List<User> list =service.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }
    @PostMapping("/add")
    public String save(User user){
        service.add(user);
        return "redirect:/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        User user = service.findOne(id);
        model.addAttribute("user",user);
        return "edit";
    }
    @PostMapping("/update")
    public String update(User user){
        service.update(user);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
