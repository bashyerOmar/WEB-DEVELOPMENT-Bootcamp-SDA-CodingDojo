package OrdersItems;



public class TestOrders {
    public static void main(String []args){
        // Menu items
        Item item1 = new Item();
        item1.name="mocha";
        item1.price=3.0;
        Item item2 = new Item();
        item2.name="latte";
        item2.price=4.5;
        Item item3 = new Item();
        item3.name="drip coffee";
        item3.price=5.5;
        Item item4 = new Item();
        item4.name="capuccino";
        item4.price=2.5;
        

        // Order instances 
        Order order1=new Order();
        order1.name="Cindhuri";
        order1.items.add(item3); //Add item3 to order1's items list
        order1.total+=item3.price;
        order1.ready = true; //Cindhuri’s order is now ready. Update her status
        Order order2=new Order();
        order2.name="Jimmy";
        order2.items.add(item1); //Add item1 to order2's item list
        order2.total+=item1.price; //increment the order's total
        order2.ready=true;
        Order order3=new Order();
        order3.name="Noah";
        order3.items.add(item4); //order3 ordered a cappucino
        order3.total += item4.price;
        Order order4=new Order();
        order4.name="Sam";
        order4.items.add(item2); // first order 
        order4.total += item2.price;
        order4.items.add(item2); //second order (2 latte)
        order4.items.add(item2); 
        order4.total += (item2.price*2);
       

        // order 1 details 
        System.out.printf("Name: %s\n", order1.name);
        System.out.println("Items you have ordered are:" );
        for (Item item : order1.items){
           System.out.println(item.name);
        }
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n\n", order1.ready);


        // order 2 details 
        System.out.printf("Name: %s\n", order2.name);
        System.out.println("Items you have ordered are:" );
        for (Item item : order2.items){
           System.out.println(item.name);
        }
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);


        // order 3 details 
        System.out.printf("Name: %s\n", order3.name);
        System.out.println("Items you have ordered are:" );
        for (Item item : order3.items){
           System.out.println(item.name);
        }
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);


        // order 4 details 
        System.out.printf("Name: %s\n", order4.name);
        System.out.println("Items you have ordered are:" );
        for (Item item : order4.items){
           System.out.println(item.name);
        }
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
