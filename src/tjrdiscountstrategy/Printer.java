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
public class Printer implements OutputDevice{

    @Override
    public void outputReceipt(Receipt receipt) {
        System.out.println("Product ID       Product Name      Qty Subtotal Discount");
    }
    
}
