package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.payload.request.CreateShoeRequest;

public interface ShoeCommandService {
    void createShoe(CreateShoeRequest createShoeRequest);
}
