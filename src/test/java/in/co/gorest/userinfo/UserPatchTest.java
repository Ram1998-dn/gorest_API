package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {



        static String name = "Tenali Ramakrishna";
        static String email = TestUtils.getRandomValue() + "tenali.ramakrishna@156ce.com";
        static String gender = "male";
        static String status = "active";
    @Test
        public void verifyThatUsersUpdateSuccessfully(){

        int storeID = 7599740;
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("id", storeID)
                .header("Authorization","Bearer 8dd14367cda63e02bfd5992781c399c7b9eab2a35e678c001cc8dda8306e775e")
                .header("Content-Type","application/json")
                .header("connection","keep-alive")
                .when()
                .body(userPojo)
                .put("/users/{id}");
                response.prettyPrint();
                response.then().statusCode(404);
    }
}
