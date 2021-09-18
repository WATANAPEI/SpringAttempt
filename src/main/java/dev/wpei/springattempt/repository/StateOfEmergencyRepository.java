package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface StateOfEmergencyRepository {
    public Page get(String prefecture);
}
