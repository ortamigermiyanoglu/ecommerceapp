package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.data.RequestFactory;
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
class ShoeCommandServiceImplIntegrationTest {
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
        CreateShoeRequest createShoeRequest = RequestFactory.createShoeRequest();

        service.createShoe(createShoeRequest);

        List<ProductDTO> productDTOList = productQueryService.getProducts(2L);
        assertEquals(1, productDTOList.size());
        assertEquals("paraya ihtiyacim var satiyorum", productDTOList.get(0).getProductDescription());
        assertEquals(BigDecimal.valueOf(499.99), productDTOList.get(0).getProductPrice());
        assertEquals("Shoe", productDTOList.get(0).getProductCategoryName());
    }

    @Test
    void createShoeV2() {

        CreateShoeRequest createShoeRequest = RequestFactory.createShoeRequestWrongData();

        assertThrows(NotFoundException.class, () -> service.createShoe(createShoeRequest));

    }
}