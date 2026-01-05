package com.example.isabelmelo.todolist.filter;


import com.example.isabelmelo.todolist.User.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class Filter extends OncePerRequestFilter {


    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var servletpath = request.getServletPath();
        if(servletpath.startsWith("/tasks")){


            //pegar autorização
            var autoRequest = request.getHeader("Authorization");
            var user_password = autoRequest.substring("Basic".length()).trim();
            byte[] decode = Base64.getDecoder().decode(user_password);

            var strAutentic = new String(decode);

            System.out.println("autorização");
            System.out.println(strAutentic);
            String[] credenciais =  strAutentic.split(":");
            String username = credenciais[0];
            String senha = credenciais[1];

            //validar usuario

            var user = this.userRepository.findByUsername(username);

            if(user == null){
                response.sendError(401);
            }
            else{
                //validar senha

                var result = BCrypt.checkpw(senha, user.getPassword());
                if(result == true){
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);

                }
                else{
                    response.sendError(401, "sem autorização");
                }

                //seguir

            }
        }
        else
        {
            filterChain.doFilter(request, response);

                }

    }
}

