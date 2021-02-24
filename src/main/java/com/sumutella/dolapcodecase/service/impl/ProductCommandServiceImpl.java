package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Product;
import com.sumutella.dolapcodecase.domain.Shoe;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;
import com.sumutella.dolapcodecase.repository.ProductRepository;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
import com.sumutella.dolapcodecase.service.ProductCommandService;
import com.sumutella.dolapcodecase.util.BusinesConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {
    private final DomainValueQueryService domainValueQueryService;
    private final ProductRepository productRepository;
    private final ShoeRepository shoeRepository;

//    @Override
//    public Product createProduct(CreateProductRequest createProductRequest) throws NotFoundException {
//        Brand brand = brandQueryService.getBrand(createProductRequest.getBrandId());
//        DomainValue usageStatus = domainValueQueryService.getDomainValue(createProductRequest.getUsageStatusId());
//        Category category = categoryQueryService.getCategory(createProductRequest.getCategoryTypeId(), createProductRequest.getCategoryId());
//        Product product = new Product();
//        product.setBrand(brand);
//        product.setCategory(category);
//        product.setUsageStatus(usageStatus);
//        product.setPrice(createProductRequest.getPrice());
//        product.setDescription(createProductRequest.getDescription());
//        product.setDiscountPercentage(createProductRequest.getDiscountPercentage());
//        return productRepository.save(product);
//    }

    @Override
    public MessageResponse deleteProduct(Long productId) throws NotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new NotFoundException("No product find with product id " + productId);
        }
        Product product = optionalProduct.get();
        product.setDeleted(true);


        if (product.getCategory().getCode().equals(BusinesConstants.SHOES.getCode())) {
            Shoe shoe = shoeRepository.getOne(productId);
            shoe.setDeleted(true);
            shoeRepository.save(shoe);

        } else if (product.getCategory().getCode().equals(BusinesConstants.CLOTHING.getCode())) {
            //TODO implement dress command&query services and controllers
        }

        productRepository.save(product);


        return new MessageResponse("Product with id " + productId + " deleted successfully");
    }
}
