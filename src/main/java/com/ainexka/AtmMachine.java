package com.ainexka;

import java.util.ArrayList;
import java.util.List;

public class AtmMachine {
    public List<Long> withdraw(long amount) {

        List<Long> bills = new ArrayList<>();
        long accumulatedAmount = 0;

        for (Bills bill : Bills.values()) {
            if (accumulatedAmount <= amount) {
                long numBills = numberOfBills(bill, amount - accumulatedAmount);
                addBillsToTotal(bills, bill, numBills);
                accumulatedAmount = bills.stream().mapToLong(Long::longValue).sum();
            }
        }

        if (amount != accumulatedAmount) {
            throw new InvalidWithdrawlAmountException();
        }

        return bills;
    }

    private long numberOfBills(Bills bill, long withdrawAmount) {
        return withdrawAmount >= bill.amount ? withdrawAmount / bill.amount : 0;
    }

    private void addBillsToTotal(List<Long> bills, Bills bill, long numBills) {
        for (int i = 0; i < numBills; i++) {
            bills.add(bill.amount);
        }

    }

    private enum Bills {
        ONE_HUNDRED(100),
        FIFTY(50),
        TWENTY(20),
        TEN(10);

        private final long amount;

        Bills(long amount) {
            this.amount = amount;
        }
    }
}
