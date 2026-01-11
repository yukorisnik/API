package systementor.integrationApiTestDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StoreApiCountTest {

    @Test
    void verifyNumberOfIds() throws Exception {
        WebClient client = WebClient.create("https://fakestoreapi.com");

        var response = client.get()
                .uri("/products")
                .exchangeToMono(r -> r.toEntity(String.class))
                .block();

        if (response == null) throw new AssertionError();

        String body = response.getBody();

        // JSON-arrayen till en Object[] 
        ObjectMapper mapper = new ObjectMapper();
        Object[] products = mapper.readValue(body, Object[].class);

        assertEquals(20, products.length);

        System.out.println("Antal produkter: " + products.length + ", test ok!");
    }
}
