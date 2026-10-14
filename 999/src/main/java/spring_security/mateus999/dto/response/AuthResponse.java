package spring_security.mateus999.dto.response;

import spring_security.mateus999.entity.Usuario;

public record AuthResponse (

        Long idUsuario

)

{

    public static AuthResponse fromEntity (Usuario usuario) {
        return new AuthResponse (
                usuario.getId()
        );
    }

}
