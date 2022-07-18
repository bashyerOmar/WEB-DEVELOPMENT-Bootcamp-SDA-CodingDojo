package OrdersItems;



public class TestOrders {
    public static void main(String []args){
        // Menu items
        Item item1 = new Item("mocha" , 3.0);
        Item item2 = new Item("latte" , 4.5);
        Item item3 = new Item("drip coffee" , 5.5);
        Item item4 = new Item("capuccino" , 2.5);
        

        // Order instances 
        Order order1=new Order("Cindhuri");
        order1.addItem(item3);//Add item3 to order1's items list
        order1.addItem(item2);
        order1.setReady(); //Cindhuri’s order is now ready. Update her status

        Order order2=new Order("Jimmy");
        order2.addItem(item1); //Add item1 to order2's item list
        order2.addItem(item3);
        order2.setReady();

        Order order3=new Order("Noah");
        order3.addItem(item4); //order3 is a cappucino
        order3.addItem(item2);

        // guest's odrers
        Order order4=new Order();
        order4.addItem(item2);
        order4.addItem(item1);
        order4.setReady();
        Order order5=new Order();
        order5.addItem(item4);
        order5.addItem(item3);
        
        
     
       

     //orders informations
      order1.display();
      order2.display();
      order3.display();
      order4.display();
      order5.display();


        
    }
}
