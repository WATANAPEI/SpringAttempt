package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import org.springframework.stereotype.Repository;

@Repository
public interface StateOfEmergencyRepository {
    public LocalStateOfEmergency get(String prefecture);
    public String getAccessUrl(String prefecture);
}
