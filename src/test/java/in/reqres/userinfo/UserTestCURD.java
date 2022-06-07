package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

//@RunWith(SerenityRunner.class)
public class UserTestCURD extends TestBase {

    static String name = "Mahendra Dhoni";
    static String job = "Cricketer";
    static int userId;

    @Steps
    UserSteps userSteps;

    @Title("This will create new user")
    @Test
    public void test01() {
        ValidatableResponse response = userSteps.createUser(name, job);
        response.log().all().statusCode(201);
    }

    @Title("Verify user was added")
    @Test
    public void test02() {
        HashMap<String, Object> userMap = userSteps.getUserInfoWithName(name);
        Assert.assertThat(userMap, hasValue(name));
        userId = (int) userMap.get("id");
        System.out.println(userId);
    }
    @Title("Update the user information and verify the updated information")
    @Test
    public void test03(){
        name = name + "_UPDATED";

        userSteps.updateUser(userId,name,job);
        HashMap<String, Object> userMap = userSteps.getUserInfoWithName(name);
        Assert.assertThat(userMap, hasValue(name));

    }
    @Title("Delete the user and verify if the user is deleted!")
    @Test
    public void test04() {
        userSteps.deleteUser(userId).statusCode(204);
        userSteps.getUserById(userId).statusCode(404);
    }


}
