package Model;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PomUnTesti {

    @Test
    public void PomluTest(){

        PageObjectModel pom=

                given()



                        .when()
                        .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")


                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .log().body()
                        .extract().body().as(PageObjectModel.class);

        System.out.println("pom = " + pom);




    }
}
