package client;
import client.constants.Endpoints;
import client.constants.Url;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import com.google.gson.Gson;


public class BurgerServiceClient {

    private String baseURI;
    private Gson gson;

    public BurgerServiceClient() {
        this.baseURI = Url.BASE_URI;
        this.gson = new Gson();
    }

    @Step("User creating, POST /api/auth/register")
    public ValidatableResponse createUserPostRequest(String userEmail, String userPassword, String userName) {

        String jsonBody = createUserJson(userEmail, userPassword, userName);

        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(jsonBody)
                .when()
                .post(Endpoints.CREATE_USER)
                .then()
                .log()
                .all();
    }

    @Step("User authorization with registration data to receive an accessToken, POST /api/auth/login")
    public ValidatableResponse loginUser(String userEmail, String userPassword, String userName) {

        String jsonBody = createUserJson(userEmail, userPassword, userName);

        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .baseUri(baseURI)
                .header("Content-type", "application/json")
                .body(jsonBody)
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
                .statusCode(SC_ACCEPTED);
    }

    private String createUserJson(String userEmail, String userPassword, String userName) {
        ClientData clientData = new ClientData(userEmail, userPassword, userName); // Создание объекта пользователя
        return gson.toJson(clientData); // Сериализация объекта в JSON
    }

}