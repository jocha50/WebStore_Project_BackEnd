package WebStore.Web;

import WebStore.Service.OrdersDTO;

import java.util.Collection;

public class AllOrders {

    private Collection<OrdersDTO> allOrders;

    public AllOrders(Collection<OrdersDTO> allOrders) {
        this.allOrders = allOrders;
    }

    public Collection<OrdersDTO> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(Collection<OrdersDTO> allOrders) {
        this.allOrders = allOrders;
    }
}
