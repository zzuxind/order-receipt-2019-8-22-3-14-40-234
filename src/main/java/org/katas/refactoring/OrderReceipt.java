package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order o;
    

    public OrderReceipt(Order o) {
        this.o = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printItems(output);
        double totSalesTx=calculateTotalSalesTax(o);
        double tot=calculateTotal(o);
        printFooter(output, totSalesTx, tot);
        return output.toString();
    }

	public void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n")
        	  .append(o.getCustomerName())
        	  .append(o.getCustomerAddress());
	}
	
	public void printItems(StringBuilder output) {
         
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription())
            .append('\t')
            .append(lineItem.getPrice())
            .append('\t')
            .append(lineItem.getQuantity())
            .append('\t')
            .append(lineItem.totalAmount())
            .append('\n');

        }

}
	
	public double calculateTotalSalesTax(Order o) {
		double totSalesTx = 0d;
		for(LineItem lineItem:o.getLineItems()) {
			totSalesTx+=lineItem.salesTax();
		}
		return totSalesTx;
	}
	
	public double calculateTotal(Order o) {
		double tot = 0d;
		for(LineItem lineItem:o.getLineItems()) {
			tot+=lineItem.totalAmount();
		}
		tot+=calculateTotalSalesTax(o);
		return tot;
	}

	public void printFooter(StringBuilder output, double totSalesTx, double tot) {
        output.append("Sales Tax").append('\t').append(totSalesTx);
        output.append("Total Amount").append('\t').append(tot);
	}
}