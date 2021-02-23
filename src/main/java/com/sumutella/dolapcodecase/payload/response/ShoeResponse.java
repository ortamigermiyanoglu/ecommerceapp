package com.sumutella.dolapcodecase.payload.response;

import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoeResponse {
    private ProductDTO productDTO;
}
