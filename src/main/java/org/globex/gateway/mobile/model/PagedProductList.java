package org.globex.gateway.mobile.model;

import java.util.List;

public class PagedProductList {

    private List<ProductDto> products;

    private int totalElements;

    private int totalPages;

    private int numberOfElements;

    private int size;

    private int number;

    public List<ProductDto> getProducts() {
        return products;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public int getNumber() {
        return number;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final PagedProductList productList;

        public Builder() {
            this.productList = new PagedProductList();
        }

        public Builder withProducts(List<ProductDto> products) {
            this.productList.products = products;
            return this;
        }

        public Builder withTotalElements(int totalElements) {
            this.productList.totalElements = totalElements;
            return this;
        }

        public Builder withTotalPages(int totalPages) {
            this.productList.totalPages = totalPages;
            return this;
        }

        public Builder withNumberOfElements(int numberOfElements) {
            this.productList.numberOfElements = numberOfElements;
            return this;
        }

        public Builder withSize(int size) {
            this.productList.size = size;
            return this;
        }

        public Builder withNumber(int number) {
            this.productList.number = number;
            return this;
        }

        public PagedProductList build() {
            return this.productList;
        }
    }
}
