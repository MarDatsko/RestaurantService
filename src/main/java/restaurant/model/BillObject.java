package restaurant.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BillObject {
    private String dishName;
    private Integer count;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    public BillObject(String dishName, Integer count, BigDecimal price) {
        this.dishName = dishName;
        this.count = count;
        this.unitPrice = price;
        this.totalPrice = price.multiply(BigDecimal.valueOf(count));
    }
}
