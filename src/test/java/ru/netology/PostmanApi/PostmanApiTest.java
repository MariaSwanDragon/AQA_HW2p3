package ru.netology.PostmanApi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanApiTest {

    @Test
    public void shouldReturnPostRequest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Добрый день, могу я вам помочь?" +
                        "Какой у вас вопрос?") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Добрый день, могу я вам помочь?" +
                        "Какой у вас вопрос?"));
    }

}

