package br.com.fiap.airquality.model.user.dto;

import br.com.fiap.airquality.model.user.User;
import br.com.fiap.airquality.model.user.UserRole;

public record ShowUserDTO(
        Long id,

        String name,

        String email,

        UserRole role
) {
    public ShowUserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
