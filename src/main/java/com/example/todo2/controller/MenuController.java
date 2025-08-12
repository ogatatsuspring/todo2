package com.example.todo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
  
  @GetMapping( "/" )
  public String showMenu() {
    return "menu";
  }

}
