import java.util.*;

/*Main driver class for the Restaurant Food Delivery System.
 Handles customer authentication, restaurant browsing, and order placement.
 Uses Stream API for efficient data filtering and processing.*/
public class Main {

    static Scanner sc=new Scanner(System.in);

    static List<Restaurant> restaurants=new ArrayList<>();
    static Map<String,Customer> customers=new HashMap<>();

    static List<String> locations = Arrays.asList(
            "KarveNagar","Kothrud","Deccan","ShivajiNagar"
    );

    static int orderCounter=1;

    /* ---------- INITIAL DATA ---------- */

    static void initialize(){

        /* ---------- KARVENAGAR ---------- */

        Restaurant r1=new Restaurant(1,"Burger House","KarveNagar",4.5);
        r1.addMenu(new MenuItem(1,"Burger",120));
        r1.addMenu(new MenuItem(2,"Fries",90));
        r1.addMenu(new MenuItem(3,"Cold Coffee",110));
        r1.addMenu(new MenuItem(37,"Cheese Burger",150));
        r1.addMenu(new MenuItem(38,"Veg Burger",100));
        r1.addMenu(new MenuItem(39,"Chocolate Shake",130));

        Restaurant r2=new Restaurant(2,"Pizza Hub","KarveNagar",3.5);
        r2.addMenu(new MenuItem(4,"Pizza",250));
        r2.addMenu(new MenuItem(5,"Garlic Bread",140));
        r2.addMenu(new MenuItem(6,"Pasta",210));
        r2.addMenu(new MenuItem(40,"Farmhouse Pizza",300));
        r2.addMenu(new MenuItem(41,"Cheese Burst Pizza",320));
        r2.addMenu(new MenuItem(42,"White Sauce Pasta",230));

        Restaurant r3=new Restaurant(3,"Seoul Kitchen","KarveNagar",4.0);
        r3.addMenu(new MenuItem(7,"Kimchi Rice",280));
        r3.addMenu(new MenuItem(8,"Korean Ramen",260));
        r3.addMenu(new MenuItem(9,"Fried Chicken",300));
        r3.addMenu(new MenuItem(43,"Bibimbap",290));
        r3.addMenu(new MenuItem(44,"Tteokbokki",270));


        /* ---------- KOTHRUD ---------- */

        Restaurant r4=new Restaurant(4,"Urban Bites","Kothrud",3.9);
        r4.addMenu(new MenuItem(10,"Burger",130));
        r4.addMenu(new MenuItem(11,"Sandwich",150));
        r4.addMenu(new MenuItem(12,"Fries",95));
        r4.addMenu(new MenuItem(45,"Club Sandwich",180));
        r4.addMenu(new MenuItem(46,"Loaded Fries",140));

        Restaurant r5=new Restaurant(5,"Pasta Palace","Kothrud",4.5);
        r5.addMenu(new MenuItem(13,"Pasta",220));
        r5.addMenu(new MenuItem(14,"Pizza",240));
        r5.addMenu(new MenuItem(15,"Garlic Bread",130));
        r5.addMenu(new MenuItem(47,"Alfredo Pasta",260));
        r5.addMenu(new MenuItem(48,"Margherita Pizza",220));

        Restaurant r6=new Restaurant(6,"Spice Kitchen","Kothrud",4.1);
        r6.addMenu(new MenuItem(16,"Biryani",210));
        r6.addMenu(new MenuItem(17,"Butter Chicken",320));
        r6.addMenu(new MenuItem(18,"Naan",40));
        r6.addMenu(new MenuItem(49,"Paneer Butter Masala",260));
        r6.addMenu(new MenuItem(50,"Chicken Tikka",280));


        /* ---------- DECCAN ---------- */

        Restaurant r7=new Restaurant(7,"Cafe Delight","Deccan",4.8);
        r7.addMenu(new MenuItem(19,"Coffee",100));
        r7.addMenu(new MenuItem(20,"Sandwich",150));
        r7.addMenu(new MenuItem(21,"Burger",135));
        r7.addMenu(new MenuItem(51,"Cappuccino",120));
        r7.addMenu(new MenuItem(52,"Mocha",140));

        Restaurant r8=new Restaurant(8,"Pizza Corner","Deccan",4.1);
        r8.addMenu(new MenuItem(22,"Pizza",260));
        r8.addMenu(new MenuItem(23,"Pasta",220));
        r8.addMenu(new MenuItem(24,"Garlic Bread",140));
        r8.addMenu(new MenuItem(53,"Cheese Pizza",280));
        r8.addMenu(new MenuItem(54,"Red Sauce Pasta",230));

        Restaurant r9=new Restaurant(9,"Street Snacks","Deccan",1.0);
        r9.addMenu(new MenuItem(25,"Vada Pav",30));
        r9.addMenu(new MenuItem(26,"Misal Pav",80));
        r9.addMenu(new MenuItem(27,"Burger",120));
        r9.addMenu(new MenuItem(55,"Pani Puri",50));
        r9.addMenu(new MenuItem(56,"Dabeli",40));


        /* ---------- SHIVAJI NAGAR ---------- */

        Restaurant r10=new Restaurant(10,"Snack Hub","ShivajiNagar",2.4);
        r10.addMenu(new MenuItem(28,"Burger",115));
        r10.addMenu(new MenuItem(29,"Fries",85));
        r10.addMenu(new MenuItem(30,"Sandwich",130));
        r10.addMenu(new MenuItem(57,"Veg Roll",100));
        r10.addMenu(new MenuItem(58,"Chicken Roll",140));

        Restaurant r11=new Restaurant(11,"Biryani House","ShivajiNagar",3.5);
        r11.addMenu(new MenuItem(31,"Chicken Biryani",230));
        r11.addMenu(new MenuItem(32,"Mutton Biryani",280));
        r11.addMenu(new MenuItem(33,"Naan",40));
        r11.addMenu(new MenuItem(59,"Egg Biryani",200));
        r11.addMenu(new MenuItem(60,"Paneer Biryani",210));

        Restaurant r12=new Restaurant(12,"Pasta Point","ShivajiNagar",2.3);
        r12.addMenu(new MenuItem(34,"Pasta",210));
        r12.addMenu(new MenuItem(35,"Pizza",240));
        r12.addMenu(new MenuItem(36,"Cold Coffee",120));
        r12.addMenu(new MenuItem(61,"Cheese Pasta",230));
        r12.addMenu(new MenuItem(62,"Chocolate Cold Coffee",150));


        restaurants.add(r1); restaurants.add(r2); restaurants.add(r3);
        restaurants.add(r4); restaurants.add(r5); restaurants.add(r6);
        restaurants.add(r7); restaurants.add(r8); restaurants.add(r9);
        restaurants.add(r10); restaurants.add(r11); restaurants.add(r12);


        /* ---------- EXISTING CUSTOMERS ---------- */

        customers.put("9876543210",
        new Customer(1001,"Sakshi Dhas","9876543210","KarveNagar"));

        customers.put("9988776655",
        new Customer(1002,"Sakshi Dhas","9988776655","Kothrud"));

        customers.put("9123456789",
        new Customer(1003,"Priya Patil","9123456789","Deccan"));

        customers.put("9012345678",
        new Customer(1004,"Amit Kulkarni","9012345678","ShivajiNagar"));
    }

    /* ---------- LOCATION ---------- */
    /*Using Stream API to display locations with indices*/
    static String chooseLocation(){

        System.out.println("\nChoose your location:");

        /*Using Stream API with indexed access*/
        locations.stream()
                 .map(location -> (locations.indexOf(location) + 1) + " " + location)
                 .forEach(System.out::println);

        int choice=sc.nextInt();
        sc.nextLine();

        if(choice<1 || choice>locations.size())
            return null;

        return locations.get(choice-1);
    }

    /* ---------- LOGIN ---------- */

    static Customer login(){

        System.out.println("Enter your phone number:");
        String phone=sc.nextLine();
        System.out.println("You entered: '" + phone + "'");

        if(customers.containsKey(phone)){
            Customer c=customers.get(phone);
            System.out.println("Welcome back "+c.getName());
            return c;
        }

        System.out.println("New Customer Signup");

        System.out.println("Enter your full name:");
        String name=sc.nextLine();

        String location=chooseLocation();

        Customer c=new Customer(0,name,phone,location);
        customers.put(phone,c);

        return c;
    }

    /* ---------- SHOW TOP RATED RESTAURANTS ---------- */
    /*Using Stream API and Comparable to sort restaurants by rating*/
    static void showTopRestaurants(String location){
        System.out.println("\nTop Rated Restaurants in " + location + ":");
        restaurants.stream()
                   .filter(r -> r.getLocation().equalsIgnoreCase(location))
                   .sorted()
                   .forEach(System.out::println);
    }

    /* ---------- SHOW RESTAURANTS ---------- */
    /*Using Stream API to filter restaurants by location*/
    static void showRestaurants(String location){
        restaurants.stream()
                   .filter(r -> r.getLocation().equalsIgnoreCase(location))
                   .forEach(System.out::println);
    }

    /* ---------- ORDER ---------- */
    /*Using Stream API to find restaurant by ID*/
    static void orderFood(Customer c){

        showRestaurants(c.getLocation());

        System.out.println("Enter restaurant id:");
        int rid=sc.nextInt();

        Restaurant selected = restaurants.stream()
                                         .filter(r -> r.getId() == rid)
                                         .findFirst()
                                         .orElse(null);

        if(selected == null){
            System.out.println("Invalid restaurant");
            return;
        }

        placeOrder(selected);
    }

    /* ---------- PLACE ORDER ---------- */
    /*Using Stream API to find menu items and filter by budget*/
    static void placeOrder(Restaurant selected){

        System.out.println("Menu:");

        selected.getMenu().forEach(System.out::println);

        /*Using Stream API to show budget-friendly options*/
        System.out.println("\nBudget-friendly items (under Rs.200):");
        selected.getMenu().stream()
                          .filter(item -> item.getPrice() < 200)
                          .forEach(item -> System.out.println("  " + item));

        Map<MenuItem,Integer> cart=new HashMap<>();

        while(true){

            System.out.println("Enter item id (0 to finish)");
            int id=sc.nextInt();

            if(id==0) break;

            MenuItem chosen = selected.getMenu().stream()
                                      .filter(m -> m.getId() == id)
                                      .findFirst()
                                      .orElse(null);

            if(chosen==null) continue;

            System.out.println("Qty:");
            int qty=sc.nextInt();

            cart.put(chosen,qty);
        }

        Order order=new Order(orderCounter++,selected,cart);
        order.printBill();
    }

    /* ---------- MAIN ---------- */

    public static void main(String[] args){

        initialize();

        Customer customer=login();

        while(true){

            System.out.println("\n1 Show Restaurants");
            System.out.println("2 Show Top Rated Restaurants");
            System.out.println("3 Order Food");
            System.out.println("4 Exit");

            int ch=sc.nextInt();

            switch(ch){
                case 1: showRestaurants(customer.getLocation()); break;
                case 2: showTopRestaurants(customer.getLocation()); break;
                case 3: orderFood(customer); break;
                case 4:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }
}


