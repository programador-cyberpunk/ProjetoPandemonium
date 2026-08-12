package com.pandemonium.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")// pra liberar as rota dos bagulho
@RestController
@RequestMapping("/audios")
    public class AudioController{

    @GetMapping
    public String listarAudios(){
        return "Lista dos audios";    }
}