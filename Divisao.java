import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Divisao implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            float num1 = Float.parseFloat(partes[2]);
            float num2 = Float.parseFloat(partes[3]);
            float divisao = num1/num2;
                byte[] resposta = Float.toString(divisao).getBytes();  
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return; 
    
        } finally {
            exchange.close();
        }
    }
}
