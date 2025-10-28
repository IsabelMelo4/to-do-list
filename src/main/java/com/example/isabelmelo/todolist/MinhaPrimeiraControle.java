package com.example.isabelmelo.todolist;

//controle é o controle entre o usuario e o sistema, onde ele pode
//enviar requisições

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// o rest é a rota que eu vou colocar no navegador para ele chegar aqui
// http://localhost:8080/PrimeiraRota
@RestController
@RequestMapping("/PrimeiraRota") //Quem vai estruturar a rota

public class MinhaPrimeiraControle {

    /* Métodos de acesso do HTTP
    GET - Buscar uma informação
    POST - Adicionar um dado
    PUT - Alterar uma informaçao
    PATH - Alterar somente uma perte da informação
     */


    // funcionalidade de uma classe

    @GetMapping()
    public String PrimeiraMensagem(){
        return "funcionou";
    }

    /*
    Ou seja, sempre que eu colocar a url do meu site e qual o lugar
    ele vai acessar ex(Primeira rota) ele vai executar o metodo primeira rota
     */
}
