import WebStore.Service.ProductDTO;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ProductRESTTest {


//    @Test
//    public void passTest(){
//        Assert.assertSame("passed","passed");
//    }
    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8081);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testAddProduct(){
        ProductDTO productDTO = new ProductDTO("12345678","phone",55.0F,"samsung s9",5);

        //add product
        given()
                .contentType("application/json")
                .body(productDTO)
                .when()
                .post("/products")
                .then()
                .statusCode(200);


        //verify if it has been added

        given()
                .when()
                .get("/products/12345678")
                .then()
                .statusCode(200)
                .and()
                .body("productNumber",equalTo("12345678"))
                .body("name",equalTo("phone"))
                .body("price",equalTo(55.0F))
                .body("description",equalTo("samsung s9"))
                .body("quantity",equalTo(5));


    }

    @Test
    public void testGetAllProducts(){
        ProductDTO productDTO = new ProductDTO("12345678","phone",55.0F,"samsung s9",5);
        ProductDTO productDTO1 = new ProductDTO("87654321","laptop",500.0F,"dell xpx",5);

        //add products
        given()
                .contentType("application/json")
                .body(productDTO)
                .when()
                .post("/products")
                .then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(productDTO1)
                .when()
                .post("/products")
                .then()
                .statusCode(200);


        //verify if we can get all products added
        given()
                .when()
                .get("products")
                .then()
                .statusCode(200)
                .and()
                .body("products.productNumber", hasItems("12345678","87654321"))
                .body("products.name",hasItems("phone","laptop"))
                .body("products.price",hasItems(55.0F,500.0F))
                .body("products.description",hasItems("samsung s9","dell xpx"))
                .body("products.quantity",hasItems(5,5));

        //then delete all the added products

        given()
                .when()
                .delete("products/12345678")
                .then()
                .statusCode(200);
        given()
                .when()
                .delete("products/87654321")
                .then()
                .statusCode(200);

    }

    @Test
    public void testDeleteProduct(){
        ProductDTO productDTO = new ProductDTO("12345678","phone",55.0F,"samsung s9",5);

        //add product
        given()
                .contentType("application/json")
                .body(productDTO)
                .when()
                .post("/products")
                .then()
                .statusCode(200);
        //delete product
        given()
                .when()
                .delete("products/12345678")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUpdateProduct() {
        ProductDTO productDTO = new ProductDTO("12345678", "phone", 55.0F, "samsung s9", 5);
        ProductDTO productDTOUpdated = new ProductDTO("12345678", "phone", 100.0F, "samsung s9", 3);

        //add product
        given()
                .contentType("application/json")
                .body(productDTO)
                .when()
                .post("/products")
                .then()
                .statusCode(200);

        //update added product
        given()
                .contentType("application/json")
                .body(productDTOUpdated)
                .when()
                .put("/products")
                .then()
                .statusCode(200);

        //verify if it has been updated

        given()
                .when()
                .get("/products/12345678")
                .then()
                .statusCode(200)
                .and()
                .body("productNumber", equalTo("12345678"))
                .body("name", equalTo("phone"))
                .body("price", equalTo(100.0F))
                .body("description", equalTo("samsung s9"))
                .body("quantity", equalTo(3));
    }


}
