package cn.ashsmoke.test;

import cn.ashsmoke.util.TimeUtil;

public class FibTest {
    public static void main(String[] args) {
        //System.out.println(fib1(64));
        //System.out.println(fib3(64));
        TimeUtil.check("fib1", () -> System.out.println(fib1(40)));
        TimeUtil.check("fib2", () -> System.out.println(fib2(40)));
        TimeUtil.check("fib3", () -> System.out.println(fib3(40)));
        TimeUtil.check("fib4", () -> System.out.println(fib4(40)));

    }

    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    public static int fib3(int n) {
        if (n <= 1) return n;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int fib4(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

}
