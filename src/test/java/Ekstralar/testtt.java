package Ekstralar;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@Test


public class testtt {

    public void test1(){


        given()



                .when()
                .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")


                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().body()
                .body("Search.'Title'",hasItem("Harry Potter and the Deathly Hallows: Part 2"));

    }

    public void combiningtest(){

        given()

                .when()
                .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().body()
                .body("Search.'Year'",hasItem("2001"))
                .body("Search[0].'imdbID'",equalTo("tt1201607"));
    }
    public void pathParamTest(){

        for (int i = 0; i <3 ; i++) {

            given()
                    .param("Year",i)
                    //.pathParam("Year","2011")
                    .log().uri()

                    .when()
                    .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")

                    .then()
                    .statusCode(200)
                    .log().body();
        }
        }

        @Test
        public void extractJsonPath(){

        String Year =
                given()
                        .when()
                        .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")


                        .then()
                        .extract().path("Search[1].'Year'");


           System.out.println("Year = " + Year);
           Assert.assertEquals(Year,"2001");
        }

    @Test
    public void extractJsonPath2(){

        String Title =
                given()
                        .when()
                        .get("http://www.omdbapi.com/?apikey=5a288bd8&s=Harry Potter")


                        .then()
                        .extract().path("Search[2].'Title'");


        System.out.println("Title = " + Title);
        Assert.assertEquals(Title,"Harry Potter and the Chamber of Secrets");
    }


        }




