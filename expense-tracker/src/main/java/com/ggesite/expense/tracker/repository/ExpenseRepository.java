package com.ggesite.expense.tracker.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ggesite.expense.tracker.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    @Query("SELECT e FROM ExpenseEntity e WHERE DATE(e.createdOn) = CURRENT_DATE")
    List<ExpenseEntity> findTodayExpenses();

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM ExpenseEntity e WHERE DATE(e.createdOn) = CURRENT_DATE")
    BigDecimal sumAmountForToday();

    @Query("SELECT e.category, SUM(e.amount) FROM ExpenseEntity e WHERE MONTH(e.createdOn) = :month GROUP BY e.category")
    List<Object[]> sumAmountPerCategoryPerMonth(@Param("month") int month);

}
