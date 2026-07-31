package com.aman.expensetrackerapi.service;

import com.aman.expensetrackerapi.model.Expense;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    List<Expense> getExpensesByCategory(String category);

    double getTotalExpenses();

    double getTotalExpensesByCategory(String category);

    void deleteExpense(Long id);
}