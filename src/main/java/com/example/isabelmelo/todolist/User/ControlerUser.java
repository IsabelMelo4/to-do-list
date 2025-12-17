package com.example.isabelmelo.todolist.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

@RestController
@RequestMapping("/users")
public class ControlerUser {

@Autowired
    private  IUserRepository userRepository;

   @PostMapping
   public ResponseEntity create (@RequestBody UserModel userModel){
       var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user !=  null){
            System.out.println("usuario já existe");
            //status code
            // mensagem de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario já existe");

        }
       String hashSenha = BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt(12));
       userModel.setPassword(hashSenha);

       var userCreated = this.userRepository.save(userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
