package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.User;
import com.sumutella.dolapcodecase.repository.UserRepository;
import com.sumutella.dolapcodecase.security.UserDetailsImpl;
import com.sumutella.dolapcodecase.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserDetailsService, UserQueryService {
    private final UserRepository userRepository;
    private final UserDetailsImpl userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return userDetails.build(user);

    }
}
