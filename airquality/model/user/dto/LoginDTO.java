package br.com.fiap.airquality.model.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @NotBlank(message = "An email is mandatory.")
        @Email(message = "The email must be in the format \"name@example.com\".")
        String email,

        @NotBlank(message = "A password is mandatory.")
        @Size(min = 6, max = 20, message = "The password size must be 6-20 characters.")
        String password
) {
}
