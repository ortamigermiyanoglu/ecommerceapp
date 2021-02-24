package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.service.ProductCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/api/v1")
@Api(value = "product-controller-api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductCommandService productCommandService;

    @PutMapping("/products/{productId}")
    @ApiOperation(value = "", notes = "delete product")
    public ResponseEntity<MessageResponse> deleteProduct(@Positive @Valid @PathVariable("productId") Long productId) throws NotFoundException, CommandOperationFailedException {
        return ResponseEntity.ok(productCommandService.deleteProduct(productId));
    }

}
