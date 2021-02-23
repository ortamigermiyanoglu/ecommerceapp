package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.service.ShoeQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ShoeQueryServiceImpl implements ShoeQueryService {


}
