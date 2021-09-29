package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import dev.wpei.springattempt.mapper.StateOfEmergencyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class LocalStateOfEmergencyRepositoryImpl implements LocalStateOfEmergencyRepository {
    StateOfEmergencyMapper mapper;

    public void save(LocalStateOfEmergency localStateOfEmergency) {
//        final Path filePath = Paths.get("temp.txt");
//        try {
//            Path file = Files.createFile(filePath);
//            String txt = localStateOfEmergency + " saved to " + file;
//            Files.writeString(file, txt);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        mapper.save(localStateOfEmergency);

    }
}
