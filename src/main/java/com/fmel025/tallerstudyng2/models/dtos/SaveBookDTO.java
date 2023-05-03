package com.fmel025.tallerstudyng2.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveBookDTO {
    @NotEmpty(message = "ISBN vacio")
    @Size(min = 10, max = 10, message = "El ISBN deberia tener solo 10 caracteres")
    private String isbn;

    @NotEmpty(message = "Titulo vacio")
    private String title;

    @NotEmpty(message = "Correo vacio")
    @Email(message = "Se necesita un correo valido")
    private String owner;
}
