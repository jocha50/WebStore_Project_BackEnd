package WebStore.Web;

import WebStore.Domain.Orders;
import WebStore.Service.OrdersDTO;
import WebStore.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrdersController {

    @Autowired
   public OrdersService ordersService;


    @GetMapping("/orders/{orderID}")
    public ResponseEntity<?> getOrder (@PathVariable String orderID){
        OrdersDTO ordersDTO = ordersService.getOrderByID(orderID);
        if(ordersDTO == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Sorry no order with Order ID"+orderID), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<OrdersDTO>(ordersDTO, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> addOrder (@RequestBody OrdersDTO ordersDTO){
        ordersService.addOrder(ordersDTO);
        return new ResponseEntity<OrdersDTO>(ordersDTO,HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(){
    AllOrders allOrders = new AllOrders(ordersService.getAllOrders());
        return new ResponseEntity<AllOrders>(allOrders,HttpStatus.OK);
    }

}
