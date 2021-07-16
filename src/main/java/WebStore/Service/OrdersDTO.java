package WebStore.Service;

import WebStore.Domain.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class OrdersDTO {

    @Id
    private String orderID;
    private Collection<Product> products;
    private double totalPrice;
    private long itemsInOrder;


    public OrdersDTO() {
    }

    public OrdersDTO(String orderID, Collection<Product> products, double totalPrice,long itemsInOrder) {
        this.orderID = orderID;
        this.products = products;
        this.totalPrice = totalPrice;
        this.itemsInOrder=itemsInOrder;
    }

    public long getItemsInOrder() {
        return itemsInOrder;
    }

    public void setItemsInOrder(long itemsInOrder) {
        this.itemsInOrder = itemsInOrder;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
