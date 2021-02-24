package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.exception.CommandOperationFailedException;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;

public interface ShoeCommandService {
    MessageResponse createShoe(CreateShoeRequest createShoeRequest) throws NotFoundException, CommandOperationFailedException;

    void deleteShoe(Long productId);
}
