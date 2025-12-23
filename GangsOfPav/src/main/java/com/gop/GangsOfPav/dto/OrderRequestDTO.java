package com.gop.GangsOfPav.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class OrderRequestDTO {

    @Positive(message = "totalAmount must be greater than 0")
    private Double totalAmount;

    @NotEmpty(message = "items must not be empty")
    @Valid
    private List<OrderItemDTO> items;

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
}
