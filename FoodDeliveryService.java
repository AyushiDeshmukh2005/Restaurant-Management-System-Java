import java.util.*;

/*Base interface for all entities in the Restaurant Food Delivery System.
 Common operations that apply to all classes.*/
public interface FoodDeliveryService {
    
    int getId();
    String getName();
}

/*Interface for restaurant-specific operations.*/
interface RestaurantOperations extends FoodDeliveryService {
    String getLocation();
    double getRating();
    List<MenuItem> getMenu();
    void addMenu(MenuItem item);
}

/*Interface for customer-specific operations.*/
interface CustomerOperations extends FoodDeliveryService {
    String getPhone();
    String getLocation();
}

/*Interface for order-specific operations.*/
interface OrderOperations extends FoodDeliveryService {
    Restaurant getRestaurant();
    Map<MenuItem, Integer> getItems();
    double calculateTotal();
    void printBill();
}
