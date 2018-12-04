package com.mihaisorin.springfw5webapp.controller;

import com.mihaisorin.springfw5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
