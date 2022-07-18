package OrdersItems;

public class Item {
  private String name;
  private double price;

  // CONSTRUCTOR
  public Item(String name , double price){
    this.name =name;
    this.price=price;

  }

  //getters and setters 
  public void setName(String name){
     this.name=name;
  }

  public String getName(){
    return this.name;
  }

  public void setPrice(double price){
      this.price =price;
  }

  public double getPrice (){
    return this.price;
  }

  
}
