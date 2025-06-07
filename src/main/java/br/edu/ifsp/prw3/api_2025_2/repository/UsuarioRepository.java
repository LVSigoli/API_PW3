package br.edu.ifsp.prw3.api_2025_2.repository;

import br.edu.ifsp.prw3.api_2025_2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login );
}
