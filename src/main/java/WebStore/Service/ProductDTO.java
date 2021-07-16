package WebStore.Service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductDTO {

    @NotEmpty
    @Size(min = 7,max = 13)
    private String productNumber;

    @NotEmpty
    private String name;

    @NotNull
    private double price;

    @NotEmpty
    private String description;

    @NotNull
    private int quantity;


    public ProductDTO() {
    }

    public ProductDTO(String productNumber, String name, double price, String description, int quantity) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
