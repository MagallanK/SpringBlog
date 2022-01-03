package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String showDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userNum}")
    public String joinDicePage(@PathVariable int userNum, Model model){
        Random random = new Random();
        int randomNum = random.nextInt(6) + 1;
        model.addAttribute("userNum", "You chose " + userNum);
        model.addAttribute("randomNum", "The correct number was " + randomNum);
        if(userNum == randomNum){
            model.addAttribute("message", "You guessed correct!");
        }
        else{
            model.addAttribute("message", "Your guess was incorrect!");
        }
        return "/roll-dice";
    }
}
