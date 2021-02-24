package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.DomainValue;
import com.sumutella.dolapcodecase.domain.Product;
import com.sumutella.dolapcodecase.domain.Shoe;
import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.service.ProductCommandService;
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
    private final ProductCommandService productCommandService;


    @Override
    public MessageResponse createShoe(CreateShoeRequest createShoeRequest) throws NotFoundException, CommandOperationFailedException {
        Shoe shoe = new Shoe();
        Product savedProduct = productCommandService.createProduct(createShoeRequest);
        DomainValue shoeType = domainValueQueryService.getDomainValue(createShoeRequest.getShoeTypeId());

        shoe.setProduct(savedProduct);
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
