import java.util.Arrays;

public class MatrixFlattenDemo {
    public static void main(String[] args) {
        String[][] matrix = {
            {"A", "B", "C"},
            {"D", "E"},
            {"F", "G", "H", "I"}
        };

     
        List<String> flatList = Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .toList();

        System.out.println("Flattened Array: " + flatList);
       
    }
}
