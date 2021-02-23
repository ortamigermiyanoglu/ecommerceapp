package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.payload.request.CreateDressRequest;

public interface DressCommandService {
    void createDress(CreateDressRequest createDressRequest);
}
