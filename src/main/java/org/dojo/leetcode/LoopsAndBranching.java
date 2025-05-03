package org.dojo.leetcode;

public class LoopsAndBranching {
    public void nDimensionalForestBruteForce(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void nDimensionalForestCacheArray(int n) {
        char[] line = new char[n];
        for (int j = 0; j < n; j++) {
            line[j] = '*';
        }

        for (int i = 0; i < n; i++) {
            System.out.println(line);
        }
    }

    public void nBy2DimensionalForest(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void nTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int compute = j + 1; // NxN compute steps
                System.out.print(compute);
            }
            System.out.println();
        }
    }

    public void nTriangleCached(int n) {
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            int compute = i + 1; // Compute moved to outer loop
            cache[i] = compute; // Cache results and reuse them
            for (int j = 0; j <= i; j++) {
                System.out.print(cache[j]);
            }
            System.out.println();
        }
    }

    public void nTriangleRows(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    public void seeding(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void nNumberTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public void nStarTriangle(int n) {
        final int a0 = 1;
        final int del = 2;
        int l = a0 + (n - 1) * del;
        for (int i = 0; i < n; i++) {
            int c = a0 + i * del;
            int sp = (l - c) / 2;
            for (int j = 0; j < l; j++) {
                System.out.print(sp <= j && j < l - sp ? '*' : ' ');
            }
            System.out.println();
        }
    }

    public void nStarTriangleReversed(int n) {
        final int a0 = 1;
        final int del = 2;
        int l = a0 + (n - 1) * del;
        for (int i = 0; i < n; i++) {
            int c = a0 + i * del;
            int sp = i * 2;
            for (int j = 0; j < l; j++) {
                System.out.print(sp <= j && j < l - sp ? '*' : ' ');
            }
            System.out.println();
        }
    }

    public void nStarTriangleDouble(int n) {
        nStarTriangle(n);
        nStarTriangleReversed(n);
    }

    public void nStarTriangleDoubleOneSided(int n) {
        nBy2DimensionalForest(n);
        seeding(n - 1);
    }

    public void nTriangleBinary(int n) {
        for (int i = 0; i < n; i++) {
            int init = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(init);
                init ^= 1;
            }
            System.out.println();
        }
    }

    public void mcDonalds(int n) {
        int l = n * 2;
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            for (int j = 0; j < l; j++) {
                if (num <= j && j < l - num) {
                    System.out.print(' ');
                } else if (j < num) {
                    System.out.print(j + 1);
                } else {
                    System.out.print(l - j);
                }
            }
            System.out.println();
        }
    }

    public void incrementalNumbers(int n) {
        int marker = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("%d ", marker);
                marker++;
            }
            System.out.println();
        }
    }

    public void diamond(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print('*');
            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            for (int j = 0; j < 2 * n - 2 * (i + 1); j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void ribbon(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            for (int j = 0; j < 2 * n - 2 * (i + 1); j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print('*');
            }
            for (int j = 0; j < 2 * (i + 1); j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void numSquare(int n) {
        int rows = 2 * n - 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                int top = i;
                int left = j;
                int right = rows - 1 - j;
                int bottom = rows - 1 - i;

                int compute = n - Math.min(Math.min(left, right), Math.min(top, bottom));
                System.out.print(compute);
            }
            System.out.println();
        }
    }
}
