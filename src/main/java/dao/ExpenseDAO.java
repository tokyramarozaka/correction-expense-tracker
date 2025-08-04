package dao;

import entity.Expense;
import entity.RecurringExpense;
import entity.RefundableExpense;

import java.util.List;

public class ExpenseDAO {
    public List<RefundableExpense> getUnrefundedExpenses(List<Expense> expenses) {
        return expenses.stream()
                .filter(e -> e instanceof RefundableExpense)
                .map(e -> (RefundableExpense) e)
                .filter(e -> !e.isRefunded())
                .toList();
    }

    public double getSumOfRecurringExpenses(List<Expense> expenses) {
        return expenses.stream()
                .filter(e -> e instanceof RecurringExpense)
                .map(e -> (RecurringExpense) e)
                .mapToDouble(RecurringExpense::getAmount)
                .sum();
    }

    public List<Expense> getLargeExpenses(List<Expense> expenses) {
        return expenses.stream()
                .filter(Expense::isLargeExpense)
                .toList();
    }

    public double getTotalAmount(List<Expense> expenses) {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
