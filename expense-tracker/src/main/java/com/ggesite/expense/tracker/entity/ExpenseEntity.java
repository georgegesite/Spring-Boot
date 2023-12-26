package com.ggesite.expense.tracker.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;

/**
 * Imports the Table annotation from the Jakarta Persistence API.
 * This allows the entity class to be mapped to a database table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "expense")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String category;
    @NotEmpty
    private String expense;

    private Long amount;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
