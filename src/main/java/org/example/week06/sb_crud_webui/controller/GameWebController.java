package org.example.week06.sb_crud_webui.controller;

import org.example.week06.sb_crud_webui.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.example.week06.sb_crud_webui.dto.GameRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class GameWebController{

        private GameService gameService;

        public GameWebController(GameService gameService) {
            this.gameService = gameService;
        }

        @GetMapping("/games")
        public String list(Model model) {
            model.addAttribute("games", gameService.findAll());
            return "games/list";
        }

        @GetMapping("/games/new")
        public String form() {
            return "games/form";
        }

        @PostMapping("/games")
        public String create(@ModelAttribute GameRequest request) {
            gameService.create(request);
            return "redirect:/games";
        }

        @GetMapping("/")
        public String home() {
            return "redirect:/games";
        }
    }

