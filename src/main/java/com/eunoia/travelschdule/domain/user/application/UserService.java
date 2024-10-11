package com.eunoia.travelschdule.domain.user.application;

import com.eunoia.travelschdule.domain.user.domain.User;
import com.eunoia.travelschdule.domain.user.domain.UserRepository;
import com.eunoia.travelschdule.global.error.CustomExpectedException;
import com.eunoia.travelschdule.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUserByName(String userName) {
        User currentUser = userRepository.findByNickname(userName)
                .orElseThrow(() -> new CustomExpectedException(ErrorCode.USER_NOT_FOUND));

        return currentUser;

    }
}
