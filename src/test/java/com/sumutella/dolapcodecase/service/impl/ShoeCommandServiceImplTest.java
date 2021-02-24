package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(SpringRunner.class)
@SpringBootTest
class ShoeCommandServiceImplTest {
    ShoeCommandService service;
    @Autowired
    private DomainValueQueryService domainValueQueryService;
    @Autowired
    private ShoeRepository shoeRepository;
    @Autowired
    private BrandQueryService brandQueryService;
    @Autowired
    private CategoryQueryService categoryQueryService;
    @Autowired
    private ProductQueryService productQueryService;

    @BeforeEach
    void setUp() {
        service = new ShoeCommandServiceImpl(domainValueQueryService, shoeRepository, brandQueryService, categoryQueryService);
    }

    @Test
    void createShoe() throws NotFoundException, CommandOperationFailedException {
        CreateShoeRequest createShoeRequest = new CreateShoeRequest();
        createShoeRequest.setBrandId(1L); //Adidas
        createShoeRequest.setCategoryId(2L); //Shoes
        createShoeRequest.setDescription("paraya ihtiyacim var satiyorum");
        createShoeRequest.setCategoryTypeId(1L); //Man
        createShoeRequest.setDiscountPercentage(0);
        createShoeRequest.setPrice(BigDecimal.valueOf(499.99));
        createShoeRequest.setShoeTypeId(9L); // Running shoe
        createShoeRequest.setUsageStatusId(1L); // New
        createShoeRequest.setSize(42);

        service.createShoe(createShoeRequest);

        List<ProductDTO> productDTOList = productQueryService.getProducts(2L);
        assertEquals(1, productDTOList.size());
        assertEquals("paraya ihtiyacim var satiyorum", productDTOList.get(0).getProductDescription());
        assertEquals(BigDecimal.valueOf(499.99), productDTOList.get(0).getProductPrice());
        assertEquals("Shoes", productDTOList.get(0).getProductCategoryName());
    }

    @Test
    void createShoeV2() throws NotFoundException, CommandOperationFailedException {

        CreateShoeRequest createShoeRequest = new CreateShoeRequest();
        createShoeRequest.setBrandId(1L); //Adidas
        createShoeRequest.setCategoryId(2L); //Shoes
        createShoeRequest.setDescription("hediye geldi satiyorum");
        createShoeRequest.setCategoryTypeId(10L); //THIS WILL THROW EXCEPTION
        createShoeRequest.setDiscountPercentage(0);
        createShoeRequest.setPrice(BigDecimal.valueOf(499.99));
        createShoeRequest.setShoeTypeId(9L); // Running shoe
        createShoeRequest.setUsageStatusId(1L); // New


        createShoeRequest.setSize(42);

        assertThrows(NotFoundException.class, () -> service.createShoe(createShoeRequest));

    }
}