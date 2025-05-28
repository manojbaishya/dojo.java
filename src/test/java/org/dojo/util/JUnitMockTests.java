package org.dojo.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JUnitMockTests {
    @Test
    public void testStreamSum() {
        List<JUnitMock> cartItems = List.of(new JUnitMock(20), new JUnitMock(30));
        final double expectedTotalPrice = 50.0;
        double actualTotalPrice = cartItems.stream().mapToDouble(JUnitMock::price).sum();
        System.out.printf("Actual Total Price is: '%f'\n", actualTotalPrice);
        assertEquals(expectedTotalPrice, actualTotalPrice, "because actualTotalPrice is equal to expectedTotalPrice.");
    }
}
