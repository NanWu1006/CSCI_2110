import java.util.Random;

/**
 * Created by KanzakiMirai on 3/15/16.
 */
public class testHeaps {
    public static void main(String[] args) {
        testMaxHeap();
        System.out.println();
        testMinHeap();
    }

    private static void testMaxHeap() {
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<>();
        for (int i = 0; i < 30; i++) {
            integerMaxHeap.add((new Random()).nextInt(100));
        }
        System.out.println("MAX HEAP ORIGINAL DATA");
        Integer tmp = integerMaxHeap.first();
        while (tmp != null) {
            tmp = integerMaxHeap.next();
            System.out.println(tmp == null ? "" : tmp);
        }
        System.out.println("DESC order output");
        for (int i = 0; i < 30; i++) {
            System.out.println(integerMaxHeap.deleteMax());
        }
    }

    private static void testMinHeap() {
        MinHeap<Integer> integerMinHeap = new MinHeap<>();
        for (int i = 0; i < 30; i++) {
            integerMinHeap.add((new Random()).nextInt(100));
        }
        System.out.println("MIN HEAP ORIGINAL DATA");
        Integer tmp = integerMinHeap.first();
        while (tmp != null) {
            tmp = integerMinHeap.next();
            System.out.println(tmp == null ? "" : tmp);
        }
        System.out.println("ASC order output");
        for (int i = 0; i < 30; i++) {
            System.out.println(integerMinHeap.deleteMin());
        }
    }
}

//       MAX HEAP ORIGINAL DATA
//        89
//        88
//        80
//        79
//        76
//        82
//        42
//        64
//        77
//        57
//        73
//        69
//        64
//        69
//        29
//        15
//        6
//        29
//        14
//        53
//        26
//        54
//        17
//        31
//        66
//        12
//        23
//        37
//        49
//
//        DESC order output
//        98
//        89
//        88
//        82
//        80
//        79
//        77
//        76
//        73
//        69
//        69
//        66
//        64
//        64
//        57
//        54
//        53
//        49
//        42
//        37
//        31
//        29
//        29
//        26
//        23
//        17
//        15
//        14
//        12
//        6
//
//        MIN HEAP ORIGINAL DATA
//        28
//        11
//        33
//        28
//        17
//        18
//        69
//        41
//        59
//        64
//        35
//        74
//        19
//        44
//        99
//        71
//        94
//        85
//        92
//        63
//        83
//        67
//        71
//        68
//        83
//        81
//        65
//        49
//        58
//
//        ASC order output
//        2
//        11
//        17
//        18
//        19
//        28
//        28
//        33
//        35
//        41
//        44
//        49
//        58
//        59
//        63
//        64
//        65
//        67
//        68
//        69
//        71
//        71
//        74
//        81
//        83
//        83
//        85
//        92
//        94
//        99
//
//        Process finished with exit code 0