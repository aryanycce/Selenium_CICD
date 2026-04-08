package api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    @BeforeClass
    public void setup() {

        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";

    }

    // GET all users

    @Test
    public void testGetUsers() {

        given()

        .when()

        .get("/users")

        .then()

        .statusCode(200)

        .body("size()", greaterThan(0));

    }


    // GET single user

    @Test
    public void testGetSingleUser() {

        given()

        .when()

        .get("/users/1")

        .then()

        .statusCode(200)

        .body("id", equalTo(1));

    }


    // POST request

    @Test
    public void testCreateUser() {

        String body = "{\n" +
                "\"name\": \"Aryan\",\n" +
                "\"username\": \"aryan123\",\n" +
                "\"email\": \"aryan@test.com\"\n" +
                "}";

        given()

        .header("Content-Type", "application/json")

        .body(body)

        .when()

        .post("/users")

        .then()

        .statusCode(201);

    }


    // PUT request

    @Test
    public void testUpdateUser() {

        String body = "{\n" +
                "\"name\": \"Updated Aryan\"\n" +
                "}";

        given()

        .header("Content-Type", "application/json")

        .body(body)

        .when()

        .put("/users/1")

        .then()

        .statusCode(200)

        .body("name", equalTo("Updated Aryan"));

    }


    // DELETE request

    @Test
    public void testDeleteUser() {

        given()

        .when()

        .delete("/users/1")

        .then()

        .statusCode(200);

    }

}