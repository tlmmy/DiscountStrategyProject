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
    private ArrayList items = new ArrayList();

    public Receipt(String custId, DatabaseStrategy db) {
        setCustomer(db.findCustomerByID(custId));
        setDb(db);
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

    public final ArrayList getItems() {
        return items;
    }

    public final void setItems(ArrayList items) {
        // needs validation
        this.items = items;
    }
    
     public final void addItem(LineItem item){
        //needs validation
        items.add(item);
    }
    
    
}
