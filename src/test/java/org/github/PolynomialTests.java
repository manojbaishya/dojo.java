package org.github;

import org.apache.commons.numbers.complex.Complex;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTests {

    @Test
    void testComputeFft() {
        var polynomial = new Polynomial(new double[] {6, 5, 8, 32});

        Complex[] expectedFft = new Complex[] {Complex.ofCartesian(51, 0), Complex.ofCartesian(-2, -27), Complex.ofCartesian(-23, 0), Complex.ofCartesian(-2, 27)};
        Complex[] actualFft = polynomial.computeFft();

        System.out.printf("Expected Polynomial is: '%s'\n", Arrays.stream(expectedFft).map(Complex::toString).reduce((x, y) -> String.format("%s, %s", x, y)));
        System.out.printf("Actual Polynomial is: '%s'\n", Arrays.stream(actualFft).map(Complex::toString).reduce((x, y) -> String.format("%s, %s", x, y)));

    }

    @Test
    void testToString() {
        var polynomial = new Polynomial(new double[] {1, 2, 3, 4, 5});
        var expectedPolynomial = "1.0 + 2.0x + 3.0x^2 + 4.0x^3 + 5.0x^4";
        var actualPolynomial = polynomial.toString();
        assertEquals(expectedPolynomial, actualPolynomial, "because actualPolynomial is equal to expectedPolynomial.");
        System.out.printf("Actual Polynomial is: '%s'%n", actualPolynomial);
    }

    @Test
    void testGetCoefficients() {
        var expectedCoefficients = new double[] {6, 5, 8, 32};
        var polynomial = new Polynomial(expectedCoefficients);
        double[] actualCoefficients = polynomial.getCoefficients();

        assertArrayEquals(expectedCoefficients, actualCoefficients);
    }

    @Test
    void testGetFFT() {
        var polynomial = new Polynomial(new double[] {6, 5, 8, 32});

        Complex[] expectedFft = new Complex[] {Complex.ofCartesian(51, 0), Complex.ofCartesian(-2, -27), Complex.ofCartesian(-23, 0), Complex.ofCartesian(-2, 27)};
        Complex[] actualFft = polynomial.computeFft();

        assertEquals(expectedFft.length, actualFft.length);
        for (int i = 0; i < expectedFft.length; i++) {
            assertEquals(expectedFft[i].getReal(), actualFft[i].getReal(), 0.00001);
            assertEquals(expectedFft[i].getImaginary(), actualFft[i].getImaginary(), 0.00001);
        }
    }
}