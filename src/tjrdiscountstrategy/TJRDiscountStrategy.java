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
         /////////////////////////////////////////////////////////////////
        // KLUDGE: do configuration here for strategy options:
        /////////////////////////////////////////////////////////////////
        
        DatabaseStrategy db = new FakeDatabase();
        ReceiptFormatStrategy fmt = new VerboseReceiptFormat();
//        ReceiptFormatStrategy fmt = new SimpleReceiptFormat();
        OutputStrategy[] outputs = {
            new ConsoleOutput(),
            new Monitor()
        };       
        // Start talking to objects, pass configuraiton data and customer
        // data to start sale. Notice how we do NOT depend on any other
        // classes -- Principal of Least Knowledge
        Register register = new Register("Kohls Department Store");
        register.startNewSale("100", db, fmt, outputs);
        
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
//        register.removeItemFromArray("33", 3);
        
        register.endSale();
        
        
        
    }
    
}
