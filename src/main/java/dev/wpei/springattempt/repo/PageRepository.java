package dev.wpei.springattempt.repo;

import dev.wpei.springattempt.domain.Page;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PageRepository {
    private Path dirPath = Paths.get("target");
    public PageRepository() {
    }
    public void save(Page page) {
        System.out.println(page + " saved to " + dirPath);
    }
}
