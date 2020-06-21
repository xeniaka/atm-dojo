package com.ainexka;

public class MininumWithdrawNotReachedException extends RuntimeException {

    public MininumWithdrawNotReachedException(Long amount) {
        super(String.format("Mininum Amount is %d", amount));
    }
}
