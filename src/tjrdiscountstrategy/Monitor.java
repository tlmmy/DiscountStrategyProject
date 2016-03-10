/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjrdiscountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author trogers8
 */
public class Monitor implements OutputStrategy {

    @Override
    public void outputReceipt(String data) {
        // needs validation
         JOptionPane.showMessageDialog(null, data);
    }
    
}
