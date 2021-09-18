package dev.wpei.springattempt.repository;

import dev.wpei.springattempt.domain.Page;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PageRepositoryImpl implements PageRepository {
    public void save(Page page) {
        final Path filePath = Paths.get("temp.txt");
        try {
            Path file = Files.createFile(filePath);
            String txt = page + " saved to " + file;
            Files.writeString(file, txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
