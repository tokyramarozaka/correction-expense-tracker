package dao;

import entity.Expense;
import entity.Recurrence;
import entity.RecurringExpense;
import entity.RefundableExpense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseDAOTest {
    private List<Expense> expenses;
    private ExpenseDAO expenseDAO;

    @BeforeEach
    void setUp() {
        var spotify = new RecurringExpense("Abonnement spotify",
                60_000, LocalDate.now(), Recurrence.MONTHLY);
        var rent = new RecurringExpense("Loyer", 300_000, LocalDate.now(), Recurrence.MONTHLY);
        var doctorVisit = new RefundableExpense("Doctor visit", 100_000,
                LocalDate.of(2025, 10, 10));
        var ps5 = new Expense("PS5", 3_000_000,
                LocalDate.of(2025, 10, 10));

        expenses = List.of(spotify, doctorVisit, ps5, rent);
        expenseDAO = new ExpenseDAO();
    }

    @Test
    void getUnrefundedExpenses() {
       var unrefundedExpenses = expenseDAO.getUnrefundedExpenses(expenses);

       assertEquals(1, unrefundedExpenses.size());
       assertEquals("Doctor visit", unrefundedExpenses.get(0).getLabel());
    }

    @Test
    void getSumOfRecurringExpenses() {
        var sumOfRecurringExpenses = expenseDAO.getSumOfRecurringExpenses(expenses);
        assertEquals(360_000, sumOfRecurringExpenses);
    }

    @Test
    void getLargeExpenses() {
    }

    @Test
    void getTotalAmount() {
    }
}