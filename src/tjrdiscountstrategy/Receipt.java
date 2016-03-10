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
    private static int receiptNo;
    private String storeName;
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;

    /**
     * Custom constructor initializes required fields.
     * @param storeName - name of seller
     * @param custId - an unique customer id
     * @param db - the persistence solution
     */
    public Receipt(String storeName, String custId, DatabaseStrategy db) {
        setStoreName(storeName);
        receiptNo++;
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }
    
    
    public final void addItemToReceipt(String prodId, int qty) {
        // needs validation for all arguments passed in
        LineItem item = new LineItem(prodId, qty, db);
        addItemToArray(lineItems, item);
        
       
    }
    
   
    private final void addItemToArray(LineItem[] origArray, LineItem item) {
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length - 1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }
    
    
    public final void removeItemFromArray(String prodId, int qty) {
        // needs validation for all arguments passed in
        for(int i=0; i < lineItems.length; i++) {
            if(lineItems[i].getProduct().getProdId().equals(prodId)) {
                // delete from memory if found
                lineItems[i] = null;
                break;
            }
        }
        shrinkArray(lineItems);
    }
    
   
    private void shrinkArray(LineItem[] origArray) {
        // Make a new array one size smaller than original
        LineItem[] tempArray = new LineItem[lineItems.length-1];
        
        // copy items into new temporary array if not null
        for(int i=0, j=0; i < origArray.length; i++) {
            if(origArray[i] != null) {
                tempArray[j++] = origArray[i];
            }
        }
        
        // replace original with temp, which is now one smaller
        lineItems = tempArray;
    }
    
    

    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        //needs validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        // needs validation
        this.customer = customer;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        // needs validaiton
        this.lineItems = lineItems;
    }

    public static int getReceiptNo() {
        return receiptNo;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        // needs validation
        this.storeName = storeName;
    }
    
    
}
