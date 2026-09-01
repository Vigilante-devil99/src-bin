import java.util.List;

record LineItem(String name, double price) {}
record Order(int orderId, List<LineItem> items) {}

public class OrderExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order(101, List.of(new LineItem("Keyboard", 45.0), new LineItem("Mouse", 20.0))),
            new Order(102, List.of(new LineItem("Monitor", 250.0))),
            new Order(103, List.of(new LineItem("USB Cable", 10.0), new LineItem("Webcam", 60.0)))
        );

      
        List<String> expensiveItemNames = orders.stream()
                .flatMap(order -> order.items().stream()) 
                .filter(item -> item.price() > 30.0)      
                .map(LineItem::name)                   
                .toList();

        System.out.println("Items > $30: " + expensiveItemNames);
      
    }
}
