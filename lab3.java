import java.util.Scanner;

public class Лаба3 {
    private static final double EPSILON = 1.0E-10;
    private static final int MAX_ITERATIONS = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер ряда (1, 2, 3, 9, 10, 11): ");
        int number = scanner.nextInt();
        System.out.print("Введите x: ");
        double x = scanner.nextDouble();
        double result = (double)0.0F;
        switch (number) {
            case 1:
                result = series1(x);
                break;
            case 2:
                result = series2(x);
                break;
            case 3:
                result = series3(x);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                System.out.println("Неверный номер ряда.");
                return;
            case 9:
                result = series9(x);
                break;
            case 10:
                result = series10(x);
                break;
            case 11:
                result = series11(x);
        }

        System.out.println("S = " + result);
    }

    public static double series1(double x) {
        double sum = (double)0.0F;
        int n = 1;

        double term;
        do {
            term = Math.pow((double)-1.0F, (double)n) * (double)(2 * n) * Math.pow(x, (double)(2 * n + 1)) / factorial(2 * n + 1);
            sum += term;
            ++n;
        } while(Math.abs(term) > 1.0E-10 && n < 10000);

        return sum;
    }

    public static double series2(double x) {
        if (Math.abs(x) >= (double)1.0F) {
            System.out.println("Ошибка: |x| должен быть < 1");
            return Double.NaN;
        } else {
            double sum = (double)0.0F;
            int n = 0;

            double term;
            do {
                term = Math.pow(x, (double)(2 * n + 1)) / (double)(2 * n + 1);
                sum += term;
                ++n;
            } while(Math.abs(term) > 1.0E-10 && n < 10000);

            return sum;
        }
    }

    public static double series3(double x) {
        if (Math.abs(x) >= (double)1.0F) {
            System.out.println("Ошибка: |x| должен быть < 1");
            return Double.NaN;
        } else {
            double sum = (double)0.0F;
            int n = 0;

            double term;
            do {
                term = Math.pow(x, (double)(4 * n + 1)) / (double)(4 * n + 1);
                sum += term;
                ++n;
            } while(Math.abs(term) > 1.0E-10 && n < 10000);

            return sum;
        }
    }

    public static double series9(double x) {
        if (!(x < (double)-1.0F) && !(x >= (double)1.0F)) {
            double sum = (double)0.0F;
            int n = 1;
            double harmonic = (double)0.0F;

            double term;
            do {
                harmonic += (double)1.0F / (double)n;
                term = harmonic * Math.pow(x, (double)(n + 1)) / (double)(n + 1);
                sum += term;
                ++n;
            } while(Math.abs(term) > 1.0E-10 && n < 10000);

            return (double)2.0F * sum;
        } else {
            System.out.println("Ошибка: x должен быть в [-1, 1)");
            return Double.NaN;
        }
    }

    public static double series10(double x) {
        if (Math.abs(x) >= (double)1.0F) {
            System.out.println("Ошибка: |x| должен быть < 1");
            return Double.NaN;
        } else {
            double sum = (double)0.0F;
            int n = 1;
            double harmonic = (double)0.0F;

            double term;
            do {
                harmonic += (double)1.0F / (double)n;
                term = Math.pow((double)-1.0F, (double)(n - 1)) * harmonic * Math.pow(x, (double)n);
                sum += term;
                ++n;
            } while(Math.abs(term) > 1.0E-10 && n < 10000);

            return sum;
        }
    }

    public static double series11(double x) {
        if (Math.abs(x) >= (double)1.0F) {
            System.out.println("Ошибка: |x| должен быть < 1");
            return Double.NaN;
        } else {
            double sum = (double)0.0F;
            int n = 0;
            double doubleFactorialOdd = (double)1.0F;
            double doubleFactorialEven = (double)1.0F;

            double term;
            do {
                if (n == 0) {
                    term = (double)1.0F;
                } else {
                    doubleFactorialOdd *= (double)((2 * n - 1) * (2 * n + 1)) / ((double)(2 * n) - (double)1.0F);
                    doubleFactorialEven *= (double)(2 * n);
                    term = doubleFactorialOdd * Math.pow(x, (double)(2 * n)) / doubleFactorialEven;
                }

                sum += term;
                ++n;
            } while(Math.abs(term) > 1.0E-10 && n < 10000);

            return sum;
        }
    }

    public static double factorial(int n) {
        if (n < 0) {
            return (double)0.0F;
        } else if (n != 0 && n != 1) {
            double result = (double)1.0F;

            for(int i = 2; i <= n; ++i) {
                result *= (double)i;
            }

            return result;
        } else {
            return (double)1.0F;
        }
    }
}
