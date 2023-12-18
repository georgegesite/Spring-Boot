package com.ggesite.expense.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    @GetMapping("/expenses")
    public String displayExpenses(Model model) {

        model.addAttribute("pageTitle", "ExpenseTracker");

        return "Home.html";
    }
}
