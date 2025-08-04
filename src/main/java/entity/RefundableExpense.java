package entity;

import java.time.LocalDate;

public class RefundableExpense extends Expense{
    private boolean refunded;

    public RefundableExpense(String label, double amount, LocalDate date) {
        super(label, amount, date);
        this.refunded = false;
    }

    public RefundableExpense(String label, double amount, LocalDate date, boolean refunded) {
        super(label, amount, date);
        this.refunded = refunded;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void refund() {
        this.refunded = true;
    }
}
