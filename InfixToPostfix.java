public class InfixToPostfix {

    static int ISP(char op) {
        return switch (op) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 0;
            default -> -1;
        };
    }

    static int ICP(char op) {
        return switch (op) {
            case '^' -> 4;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(' -> 5;
            default -> -1;
        };
    }

    static void infixToPostfix(String E) {
        char[] st = new char[E.length()];
        int top = -1;

        for (int i = 0; i < E.length(); i++) {
            char x = E.charAt(i);

            if (Character.isLetterOrDigit(x)) {
                System.out.print(x);
            } 
            else if (x == ')') {
                while (top != -1 && st[top] != '(') {
                    System.out.print(st[top]);
                    top--;
                }
                top--;
            } 
            else {
                while (top > -1 && ISP(st[top]) >= ICP(x)) {
                    System.out.print(st[top]);
                    top--;
                }
                top++;
                st[top] = x;
            }
        }

        while (top > -1) {
            System.out.print(st[top]);
            top--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String E = "A+B*(C-D^E^F)*(G+H/E)-G/H";
        infixToPostfix(E);
    }
}
