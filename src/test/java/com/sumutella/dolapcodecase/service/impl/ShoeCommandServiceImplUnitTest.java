package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.data.RequestFactory;
import com.sumutella.dolapcodecase.domain.Brand;
import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.domain.DomainValue;
import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.BrandQueryService;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.service.ShoeCommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ShoeCommandServiceImplUnitTest {

    @Mock
    private DomainValueQueryService domainValueQueryService;
    @Mock
    private ShoeRepository shoeRepository;
    @Mock
    private BrandQueryService brandQueryService;
    @Mock
    private CategoryQueryService categoryQueryService;

    private ShoeCommandService service;


    @BeforeEach
    void setUp() {
        service = new ShoeCommandServiceImpl(domainValueQueryService, shoeRepository, brandQueryService, categoryQueryService);
    }

    @Test
    void createShoe() throws NotFoundException, CommandOperationFailedException {

        Mockito.when(domainValueQueryService.getDomainValue(Mockito.anyLong())).thenReturn(new DomainValue());
        Mockito.when(brandQueryService.getBrand(Mockito.anyLong())).thenReturn(new Brand());
        Mockito.when(categoryQueryService.getCategory(Mockito.anyLong(), Mockito.anyLong())).thenReturn(new Category());

        MessageResponse actual = service.createShoe(RequestFactory.createShoeRequest());

        assertEquals("Product created successfully", actual.getMessage());

    }

}