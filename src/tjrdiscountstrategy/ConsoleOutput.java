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
public class ConsoleOutput implements OutputStrategy {
    
    @Override
    //needs validation
    public final void outputReceipt(String data){
        System.out.println(data);    
    }

    
}
