import java.util.*;

/*Restaurant class representing a food delivery partner restaurant.
 Implements Comparable for sorting restaurants by rating.*/
public class Restaurant implements Comparable<Restaurant>, RestaurantOperations{

    private final int id;
    private final String name;
    private final String location;
    private final double rating;

    private final List<MenuItem> menu = new ArrayList<>();

    /*Constructs a Restaurant with specified details.*/
    public Restaurant(int id, String name, String location, double rating){
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    /*Gets the restaurant ID.*/
    public int getId(){
        return id;
    }

    /*Gets the restaurant name.*/
    public String getName(){
        return name;
    }

    /*Gets the restaurant location.*/
    public String getLocation(){
        return location;
    }

    /*Gets the restaurant rating.*/
    public double getRating(){
        return rating;
    }

    /*Gets the restaurant menu.*/
    public List<MenuItem> getMenu(){
        return Collections.unmodifiableList(menu);
    }

    /*Adds a menu item to the restaurant.*/
    public void addMenu(MenuItem m){
        menu.add(m);
    }

    /*Compares restaurants by rating in descending order */
    @Override
    public int compareTo(Restaurant other){
        return Double.compare(other.rating, this.rating);
    }

    /*Checks equality based on restaurant ID (uniquely identifies a restaurant).*/
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Restaurant other = (Restaurant) obj;
        return this.id == other.id;
    }

    /*Returns hash code based on ID for use in hash-based collections.*/
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    /*Returns string representation of the restaurant.*/
    @Override
    public String toString(){
        return id + " " + name + " | " + location + " | Rating " + rating;
    }
}


