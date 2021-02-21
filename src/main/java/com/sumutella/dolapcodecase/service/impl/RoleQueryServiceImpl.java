package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Role;
import com.sumutella.dolapcodecase.domain.domainutil.ERole;
import com.sumutella.dolapcodecase.repository.RoleRepository;
import com.sumutella.dolapcodecase.service.RoleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRole(ERole roleName) {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        return userRole;
    }
}
