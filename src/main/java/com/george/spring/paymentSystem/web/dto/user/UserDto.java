package com.george.spring.paymentSystem.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "User DTO.")
public class UserDto {
    @Schema(description = "User Id.", example = "1")
    private Long id;
    @Schema(description = "User Email.", example = "test1@test.com")
    @NotNull(message = "Username must be not null")
    @Length(max = 255,
            message = "Username must be shorter than 255 symbols.")
    private String username;
    @Schema(description = "User Password.", example = "12345")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null")
    private String password;
    @Schema(description = "User Password Confirmation.", example = "12345")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null")
    private String passwordConfirmation;
}
