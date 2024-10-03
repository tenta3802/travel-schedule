package com.eunoia.travelschdule.domain.token.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<Token, String> {

    Optional<Token> findByAccessToken(String accessToken);
}
