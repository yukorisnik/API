package systementor.integrationApiTestDemo;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

    public class StoreApiFieldsTest {
    
        @Test
        void verifyFields() {
            WebClient client = WebClient.create("https://fakestoreapi.com");
            
            var response = client.get()

            .uri("/products/3")
            .retrieve()
            .toEntity(String.class)
            .block();

            //assertEquals(200, response.getStatusCode().value());

        String body = response.getBody();

        assertTrue(body.contains("\"title\""));
        assertTrue(body.contains("\"price\""));
        assertTrue(body.contains("\"category\""));   

        System.out.println("korrekta fält finns: " + body);
     }
}

       

