package in.reqres.userinfo;

import in.reqres.constants.EndPoints;
import in.reqres.model.LoginPojo;
import in.reqres.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)
public class UserLogin extends TestBase {

    static String email = "eve.holt@reqres.in";
    static String password = "cityslicka";

    @Test
    public void userLogin(){

        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setEmail(email);
        loginPojo.setPassword(password);

        SerenityRest.given()
                .header("Content-Type","application/json")
                .body(loginPojo)
                .when()
                .post(EndPoints.USER_LOGIN)
                .then().log().all()
                .statusCode(200);
    }

}
