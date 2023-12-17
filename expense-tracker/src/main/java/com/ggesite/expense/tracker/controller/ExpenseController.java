package com.ggesite.expense.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    @GetMapping("/expenses")
    public String displayExpenses(Model model) {

        model.addAttribute("welcome", "Hello and welcome");

        return "Home.html";
    }
}
