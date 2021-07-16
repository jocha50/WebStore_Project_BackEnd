package WebStore.Web;

import WebStore.Domain.Product;
import WebStore.Service.ProductDTO;
import WebStore.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    public ProductService productService;


    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productNumber) {
        ProductDTO productDTO = productService.getProductByProductNumber(productNumber);

        if (productDTO.getProductNumber() == null) {
            //some validation here.
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Sorry no Product by product Number "+productNumber), HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(@RequestParam(value="search", required=false) String search) {
        Products products;
        if(search != null){

           products = new Products(productService.search(search));


        }
        else{

         products = new Products(productService.getAllProducts());
        }

        if (products == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("seems like we don't have products in stock"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> removeProduct(@PathVariable String productNumber) {
        ProductDTO productDTO = productService.getProductByProductNumber(productNumber);
        if (productDTO.getProductNumber() == null) { // if the product doesn't exist
            //do some validation here
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Sorry no Product by product Number"+productNumber), HttpStatus.BAD_REQUEST);

        }
        productService.removeProduct(productNumber);
        return new ResponseEntity<ProductDTO>(HttpStatus.OK);
    }


    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO productDTO1 = productService.getProductByProductNumber(productDTO.getProductNumber());

        if (productDTO1.getProductNumber() == null) { // if the product doesn't exist
            //do some validation here
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Sorry no Product like that"), HttpStatus.BAD_REQUEST);



        }
        productService.updateProduct(productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }
}
