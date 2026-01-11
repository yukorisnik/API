package systementor.integrationApiTestDemo;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

public class StoreApiCountTest {

    @Test
    void verifyNumberOfIds() {
        WebClient client = WebClient.create("https://fakestoreapi.com");

        List<Map<String, Object>> products = client.get()
                .uri("/products")
                //.header("User-Agent", "GitHubActionsTest")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Map<String, Object>>>() {})
                .block();

        if (products == null || products.size() != 20) {
            throw new RuntimeException("Misslyckades: Förväntade 20 ID:n men hittade " + (products != null ? products.size() : 0));
        }

        // Kontrollera antalet element i listan
        assertEquals(20, products.size());
        
        System.out.println("Antal ID:n hittade: " + products.size() +", test ok");
    }
}
