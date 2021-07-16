package WebStore.Service;

import WebStore.Domain.Product;
import WebStore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO getProductByProductNumber(String productNumber){
        Product product = productRepository.findProductByProductNumber(productNumber);
        return ProductAdapter.getProductDTO(product);
    }

    public Collection<ProductDTO> getAllProducts(){
        Collection<Product> products = productRepository.findAll();
        Collection<ProductDTO> productDTOS = new ArrayList<>();

        for(Product p: products){
            productDTOS.add(ProductAdapter.getProductDTO(p));
        }
        return productDTOS;

    }

    public List<ProductDTO> search(String search){
        List<Product> products = productRepository.findProductByNameContaining(search);
        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product p: products){
            productDTOS.add(ProductAdapter.getProductDTO(p));
        }
        return productDTOS;


    }

    public void addProduct(ProductDTO productDTO){
        Product product = ProductAdapter.getProduct(productDTO);
        productRepository.save(product);

    }

    public void removeProduct(String productNumber){
        Product product = productRepository.findProductByProductNumber(productNumber);
        productRepository.delete(product);
    }

    public void updateProduct(ProductDTO productDTO){
        Product product = ProductAdapter.getProduct(productDTO);
        productRepository.save(product);

    }
}
