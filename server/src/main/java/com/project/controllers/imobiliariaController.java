package com.project.controllers;

import com.project.beans.Imovel;
import com.project.services.ImobiliariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class imobiliariaController {

    @Autowired
    public ImobiliariaService imobiliariaService;

    @GetMapping("/imoveis")
    public List<Imovel> getImoveis(){
        return this.imobiliariaService.getImoveis();
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
