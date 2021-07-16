package WebStore.Repository;

import WebStore.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findProductByProductNumber(String productNumber);


    List<Product> findProductByNameContaining(String name);
}
