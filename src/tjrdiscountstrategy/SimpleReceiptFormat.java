package tjrdiscountstrategy;

/**
 * This is a strategy implementation of the ReceiptFormatStrategy contract that
 * shows a very verbose line item that includes the discount on each item.
 * @author trogers8
 */
public class SimpleReceiptFormat implements ReceiptFormatStrategy {

    @Override
    public String format(Receipt receipt) {
       
        double totalBeforeDiscount = 0;
        double totalAfterDiscount = 0;
        double totalDiscount = 0;

        
        StringBuilder sb = new StringBuilder();

       

        
        sb.append(ReceiptFormatStrategy.RECEIPT_NUM)
                .append(Receipt.getReceiptNo());
        sb.append("\n\n").append(ReceiptFormatStrategy.THANK_YOU)
                .append(receipt.getCustomer().getCustName());
        sb.append("\n").append(ReceiptFormatStrategy.FOR_SHOPPING_AT)
                .append(receipt.getStoreName()).append("\n");

       
        sb.append("\n\n").append(ReceiptFormatStrategy.ITEM_ID).append("\t")
                .append(ReceiptFormatStrategy.ITEM_NAME).append("\t\t\t")
                .append(ReceiptFormatStrategy.UNIT_COST).append("\t")
                .append(ReceiptFormatStrategy.QTY).append("\t")
                .append(ReceiptFormatStrategy.EXT_PRICE);
        sb.append("\n---\t----\t\t\t---------\t---\t----------");

        LineItem[] items = receipt.getLineItems();
        for (LineItem item : items) {
            totalBeforeDiscount += item.getExtPrice();
            totalAfterDiscount += (item.getExtPrice() - item.getDiscountedTotal());
            totalDiscount += item.getDiscountedTotal();

            sb.append(String.format("\n%-8s",item.getProduct().getProdId()));
            sb.append(String.format("%-25s",item.getProduct().getProdName()));
            sb.append(String.format("%8.2f",item.getProduct().getUnitCost()));
            sb.append(String.format("%10d",item.getQty()));
            sb.append(String.format("%15.2f",item.getExtPrice()));
        }

        // display grand totals
        sb.append("\n\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.GRAND_TOTALS)
                .append("\n");
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.TOT_BEFORE_DISCOUNT)
                .append(String.format("%9.2f",totalBeforeDiscount));
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.TOT_AFTER_DISCOUNT)
                .append(String.format("%10.2f",totalAfterDiscount));
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.AMT_SAVED)
                .append(String.format("%14.2f",totalDiscount));

        return sb.toString();
    }
}
