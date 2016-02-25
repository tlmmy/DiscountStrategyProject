/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tjrdiscountstrategy;

/**
 *
 * @author l152student
 */
public class LineItem {
    private Product product;
    private int qty;
    

    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        setProduct(db.findProductByID(prodId));
        setQty(qty);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //needs validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        //needs validation
        this.qty = qty;
    }
    
   
    public final double getSubTotal(){
        return product.getUnitCost() * qty;
    }
    
    public final String getLineItemInfo(){
        String data = product.getProdId() + "               " + product.getProdName() + "   " 
                + this.getQty() + "   " + this.getSubTotal() + "    " + product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
        return data;
    }
    
}
