package org.dojo.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuntimeAnalysisTests {
    @Test
    void hasDuplicates() {
        List<Integer> listHasDuplicates = List.of(1, 2, 6, 3, 4, 5, 6, 7, 8);
        boolean result = RuntimeAnalysis.hasDuplicates(listHasDuplicates);
        assertTrue(result, "because at-least '6' is a duplicate.");
        System.out.println("listHasDuplicates returned true!");

        List<Integer> listDoesNotHaveDuplicates = List.of(1, 2, 3, 4);
        result = RuntimeAnalysis.hasDuplicates(listDoesNotHaveDuplicates);
        assertFalse(result, "because has no duplicates.");
        System.out.println("listHasDuplicates returned false!");
    }
}
