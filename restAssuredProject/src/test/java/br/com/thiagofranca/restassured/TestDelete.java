package br.com.thiagofranca.restassured;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

/* Para escrita dos testes utilizei o testNG
 * Para validação do delete, verifico o código 204 quando bato no endpoint
 * Coloquei a annotation @Test do testNG em cima do método. */


public class TestDelete {
	@Test
	public void deleteItem() {
		String endpoint = "https://reqres.in/api/users/2";
		
		when().
			delete(endpoint).
		then().
			statusCode(204).
			log().all();
		
	}
}
