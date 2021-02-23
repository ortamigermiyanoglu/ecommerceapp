package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
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
@Api(value = "category-controller-api")
@RequiredArgsConstructor
public class CategoryController {
    private final ProductQueryService productQueryService;

    @GetMapping("/categories/{categoryId}")
    @ApiOperation(value = "", notes = "get products in the category")
    public ResponseEntity<List<ProductDTO>> getProductsInCategory(@PathVariable("categoryId") Long categoryId) throws NotFoundException {
        return ResponseEntity.ok(productQueryService.getProducts(categoryId));
    }

}
