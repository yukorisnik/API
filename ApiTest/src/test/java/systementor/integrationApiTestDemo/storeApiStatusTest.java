package systementor.integrationApiTestDemo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

public class storeApiStatusTest {

    @Test
    void callReturn200() {
        WebClient client = WebClient.create("https://fakestoreapi.com");

        var response = client.get()
                .uri("/products")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null) throw new AssertionError();
        assertEquals(200, response.getStatusCode().value());
        //System.out.println("Response: " + response);
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());

        //assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}