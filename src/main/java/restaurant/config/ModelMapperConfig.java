package restaurant.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import restaurant.mapping.MenuDishDtoMapper;

@Configuration
public class ModelMapperConfig {

    private final MenuDishDtoMapper menuDishDtoMapper;

    @Autowired
    public ModelMapperConfig(MenuDishDtoMapper menuDishDtoMapper) {
        this.menuDishDtoMapper = menuDishDtoMapper;
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        addConverters(modelMapper);

        return modelMapper;
    }

    private void addConverters(ModelMapper modelMapper) {
        modelMapper.addConverter(menuDishDtoMapper);

    }
}
