package com.ggesite.expense.tracker.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggesite.expense.tracker.service.ExpenseService;
import com.ggesite.expense.tracker.entity.ExpenseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String displayExpenses(Model model) {
        List<ExpenseEntity> expenses = expenseService.getTodayExpenses();
        model.addAttribute("expensesData", expenses);
        model.addAttribute("pageTitle", "ExpenseTracker");

        BigDecimal totalExpenseToday = expenseService.getSumAmountForToday();
        model.addAttribute("totalExpense", totalExpenseToday);
        model.addAttribute("expenseForm", new ExpenseEntity());

        List<Object[]> thisMonthExpenses = expenseService.getExpensesByCategoryForCurrentMonth();
        model.addAttribute("expenses", thisMonthExpenses);

        return "Home.html";
    }

    @PostMapping("/expenses/add")
    public String saveTodo(@ModelAttribute("expenseForm") ExpenseEntity expnseEntity) {
        expenseService.saveExpense(expnseEntity);
        return "redirect:/expenses";
    }

    @PostMapping("/expenses/month")
    public String getExpenseReport(@RequestParam int month, Model model) {

        List<ExpenseEntity> expenses = expenseService.getTodayExpenses();
        model.addAttribute("expensesData", expenses);
        model.addAttribute("pageTitle", "ExpenseTracker");

        BigDecimal totalExpenseToday = expenseService.getSumAmountForToday();
        model.addAttribute("totalExpense", totalExpenseToday);
        model.addAttribute("expenseForm", new ExpenseEntity());

        List<Object[]> expensesByCategory = expenseService.getExpensesByCategoryForMonth(month);

        model.addAttribute("expenses", expensesByCategory);

        return "Home.html";
    }
}
