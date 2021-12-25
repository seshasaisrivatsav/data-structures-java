package arraysAndStrings;

public class CheckPalindromeNumberNoSpace {

    public static void main(String[] args) {
        System.out.println("123321 is palindrome? " + checkPal(123321));
		System.out.println("123456 is palindrome? " + checkPal(123456));
		System.out.println("123321 is palindrome? " + checkPal(123321));
		System.out.println("1 is palindrome? " + checkPal(1));
    }


    public static boolean checkPal(int num) {
        int reverted = 0;
        int orig = num;
        while (num != 0) {
            reverted = (reverted * 10) + (num % 10);
            num = num / 10;
        }
        return orig == reverted;
    }
}
