package com.javaguru.shoppinglist.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {

    @NotNull(groups = {Update.class})
    @Null(groups = {Create.class})
    private Long id;
    @NotEmpty(groups = {Update.class, Create.class})
    private String name;
    private String info;
    @Min(0)
    private BigDecimal price;
    @Min(0)
    @Max(99)
    private BigDecimal discount;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(info, that.info) &&
                Objects.equals(price, that.price) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, price, discount);
    }

    @Override
    public String toString() {
        return "productDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }


    public interface Update {
        // empty class
    }

    public interface Create {
        // empty class
    }
}
