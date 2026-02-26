package com.franciscoreina.spring7.dtos.milk;

import com.franciscoreina.spring7.domain.MilkType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record MilkUpdateRequest(
        @Size(max = 50)
        String name,

        MilkType milkType,

        @Size(max = 50)
        String upc,

        @DecimalMin("0.00")
        @Digits(integer = 10, fraction = 2)
        BigDecimal price,

        @Min(0)
        Integer stock
) {
}

