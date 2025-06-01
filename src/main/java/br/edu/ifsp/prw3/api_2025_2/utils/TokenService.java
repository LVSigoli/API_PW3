package br.edu.ifsp.prw3.api_2025_2.utils;

import br.edu.ifsp.prw3.api_2025_2.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generateToken(Usuario usuario) {
        try{
            var algoritmo = Algorithm.HMAC256("12345678");

            String token = JWT.create()
                    .withIssuer("DISCIPLINA PW3")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar jwt token", e);
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
