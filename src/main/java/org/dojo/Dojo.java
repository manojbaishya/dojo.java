package org.dojo;

import org.dojo.algorithms.EasyProblemsProfiler;
import org.dojo.util.Benchmarks;

import java.io.IOException;

public class Dojo {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome to Dojo.java, where we solve Computer Science problems in Java!");
        runDemos(args);
    }

    private static void runDemos(String[] args) throws IOException {
        // Data collection and execution statistics for performance benchmarks
        // using Java Microbenchmark Harness
        Benchmarks.run(args);

        // Code profiling using Java Flight Recorder
        EasyProblemsProfiler.run();
    }
}
