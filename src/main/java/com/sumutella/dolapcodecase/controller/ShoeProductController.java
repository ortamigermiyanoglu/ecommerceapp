package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.payload.response.CreateShoeModelResponse;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.payload.response.ShoeResponse;
import com.sumutella.dolapcodecase.service.*;
import com.sumutella.dolapcodecase.util.BusinesConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1")
@Api(value = "shoe-product-controller-api")
@RequiredArgsConstructor
public class ShoeProductController {
    private final DomainValueQueryService domainValueQueryService;
    private final BrandQueryService brandQueryService;
    private final CategoryQueryService categoryQueryService;
    private final ShoeCommandService shoeCommandService;
    private final ShoeQueryService shoeQueryService;
    private final CategoryTypeQueryService categoryTypeQueryService;


    @GetMapping("/products")
    @ApiOperation(value = "", notes = "get create model for shoe product")
    public ResponseEntity<CreateShoeModelResponse> getCreateShoeProductModel() throws NotFoundException {
        CreateShoeModelResponse response = new CreateShoeModelResponse();
        response.setShoeTypes(domainValueQueryService.getDomainValues(BusinesConstants.SHOE_TYPE.getCode()));
        response.setBrands(brandQueryService.getBrands(BusinesConstants.SHOE_BRAND_TYPE.getCode()));
        response.setCategories(categoryQueryService.getCategories(BusinesConstants.MAN_CATEGORY_TYPE.getCode()));
        response.setUsageStatuses(domainValueQueryService.getDomainValues(BusinesConstants.USAGE_STATUS.getCode()));
        response.setCategoryTypes(categoryTypeQueryService.getCategoryTypes());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    @ApiOperation(value = "", notes = "create shoe product")
    public ResponseEntity<MessageResponse> createProduct(@RequestBody @Valid CreateShoeRequest createShoeRequest) throws NotFoundException, CommandOperationFailedException {
        return ResponseEntity.ok(shoeCommandService.createShoe(createShoeRequest));
    }

    @PostMapping("/products/{productId}")
    @ApiOperation(value = "", notes = "get shoe product")
    public ResponseEntity<ShoeResponse> getProduct(@Positive @Valid @PathVariable("productId") Long productId) throws NotFoundException, CommandOperationFailedException {
        return ResponseEntity.ok(new ShoeResponse(shoeQueryService.getShoe(productId)));
    }


}
