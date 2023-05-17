package com.george.spring.paymentSystem.web.dto.paymentMethod;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Payment Method DTO.")
public class PaymentMethodDto {
    @Schema(description = "Payment Method Id.", example = "1")
    private Long id;
    @Schema(description = "Payment Method Number.", example = "1111111111111111")
    @NotNull(message = "Number must be not null.")
    private Long number;
    @Schema(description = "Payment Method Balance.", example = "1.0")
    private Double currentBalance;
    @Schema(description = "Payment Method Type.", example = "CARD")
    @NotNull(message = "Payment method must be not null.")
    private PaymentMethodType paymentMethodType;
}
