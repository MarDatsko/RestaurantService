package restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.ToString;
import restaurant.model.enums.DishType;

@Data
@ToString
@Document(collection = "Dish")
public class Dish {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;
    private BigDecimal price = BigDecimal.ZERO;
    private List<Ingredient> ingredients;
    private DishType type;
}
