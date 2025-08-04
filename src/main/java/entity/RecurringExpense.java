package entity;

import java.time.LocalDate;

public class RecurringExpense extends Expense {
    private final Recurrence recurrence;

    public RecurringExpense(String label, double amount, LocalDate date, Recurrence recurrence) {
        super(label, amount, date);
        this.recurrence = recurrence;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    @Override
    public String toString() {
        return super.toString() + ", recurrence=" + recurrence;
    }
}
