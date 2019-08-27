package org.katas.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<LineItem> ItemList;

    public Order(String customerName, String address, List<LineItem> ItemList) {
        this.customerName = customerName;
        this.address = address;
        this.ItemList = ItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
    	List<LineItem> returnLineItems=new ArrayList<LineItem>();
    	returnLineItems.addAll(ItemList);
        return returnLineItems;
    }
}
