package com.ggesite.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ggesite.expense.tracker.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

}
