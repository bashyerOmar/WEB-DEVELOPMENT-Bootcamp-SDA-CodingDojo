public class CafeJava {
    public static void main(String [] args) {
          
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is ";
        
        // Menu variables (add yours below)
        int Coffee=4;
        double Latte =5.5;
        double Cappuccino=3.5;
    
        // Customer name variables
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions 
        boolean orderStatus_customer1=false;
        boolean orderStatus_customer2=true;
        boolean orderStatus_customer3=false;
        boolean orderStatus_customer4=true;
    

        // APP INTERACTION SIMULATION
        //Cindhuri's order coffee
        System.out.print(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	
        if (orderStatus_customer1){ // if the order ready
             System.out.println(readyMessage );
        }else{
            System.out.println(pendingMessage );
        }


        // noah's order Cappuccino
        System.out.print(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Noah"
    	
        if (orderStatus_customer4){ // if the order ready
             System.out.println(readyMessage +" and "+ displayTotalMessage + Cappuccino + " $"  );
        }else{
            System.out.println(pendingMessage );
        }


        // Sam's order 2 lattee
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Sam"
        System.out.print( displayTotalMessage + (Latte*2) + "$"  ); // print the total price 
        if (orderStatus_customer2){ // if the order ready
             System.out.println(readyMessage );
        }else{
            System.out.println(pendingMessage );
        }


         // Jimmy's order latte but he paid for coffee ! 
         System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Sam"
         System.out.println( displayTotalMessage + Coffee + "$ ,  but you need to pay " +(Latte-Coffee)+" $ to get your latte !"  ); // print the total price 
         
       
    }
}
