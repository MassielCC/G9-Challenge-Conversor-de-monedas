import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorApp {
    public ExchangeRate obtenerTasa(String monedaPair){
        String apiKey = System.getenv("API_KEY");
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+monedaPair);
        // Request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
    public void mostrarResultado(String base, String target, double monto, double conversion_rate){
        double result= monto*conversion_rate;
        System.out.printf("El valor %.2f [%s] corresponde al valor final de => %.2f [%s]\n", monto, base, result, target);
    }
}
