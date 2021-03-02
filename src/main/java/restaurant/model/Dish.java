package restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "Dish")
public class Dish {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<Product> products;
    private Integer dishWeight;
}
