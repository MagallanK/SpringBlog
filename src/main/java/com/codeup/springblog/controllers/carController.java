package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class carController {
    private final carRepository carDao;

    public carController(carRepository carDao){
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String carIndex(Model model){
        model.addAttribute("cars", carDao.findAll());

        return "cars";

    }
}
