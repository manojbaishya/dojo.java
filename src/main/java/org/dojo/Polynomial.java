package org.dojo;

import org.apache.commons.numbers.complex.Complex;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Polynomial {
    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    private final double[] coefficients;
    public double[] getCoefficients() {
        return coefficients;
    }

    public int degreeBound() {
        return coefficients.length;
    }

    private Complex[] fft;
    public Complex[] getFFT() {
        return fft;
    }

    public Complex[] computeFft() {
        fft = computeFft(coefficients, degreeBound());
        return fft;
    }

    private Complex[] computeFft(double[] coefficients, int degreeBound) {
        if (degreeBound == 1) return Arrays.stream(coefficients).mapToObj(x -> Complex.ofCartesian(x, 0)).toArray(Complex[]::new);

        var wn = Complex.ofCartesian(0, 2 * Math.PI / degreeBound).exp();
        var w = Complex.ofCartesian(1, 0);

        Complex[] fftEven = computeFft(IntStream.range(0, coefficients.length).filter(k -> k % 2 == 0).mapToDouble(j -> coefficients[j]).toArray(), degreeBound / 2);
        Complex[] fftOdd = computeFft(IntStream.range(0, coefficients.length).filter(k -> k % 2 == 1).mapToDouble(j -> coefficients[j]).toArray(), degreeBound / 2);

        Complex[] fft = new Complex[degreeBound];
        for (int k = 0; k < degreeBound / 2; k++) {
            fft[k] = fftEven[k].add(w.multiply(fftOdd[k]));
            fft[k + degreeBound / 2] = fftEven[k].subtract(w.multiply(fftOdd[k]));
            w =  w.multiply(wn);
        }
        return fft;
    }

    @Override
    public String toString() {
        var polynomial = new StringBuilder();
        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0) polynomial.append(String.format("%s", coefficients[i]));
            else if (i == 1) polynomial.append(String.format(" + %sx", coefficients[i]));
            else polynomial.append(String.format(" + %sx^%d", coefficients[i], i));
        }
        return polynomial.toString();
    }
}
