package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Role;
import com.sumutella.dolapcodecase.repository.RoleRepository;
import com.sumutella.dolapcodecase.service.RoleQueryService;
import com.sumutella.dolapcodecase.util.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRole(ERole roleName) {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        return userRole;
    }
}
