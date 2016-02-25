/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjrdiscountstrategy;

/**
 *
 * @author trogers8
 */
public class TJRDiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // KLUDGE: do configuration here
        DatabaseStrategy db = new FakeDatabase();
               
        
        //Start talking to objects
        Register register = new Register();
        register.startNewSale("100", db);
        OutputDevice printer = new Printer();
        
        
        //test so far
        Customer customer = register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustName() + " found and added to receipt");
        
        register.addItemToSale("11", 3);
        register.addItemToSale("22", 5);
        register.addItemToSale("33", 1);
        // test...
        LineItem[] items = register.getReceipt().getLineItems();
        printer.outputReceipt(register.getReceipt());
        for(LineItem item : items){
            System.out.println(item.getLineItemInfo());
        }
        
        
    }
    
}
