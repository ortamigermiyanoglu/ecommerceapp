package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ShoeProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DomainValueQueryService domainValueQueryService;
    @Autowired
    private BrandQueryService brandQueryService;
    @Autowired
    private CategoryQueryService categoryQueryService;
    @Autowired
    private ShoeCommandService shoeCommandService;
    @Autowired
    private ShoeQueryService shoeQueryService;
    @Autowired
    private CategoryTypeQueryService categoryTypeQueryService;

    private ShoeProductController controller;


    @BeforeEach
    void setUp() {
        controller = new ShoeProductController(domainValueQueryService, brandQueryService, categoryQueryService, shoeCommandService, shoeQueryService, categoryTypeQueryService);
    }


    //TODO authentication during api endpoint test
//    @Test
//    void getCreateShoeProductModel() throws Exception {
//        mockMvc.perform(post("/api/v1/shoes")
//        .contentType("application/json")).andExpect(status().isOk());
//    }
}