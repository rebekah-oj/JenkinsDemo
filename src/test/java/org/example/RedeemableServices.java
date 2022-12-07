package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RedeemableServices {

    private static  String token = " eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzOCIsImp0aSI6ImYzZDUzYmExODNiNjUwMmU5MzQ1YzE0MDhmNzllNmEwNTRhNzUwMDUzMWEyM2Q2N2QzYjgxMjE1MWQ1NTgyZjc0ZjY4NmY3ODQ2ZTI0YzM5IiwiaWF0IjoiMTY3MDQyMDQ0Ni" +
            "4xMjc5NzIiLCJuYmYiOiIxNjcwNDIwNDQ2LjEyNzk3OCIsImV4cCI6IjE3MDE5NTY0NDYuMTIyNTQxIiwic3ViIjoiMjgxNTMiLCJzY29wZXMiOltdfQ.IrL5BwiBdlkwi7UCXSKTs3R3Py_vQfnnLkaeIOxiOkQxmO9k20vcfRVERUTsLIOKZEYgPN81bqr2q7761GPkygsXYAIfzvt9eXGJ_" +
            "CNcqBCb573RYKSyIEo8OMgYR5dT-xTZsHs9qK5QXC7YXlo_X2vvHGka1" +
            "-7kCaMJgQtvDoqgS9Ax-SxGbQinU-L4Q5ZggsC4gZgoX110H5XULH64P6m799AxPaA9C9tCu5sSC3kDK4OrNcvHdXOxAfdWRqM3ypQxPqz7JklNCM4VSxEJY3BRSswNDiwPT2ub-V7Qh0pGjSzhzX8soA5Zjc1M-tIBg7nMFmfh7mGcIxB1Hz8ca1TkCm_QDflkNcRsunU3mT7Yi2Ofm81L-" +
            "o7Keqdw1uQ2P_7mEVv3-aQ44EDYh01RwN4Wbbc7sH5q2SuW17LswigT_EcQSJRLOCmuXn-oFeTrQHMpEQyfJKhL3FtHuFJDXAsS4bvmYnCavggN7NGENHbxF-V5gyQKAhrbRGAA6yR1m8fLhTP5dKNPXSiYcQnu0xQmhD_XsxFQqok6uj1UKko1eqb3GG68U3CJ82a4ChJt2ycRJImdj4BLU4_" +
            "kTG96L-lH_4F7R27eSodYfrslMDYRtOjdJ692SKBEqqSAY-aiSSB0b_PlYphFOd5gqCtbQLh7bjLUcKRzs4jPnjgIwX0";

    private static String payload2 = """
            {
            "amount": "15000",
            "use_card" : false,
            "save_card" : false
            }""";

@Test(groups = {"Login Test"})
    public void login(){

     String payload = """
            {
              "email": "laundryredeem@gmail.com",
              "password": "eden"}""";


    RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

    RequestSpecification request = given();

    request.header("Content-Type", "application/json");

    Response response = request.body(payload).post("/api/v3/garden/login");

    response.prettyPrint();

          Assert.assertEquals(200, response.statusCode());

    }

    @Test
    public void fundWallet(){

    String token = " eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzNiIsImp0aSI6ImQ1NTFlZDk2YzM3ZDkzYjUzZjI4N2IwOGM5NDlkZTc3NGIwZjViYWM2ZmQ2YWY3YTQ5YTdjMjQzNTVlM2UwYzQzOTA4YjFjMDc4MjhkY2RlIiwiaWF0IjoiMTY3MDE1NDY4NC4yNjE2NTEiLCJuYmYiOiIxNjcwMTU0Njg0LjI2MTY1NCIsImV4cCI6IjE3MDE2OTA2ODQuMjU2NzIzIiwic3ViIjoiMjgxNTAiLCJzY29wZXMiOltdfQ.ANc8rhkaZHJHPVNGUSnMrUMxCncCkr9YHyOWMvgszUf7AnSbp_FooyDCiHwIoBkR_EHg9AtY_atfB7PHlkNG2whRSkVvBJuruiHt79WMBMyXxNx3GzUUCJ8QnbPLgCdIX1ZwKu1OGqTV6I0LPobgl2EuQLY0xp0BEkESedpDcQj8EBedxY8auL_Dizjzk3Ozah5hXA_nJ0y9TfkF3YsZhzZLTlCb_hxNki7JGDMTG68sKxpvvzS4mTD6afahB0n6DaTUfXN-3yk4d9rLF0JxyBkwyprYIrC5x2Q7YRdSk7QwTTx5Y2tm2wX2U45PFcv-nJlrkVtlzsEmfMw46bqeH3Gz2p5l6dpJrawd9fHYJLlt6v1Gx1_YOvVEUz6v3Qwbk9aXU47x1WbJqU05YCWZeYpch4eKYmrz1n_v7NB5uycc6YMbiUtPl9VU8U28yT9q4WNwm9YU01YQwMrEYUzOGJtQaUcDFRf2N0Jifi00gCH7sJmBfqmNox1etl8cpnpIjuwUGkdgVPN_QDZ7ok-VmoXfazZmv5ac2tGBriV5Kk1mybC_Cwb4U0BGQlv9X-LoYFimVj1Lqa6ycijL9q-iO4sbgA9GdrDgvrUcNjnp2EvGAggOqDYWNAbCxXUw-ckfNramOA6rRPqGTSMANu3X-F3-zWSdCoAfeGliLYl9tOI";

        RestAssured.baseURI = "https://api-plg-wallet.edenlife.ng";

        RequestSpecification request = given();

        request.header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + token);

        Response response = request.body(payload2).post("/api/v3/garden/wallet/fund");

        response.prettyPrint();

        Assert.assertEquals(200, response.statusCode());

        String message =  response.getBody().path("message");
       // String payment_provider = response.getBody().path("payment_provider");
       // String contentType = response.contentType();
        //Boolean status = response.getBody().path("status");

        Assert.assertEquals("Payment URL generated for wallet funding successfully", message);
       // Assert.assertEquals("paystack", payment_provider);
       // Assert.assertEquals("application/json", contentType);
       // Assert.assertEquals(Optional.of(true), status);

    }

    @Test(groups = {"Get Customer's Wallet Test"})
    public void getCustomerWallet(){

    //String generatedToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzNiIsImp0aSI6IjNhZTJhYjVkZDhlZTlmZWViZDc4NDE2OTI4NzBmYmU4NGNhMGZmNTczNTAyNzhiNmU3ZGJkMzBlZGZjZTljZjQwM2UwOGEzY2RlZWUzYjlkIiwiaWF0IjoiMTY3MDE0Njk0My4xNTA3NTkiLCJuYmYiOiIxNjcwMTQ2OTQzLjE1MDc2NSIsImV4cCI6IjE3MDE2ODI5NDMuMTQ1MDI3Iiwic3ViIjoiMjgxNTMiLCJzY29wZXMiOltdfQ.lp20iuxGtNvo8Kbh5y-3gCwgfotKmGhOuXKvbyRINefYyKNpDq_u8ijgY439Y8K0JbSUy4Tphq_G3RUHbb0dabZm0Y8yv5OsFmMKgIJ8gs94CEscw58AXFC-NHYBbFmnac2V9joKSkw8qrVGJQd5aq6t-Kk3QlKtjnl6JGqlW2Efh3EUSFBuyJpfcnFMj4dAxrGmJ5TOFtOcs0fSwr1fquDbdNFsnkc5c50AP-iofTxIuZq2V8E-XBqQSe-5lGzxTc4MzgEx9dtfFreH5WNBHWTHfVXo4cRetlhSDzTyb8G9wGt76jF2pcc1NoZw41CoKJnKauFSjO4kLv0oS4OTzDAuPsflV8sJ-cnrqM182Qmjy2S9ZMsioVUopcuPCFazLIgFXXPMt5vvNiI_V42nhDBWJIALfuEZkHBgpe-r9r5U4kdnrWYapHNpw12j2kcuoVRFGRev2UTowR5P2WPbKRckR3Rtbfmb93VKlnbIFBfDeRL39HM0H2m2D8b-ubPnJgea2HUzdhR17OZlFgT0ylImPy0Orm5-DsB-DD38ee4RtdWOyS_7aIU3bM2CoHoDNYlnEGFC7s8yjPEzwL8nEwM6RpKAopXk2t6zNj7MiwbpeJXWN82aG7TUYpO641xzSndWC8ZiAl_xZM3YzqOTjy-O7MSmP6Ia7q4F8MOzMk4";
   // RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

         Response response =   given()
                    .header("Authorization", "Bearer" + " eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzNiIsImp0aSI6IjJmMjMwZmQ3NGZhNDQzMmYyZmI3MTljZDUyNzA4NTM2ODc0OGJiNjQyMWVlODUzMDk1NGUwZTQwYzkwOWQ2NzVhNzkxNTIzOTk2YjdhZDcxIiwiaWF0IjoiMTY3MDE1MTUzMi43NjUyMjIiLCJuYmYiOiIxNjcwMTUxNTMyLjc2NTIyNyIsImV4cCI6IjE3MDE2ODc1MzIuNzYwNDYxIiwic3ViIjoiMjgxNTMiLCJzY29wZXMiOltdfQ.IHW-PSvtYXjSwGj7tWcQjftem13vu815wuwfU89XC5RBPFf84GMQB0XLsoYg36mO_v9ScokKAqHqrv6yT2TZHpEiIrwtTFx_nAXX0DYFoKexhSlL7P4ug2f_4Mx7JjicIkPwOIY7kDcyRJIPERJwje0R-Gguyg_lRSjga5D4GDPDQSFch24-LnqrDWU8Wec71KSv9laPX2T6ilZPfsSqC0xpx4_YCfs0nuVN-roL7yxHG6YO0vL0K8fLA_0UY7h4727QJsZka0vS3yrcqybQNTrQL-podKp-PPMo_kPPWzsHrFJcnnzbLPKdsfKcNABWmD-2DqowOccCibzyPa2FSkYnQaj6ghjhyJr4zlj5G2198Wvmkqw62t7s6_YiIQZ1KAVrevIDc-Iziz4cbkkpHExg5q9Cyy_tq0lSOUSocDRfsJUxKr9dGwzVqh38yv41QUIer17YY_j8TYEQTA__1AzVCHaeR1uY_WTq94TrI9wGsIv8MI-TfkOdz2naXupoRp1Y382D0fXmgCMyNNkvSlLw5z9HxxlpHwzbjegJ5ro8KJ-Rnr359_3ztsaqW4j3c1JRUxvLceKgp1u9Xh48-vYFW0Ub8_YfHuwEQvzgQkoOfKuzH22h9hid28fN0NQK0_u4eMloQp3NDuQqTYcun9zqRMPYPmJY7aEnmFBo1iM")
                    .when()
                    .get("https://api-staging-testanything.edenlife.ng/api/v3/garden/wallet")
                    .then()
                    .extract()
                    .response();

        response.prettyPrint();

       Assert.assertEquals(200, response.statusCode());

       String message = response.getBody().path("message");
      // String contentType = response.getContentType();

       Assert.assertEquals("Customer wallet retireved successfully", message);
       // Assert.assertEquals(" application/json", contentType);
    }

    @Test
    public void viewLaundryServiceDetails(){

    RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

    Response response = given()
            .header("Authorization", "Bearer" + token)
            .header("Content-Type", "application")
            .when()
            .get("api/v3/garden/wallet/laundry/paused_service_details")
            .then()
            .extract().response();

      response.prettyPrint();

      String message = response.getBody().path("message");
      Assert.assertEquals("Laundry service details retrieved successfully", message);

    }

    @Test
    public void redeemLaundryService(){

    String payload = """
            
            {
            "service_items": [
            {
            "pickup_from_customer": "2022-12-12",
            "customer_order_id": 1129906,
            "qty" : 1,
            "item": "wash-and-fold"
            }
            ]
            }""";

    RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

            System.out.println(payload);
       Response response = given()
            .header("Authorization", "Bearer" + token).header("Content-Type", "application/json")
            .and()
            .body(payload)
            .when()
            .post("/api/v3/garden/wallet/redeem/laundry")
            .then()
            .extract().response();

    response.prettyPrint();

        Assert.assertEquals(200, response.statusCode());
       Assert.assertEquals("Laundry services redeemed successfully", response.jsonPath().getString("message"));

    }

    @Test
    public void viewCleaningService(){

    String token = " eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzOCIsImp0aSI6IjY0NjQzNTY1OTFmYzkyZTk0ZWU2MjQ5YzI0ZTgzMTM1NzY1Y2JhYzMxOGE5MzE3NzhkMWJhNTNiMDE0MzdkNDM1NWFhZGRkMmM3NGJjMDViIiwiaWF0IjoiMTY3MDQyNjA3OC4yOTgzMzUiLCJuYmYiOiIxNjcwNDI2MDc4LjI5ODM0MSIsImV4cCI6IjE3MDE5NjIwNzguMjkzNzkyIiwic3ViIjoiMjgxNTAiLCJzY29wZXMiOltdfQ.KHoBkly0WDxyOk5pcrKNkprISS9HDy4S-0feTeBl-y9kHPgW31KxXfJI6aqq0UrPWMy2h8szAkk0NCgjp3VRFNjObvrVNNze-glfcaPGshwmwGrxp52J7pqREATYisrfVf_jDdfIS0EdHWybC4qNDyq0TqXmXa5XkdI8Mgzr97VSTSxrei5uEtt58mCKH_x5aS6NhsaXUHG_ovDoOH2CLCjrcDnH05l--lw9vgkDOVS_-E4fprg0slNl4nRNfvb1J8lVJMQYw3hQb3UCPfJYws_RMg4clz1Nv8J5WVU6PmQcGAePV5nuNXV1MxwSp8DA3kD1yWPmsqlVeYJ0lhJO5aMGDJw5qG8ecLeic7TBtQbapE4gIlaIO_5EKj3AkvjsNhN7mGJrMMBe67eKdMYfGPFegAw9OTrxSgETsKjOcow8rRQ7XGiTV1QLUvjF9zhHjX5LhSZgytulKCAKlBJIvTHwhjNlItImrKQ8-1ZMnk45B4X96ya9qu5w5uwdw5XIxTgXmOE_m4i4D-6oPjKKPtsrp_j8ZabaLtPxTUi3JBEPhyl1e1nxtAm-LYQZ0ZX8J78x7kSLP7IdlZhVpKxEJcOSInD92T3YG5t1kWOJlPhYdNmDVRjdbmO6WF7FnlK0ew8y8N0PUgGSA-GgUW1P6WnkQznwQz1ImRo50o-mVvQ";

        RestAssured.baseURI = "https://api-staging-testanything.edenlife.ng";

      Response response = given()
              .header("Authorization", "Bearer" + token)
              .header("Content-Type", "application/json")
              .when()
              .get("/api/v3/garden/wallet/cleaning/paused_service_details")
              .then()
              .extract().response();

      response.prettyPrint();
      String message = response.getBody().path("message");

      Assert.assertEquals(200, response.statusCode());
      Assert.assertEquals("Cleaning service details retrieved successfully", message);
    }
}

//https://api-staging-testanything.edenlife.ng/api/v3/garden/login