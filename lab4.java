import java.util.Arrays;

public class lab4 {

    public static class MinMaxResult {
        public final int nMin;
        public final int nMax;

        public MinMaxResult(int nMin, int nMax) {
            this.nMin = nMin;
            this.nMax = nMax;
        }
    }

    public static MinMaxResult findMinMaxIndexes(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        int nMin = 0;
        int nMax = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[nMin]) {
                nMin = i;
            }
            if (array[i] > array[nMax]) {
                nMax = i;
            }
        }
        return new MinMaxResult(nMin, nMax);
    }

    public static void main(String[] args) {
        // Пример массивов
        double[] A = {3.5, -2.1, 8.9, 4.2};
        double[] B = {1.0, 5.6, -3.8, 7.2, 2.4};
        double[] C = {9.1, 6.3, 0.7, -1.5};

        // Анализ массива A
        MinMaxResult resultA = findMinMaxIndexes(A);
        System.out.println("Массив A: " + Arrays.toString(A));
        System.out.printf("NMin: %d (элемент %.2f), NMax: %d (элемент %.2f)\n\n",
                resultA.nMin, A[resultA.nMin], resultA.nMax, A[resultA.nMax]);

        // Анализ массива B
        MinMaxResult resultB = findMinMaxIndexes(B);
        System.out.println("Массив B: " + Arrays.toString(B));
        System.out.printf("NMin: %d (элемент %.2f), NMax: %d (элемент %.2f)\n\n",
                resultB.nMin, B[resultB.nMin], resultB.nMax, B[resultB.nMax]);

        // Анализ массива C
        MinMaxResult resultC = findMinMaxIndexes(C);
        System.out.println("Массив C: " + Arrays.toString(C));
        System.out.printf("NMin: %d (элемент %.2f), NMax: %d (элемент %.2f)\n",
                resultC.nMin, C[resultC.nMin], resultC.nMax, C[resultC.nMax]);
    }
}
