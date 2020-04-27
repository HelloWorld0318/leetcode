package com.hjx.leetcode.disjoint_set;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        if (!isNum(inputString)) {
            System.out.println("ERROR");
        } else {
            int num = Integer.valueOf(inputString);
            if (isReverseTrue(num)) {
                System.out.println(num);
                return;
            }

            int maxValue = num + 1;
            int minValue = num - 1;
            while (true) {
                if (isReverseTrue(maxValue)) {
                    break;
                }
                maxValue++;
            }

            while (minValue > 0) {
                if (isReverseTrue(minValue)) {
                    break;
                }
                minValue--;
            }

            if (isReverseTrue(minValue)) {
                if (Math.abs(maxValue - num) == Math.abs(num - minValue)) {
                    System.out.println(minValue + "," + maxValue);
                } else if (Math.abs(maxValue - num) < Math.abs(num - minValue)) {
                    System.out.println(maxValue);
                } else {
                    System.out.println(minValue);
                }
            } else {
                System.out.println(maxValue);
            }
        }
    }


    public static boolean isReverseTrue(int n) {
        String num = String.valueOf(n);
        String newString = new StringBuffer(num).reverse().toString();
        return newString.equals(num);
    }

    public static boolean isNum(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}