package br.com.thiagofranca.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
	
/* Para escrita dos testes utilizei o testNG
 * Para o get, validei se o header é de fato um json
 * busquei as informações da primeira página  * 
 * e busquei pelo id do 3º usuário na lista 
 * na URL mencionada. 
 * Coloquei a annotation @Test do testNG em cima dos métodos. */



public class TestGet {
	String url = "https://reqres.in/api/users";
	
    @Test
    public void getPageOne(){
    	
        given().
        		header("Content-Type", "application/json").
                param("page", "1").
        when().
                get(url).
        then().
                statusCode(200).
                body("page", equalTo(1));
       
    }

    @Test
    public void getUser() {
        get(url + "/3").then().body("data.id", equalTo(3));
    }
    	
}
