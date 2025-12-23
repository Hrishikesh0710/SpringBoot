package com.gop.GangsOfPav.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class OrderItemDTO {

    @NotBlank(message = "itemName is required")
    private String itemName;

    @Positive(message = "price must be greater than 0")
    private Double price;

    @Positive(message = "quantity must be greater than 0")
    private Integer quantity;

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
