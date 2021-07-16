package WebStore.Service;

import WebStore.Domain.Orders;

public class OrdersAdapter {

    public static Orders getOrders(OrdersDTO ordersDTO){
        Orders orders = new Orders();
        if(ordersDTO != null){
            orders = new Orders(ordersDTO.getOrderID(), ordersDTO.getProducts(), ordersDTO.getTotalPrice(),ordersDTO.getItemsInOrder());
        }
        return orders;
    }

    public static OrdersDTO getOrdersDTO(Orders orders){
        OrdersDTO ordersDTO = new OrdersDTO();
        if(orders != null){
            ordersDTO = new OrdersDTO(orders.getOrderID(), orders.getProducts(), orders.getTotalPrice(),orders.getItemsInOrder());
        }
        return ordersDTO;
    }

}
