package in.reqres.userinfo;

import in.reqres.constants.EndPoints;
import in.reqres.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.util.HashMap;

public class UserSteps {

    @Step("Creating user with name : {0}, job: {1}, email: {2}")
    public ValidatableResponse createUser(String name, String job){

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

       return SerenityRest.given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post(EndPoints.GET_ALL_USER)
                .then();
    }
    @Step("Getting user information with name :{0}")
    public HashMap<String,Object> getUserInfoWithName(String name){

        String p1 = "findAll{it.name == ' ";
        String p2 = " '}.get(0)";
        HashMap<String,Object> userMap = SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_USER)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        return userMap;
    }
    @Step("Updating user information with studentId: {0}, name: {1}, email: {2}")
    public ValidatableResponse updateUser(int studentId, String name, String job) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("studentID", studentId)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATED_USERID)
                .then();
    }
    @Step("Deleting user information with userId: {0}")
    public ValidatableResponse deleteUser(int userId){
        return SerenityRest.given().log().all()
                .pathParam("userId", userId)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
    @Step("Getting user information with userId: {0}")
    public ValidatableResponse getUserById(int userId){
        return SerenityRest.given().log().all()
                .pathParam("userId", userId)
                .when()
                .get(EndPoints.GET_USER_BY_ID)
                .then();
    }

}
