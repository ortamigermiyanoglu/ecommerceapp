package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.*;
import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.BrandQueryService;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.service.ShoeCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ShoeCommandServiceImpl implements ShoeCommandService {
    private final DomainValueQueryService domainValueQueryService;
    private final ShoeRepository shoeRepository;
    private final BrandQueryService brandQueryService;
    private final CategoryQueryService categoryQueryService;


    @Override
    public MessageResponse createShoe(CreateShoeRequest createShoeRequest) throws NotFoundException, CommandOperationFailedException {
        Shoe shoe = new Shoe();
        Product product = new Product();

        DomainValue shoeType = domainValueQueryService.getDomainValue(createShoeRequest.getShoeTypeId());
        Brand brand = brandQueryService.getBrand(createShoeRequest.getBrandId());
        DomainValue usageStatus = domainValueQueryService.getDomainValue(createShoeRequest.getUsageStatusId());
        Category category = categoryQueryService.getCategory(createShoeRequest.getCategoryTypeId(), createShoeRequest.getCategoryId());

        product.setBrand(brand);
        product.setCategory(category);
        product.setUsageStatus(usageStatus);
        product.setPrice(createShoeRequest.getPrice());
        product.setDescription(createShoeRequest.getDescription());
        product.setDiscountPercentage(createShoeRequest.getDiscountPercentage());
        shoe.setProduct(product);
        shoe.setShoeType(shoeType);
        shoe.setSize(createShoeRequest.getSize());

        shoeRepository.save(shoe);
        return new MessageResponse("Product created successfully");

    }

    @Override
    public void deleteShoe(Long productId) {
        Shoe shoe = shoeRepository.getOne(productId);
        shoe.setDeleted(true);
        shoeRepository.save(shoe);
    }
}
