public class StringOperations {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "  Hello, Java World!  ";

        int length = str1.length();
        char ch = str1.charAt(1);
        String sub = str1.substring(1, 4);

        String combined = str1.concat(" ").concat(str2);
        boolean isEqual = str1.equals("hello");
        boolean isEqualIgnoreCase = str1.equalsIgnoreCase("hello");
        int compareResult = str1.compareTo(str2);

        boolean contains = str3.contains("Java");
        boolean startsWith = str3.startsWith("  Hello");
        boolean endsWith = str3.endsWith("!  ");
        int index = str3.indexOf("Java");

        String upper = str1.toUpperCase();
        String lower = str2.toLowerCase();
        String trimmed = str3.trim();
        String replaced = str3.replace("Java", "Core Java");

        String[] words = str3.trim().split(" ");

        char[] charArray = str1.toCharArray();
        String valueOfNumber = String.valueOf(100);

        StringBuilder sb = new StringBuilder(str1);
        sb.append(" ").append(str2).reverse();
        String reversed = sb.toString();

        System.out.println("Length: " + length);
        System.out.println("Char at 1: " + ch);
        System.out.println("Substring: " + sub);
        System.out.println("Combined: " + combined);
        System.out.println("Equals: " + isEqual);
        System.out.println("Equals Ignore Case: " + isEqualIgnoreCase);
        System.out.println("Compare To: " + compareResult);
        System.out.println("Contains: " + contains);
        System.out.println("Starts With: " + startsWith);
        System.out.println("Ends With: " + endsWith);
        System.out.println("Index Of: " + index);
        System.out.println("Upper: " + upper);
        System.out.println("Lower: " + lower);
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println("Replaced: " + replaced);
        System.out.println("Reversed: " + reversed);
        System.out.println("Value of number: " + valueOfNumber);
        
        for (String word : words) {
            System.out.println("Word: " + word);
        }
    }
}
