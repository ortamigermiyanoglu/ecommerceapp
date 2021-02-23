package com.sumutella.dolapcodecase.configuration;

import com.sumutella.dolapcodecase.domain.Brand;
import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.domain.DomainValue;
import com.sumutella.dolapcodecase.domain.Product;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    private ModelMapper modelMapper = new ModelMapper();

    @Bean
    public ModelMapper modelMapper() {
        PropertyMap<DomainValue, IdCodeDisplayValueDTO> domainValuesMap = new PropertyMap<>() {
            protected void configure() {
                map().setDisplayValue(source.getName());
            }
        };
        modelMapper.addMappings(domainValuesMap);

        PropertyMap<Brand, IdCodeDisplayValueDTO> brandsMap = new PropertyMap<>() {
            protected void configure() {
                map().setDisplayValue(source.getName());
            }
        };
        modelMapper.addMappings(brandsMap);

        PropertyMap<Category, IdCodeDisplayValueDTO> categoriesMap = new PropertyMap<>() {
            protected void configure() {
                map().setDisplayValue(source.getName());
            }
        };
        modelMapper.addMappings(categoriesMap);

        PropertyMap<Product, ProductDTO> productsMap = new PropertyMap<>() {
            protected void configure() {
                map().setDiscountPercentage(source.getDiscountPercantege());
            }
        };
        modelMapper.addMappings(productsMap);

        return modelMapper;
    }
}
