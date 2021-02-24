package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.domain.Role;
import com.sumutella.dolapcodecase.util.ERole;

public interface RoleQueryService {
    Role getRole(ERole roleName);
}
