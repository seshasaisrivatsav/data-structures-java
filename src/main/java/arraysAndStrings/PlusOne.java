package arraysAndStrings;

import java.util.Arrays;

/*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println("expected: [1, 2, 4] actual: " + Arrays.toString(plusOneMine(new int[]{1, 2, 3})));
        System.out.println("expected: [4, 3, 2, 3] actual: " + Arrays.toString(plusOneMine(new int[]{4, 3, 2, 2})));
        System.out.println("expected: [1, 0] actual: " + Arrays.toString(plusOneMine(new int[]{9})));
        System.out.println("expected: [1, 2, 4] actual: " + Arrays.toString(plusOneSmarter(new int[]{1, 2, 3})));
        System.out.println("expected: [4, 3, 2, 3] actual: " + Arrays.toString(plusOneSmarter(new int[]{4, 3, 2, 2})));
        System.out.println("expected: [1, 0, 0, 0, 0] actual: " + Arrays.toString(plusOneSmarter(new int[]{9, 9, 9, 9})));
    }

    public static int[] plusOneSmarter(int[] digit) {
        int n = digit.length;
        for (int i=n-1; i>=0; i--) {
            if (digit[i] < 9) {
                digit[i]++;
                return digit;
            }
            digit[i]=0;
        }

        // we fall here, it means we have a carry
        int[] resWithCarry = new int[n+1];
        resWithCarry[0] = 1;
        System.arraycopy(digit, 0, resWithCarry, 1, n);
        return resWithCarry;
    }

    public static int[] plusOneMine(int[] digits) {
        int j=digits.length-1;
        int leadingSum = digits[j] + 1;
        boolean hasCarry = false;
        if (leadingSum > 9) {
            digits[j] = leadingSum % 10;
            hasCarry = true;
            j--;
            while(j >= 0) {
                if (hasCarry) {
                    int loopSum = digits[j] + 1;
                    if (loopSum > 9) {
                        hasCarry = true;
                        digits[j] = loopSum%10;
                    } else {
                        digits[j] = loopSum;
                        hasCarry = false;
                    }
                    j--;
                } else {
                    break;
                }
            }
        } else {
            digits[j] = leadingSum;
            return digits;
        }

        if (hasCarry) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i=0; i<digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
