package com.eunoia.travelschdule.domain.user.security;

import com.eunoia.travelschdule.domain.user.domain.User;
import com.eunoia.travelschdule.domain.user.domain.UserRepository;
import com.eunoia.travelschdule.global.error.CustomExpectedException;
import com.eunoia.travelschdule.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByNickname(username)
                .orElseThrow(() -> new CustomExpectedException(ErrorCode.USER_NOT_FOUND));

        return new PrincipalDetails(user, null, null);
    }
}
