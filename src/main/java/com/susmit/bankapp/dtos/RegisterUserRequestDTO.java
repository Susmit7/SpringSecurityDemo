package com.susmit.bankapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterUserRequestDTO {
    @NotBlank(message = "username can not be empty")
    @NotNull(message = "username can not be null")
    private String username;
    @NotBlank(message = "password can not be empty")
    @NotNull(message = "password can not be null")
    private String password;
}
