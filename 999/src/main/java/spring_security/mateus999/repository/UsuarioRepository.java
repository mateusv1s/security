package spring_security.mateus999.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import spring_security.mateus999.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {

    UserDetails findByLogin(String login);

}
