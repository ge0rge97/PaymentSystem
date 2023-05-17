package com.george.spring.paymentSystem.web.dto.payment;

import com.george.spring.paymentSystem.web.dto.user.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Payment DTO.")
public class PaymentDto {
    @Schema(description = "Payment Id.", example = "1")
    private Long id;
    @Schema(description = "Payment Date.", example = "1970-01-01 00:00:0")
    private LocalDateTime paymentDate;
    @Schema(description = "Payment Amount.", example = "100.0")
    @NotNull(message = "Amount must be not null.")
    private Double amount;
    @Schema(description = "User DTO Sender.")
    private UserDto sender;
    @Schema(description = "User DTO Receiver.")
    private UserDto receiver;
}
