package org.softserve.edu;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.softserve.edu.models.UserDataDTO;
import org.softserve.edu.models.StatusCodes;
import org.softserve.edu.utils.ConverterDTO;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class TestCreateUser {

    private static final Logger LOG = LogManager.getLogger(TestGetUser.class.getName());

    @BeforeMethod
    public void beforeRequest(Method method){
        String testName = method.getName();
        LOG.info("Running method "+ testName);
    }

    @Test (groups = "POST requests", testName = "REST: POST: Verify create new user with valid data ")
    public void testCreateNewUserWithValidData() {

            UserDataDTO userForCreation = createUser();

        String jsonInString = ConverterDTO.dtoToJsonString(userForCreation);

            ValidatableResponse createNewUser =
                    given().
                            contentType("application/json").
                            body(jsonInString).
                    when().
                            post("/users").
                    then().
                            statusCode(StatusCodes.CREATED);

        Response createNewUserResponse = createNewUser.
                extract().
                response();

//    'name' field from the response body to string Verify 'name' field from the response body and one from the User object

        String responseName = createNewUserResponse.
                path("name");
        assertThat(responseName).
                isEqualTo(userForCreation.getName());

//    'username' field from the response body to string Verify 'username' field from the response body and one from the User object

            String responseUsername = createNewUserResponse.
                    path("username");
            assertThat(responseUsername).
                    isEqualTo(userForCreation.getUsername());

//    'email' field from the response body to string Verify 'email' field from the response body and one from the User object

            String responseEmail = createNewUserResponse.
                    path("email");
            assertThat(responseEmail).
                    isEqualTo(userForCreation.getEmail());

//    'phone' field from the response body to string Verify 'phone' field from the response body and one from the User object

            String responsePhone = createNewUserResponse.
                    path("phone");
            assertThat(responsePhone).
                    isEqualTo(userForCreation.getPhone());

//    'website' field from the response body to string Verify 'website' field from the response body and one from the User object

            String responseWebsite = createNewUserResponse.
                    path("website");
            assertThat(responseWebsite).
                    isEqualTo(userForCreation.getWebsite());

//    'address' field from the response body to string Verify 'address' field from the response body and map from the User object

            LinkedHashMap<String,Object> responseAddress = createNewUserResponse.
                    path("address");
            assertThat(responseAddress).
                    isEqualTo(userForCreation.getAddress());

//    'company' field from the response body to string Verify 'address' field from the response body and map from the User object

            LinkedHashMap<String,Object> responseCompany = createNewUserResponse.
                    path("company");
            assertThat(responseCompany).
                    isEqualTo(userForCreation.getCompany());

    }

    @AfterMethod
    public void afterRequest(Method method){
        String testName = method.getName();
        LOG.info("Finishing method "+ testName);
    }

    @AfterClass
    public void cleanUp(){
        LOG.info("All POST requests sent");
    }

    private static UserDataDTO createUser(){

        UserDataDTO userForCreation = new UserDataDTO();

        userForCreation.setName("Jack");
        userForCreation.setUsername("jackson");
        userForCreation.setEmail("jack-3000@gmail.com");

        LinkedHashMap<String,Object> userAddress = new LinkedHashMap<>();
        userAddress.put("street", "St. John");
        userAddress.put("suite", "563");
        userAddress.put("city", "Texas");
        userAddress.put("zipcode", "679HN1");
        userForCreation.setAddress(userAddress);

        userForCreation.setPhone("345-678-908");
        userForCreation.setWebsite("jack-3000.com");

        LinkedHashMap<String,Object> userCompany = new LinkedHashMap<>();
        userCompany.put("companyName", "BBC");
        userCompany.put("catchPhrase", "catch phrase");
        userCompany.put("bs", "don't even know");
        userForCreation.setCompany(userCompany);

        return userForCreation;
    }
}
