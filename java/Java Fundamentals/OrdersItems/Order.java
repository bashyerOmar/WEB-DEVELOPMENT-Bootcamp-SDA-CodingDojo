package OrdersItems;
import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items ;

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
      this.name="Guest";
      this.items= new ArrayList<Item>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order (String name){
      this.name=name;
      this.items= new ArrayList<Item>();
    }

    
    public void setName (String name){
          this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public double getOrderTotal(){
        for (int i=0; i< this.items.size(); i++){ // sum all the item's prices to get the total 
            this.total += this.items.get(i).getPrice();
         }
        return this.total;
    }

    public void setReady(){
        this.ready =true;
    }

    public boolean isReady(){
        return this.ready;
    }

    public String getStatusMessage(){
        if (isReady()){
            return "Your order is ready";
        }
        // if the order not ready
        return "Thank you for waiting, Your order will be ready soon.";
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void display(){
        System.out.printf("Customer Name: %s\n", this.getName());
        for (Item item : this.getItems()){
            System.out.println(item.getName()+" - "+ item.getPrice());
         }
         System.out.println("Total :"+this.getOrderTotal() +" \n\n");
    }
}
