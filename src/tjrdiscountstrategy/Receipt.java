/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjrdiscountstrategy;
import java.util.*;

/**
 *
 * @author trogers8
 */
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
     

    public Receipt(String custId, DatabaseStrategy db) {
        setCustomer(db.findCustomerByID(custId));
        setDb(db);
        lineItems = new LineItem[0];
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        // needs validation
        this.customer = customer;
    }
    
    
    
    
    public final DatabaseStrategy getDb(){
        return db;
    }
    
    public final void setDb(DatabaseStrategy db){
        //needs validation
        this.db = db;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        // needs validation
        this.lineItems = lineItems;
    }

  
    
     public final void addItemToReceipt(String prodId, int qty){
        //needs validation
        LineItem item = new LineItem(prodId, qty, db);
        addItemToArray(lineItems, item);
        
        
        //hard way to manipulate array
//        for(int i=0; i<lineItems.length; i++){
//            tempArray[i] = lineItems[i];
//        }
//        tempArray[tempArray.length-1] = item;
//        lineItems = tempArray;
//        tempArray = null;
    }
     
     private void addItemToArray(LineItem[] origArray, LineItem item){
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length-1] = item;
        origArray = tempArray;
        lineItems = origArray;
     }
    
    
}
