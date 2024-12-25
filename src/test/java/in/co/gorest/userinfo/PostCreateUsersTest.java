package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostCreateUsersTest extends TestBase {



    @Test
    public void createUser(){
        String email = TestUtils.getRandomValue() +  "tenali.ramakrishna@1567ce.com";
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Tenali Ramakrishna ayar");
        userPojo.setEmail(email);
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Access","application/json")
                .header("Authorization","Bearer 4c9a7e0792e0e7d33962f732f47cce30d0133079d2bb012b9830286dec0a9223")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(404);
    }
}
