package com.ggesite.expense.tracker.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseDto {
    private long id;
    private String category;
    private Long amount;
    private String expense;
    private String date;
}
