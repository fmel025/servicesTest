package com.fmel025.tallerstudyng2.controllers;

import com.fmel025.tallerstudyng2.models.dtos.SaveBookDTO;
import com.fmel025.tallerstudyng2.models.entities.Book;
import com.fmel025.tallerstudyng2.services.BookService;
import com.fmel025.tallerstudyng2.utils.RequestErrorHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    BookService bookService;

    @Autowired
    RequestErrorHandler errorHandler;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getBookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book-list";
    }

    @GetMapping("/")
    public String getMainPage(Model model){
        String time = Calendar.getInstance().getTime().toString();
        model.addAttribute("time", time);
        return "main";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute @Valid SaveBookDTO bookInfo,
                           BindingResult validations, Model model){

        if(validations.hasErrors()){
            System.out.println("Hay errores");
            model.addAllAttributes(errorHandler.mapErrors(validations.getFieldErrors()));
            model.addAttribute("hasErrors", true);
            return "main";
        }

        System.out.println(bookInfo);

        Book newBook = new Book(bookInfo.getIsbn(), bookInfo.getTitle());
        bookService.save(newBook);

        return "redirect:/library/all";
    }
}
