package WebStore.Service;

import WebStore.Domain.Orders;
import WebStore.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public OrdersDTO getOrderByID(String orderID){
        Orders orders=  ordersRepository.findByOrderID(orderID);
        return OrdersAdapter.getOrdersDTO(orders);
    }

    public void addOrder(OrdersDTO ordersDTO){
        Orders orders = OrdersAdapter.getOrders(ordersDTO);
        ordersRepository.save(orders);
    }

    public Collection<OrdersDTO> getAllOrders(){

        Collection<Orders> allOrders = ordersRepository.findAll();
        Collection<OrdersDTO> allOrdersDTO = new ArrayList<>();

        for(Orders order : allOrders){
            allOrdersDTO.add(OrdersAdapter.getOrdersDTO(order));
        }

        return allOrdersDTO;

    }
}
