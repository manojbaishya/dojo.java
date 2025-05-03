package org.dojo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoopsAndBranchingTests {
    private LoopsAndBranching sut;

    @BeforeEach
    void setUp() {
        sut = new LoopsAndBranching();
    }

    @Test
    void nDimensionalForestBruteForce() {
        int n = 10;
        sut.nDimensionalForestBruteForce(n);
    }

    @Test
    void nDimensionalForestCacheArray() {
        int n = 10;
        sut.nDimensionalForestCacheArray(n);
    }

    @Test
    void nBy2DimensionalForest() {
        int n = 10;
        sut.nBy2DimensionalForest(n);
    }

    @Test
    void nTriangle() {
        int n = 10;
        sut.nTriangle(n);
    }

    @Test
    void nTriangleCached() {
        int n = 9;
        sut.nTriangleCached(n);
    }

    @Test
    void nTriangleRows() {
        int n = 9;
        sut.nTriangleRows(n);
    }

    @Test
    void seeding() {
        int n = 9;
        sut.seeding(n);
    }

    @Test
    void nNumberTriangle() {
        int n = 9;
        sut.nNumberTriangle(n);
    }

    @Test
    void nStarTriangle() {
        int n = 9;
        sut.nStarTriangle(n);
    }

    @Test
    void nStarTriangleReversed() {
        int n = 9;
        sut.nStarTriangleReversed(n);
    }

    @Test
    void nStarTriangleDouble() {
        int n = 9;
        sut.nStarTriangleDouble(n);
    }

    @Test
    void nStarTriangleDoubleOneSided() {
        int n = 9;
        sut.nStarTriangleDoubleOneSided(n);
    }

    @Test
    void nTriangleBinary() {
        int n = 9;
        sut.nTriangleBinary(n);
    }

    @Test
    void mcDonalds() {
        int n = 9;
        sut.mcDonalds(n);
    }

    @Test
    void incrementalNumbers() {
        int n = 9;
        sut.incrementalNumbers(n);
    }

    @Test
    void diamond() {
        int n = 10;
        sut.diamond(n);
    }

    @Test
    void ribbon() {
        int n = 5;
        sut.ribbon(n);
    }

    @Test
    void numSquare() {
        int n = 4;
        sut.numSquare(n);
    }
}
