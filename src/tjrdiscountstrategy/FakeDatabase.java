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
public class FakeDatabase implements DatabaseStrategy {
    private Customer[] customers = {
        new Customer("100", "Bob James"),
        new Customer("200", "Sally Smith"),
        new Customer("300", "Peter Piper")
    };
    
    private Product[] products = {
        new Product("11","Brewer's Hat", 29.95, new PercentOffDiscount(.10)),
        new Product("22", "Women's Blouse", 49.95, new FlatAmtDiscount(5.00)),
        new Product("33", "Men's Black Belt", 39.95, new NoDiscount())
    };
    
    @Override
    public final Customer findCustomerByID(String custId){
        //needs validation
        Customer customer = null;
        
        for(Customer c : customers){
            if(c.getCustId().equals(custId))
              customer = c;
               break;
        }
        
        return customer;
    }
    
    @Override
    public final Product findProductByID(String prodId){
        //needs validation
        Product product = null;
        
        for(Product p: products){
            if(p.getProdId().equals(prodId))
              product = p;
               break;
        }
        
        return product;
    }
}
