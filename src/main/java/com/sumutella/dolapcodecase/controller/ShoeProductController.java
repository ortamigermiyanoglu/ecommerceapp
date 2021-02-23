package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.response.CreateShoeModelResponse;
import com.sumutella.dolapcodecase.service.BrandQueryService;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.util.BusinesConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(value = "shoe-product-controller-api")
@RequiredArgsConstructor
public class ShoeProductController {
    private final DomainValueQueryService domainValueQueryService;
    private final BrandQueryService brandQueryService;
    private final CategoryQueryService categoryQueryService;


    @GetMapping("/product")
    @ApiOperation(value = "", notes = "get create model for shoe product")
    public ResponseEntity<CreateShoeModelResponse> getCreateShoeProductModel() throws NotFoundException {
        CreateShoeModelResponse response = new CreateShoeModelResponse();
        response.setShoeTypes(domainValueQueryService.getDomainValues(BusinesConstants.SHOE_TYPE.getCode()));
        response.setBrands(brandQueryService.getBrands(BusinesConstants.SHOE_BRAND_TYPE.getCode()));
        response.setCategories(categoryQueryService.getCategories(BusinesConstants.MAN_CATEGORY_TYPE.getCode()));
        response.setUsageStatuses(domainValueQueryService.getDomainValues(BusinesConstants.USAGE_STATUS.getCode()));
        return ResponseEntity.ok(response);
    }

}
