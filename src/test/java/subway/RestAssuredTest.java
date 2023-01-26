package subway;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestAssuredTest {

    private final String GOOGLE_URL = "https://google.com";

    @DisplayName("구글 페이지 접근 테스트")
    @Test
    void accessGoogle() {
        //given
        var request = given().baseUri(GOOGLE_URL);

        //when
        ExtractableResponse<Response> response = request.when().get().then().extract();

        //then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}