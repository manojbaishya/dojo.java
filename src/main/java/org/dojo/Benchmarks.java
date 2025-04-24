package org.dojo;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class Benchmarks {
    public static void run(String[] args) throws IOException {
        Main.main(args);
    }

    @Param({"50", "100", "200", "400", "800", "1600", "3200"})
    public int size;

    @Benchmark
    public boolean benchmarkRuntimeAnalysisHasDuplicates()
    {
        List<Integer> testSubject = IntStream.range(0, size).boxed().toList();
        return RuntimeAnalysis.hasDuplicates(testSubject);
    }

    @Benchmark
    public boolean benchmarkRuntimeAnalysisHasDuplicatesWithSorting()
    {
        List<Integer> testSubject = IntStream.range(0, size).boxed().toList();
        return RuntimeAnalysis.hasDuplicatesWithSorting(testSubject);
    }

    @Benchmark
    public boolean benchmarkRuntimeAnalysisHasDuplicatesWithSets()
    {
        List<Integer> testSubject = IntStream.range(0, size).boxed().toList();
        return RuntimeAnalysis.hasDuplicatesWithSets(testSubject);
    }

    @Benchmark
    public boolean benchmarkRuntimeAnalysisHasDuplicatesWithSetLength()
    {
        List<Integer> testSubject = IntStream.range(0, size).boxed().toList();
        return RuntimeAnalysis.hasDuplicatesWithSetLength(testSubject);
    }
}
