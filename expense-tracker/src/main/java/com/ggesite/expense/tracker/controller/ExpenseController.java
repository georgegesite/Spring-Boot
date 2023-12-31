package com.ggesite.expense.tracker.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggesite.expense.tracker.service.ExpenseService;
import com.ggesite.expense.tracker.entity.ExpenseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ExpenseController handles HTTP requests related to expenses.
 * It provides endpoints to display expenses, add new expenses,
 * and generate expense reports.
 */
@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "Login.html";
    }

    @RequestMapping(value = "/expenses", method = { RequestMethod.GET, RequestMethod.POST })
    public String displayExpenses(Model model, @RequestParam(required = false) Integer month) {
        List<ExpenseEntity> expenses = expenseService.getTodayExpenses();
        model.addAttribute("expensesData", expenses);
        model.addAttribute("pageTitle", "ExpenseTracker");

        BigDecimal totalExpenseToday = expenseService.getSumAmountForToday();
        model.addAttribute("totalExpense", totalExpenseToday);
        model.addAttribute("expenseForm", new ExpenseEntity());

        if (month != null) {
            List<Object[]> expensesByCategory = expenseService.getExpensesByCategoryForMonth(month);
            model.addAttribute("expenses", expensesByCategory);
        } else {
            List<Object[]> thisMonthExpenses = expenseService.getExpensesByCategoryForCurrentMonth();
            model.addAttribute("expenses", thisMonthExpenses);
        }

        return "Home.html";
    }

    @PostMapping("/expenses/add")
    public String saveExpense(@ModelAttribute("expenseForm") ExpenseEntity expenseEntity) {
        expenseService.saveExpense(expenseEntity);
        return "redirect:/expenses";
    }

}
