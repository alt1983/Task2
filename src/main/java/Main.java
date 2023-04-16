package main.java;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму размена");
        int n = scanner.nextInt();
        System.out.println("Введите номиналы монет через запятую");
        String s = scanner.next();
        String[] rubs = s.split(",");
        int[] rub = new int[rubs.length];
        for (int i = 0; i < rubs.length; i++) {
            try {
                rub[i] = Integer.parseInt(rubs[i]);
            } catch (NumberFormatException nfe) {
            }
            ;
        }
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < rub.length; i++)
            for (int j = rub[i]; j <= n; j++)
                table[j] += table[j - rub[i]];
        System.out.println("Количество вариантов размена: " + table[n]);

    }
}