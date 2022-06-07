package in.reqres.userinfo;

import in.reqres.constants.EndPoints;
import in.reqres.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetAllUser extends TestBase {

    @Test
    public void getAllUser(){
        SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_USER)
                .then()
                .log().all()
                .statusCode(200);
    }

}
