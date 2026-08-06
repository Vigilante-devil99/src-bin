import java.util.ArrayList;
import java.util.List;

public class Add {

 
    private static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    private static Pair<List<Integer>, List<Integer>> realizer(List<Integer> arr, List<Integer> index) {
        if ((arr.size() % 2 != 0) || (arr.size() / 2 != index.size())) {
            return new Pair<>(new ArrayList<>(), new ArrayList<>());
        }

        List<Integer> ra = new ArrayList<>();
        List<Integer> ri = new ArrayList<>();

        for (int i = 0; i < arr.size() / 2; ++i) {
            int curr = i * 2;
            int low = arr.get(curr);
            int up = arr.get(curr + 1);
            if (low > up) {
                System.out.println("Invalid indices");
                return new Pair<>(new ArrayList<>(), new ArrayList<>());
            }
            ra.add(up - low + 1);
            ri.add(index.get(i) - low);
        }

        return new Pair<>(ra, ri);
    }

    public static int rmo(List<Integer> arr, List<Integer> index) {
        Pair<List<Integer>, List<Integer>> ai = realizer(arr, index);

        if (ai.first.isEmpty() || ai.second.isEmpty()) {
            return 0;
        }

        if (ai.second.get(0) < 0 || ai.first.get(0) <= ai.second.get(0)) {
            return 0;
        }

        int offset = ai.second.get(0);
        for (int i = 1; i < ai.second.size(); ++i) {
            if (ai.second.get(i) < 0 || ai.first.get(i) <= ai.second.get(i)) {
                return 0;
            }
            offset = offset * ai.first.get(i) + ai.second.get(i);
        }

        return offset;
    }

    public static int cmo(List<Integer> arr, List<Integer> index) {
        Pair<List<Integer>, List<Integer>> ai = realizer(arr, index);

        if (ai.first.isEmpty() || ai.second.isEmpty()) {
            return 0;
        }

        int last = ai.second.size() - 1;
        if (ai.second.get(last) < 0 || ai.first.get(last) <= ai.second.get(last)) {
            return 0;
        }

        int offset = ai.second.get(last);
        for (int i = last - 1; i >= 0; --i) {
            if (ai.second.get(i) < 0 || ai.first.get(i) <= ai.second.get(i)) {
                return 0;
            }
            offset = offset * ai.first.get(i) + ai.second.get(i);
        }

        return offset;
    }

    public static void main(String[] args) {
        List<Integer> v = List.of(-5, 5, 7, 20);
        List<Integer> i = List.of(3, 10);

        System.out.println(rmo(v, i));
        System.out.println(cmo(v, i));
    }
}
