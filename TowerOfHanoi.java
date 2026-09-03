public class TowerOfHanoi {
    public static void solve(int n, char src, char aux, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " -> " + dest);
            return;
        }
        solve(n - 1, src, dest, aux);
        System.out.println("Move disk " + n + " from " + src + " -> " + dest);
        solve(n - 1, aux, src, dest);
    }

    public static void main(String[] args) {
        int n = 3;
        solve(n, 'A', 'B', 'C');
    }
}
