package com.ggesite.expense.tracker.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggesite.expense.tracker.service.ExpenseService;
import com.ggesite.expense.tracker.Dto.ExpenseDto;
import com.ggesite.expense.tracker.entity.ExpenseEntity;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String displayExpenses(Model model) {
        List<ExpenseDto> expenses = expenseService.findAllExpensesToday();
        model.addAttribute("expensesData", expenses);
        model.addAttribute("pageTitle", "ExpenseTracker");

        model.addAttribute("expenseForm", new ExpenseEntity());

        return "Home.html";
    }

    @PostMapping("/expenses/add")
    public String saveTodo(@ModelAttribute("expenseForm") ExpenseEntity expnseEntity) {
        expenseService.saveExpense(expnseEntity);
        return "redirect:/expenses";
    }
}
