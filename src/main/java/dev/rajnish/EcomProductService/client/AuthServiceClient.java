package dev.rajnish.EcomProductService.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import dev.rajnish.EcomProductService.dto.ValidateRequestDTO;
import dev.rajnish.EcomProductService.exceptions.UnauthorisedException;

@Component
public class AuthServiceClient {

    @Value("${authservice.api.url}")
    private String authServiceBaseUrl;
    @Value("${authservice.api.path.validate}")
    private String authServiceValidatePath;

    public void authenticateUser(String token,String role) throws UnauthorisedException
    {
        WebClient webClient = WebClient.builder().build();
        ValidateRequestDTO validateRequestDTO = new ValidateRequestDTO();
        validateRequestDTO.setRole(role);
        String authUrl = authServiceBaseUrl.concat(authServiceValidatePath);
        String response = webClient.post().uri(authUrl).header(HttpHeaders.AUTHORIZATION,token).bodyValue(validateRequestDTO).retrieve().bodyToMono(String.class).block();
        System.out.println("This is the response from auth server" + response);

        if(response.equals("false"))
        {
            throw new UnauthorisedException("Unauthorised request");
        }
    }
    
}
