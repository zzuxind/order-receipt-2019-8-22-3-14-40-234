package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order o;
    static final double Tax = .10;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printItems(output);
        return output.toString();
    }

	public void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n")
        	  .append(o.getCustomerName())
        	  .append(o.getCustomerAddress());
	}
	
	public void printItems(StringBuilder output) {
		double totSalesTx = 0d;
        double tot = 0d;
        
        
        
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription())
            .append('\t')
            .append(lineItem.getPrice())
            .append('\t')
            .append(lineItem.getQuantity())
            .append('\t')
            .append(lineItem.totalAmount())
            .append('\n');

            // calculate sales tax @ rate of 10%
            
			double salesTax = lineItem.totalAmount() * Tax;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        printFooter(output, totSalesTx, tot);
	}

	public void printFooter(StringBuilder output, double totSalesTx, double tot) {
        output.append("Sales Tax").append('\t').append(totSalesTx);
        output.append("Total Amount").append('\t').append(tot);
	}
}