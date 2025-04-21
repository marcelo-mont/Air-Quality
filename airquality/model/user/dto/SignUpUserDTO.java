package br.com.fiap.airquality.model.user.dto;

import br.com.fiap.airquality.model.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpUserDTO(
        Long id,

        @NotBlank(message = "Please provide the name!")
        String name,

        @NotBlank(message = "An email is mandatory.")
        @Email(message = "The email must be in the format name@example.com.")
        String email,

        @NotBlank(message = "A password is mandatory.")
        @Size(min = 6, max = 20, message = "The password size must be 6-20 characters.")
        String password,

        UserRole role

) {
}
