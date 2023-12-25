package com.ggesite.expense.tracker.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ggesite.expense.tracker.repository.ExpenseRepository;
import com.ggesite.expense.tracker.entity.ExpenseEntity;

@Service
/**
 * ExpenseService provides methods for managing expenses.
 * It handles fetching, saving, and calculating aggregated expenses using an
 * ExpenseRepository.
 */
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseEntity saveExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> getTodayExpenses() {
        return expenseRepository.findTodayExpenses();
    }

    public BigDecimal getSumAmountForToday() {
        return expenseRepository.sumAmountForToday();
    }

    public List<Object[]> getExpensesByCategoryForMonth(int month) {
        return expenseRepository.sumAmountPerCategoryPerMonth(month);
    }

    public List<Object[]> getExpensesByCategoryForCurrentMonth() {
        return expenseRepository.sumAmountPerCategoryForCurrentMonth();
    }
}
