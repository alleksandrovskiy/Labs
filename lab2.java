public class Лаба2 {
    public static void main(String[] args) {
        double x = (double)1.0F;
        double a = (double)2.0F;
        double b = (double)0.5F;
        double z2;
        if (x > (double)0.0F) {
            z2 = (a + (double)1.0F) / (double)2.0F * Math.exp(x);
        } else {
            z2 = Math.cos(b * x + (double)1.0F);
        }

        System.out.println("Задача 2: y = {(a + 1) / 2 * e^x, x > 0; cos(bx + 1), x <= 0}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z2);
        double z4;
        if (x <= (double)2.0F) {
            z4 = (a + x * x) / (b + Math.log(Math.abs(x) + (double)1.0F));
        } else {
            z4 = Math.exp(x) + Math.log(Math.abs(x));
        }

        System.out.println("Задача 4: y = {(a + x^2) / (b + ln(|x| + 1)), x <= 2; e^x + ln|x|, x > 2}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z4);
        double z6;
        if (x <= (double)-1.0F) {
            z6 = a * Math.log10(x * x);
        } else {
            z6 = (b + x * x) / (x * x + a);
        }

        System.out.println("Задача 6: y = {a * lg(x^2), x <= -1; (b + x^2) / (x^2 + a), x > -1}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z6);
        double z10;
        if (x <= (double)0.0F) {
            z10 = Math.sqrt(Math.exp(x) - (double)1.0F);
        } else {
            z10 = (double)1.0F / (x * x + a);
        }

        System.out.println("Задача 10: y = {sqrt(e^x - 1), x <= 0; 1 / (x^2 + a), x > 0}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z10);
        double z12;
        if (x <= (double)1.0F) {
            z12 = (double)2.0F * x * x + Math.cos(b * x);
        } else {
            z12 = Math.exp(x) + Math.log10(x * x);
        }

        System.out.println("Задача 12: y = {2x^2 + cos(bx), x <= 1; e^x + lg(x^2), x > 1}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z12);
        double z14;
        if (x <= (double)-1.0F) {
            z14 = 0.2 * x * x + b * x + Math.log(Math.abs(x + (double)3.0F));
        } else {
            z14 = b * x * x + Math.log(x + (double)3.0F);
        }

        System.out.println("Задача 14: y = {0.2x^2 + [bx + ln|x + 3|], x <= -1; bx^2 + ln(x + 3), x > -1}");
        System.out.printf("Для x = %.2f, y = %.2f%n%n", x, z14);
    }
}
