package org.globex.gateway.mobile.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {

    private String itemId;

    private String name;

    @JsonProperty("desc")
    private String description;

    private String category;

    private Double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantity;

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final ProductDto productDto;

        public Builder() {
            this.productDto = new ProductDto();
        }

        public Builder withItemId(String itemId) {
            this.productDto.itemId = itemId;
            return this;
        }

        public Builder withName(String name) {
            this.productDto.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.productDto.description = description;
            return this;
        }

        public Builder withCategory(String category) {
            this.productDto.category = category;
            return this;
        }

        public Builder withPrice(Double price) {
            this.productDto.price = price;
            return this;
        }

        public Builder withQuantity(Integer quantity) {
            this.productDto.quantity = quantity;
            return this;
        }

        public ProductDto build() {
            return this.productDto;
        }
    }
}
