/*Customer class representing a restaurant application user.
 Each customer has a unique ID and location-based preferences.*/
public class Customer implements CustomerOperations{
    private final int id;
    private final String name;
    private final String phone;
    private final String location;

    /*Constructs a Customer with specified details.*/
    public Customer(int id, String name, String phone, String location){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    /*Gets the customer ID.*/
    public int getId(){
        return id;
    }

    /*Gets the customer name.*/
    public String getName(){
        return name;
    }

    /*Gets the customer phone number.*/
    public String getPhone(){
        return phone;
    }

    /*Gets the customer location.*/
    public String getLocation(){
        return location;
    }

    /*Checks equality based on customer ID (uniquely identifies a customer).*/
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Customer other = (Customer) obj;
        return this.id == other.id;
    }

    /*Returns hash code based on ID for use in hash-based collections.*/
    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }

    /*Returns string representation of the customer.*/
    @Override
    public String toString(){
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", phone='" + phone + '\'' + ", location='" + location + '\'' + '}';
    }
}


