package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> listAll(){

        Client c1 = new Client();
        c1.setId(1L);
        c1.setName("Tiago");
        c1.setEmail("programtiago@gmail.com");
        c1.setPhone("xxxxxxxx");

        Client c2 = new Client();
        c2.setId(2L);
        c2.setName("Ana");
        c2.setEmail("ana.silva24@gmail.com");
        c2.setPhone("xxxxasfdasdas");

        return Arrays.asList(c1, c2);

    }

}


