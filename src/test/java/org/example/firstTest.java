package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class firstTest {


    @Test
   public void testOne(){

       String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIzNiIsImp0aSI6ImVlYWQwOGJhYzk4ZWIyOWQ2NjQ0MDJiYTIzNGU4NzFkN2IwOWQyNmU4ZmQ2OWIwMWIyZmNjODA5NmFmYTNlMWNmOTdlODJmZGM4YWFhY2Q3IiwiaWF0IjoiMTY2ODY3NzkwNy41MzcyMTEiLCJuYmYiOiIxNjY4Njc3OTA3LjUzNzIxNiIsImV4cCI6IjE3MDAyMTM5MDcuNTMxMDQ0Iiwic3ViIjoiMjc5NTEiLCJzY29wZXMiOltdfQ.V8k2nK-3eZNjSvTwVLgC2ZHYCxRGjosiTG6tuNXdS_4aWiStBjtW7kriwa3eNDKfSaIleWP7rSXrW7C3p2pe7eueMtcl82bkNZctUXZCyKsAfSXMLc5m0-N7gFwbJyGM-MnG_RLMWExQRhpR991E74GmkBROAUM-jCBddFzYB1yUjNubGyKsiYMNZnJ3uu_I8UC5gWCBcgNUdzXUt1XmpxRr07EE2NHXt_S2AkjAtwlN4QF3RyPprhpE6ztsipSD4l9WrKaXqkhAOo0C4s-BP-GOgxci4s4GSc5Dg5SKxe6qi0XVrFyC-66yDGKdtPE48UcqpJ2oKa69EjMZaI9bjWs-k_9pWIRYjxcpy8z510PcsRFlh1OkhGPNiMaiFV0MvsVFwUVGVkv3gkRiORq9qNQXT4h5zSX5ZBffBRwzY-aewUUh0txsh7n8H76AO9qtLW9gfSaicZDxaJPme9a-06PSIOhS9A26aEQFcBj4JDBw0j4U22q1_IkdqqbAYJMBmz7NggNC-Emb25DD6WIQKt1RlOVTl6b29jjdcQ1mKChvSTQd8aAwk4gb_oocg1chLBeGjNh87S4lBuu8C5V_Z4L37oTk4qGIfXJShRq9thpFjS80aWeg33WVKlAxIq_dU8RWyz0nIee6y4RjoHYgveu4mljWJINLdPmjnZSFi3I";

       Response response = RestAssured.get("https://api-onetime-orders.edenlife.ng/api/v2/onetime_order/orders?itemPerPage=20");

       given()
               .header("authorization", "bearer", token);
       System.out.println(response.getStatusCode());
       System.out.println(response.getBody());
       System.out.println(response.getHeader("content-type"));

       int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

   }

   @Test
   public void login(){

       JSONObject request = new JSONObject();
       request.put("email", "rebekahoj15@gmail.com");
       request.put("password", "eden");

       System.out.println(request);
       System.out.println(request.toString());

       given().
               when()
               .body(request.toJSONString())
               .post("https://api-onetime-order-sec.edenlife.ng/api/v3/garden/login")
               .then()
               .statusCode(200);



       // Request request = RestAssured.post("https://api-onetime-order-sec.edenlife.ng/api/v3/garden/login");

   }
}
