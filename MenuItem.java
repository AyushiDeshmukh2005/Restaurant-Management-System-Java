/*Immutable MenuItem class representing a food item in the restaurant menu.*/
public class MenuItem implements FoodDeliveryService {
    private final int id;
    private final String name;
    private final double price;

    /*Constructs a MenuItem with specified id, name, and price.*/
    public MenuItem(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /*Gets the ID of the menu item.*/
    public int getId(){
        return id;
    }

    /*Gets the name of the menu item.*/
    public String getName(){
        return name;
    }

    /*Gets the price of the menu item.*/
    public double getPrice(){
        return price;
    }

    /*Checks equality based on ID (uniquely identifies a menu item).*/
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        MenuItem other = (MenuItem) obj;
        return this.id == other.id;
    }

    /*Returns hash code based on ID for use in hash-based collections.*/
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    /*Returns string representation of the menu item.*/
    @Override
    public String toString(){
        return id + " " + name + " Rs." + price;
    }
}
