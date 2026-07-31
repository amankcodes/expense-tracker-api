package com.aman.expensetrackerapi.service;

import com.aman.expensetrackerapi.exception.ExpenseNotFoundException;
import com.aman.expensetrackerapi.model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceImplTest {

    private ExpenseServiceImpl expenseService;

    @BeforeEach
    void setUp() {
        expenseService = new ExpenseServiceImpl();

        expenseService.addExpense(
                new Expense(
                        1L,
                        "Lunch",
                        250,
                        "Food",
                        LocalDate.parse("2026-08-01")
                )
        );

        expenseService.addExpense(
                new Expense(
                        2L,
                        "Uber",
                        150,
                        "Travel",
                        LocalDate.parse("2026-08-01")
                )
        );
    }

    @Test
    void shouldAddExpense() {

        Expense expense = new Expense(
                3L,
                "Book",
                500,
                "Study",
                LocalDate.parse("2026-08-01")
        );
        Expense saved = expenseService.addExpense(expense);
        assertEquals("Book", saved.getTitle());
    }

    @Test
    void shouldReturnAllExpenses() {

        List<Expense> expenses = expenseService.getAllExpenses();

        assertEquals(2, expenses.size());
    }

    @Test
    void shouldFilterByCategory() {

        List<Expense> expenses = expenseService.getExpensesByCategory("Food");

        assertEquals(1, expenses.size());
        assertEquals("Lunch", expenses.get(0).getTitle());
    }

    @Test
    void shouldCalculateTotalExpense() {

        assertEquals(400, expenseService.getTotalExpenses());
    }

    @Test
    void shouldCalculateCategoryTotal() {

        assertEquals(250,
                expenseService.getTotalExpensesByCategory("Food"));
    }

    @Test
    void shouldDeleteExpense() {

        expenseService.deleteExpense(1L);

        assertEquals(1, expenseService.getAllExpenses().size());
    }

    @Test
    void shouldThrowExceptionWhenDeletingInvalidId() {

        assertThrows(
                ExpenseNotFoundException.class,
                () -> expenseService.deleteExpense(100L)
        );
    }
}