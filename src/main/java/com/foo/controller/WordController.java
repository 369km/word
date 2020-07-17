package com.foo.controller;


import com.foo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export/word")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping
    public void exportWord() {
        wordService.export();
    }
}
