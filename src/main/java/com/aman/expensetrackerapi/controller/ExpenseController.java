package com.aman.expensetrackerapi.controller;

import com.aman.expensetrackerapi.model.Expense;
import com.aman.expensetrackerapi.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getExpenses(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return expenseService.getExpensesByCategory(category);
        }

        return expenseService.getAllExpenses();
    }

    @GetMapping("/total")
    public double getTotalExpenses(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return expenseService.getTotalExpensesByCategory(category);
        }

        return expenseService.getTotalExpenses();
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Expense deleted successfully";
    }
}