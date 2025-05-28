package org.dojo.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProblemsTests {
    private ArrayProblems sut;

    @BeforeEach
    void setUp() { sut = new ArrayProblems(); }

    static Stream<Arguments> longestCommonPrefixData() {
        return Stream.of(
                Arguments.of(7, new int[] {2, 3, 1, 2, 4, 3}, 2),
                Arguments.of(4, new int[] {1, 4, 4}, 1),
                Arguments.of(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}, 0)
        );
    }
    @ParameterizedTest
    @MethodSource("longestCommonPrefixData")
    void longestCommonPrefix(int target, int[] nums, int expected) {
        int actual = sut.minSubArrayLen(target, nums);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> mergeSortData() {
        return Stream.of(
                Arguments.of(
                        new int[] {139, 395, 296, 492, 377, 473},
                        new int[] {139, 296, 377, 395, 473, 492}
                ),
                Arguments.of(
                        new int[] {359, 266, 125, 318, 224},
                        new int[] {125, 224, 266, 318, 359}
                ),
                Arguments.of(
                        new int[] {328, 182, 341, 327, 115, 384, 447, 210, 316, 220},
                        new int[] {115, 182, 210, 220, 316, 327, 328, 341, 384, 447}
                ),
                Arguments.of(
                        new int[] {76088, 73640, 70858, 75035, 51858, 88499, 22543, 6648, 80422, 78931, 91252, 17044, 97663, 83138, 76228, 37233, 38384, 70984, 16304, 76902, 94159, 59994, 44607, 51800, 4264},
                        new int[] {4264, 6648, 16304, 17044, 22543, 37233, 38384, 44607, 51800, 51858, 59994, 70858, 70984, 73640, 75035, 76088, 76228, 76902, 78931, 80422, 83138, 88499, 91252, 94159, 97663}
                ),
                Arguments.of(
                        new int[] {99140, 9327, 88279, 43779, 57763, 93010, 45764, 98581, 3000, 7322, 21898, 96719, 66520, 15489, 6124, 50053, 74645, 35177, 73757, 57436, 882, 61197, 81655, 2027, 91510},
                        new int[] {882, 2027, 3000, 6124, 7322, 9327, 15489, 21898, 35177, 43779, 45764, 50053, 57436, 57763, 61197, 66520, 73757, 74645, 81655, 88279, 91510, 93010, 96719, 98581, 99140}
                )
        );
    }
    @ParameterizedTest
    @MethodSource("mergeSortData")
    void mergeSort(int[] nums, int[] expected) {
        System.out.printf("Expected: %s%n", Arrays.toString(nums));
        sut.mergeSort(nums, 0, nums.length - 1);
        System.out.printf("Actual: %s%n", Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    static Stream<Arguments> quickSortData() {
        return Stream.of(
                Arguments.of(
                        new int[] {4, 6, 2, 5, 7, 9, 1, 3},
                        new int[] {1, 2, 3, 4, 5, 6, 7, 9}
                ),
                Arguments.of(
                        new int[] {544, 484, 246, 354, 872, 767, 164, 134, 293, 879},
                        new int[] {134, 164, 246, 293, 354, 484, 544, 767, 872, 879}
                ),
                Arguments.of(
                        new int[] {328, 328, 328, 416, 411, 296, 296, 296, 484, 102, 102, 150},
                        new int[] {102, 102, 150, 296, 296, 296, 328, 328, 328, 411, 416, 484}
                ),
                Arguments.of(
                        new int[] {101, 114, 330, 207, 220, 179, 188, 228, 415, 374},
                        new int[] {101, 114, 179, 188, 207, 220, 228, 330, 374, 415}
                ),
                Arguments.of(
                        new int[] {139, 395, 296, 492, 377, 473},
                        new int[] {139, 296, 377, 395, 473, 492}
                ),
                Arguments.of(
                        new int[] {359, 266, 125, 318, 224},
                        new int[] {125, 224, 266, 318, 359}
                ),
                Arguments.of(
                        new int[] {328, 182, 341, 327, 115, 384, 447, 210, 316, 220},
                        new int[] {115, 182, 210, 220, 316, 327, 328, 341, 384, 447}
                ),
                Arguments.of(
                        new int[] {76088, 73640, 70858, 75035, 51858, 88499, 22543, 6648, 80422, 78931, 91252, 17044, 97663, 83138, 76228, 37233, 38384, 70984, 16304, 76902, 94159, 59994, 44607, 51800, 4264},
                        new int[] {4264, 6648, 16304, 17044, 22543, 37233, 38384, 44607, 51800, 51858, 59994, 70858, 70984, 73640, 75035, 76088, 76228, 76902, 78931, 80422, 83138, 88499, 91252, 94159, 97663}
                ),
                Arguments.of(
                        new int[] {99140, 9327, 88279, 43779, 57763, 93010, 45764, 98581, 3000, 7322, 21898, 96719, 66520, 15489, 6124, 50053, 74645, 35177, 73757, 57436, 882, 61197, 81655, 2027, 91510},
                        new int[] {882, 2027, 3000, 6124, 7322, 9327, 15489, 21898, 35177, 43779, 45764, 50053, 57436, 57763, 61197, 66520, 73757, 74645, 81655, 88279, 91510, 93010, 96719, 98581, 99140}
                ),
                Arguments.of(
                        new int[] {342, 493, 207, 161, 221, 500, 384, 500, 230, 426, 124, 340, 156, 258, 240, 304, 200, 369, 106, 315, 423, 437, 155, 416, 295, 312},
                        new int[] {106, 124, 155, 156, 161, 200, 207, 221, 230, 240, 258, 295, 304, 312, 315, 340, 342, 369, 384, 416, 423, 426, 437, 493, 500, 500}
                ),
                Arguments.of(
                        new int[] {407, 177, 296, 383, 129, 148, 140, 474, 397, 103, 302, 315, 426, 309, 166, 333, 123, 100, 236, 255, 358, 296, 474, 131, 387, 491, 259, 163, 476, 431, 347, 442, 279, 311, 410, 222, 210, 201, 341, 351, 112, 478, 221, 401, 186, 450, 319, 179, 214, 233, 133, 161, 420, 243, 228, 368, 355, 122, 277, 415, 433, 342, 119, 497, 330, 122, 418, 269, 496, 279, 462, 436, 306, 184, 119, 218, 155, 336, 254, 113, 219, 288, 278, 291, 474, 456, 480, 120, 176, 250, 319, 362, 141, 312, 303, 191, 486, 490, 487, 121, 415, 195, 239, 137, 356, 141, 381, 140, 271, 318, 386, 413, 394, 453, 472, 470, 427, 364, 185, 445, 390, 447, 269, 268, 192, 494, 463, 441, 481, 148, 143, 224, 228, 121, 272, 356, 392, 239, 319, 314, 388, 244, 462, 424, 280, 241, 183, 464, 389, 114, 117, 263, 333, 456, 365, 160, 494, 356, 130, 120, 380, 169, 217, 365, 304, 155, 400, 209, 358, 420, 355, 412, 418, 218, 265, 300, 183, 360, 446, 397, 397, 496, 224, 453, 346, 257, 492, 430, 420, 351, 366, 355, 305, 292, 453, 196, 269, 161, 108, 228, 352, 308, 223, 329, 191, 404, 297, 221, 270, 218, 114, 316, 143, 317, 341, 233, 105, 423, 298, 392, 353, 162, 380, 256, 113, 204, 350, 359, 310, 116, 382, 112, 219, 301, 215, 172, 125, 235, 109, 259, 185, 446, 441, 143, 435, 162, 424, 356, 215, 362, 195, 219, 486, 428, 131, 403, 361, 496, 102, 210, 354, 305, 223, 492, 256, 299, 220, 388, 329, 302, 239, 405, 431, 452, 103, 210, 392, 402, 439, 378, 381, 382, 212, 220, 244, 458, 280, 331, 414, 252, 310, 319, 214, 363, 274, 276, 235, 467, 405, 498, 251, 259, 181, 366, 225, 365, 176, 245, 268, 159, 336, 226, 379, 258, 225, 231, 295, 257, 204, 291, 314, 355, 261, 470, 287, 102, 376, 259, 390, 276, 141, 447, 231, 113, 251, 126, 382, 465, 407, 339, 229, 285, 492, 128, 434, 243, 126, 415, 274, 340, 450, 485, 201, 432, 369, 410, 465, 176, 150, 107, 271, 300, 366, 493, 223, 202, 457, 108, 264, 344, 470, 150, 150, 227, 437, 460, 404, 173, 454, 143, 433, 483, 342, 421, 279, 265, 294, 480, 339, 256, 498, 122, 335, 180, 408, 403, 448, 136, 176, 296, 449, 177, 284, 243, 146, 399, 293, 346, 442, 285, 124, 445, 472, 417, 471, 364, 298, 458, 342, 250, 349, 382, 254, 196, 197, 434, 196, 206, 368, 313, 490, 125, 426, 410, 414, 162, 199, 134, 494, 460, 465, 436, 353, 111, 113, 177, 382, 187, 228, 323, 220, 493, 171, 180, 356, 331, 280, 178, 168, 384, 235, 271, 473, 216, 411, 294, 309, 224, 268, 128, 412, 372, 270, 295, 158, 203, 431, 465, 401, 354, 262, 267, 498, 347, 283, 111, 482, 130, 201, 386, 379, 482, 247, 440, 456, 273, 223, 190, 228, 262},
                        new int[] {100, 102, 102, 103, 103, 105, 107, 108, 108, 109, 111, 111, 112, 112, 113, 113, 113, 113, 114, 114, 116, 117, 119, 119, 120, 120, 121, 121, 122, 122, 122, 123, 124, 125, 125, 126, 126, 128, 128, 129, 130, 130, 131, 131, 133, 134, 136, 137, 140, 140, 141, 141, 141, 143, 143, 143, 143, 146, 148, 148, 150, 150, 150, 155, 155, 158, 159, 160, 161, 161, 162, 162, 162, 163, 166, 168, 169, 171, 172, 173, 176, 176, 176, 176, 177, 177, 177, 178, 179, 180, 180, 181, 183, 183, 184, 185, 185, 186, 187, 190, 191, 191, 192, 195, 195, 196, 196, 196, 197, 199, 201, 201, 201, 202, 203, 204, 204, 206, 209, 210, 210, 210, 212, 214, 214, 215, 215, 216, 217, 218, 218, 218, 219, 219, 219, 220, 220, 220, 221, 221, 222, 223, 223, 223, 223, 224, 224, 224, 225, 225, 226, 227, 228, 228, 228, 228, 228, 229, 231, 231, 233, 233, 235, 235, 235, 236, 239, 239, 239, 241, 243, 243, 243, 244, 244, 245, 247, 250, 250, 251, 251, 252, 254, 254, 255, 256, 256, 256, 257, 257, 258, 259, 259, 259, 259, 261, 262, 262, 263, 264, 265, 265, 267, 268, 268, 268, 269, 269, 269, 270, 270, 271, 271, 271, 272, 273, 274, 274, 276, 276, 277, 278, 279, 279, 279, 280, 280, 280, 283, 284, 285, 285, 287, 288, 291, 291, 292, 293, 294, 294, 295, 295, 296, 296, 296, 297, 298, 298, 299, 300, 300, 301, 302, 302, 303, 304, 305, 305, 306, 308, 309, 309, 310, 310, 311, 312, 313, 314, 314, 315, 316, 317, 318, 319, 319, 319, 319, 323, 329, 329, 330, 331, 331, 333, 333, 335, 336, 336, 339, 339, 340, 341, 341, 342, 342, 342, 344, 346, 346, 347, 347, 349, 350, 351, 351, 352, 353, 353, 354, 354, 355, 355, 355, 355, 356, 356, 356, 356, 356, 358, 358, 359, 360, 361, 362, 362, 363, 364, 364, 365, 365, 365, 366, 366, 366, 368, 368, 369, 372, 376, 378, 379, 379, 380, 380, 381, 381, 382, 382, 382, 382, 382, 383, 384, 386, 386, 387, 388, 388, 389, 390, 390, 392, 392, 392, 394, 397, 397, 397, 399, 400, 401, 401, 402, 403, 403, 404, 404, 405, 405, 407, 407, 408, 410, 410, 410, 411, 412, 412, 413, 414, 414, 415, 415, 415, 417, 418, 418, 420, 420, 420, 421, 423, 424, 424, 426, 426, 427, 428, 430, 431, 431, 431, 432, 433, 433, 434, 434, 435, 436, 436, 437, 439, 440, 441, 441, 442, 442, 445, 445, 446, 446, 447, 447, 448, 449, 450, 450, 452, 453, 453, 453, 454, 456, 456, 456, 457, 458, 458, 460, 460, 462, 462, 463, 464, 465, 465, 465, 465, 467, 470, 470, 470, 471, 472, 472, 473, 474, 474, 474, 476, 478, 480, 480, 481, 482, 482, 483, 485, 486, 486, 487, 490, 490, 491, 492, 492, 492, 493, 493, 494, 494, 494, 496, 496, 496, 497, 498, 498, 498}
                )
        );
    }
    @ParameterizedTest
    @MethodSource("quickSortData")
    void quickSort(int[] nums, int[] expected) {
        System.out.printf("Expected: %s%n", Arrays.toString(expected));
        sut.quickSort(nums, 0, nums.length - 1);
        System.out.printf("Actual: %s%n", Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    static Stream<Arguments> getSecondLargestData() {
        return Stream.of(
                Arguments.of(new int[] {12, 35, 1, 10, 34, 1}, 34),
                Arguments.of(new int[] {10, 5, 10}, 5)
        );
    }
    @ParameterizedTest
    @MethodSource("getSecondLargestData")
    void getSecondLargest(int[] nums, int expected) {
        int actual = sut.getSecondLargest(nums);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> checkSortAndRotationData() {
        return Stream.of(
                Arguments.of(new int[] {3, 4, 5, 1, 2}, true),
                Arguments.of(new int[] {2, 1, 3, 4}, false),
                Arguments.of(new int[] {1, 2, 3}, true)
        );
    }
    @ParameterizedTest
    @MethodSource("checkSortAndRotationData")
    void checkSortAndRotation(int[] nums, boolean expected) {
        boolean actual = sut.checkSortAndRotation(nums);
        System.out.printf("Expected: %b, Actual: %b%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> removeDuplicatesData() {
        return Stream.of(
                Arguments.of(
                        new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                        new int[] {0, 1, 2, 3, 4, 2, 2, 3, 3, 4},
                        5
                ),
                Arguments.of(
                        new int[] {1, 1, 2},
                        new int[] {1, 2, 2},
                        2
                )
        );
    }
    @ParameterizedTest
    @MethodSource("removeDuplicatesData")
    void removeDuplicates(int[] input, int[] expected, int expectedSize) {
        int actualSize = sut.removeDuplicates(input);
        for (int i = 0; i < actualSize; i++) {
            assertEquals(input[i], expected[i]);
            assertEquals(expectedSize, actualSize);
        }
        System.out.printf("Expected: %s, ActualSize: %d%n", Arrays.toString(expected), actualSize);
    }
    @ParameterizedTest
    @MethodSource("removeDuplicatesData")
    void removeDuplicates2(int[] input, int[] expected, int expectedSize) {
        int actualSize = sut.removeDuplicates2(input);
        for (int i = 0; i < actualSize; i++) {
            assertEquals(input[i], expected[i]);
            assertEquals(expectedSize, actualSize);
        }
        System.out.printf("Expected: %s, ActualSize: %d%n", Arrays.toString(expected), actualSize);
    }

    static Stream<Arguments> rotateData() {
        return Stream.of(
                Arguments.of(
                        new int[] {1, 2, 3, 4, 5, 6, 7},
                        3,
                        new int[] {5, 6, 7, 1, 2, 3, 4}
                ),
                Arguments.of(
                        new int[] {-1, -100, 3, 99},
                        2,
                        new int[] {3, 99, -1, -100}
                )
        );
    }
    @ParameterizedTest
    @MethodSource("rotateData")
    void rotate(int[] input, int k, int[] expected) {
        sut.rotate(input, k);
        assertArrayEquals(expected, input);
    }
    @ParameterizedTest
    @MethodSource("rotateData")
    void rotate2(int[] input, int k, int[] expected) {
        sut.rotate2(input, k);
        assertArrayEquals(expected, input);
    }
    static Stream<Arguments> findUnionData() {
        return Stream.of(
                Arguments.of(
                        new int[] {1, 2, 3, 4, 5},
                        new int[] {1, 2, 3, 6, 7},
                        new int[] {1, 2, 3, 4, 5, 6, 7}
                ),
                Arguments.of(
                        new int[] {2, 2, 3, 4, 5},
                        new int[] {1, 1, 2, 3, 4},
                        new int[] {1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[] {1, 1, 1, 1, 1},
                        new int[] {2, 2, 2, 2, 2},
                        new int[] {1, 2}
                )
        );
    }
    @ParameterizedTest
    @MethodSource("findUnionData")
    void findUnion(int[] input1, int[] input2, int[] expected) {
        int[] actual = sut.findUnion(input1, input2);
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> findMaxConsecutiveOnesData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 0, 1, 1, 1}, 3)
        );
    }
    @ParameterizedTest
    @MethodSource("findMaxConsecutiveOnesData")
    void findMaxConsecutiveOnes(int[] nums, int expected) {
        int actual = sut.findMaxConsecutiveOnes(nums);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> longestSubarraySumData() {
        return Stream.of(
                Arguments.of(new int[] {10, 5, 2, 7, 1, -10}, 15, 4)
        );
    }
    @ParameterizedTest
    @MethodSource("longestSubarraySumData")
    void longestSubarraySum(int[] nums, int k, int expected) {
        int actual = sut.longestSubarraySum(nums, k);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> longestSubarraySumPrefixData() {
        return Stream.of(
                Arguments.of(new int[] {10, 5, 2, 7, 1, -10}, 15, 6)
        );
    }
    @ParameterizedTest
    @MethodSource("longestSubarraySumPrefixData")
    void longestSubarraySumPrefix(int[] nums, int k, int expected) {
        int actual = sut.longestSubarraySumPrefix(nums, k);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> twoSum2Data() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 3}, 6, new int[] {0, 2}),
                Arguments.of(new int[] {0, 4, 3, 0}, 0, new int[] {0, 3}),
                Arguments.of(new int[] {-3, 4, 3, 90}, 0, new int[] {0, 2}),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, -8, new int[] {2, 4}),
                Arguments.of(new int[] {-10, -1, -18, -19}, -19, new int[] {1, 2})
        );
    }
    @ParameterizedTest
    @MethodSource("twoSum2Data")
    void twoSum2(int[] inputArray, int inputTarget, int[] expected) {
        int[] actual = sut.twoSum2(inputArray, inputTarget);
        System.out.printf("Actual: %s%n", Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> majorityElementData() {
        return Stream.of(
                Arguments.of(new int[] {2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }
    @ParameterizedTest
    @MethodSource("majorityElementData")
    void majorityElement(int[] nums, int expected) {
        int actual = sut.majorityElement(nums);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("majorityElementData")
    void majorityElementMoore(int[] nums, int expected) {
        int actual = sut.majorityElementMoore(nums);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> rearrangeArrayAlternateSignsData() {
        return Stream.of(
                Arguments.of(
                        new int[] {3, 1, -2, -5, 2, -4},
                        new int[] {3, -2, 1, -5, 2, -4}
                )
        );
    }
    @ParameterizedTest
    @MethodSource("rearrangeArrayAlternateSignsData")
    void rearrangeArrayAlternateSigns(int[] nums, int[] expected) {
        int[] actual = sut.rearrangeArrayAlternateSigns(nums);
        System.out.printf("Expected: %s, Actual: %s%n", Arrays.toString(expected), Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> nextPermutationData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, new int[] {1, 3, 2}),
                Arguments.of(new int[] {3, 2, 1}, new int[] {1, 2, 3}),
                Arguments.of(new int[] {2, 3, 1}, new int[] {3, 1, 2})
        );
    }
    @ParameterizedTest
    @MethodSource("nextPermutationData")
    void nextPermutation(int[] nums, int[] expected) {
        System.out.printf("Input: %s%n", Arrays.toString(nums));
        sut.nextPermutation(nums);
        System.out.printf("Actual: %s%n", Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }

    static Stream<Arguments> leadersData() {
        return Stream.of(
                Arguments.of(new int[] {16, 17, 4, 3, 5, 2}, new int[] {17, 5, 2})
        );
    }
    @ParameterizedTest
    @MethodSource("leadersData")
    public void leaders(int[] nums, int[] expected) {
        int[] actual = sut.leaders(nums).stream().mapToInt(i -> i).toArray();
        System.out.printf("Expected: %s, Actual: %s%n", Arrays.toString(expected), Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> rotateImageData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}})
        );
    }
    @ParameterizedTest
    @MethodSource("rotateImageData")
    void rotateImage(int[][] input, int[][] expected) {
        sut.rotateImage(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> spiralOrderData() {
        return Stream.of(
                Arguments.of(
                        new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                Arguments.of(
                        new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                ),
                Arguments.of(
                        new int[][] {{3}, {2}},
                        List.of(3, 2)
                ),
                Arguments.of(
                        new int[][] {{7}, {9}, {6}},
                        List.of(7, 9, 6)
                ),
                Arguments.of(
                        new int[][] {{2, 5}, {8, 4}, {0, -1}},
                        List.of(2, 5, 4, -1, 0, 8)
                ),
                Arguments.of(
                        new int[][] {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                                {17, 18, 19, 20},
                                {21, 22, 23, 24}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 16, 20, 24, 23, 22, 21, 17, 13, 9, 5, 6, 7, 11, 15, 19, 18, 14, 10)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("spiralOrderData")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        List<Integer> actual = sut.spiralOrder(matrix);
        System.out.printf("Expected: %s, Actual: %s%n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> subarraySumData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 1}, 2, 2),
                Arguments.of(new int[] {1, 2, 3}, 3, 2)
        );
    }
    @ParameterizedTest
    @MethodSource("subarraySumData")
    void subarraySum(int[] nums, int k, int expected) {
        int actual = sut.subarraySum(nums, k);
        System.out.printf("Expected: %d, Actual: %d%n", expected, actual);
        assertEquals(expected, actual);
    }
}
