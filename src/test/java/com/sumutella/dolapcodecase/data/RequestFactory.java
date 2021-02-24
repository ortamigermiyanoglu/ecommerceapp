package com.sumutella.dolapcodecase.data;

import com.sumutella.dolapcodecase.payload.request.CreateProductRequest;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class RequestFactory {
    private static ModelMapper mapper = new ModelMapper();

    private RequestFactory() {
    }

    public static CreateShoeRequest createShoeRequest() {
        CreateShoeRequest createShoeRequest = mapper.map(createProductRequest(), CreateShoeRequest.class);
        createShoeRequest.setSize(42);
        createShoeRequest.setShoeTypeId(9L); // Running shoe
        return createShoeRequest;
    }

    public static CreateShoeRequest createShoeRequestWrongData() {
        CreateShoeRequest createShoeRequest = mapper.map(createProductRequest(), CreateShoeRequest.class);
        createShoeRequest.setSize(42);
        createShoeRequest.setShoeTypeId(21L); // THIS THROWS ERROR
        return createShoeRequest;
    }

    public static CreateProductRequest createProductRequest() {
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setBrandId(1L); //Adidas
        createProductRequest.setCategoryId(2L); //Shoes
        createProductRequest.setDescription("paraya ihtiyacim var satiyorum");
        createProductRequest.setCategoryTypeId(1L); //Man
        createProductRequest.setDiscountPercentage(0);
        createProductRequest.setPrice(BigDecimal.valueOf(499.99));
        createProductRequest.setUsageStatusId(1L); // New
        return createProductRequest;
    }
}
