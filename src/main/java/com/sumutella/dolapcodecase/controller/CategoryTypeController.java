package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.CategoryTypeQueryService;
import com.sumutella.dolapcodecase.service.ProductQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "category-type-controller-api")
@RequiredArgsConstructor
public class CategoryTypeController {
    private final CategoryQueryService categoryQueryService;
    private final CategoryTypeQueryService categoryTypeQueryService;
    private final ProductQueryService productQueryService;


    @GetMapping("/categorytypes/{categoryTypeId}")
    @ApiOperation(value = "", notes = "get categories in the category type")
    public ResponseEntity<List<IdCodeDisplayValueDTO>> getCategoriesInCategoryType(@PathVariable("categoryTypeId") Long categoryTypeId) throws NotFoundException {
        return ResponseEntity.ok(categoryQueryService.getCategories(categoryTypeId));
    }

    @GetMapping("/categorytypes")
    @ApiOperation(value = "", notes = "get category types")
    public ResponseEntity<List<IdCodeDisplayValueDTO>> getCategoryTypes() {
        return ResponseEntity.ok(categoryTypeQueryService.getCategoryTypes());
    }


    @GetMapping("/categorytypes/{categoryTypeId}/categories/{categoryId}")
    @ApiOperation(value = "", notes = "get products in the category types' category")
    public ResponseEntity<List<ProductDTO>> getProductsInCategory(@PathVariable("categoryTypeId") Long categoryTypeId, @PathVariable("categoryId") Long categoryId) throws NotFoundException {
        return ResponseEntity.ok(productQueryService.getProducts(categoryTypeId, categoryId));
    }


}
