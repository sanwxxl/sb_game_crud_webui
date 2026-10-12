package org.example.week06.sb_crud_webui.controller;

import org.example.week06.sb_crud_webui.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
    }

