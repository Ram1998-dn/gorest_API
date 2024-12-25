package in.co.gorest.userinfo;

import in.co.gorest.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void VerifyUserDeleteSuccessfully() {
        given().log().ifValidationFails()
              //  .pathParam("id",7599740)
                .header("Authorization","Bearer 8dd14367cda63e02bfd5992781c399c7b9eab2a35e678c001cc8dda8306e775e")
                .header("Content-Type","application/json")
                .header("connection","keep-alive")
                .when()
                .delete("/users/7599740")
                .then().log().all()
                .statusCode(201);

    }
}
