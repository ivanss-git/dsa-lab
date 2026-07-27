package two_pointers;
import utils.MyClass;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        String original = newStr.toString();
        String reversed = newStr.reverse().toString();
        return original.equals(reversed);
    }
    public static void main (String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String str = "ama";
        MyClass.log("The String " + str + " is a palindrome: %s" + vp.isPalindrome(str));
    }
    
}
