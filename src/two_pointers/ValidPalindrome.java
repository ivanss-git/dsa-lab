package two_pointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }
    public static void main (String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String str = "ama";
        System.out.printf("The String " + str + " is a palindrome: %s" , vp.isPalindrome(str));
    }
    
}
