package com.example.isabelmelo.todolist.User;

import com.example.isabelmelo.todolist.RestContoller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ControlerUser {

    @PostMapping
   public void creat(@RequestBody UserModel userModel){
        System.out.println(userModel.getName());
        System.out.println(userModel.getPassword());
        System.out.println(userModel.getUsername());
    }
}
