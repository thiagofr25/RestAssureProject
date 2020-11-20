package br.com.thiagofranca.restassured;


import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

/* Para escrita dos testes utilizei o testNG
 * e também o json simple para realizar a inserção na API
 * Para o put, validei se o header é de fato um json e
 * e quando bate no endpoint verifico o código.
 * Também exibi as informações no log para checkar. Muito similar ao path e post.
 * Coloquei a annotation @Test do testNG em cima dos métodos. */

public class TestPut {
	@Test
	public void putNomeProfissao() {
		String endpoint = "https://reqres.in/api/users/2";
		JSONObject request = new JSONObject();
		
		request.put("name","Thiago");
		request.put("job","Quality Assurance");
		System.out.println(request.toJSONString());
	
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put(endpoint).
		then().
			statusCode(200).
			log().all();
		
	}
}
