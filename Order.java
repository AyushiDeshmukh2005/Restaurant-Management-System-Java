import java.util.*;

/*Order class representing a customer's food order from a restaurant.
 Handles order details and bill calculation with discount logic.*/
public class Order implements OrderOperations{

    private final int id;
    private final Restaurant restaurant;
    private final Map<MenuItem,Integer> items;

    /*Constructs an Order with specified details.*/
    public Order(int id, Restaurant r, Map<MenuItem,Integer> items){
        this.id = id;
        this.restaurant = r;
        this.items = new HashMap<>(items);
    }

    /*Gets the order ID.*/
    public int getId(){
        return id;
    }

    /*Gets the restaurant for this order.*/
    public Restaurant getRestaurant(){
        return restaurant;
    }

    /*Gets the ordered items with quantities.*/
    public Map<MenuItem,Integer> getItems(){
        return Collections.unmodifiableMap(items);
    }

    /*Gets the order name (restaurant name for this order).*/
    public String getName(){
        return restaurant.getName();
    }

    /*Calculates the total cost of the order.*/
    public double calculateTotal(){
        return items.entrySet().stream()
                   .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                   .sum();
    }

    /*Calculates applicable discount based on order total.*/
    private double calculateDiscount(double total){
        if(total > 1000) return total * 0.30;
        if(total > 500) return total * 0.20;
        if(total > 300) return total * 0.10;
        return 0;
    }

    /*Prints the bill for this order with discount and final amount.*/
    public void printBill(){
        double total = calculateTotal();
        System.out.println("\n------ BILL ------");
        System.out.println("Restaurant: " + restaurant.getName());

        items.forEach((item, qty) -> {
            double cost = item.getPrice() * qty;
            System.out.println(item.getName() + " x" + qty + " = Rs." + cost);
        });

        System.out.println("Subtotal = Rs." + total);

        double discount = calculateDiscount(total);

        if(discount > 0){
            if(total > 1000) System.out.println(" 30% Discount Applied!");
            else if(total > 500) System.out.println(" 20% Discount Applied!");
            else if(total > 300) System.out.println(" 10% Discount Applied!");
        } else {
            System.out.println("No discount applied.");
        }

        double finalAmount = total - discount;
        System.out.println("Discount = Rs." + discount);
        System.out.println("Final Total = Rs." + finalAmount);
        System.out.println("------------------");
    }

    /*Checks equality based on order ID (uniquely identifies an order).*/
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Order other = (Order) obj;
        return this.id == other.id;
    }

    /*Returns hash code based on ID for use in hash-based collections.*/
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    /*Returns string representation of the order.*/
    @Override
    public String toString(){
        return "Order{" + "id=" + id + ", restaurant=" + restaurant.getName() + ", items=" + items.size() + '}';
    }
}


