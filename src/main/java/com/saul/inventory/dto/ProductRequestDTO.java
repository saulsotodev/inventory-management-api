package com.saul.inventory.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String name;

    @NotNull(message = "La cantidad inicial es obligatoria.")
    @Min(value = 0, message = "El inventario inicial no puede ser negativo.")
    private Integer quantity;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a cero.")
    private BigDecimal price;
}