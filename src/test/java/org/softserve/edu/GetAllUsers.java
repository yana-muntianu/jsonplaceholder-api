package org.softserve.edu;

import org.softserve.edu.models.NewUser;
import org.softserve.edu.models.StatusCodes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class GetAllUsers {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private static int UserId;

    @BeforeClass
    public void setup() {
        baseURI = BASE_URI;
    }

    @Test
    public void getAllUsers(){

        given()
                .get("/users")
        .then()
                .statusCode(StatusCodes.OK)
                .log().all();
    }

    @Test
    public void createNewUser() {

        String name = "Jack";
        String username = "jack-3000";
        String email = "jack-3000@gmail.com";
        String[] address = {"New Street","563","Texas","4567HL"};
        String phone = "908-66-78";
        String website = "jack_jack.com";
        String[] company = {"BBC","catchPhrase","bs"};

        NewUser newUserData = new NewUser(name, username, email, address, phone, website, company);

        given().
                contentType("application/json").
                body(newUserData).
        when().
                post("/users").
        then().
                assertThat().
                statusCode(StatusCodes.CREATED).
                body("name", equalTo(name)).
                body("username", equalTo(username)).
                body("email", equalTo(email)).
                body("phone", equalTo(phone)).
                body("website", equalTo(website)).
                body("address", hasItems(address)).
                body("company", hasItems(company)).
                log().all();


//        Response myResponse = get("/users");
//        UserId = myResponse.
//        then().
//                contentType(ContentType.JSON).assertThat().
//                body("name", equalTo("Jack")).
//                extract().path("id");
//
//        System.out.println(UserId);

    }
}
