package com.ainexka;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtmMachineTest {

    @Test
    public void testWithdrawEqualsLowestBillValue_returnsOneLowestBill() {
        List<Long> expected = asList(10L);

        List<Long> result = new AtmMachine().withdraw(10);

        assertEquals(expected, result);
    }

    @Test
    public void testWithdrawHighestBillValue_returnsOneHighestBill() {
        List<Long> expected = asList(100L);

        List<Long> result = new AtmMachine().withdraw(100);

        assertEquals(expected, result);
    }

    @Test
    public void testWithdrawAmountMultipleOfBillValue_returnsTwoBillsSameValue() {
        List<Long> expected = asList(20L, 20L);

        List<Long> result = new AtmMachine().withdraw(40);

        assertEquals(expected, result);
    }

    @Test
    public void testWithdrawAmountLessThanLowestBillValue_returnsException() {
        try {
            new AtmMachine().withdraw(5);
        } catch (Exception e) {
            assertTrue(e instanceof InvalidWithdrawlAmountException);
        }
    }

    @Test
    public void testWithdrawInvalidAmount_returnsException() {
        try {
            new AtmMachine().withdraw(225);
        } catch (Exception e) {
            assertTrue(e instanceof InvalidWithdrawlAmountException);
        }
    }

    @Test
    public void testWithdraw80_returnsOne50One20One10() {
        List<Long> expected = asList(50L, 20L, 10L);

        List<Long> result = new AtmMachine().withdraw(80);

        assertEquals(expected, result);
    }

    @Test
    public void testWithdraw180_returnsTwo50One20One10() {
        List<Long> expected = asList(100L, 50L, 20L, 10L);

        List<Long> result = new AtmMachine().withdraw(180);

        assertEquals(expected, result);
    }

    @Test
    public void testWithdraw390_returnsTwo50One20One10() {
        List<Long> expected = asList(100L, 100L, 100L, 50L, 20L, 20L);

        List<Long> result = new AtmMachine().withdraw(390);

        assertEquals(expected, result);
    }
}
