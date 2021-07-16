package WebStore.Repository;

import WebStore.Domain.Orders;
import WebStore.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepository  extends MongoRepository<Orders, String> {
    Orders findByOrderID(String orderID);
}
