package systementor.integrationApiTestDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
 
    public class StoreApiOneProdTest {
        WebClient client = WebClient.create("https://fakestoreapi.com");
    
        @Test
        void verifyProdInfo() {var response = client.get()

            .uri("/products/4")
            .retrieve()
            .toEntity(String.class)
            .block();

            assertEquals(200, response.getStatusCode().value());

        String body = response.getBody();
        
        assertTrue(body.contains("\"title\""));
        assertTrue(body.contains("Mens Casual Slim Fit"));
        
        System.out.println("Produkt 4 svarar med korrekt data:"); 
        System.out.println(body);
     
        }


}
