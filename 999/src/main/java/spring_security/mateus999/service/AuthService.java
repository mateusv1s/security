package spring_security.mateus999.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring_security.mateus999.dto.request.AuthRequest;
import spring_security.mateus999.repository.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;

    public AuthService (UsuarioRepository usuarioRepository, @Lazy AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
    }

    // metodo que o spring vai chamar toda vez que for fazer login no projeto
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }

    public Authentication login (AuthRequest request) {
        var tokenSalvo = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        return authenticationManager.authenticate(tokenSalvo);
    }


}
