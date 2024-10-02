package com.eunoia.travelschdule.domain.user.application;

import com.eunoia.travelschdule.domain.user.domain.User;
import com.eunoia.travelschdule.domain.user.domain.UserRepository;
import com.eunoia.travelschdule.domain.user.security.PrincipalDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Oauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        Map<String, Object> oAuth2UserAttributes = super.loadUser(userRequest).getAttributes();

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfo.of(registrationId, oAuth2UserAttributes);

        User user = getOrSave(oAuth2UserInfo);

        return new PrincipalDetails(user, oAuth2UserAttributes, userNameAttributeName);
    }

    @Transactional
    private User getOrSave(OAuth2UserInfo oAuth2UserInfo) {
        Optional<User> user = userRepository.findByEmail(oAuth2UserInfo.email());

        return user.orElseGet(() -> userRepository.save(oAuth2UserInfo.toEntity()));

    }
}
