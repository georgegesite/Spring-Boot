package com.ggesite.expense.tracker.service;

import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ggesite.expense.tracker.repository.ExpenseRepository;
import com.ggesite.expense.tracker.Dto.ExpenseDto;
import com.ggesite.expense.tracker.entity.ExpenseEntity;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // try and understand this function
    public List<ExpenseDto> findAllExpensesToday() {
        List<ExpenseEntity> expenses = expenseRepository.findAll();
        return expenses.stream().map((expense) -> mapToExpenseDto(expense)).collect(Collectors.toList());

    }

    // save expense
    public ExpenseEntity saveExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    // try and understand this function
    private ExpenseDto mapToExpenseDto(ExpenseEntity expense) {
        ExpenseDto expenseDto = ExpenseDto.builder()
                .id(expense.getId())
                .category(expense.getCategory())
                .amount(expense.getAmount())
                .expense(expense.getExpense())
                .build();

        return expenseDto;
    }

    public List<ExpenseEntity> getTodayExpenses() {
        return expenseRepository.findTodayExpenses();
    }

    public BigDecimal getSumAmountForToday() {
        return expenseRepository.sumAmountForToday();
    }

}
