package WebStore.Service;

import WebStore.Domain.Product;

public class ProductAdapter {

public static Product getProduct(ProductDTO productDTO){
    Product product = new Product();
    if(productDTO != null){
        product = new Product(
                productDTO.getProductNumber(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                productDTO.getQuantity());
    }

    return product;
}

    public static ProductDTO getProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        if(product != null){
            productDTO = new ProductDTO(
                    product.getProductNumber(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getQuantity());
        }

        return productDTO;
    }


}
