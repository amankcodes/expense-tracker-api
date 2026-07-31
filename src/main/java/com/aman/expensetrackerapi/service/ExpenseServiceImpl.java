package com.aman.expensetrackerapi.service;

import com.aman.expensetrackerapi.exception.ExpenseNotFoundException;
import com.aman.expensetrackerapi.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ConcurrentHashMap<Long, Expense> expenseMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Expense addExpense(Expense expense) {
        expense.setId(idGenerator.getAndIncrement());
        expenseMap.put(expense.getId(), expense);
        return expense;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenseMap.values());
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {

        List<Expense> filteredExpenses = new ArrayList<>();

        for (Expense expense : expenseMap.values()) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                filteredExpenses.add(expense);
            }
        }

        return filteredExpenses;
    }

    @Override
    public double getTotalExpenses() {

        double total = 0;

        for (Expense expense : expenseMap.values()) {
            total += expense.getAmount();
        }

        return total;
    }

    @Override
    public double getTotalExpensesByCategory(String category) {

        double total = 0;

        for (Expense expense : expenseMap.values()) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    @Override
    public void deleteExpense(Long id) {

        if (!expenseMap.containsKey(id)) {
            throw new ExpenseNotFoundException("Expense not found with id: " + id);
        }

        expenseMap.remove(id);
    }
}