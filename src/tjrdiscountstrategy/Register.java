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
public class Register {
    private Receipt receipt;
    private String storeName;
    private ReceiptFormatStrategy fmt;
    private OutputStrategy[] outputs;

    
    public Register(String storeName) {
        this.storeName = storeName;
    }
    
    
    public final void startNewSale(String custId, DatabaseStrategy db,ReceiptFormatStrategy fmt, OutputStrategy[] outputs) {
        // needs validation
        receipt = new Receipt(storeName, custId, db);
        setFmt(fmt);
        setOutputs(outputs);
    }
    
    
    public final void endSale() {
        String data = fmt.format(receipt);
        for(OutputStrategy out : outputs) {
            out.outputReceipt(data);
        }
    }
    
  
    public final void addItemToSale(String prodId, int qty) {
        // needs validation
        receipt.addItemToReceipt(prodId, qty);
    }
    

    public final void removeItemFromArray(String prodId, int qty) {
        // needs validation
        receipt.removeItemFromArray(prodId, qty);
    }
    


    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        // needs validation
        this.receipt = receipt;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        // needs validation
        this.storeName = storeName;
    }

    public final ReceiptFormatStrategy getFmt() {
        return fmt;
    }

    public final void setFmt(ReceiptFormatStrategy fmt) {
        // needs validation
        this.fmt = fmt;
    }

    public final OutputStrategy[] getOutputs() {
        return outputs;
    }

    public final void setOutputs(OutputStrategy[] outputs) {
        // needs validation
        this.outputs = outputs;
    }
    
}
