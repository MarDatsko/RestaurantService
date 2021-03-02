package restaurant.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuDishDto {
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> products;
    private Integer dishWeight;
}
