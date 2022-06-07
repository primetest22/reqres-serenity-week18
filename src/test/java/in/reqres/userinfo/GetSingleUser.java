package in.reqres.userinfo;

import in.reqres.constants.EndPoints;
import in.reqres.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)
public class GetSingleUser extends TestBase {

    @Test
    public void singleUser() {

        SerenityRest.given()
                .when()
                .pathParam("userID", 3)
                .get(EndPoints.GET_USER_BY_ID)
                .then()
                .log().all().statusCode(200);
    }

}
