package dataAPI;
import dataAPI.Constants.Endpoints;
import dataAPI.Constants.Url;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class BurgerServiceClient {

    private String baseURI;

    public BurgerServiceClient() {
        this.baseURI = Url.BASE_URI;
    }

    @Step("User authorization with registration data to receive an accessToken, POST /api/auth/login")
    public ValidatableResponse loginUser(String userEmail, String userPassword, String userName) {
        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body("{\"email\": \"" + userEmail + "\", \"password\": \"" + userPassword + "\", \"name\": \"" + userName + "\"}")
                .post(Endpoints.LOGIN_USER)
                .then()
                .log()
                .all();
    }

    @Step("User removing with accessToken and completing the test, DELETE /api/auth/user")
    public ValidatableResponse deleteUser(String userAccessToken) {

        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .header("Authorization", userAccessToken)
                .when()
                .delete(Endpoints.DELETE_USER)
                .then()
                .log()
                .all()
                .statusCode(202);
    }



}