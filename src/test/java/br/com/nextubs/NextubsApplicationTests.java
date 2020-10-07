package br.com.nextubs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NextubsApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api/v1/find_ubs";
	}
	
	@Test
	public void whenPageLessThanOne_thenReturns500() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "-1")
		.queryParam("per_page", "1")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(500);
	}
	
	@Test
	public void whenPerPageLessThanOne_thenReturns500() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "10")
		.queryParam("per_page", "-1")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(500);
	}
	
	@Test
	public void correctParams_thenReturns200() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "1")
		.queryParam("per_page", "6")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(200);
	}
	
	@Test
	public void whenForgetAParam_thenReturns400() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "1")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(400);
	}
	
	@Test
	public void whenSendAEmptiParam_then400() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "")
		.queryParam("per_page", "6")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(400);
	}
	
	@Test
	public void whenSendIncorrectDataInPageAndPerPage_then400() {

		RestAssured
		.given()
		.queryParam("query", -23.604936, -46.692999)
		.queryParam("page", "test")
		.queryParam("per_page", "test")
		.accept(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(400);
	}

}
