package org.example;

import com.google.common.base.Verify;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GiftCard {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";
    }

    private static String token = " eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzNiIsImp0aSI6ImIwYmNiOWNmZWY1ODNjNDU0Zjc2NTA5MDU5ODA3MWI3NmVjMTM4NDMwYjgzNzIxNjBkYmViNDUzMTE1ZmYwYTJjMTYxN2NlZDhlMjFjNzIzIiwiaWF0IjoiMTY3MDI1NjIwNy4xMjI3MjUiLCJuYmYiOiIxNjcwMjU2MjA3LjEyMjcyOSIsImV4cCI6IjE3MDE3OTIyMDcuMTE4MjYzIiwic3ViIjoiMjgxNTAiLCJzY29wZXMiOltdfQ.qIzgK_Tm1FuvNby_gfQPoNIezftbAZg_k3miuREv-WTVJsSfNYNuEx9Pfar6K6bWlmEnhwuLTGK4TR_mUQSZByAxHSf2CFX8YACT0esMpL-lpNDdmaDjSW3MtqGI9DZv0-3DhwNOGWhGtO9eIQ2ODvIepiIG9662oetmEFXx79BYy_YXhNdU9Ovkft-tyWUDcPWjlPawHKIsdM3iyZa9Bd47yGhbVjMYKtBa7hXiU0EA681-bnGq4xk6BWLUamjBSPwRGjhjHtLcQS1lGYq-5UJFYwZWYKg2t0guRkNrF21poNUAY017uMuWicOIdRXbBnCTRUFOWbSrfBnXtHUhyLYicMR3VaOCjGNuSV97QVED5j28OdhZS7buI25PAKeWUSWzDBwOa_sepaQxikyUOqQF-M67BI8qfMzLYqylbldpaXZf4q0pBleED9L9r8C4dJyBalNgCF7pmQkfT_yUfvEMtlLA-bKXL3aPsjyX-CGjLbvCtCpn8Pdc9dFAoVm-G0LU_093nEnUre_WVWFEHKHLuLlppjYKdoY9bZDlRWsdwsl2OTwr7whyrSTVJvNaB2uK_pqk5FpWGNDc9Z6Hd-uNNcUus-v_lJNGZztW94zXSOQ6zHgESDQJ2jKy8S5_5KVAPsYT1Bzk161k_Nq6jhJcgQLlUyN5uImSh12DI7g";


    @Test
    public void getTemplates(){

        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

        Response response =  given()

                .header("Authorization", "Bearer" + token)
                .header("Content-Type", "application/json")
                .when()
                .get("/api/v3/garden/giftcard/templates")
                .then()
                .extract()
                .response();

                response.prettyPrint();

                String successMessage = response.getBody().path("message");
                String contentType = response.contentType();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Giftcard templates fetched successfully", successMessage);
        Assert.assertEquals("application/json", contentType);
    }

    @Test
    public void createGiftCard(){

        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

       Response response = given()
               .header("Authorization", "Bearer" + token)
               .param("template_id", "1")
               .param("amount","4000")
               .param("recipient_type", "phone")
               .param("recipient", "2348154855575")
               .param("recipient_name", "Olamide Oloja")
               .param("note", "you deserve the world")
               .param("send_type", "now")
               .param("payment_method", "wallet")
               .when()
               .post("api/v3/garden/giftcard")
               .then()
               .extract().response();

       response.prettyPrint();

       String successMessage = response.getBody().path("message");

       Assert.assertEquals(200, response.statusCode());
       Assert.assertEquals("Customer wallet charged successfully", successMessage);
    }


    @Test
    public void redeemGiftcard(){

        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

        Response response = given()
                .header("Authorization", "Bearer" + token)
                .header("Content-Type", "application/json")
                .when()
                .post("/api/v3/garden/giftcard/redeem/EDEN-GIFT-27671-2302144798600")
                .then().extract().response();

        response.prettyPrint();

        String message = response.getBody().path("message");
        //String paymentStatus = response.getBody().path("payment_status");

        Assert.assertEquals(404, response.statusCode());
        Assert.assertEquals("Giftcard already redeemed", message);
        //Assert.assertEquals("paid", paymentStatus);

    }

    @Test
    public void getGiftCard(){

        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

        Response response = given()
                .header("Authorization", "Bearer" + token)
                .when()
                .get("/api/v3/garden/giftcard/EDEN-GIFT-27671-2302144798600")
                .then()
                .extract().response();

        response.prettyPrint();

        String paymentStatus = response.getBody().path("data.payment_status");

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("paid", paymentStatus);
    }



}
