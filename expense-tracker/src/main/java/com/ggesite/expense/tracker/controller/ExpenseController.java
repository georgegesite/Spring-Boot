package com.ggesite.expense.tracker.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ggesite.expense.tracker.service.ExpenseService;
import com.ggesite.expense.tracker.Dto.ExpenseDto;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String displayExpenses(Model model) {
        List<ExpenseDto> expenses = expenseService.findAllExpensesToday();
        model.addAttribute("expenses", expenses);
        model.addAttribute("pageTitle", "ExpenseTracker");

        return "Home.html";
    }
}
