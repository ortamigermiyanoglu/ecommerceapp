package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.*;
import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.repository.ProductRepository;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.BrandQueryService;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.service.ShoeCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ShoeCommandServiceImpl implements ShoeCommandService {
    private final BrandQueryService brandQueryService;
    private final CategoryQueryService categoryQueryService;
    private final DomainValueQueryService domainValueQueryService;
    private final ShoeRepository shoeRepository;
    private final ProductRepository productRepository;


    @Override
    public MessageResponse createShoe(CreateShoeRequest createShoeRequest) throws NotFoundException, CommandOperationFailedException {
        Brand brand = brandQueryService.getBrand(createShoeRequest.getBrandId());
        DomainValue usageStatus = domainValueQueryService.getDomainValue(createShoeRequest.getUsageStatusId());
        DomainValue shoeType = domainValueQueryService.getDomainValue(createShoeRequest.getShoeTypeId());
        Category category = categoryQueryService.getCategory(createShoeRequest.getCategoryTypeId(), createShoeRequest.getCategoryId());
        Shoe shoe = new Shoe();
        Product product = new Product();
        product.setBrand(brand);
        product.setCategory(category);
        product.setUsageStatus(usageStatus);
        product.setPrice(createShoeRequest.getPrice());
        product.setDescription(createShoeRequest.getDescription());
        product.setDiscountPercentage(createShoeRequest.getDiscountPercentage());
        Product savedProduct = productRepository.save(product);

        shoe.setProduct(savedProduct);
        shoe.setShoeType(shoeType);
        shoe.setSize(createShoeRequest.getSize());

        Shoe savedShoe = shoeRepository.save(shoe);
        if (Objects.nonNull(savedShoe)) {
            return new MessageResponse("Product created successfully");
        }

        throw new CommandOperationFailedException("Shoe create product request failed: " + createShoeRequest);
    }
}
