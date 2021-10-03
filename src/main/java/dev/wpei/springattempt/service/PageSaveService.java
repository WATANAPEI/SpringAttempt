package dev.wpei.springattempt.service;

import dev.wpei.springattempt.aws.s3.ObjectUploader;
import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import dev.wpei.springattempt.repository.LocalStateOfEmergencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PageSaveService {
    private ObjectUploader uploader;
    private LocalStateOfEmergencyRepository repo;

    /**
     * Use PageSaveServiceBuilder, not constructor
     */
    @Autowired
    public PageSaveService(LocalStateOfEmergencyRepository repo){
        this.repo = repo;
    }
    public PageSaveService withS3() {
        this.uploader = new ObjectUploader();
        return this;
    }

    public void save(LocalStateOfEmergency localStateOfEmergency) {
        if(uploader == null && repo == null) {
            throw new IllegalStateException("Save destination must be specified.");
        }
        if(uploader != null) {
            uploader.upload(localStateOfEmergency);
            log.info("S3 upload finished.");
        }
        if(repo != null) {
            repo.save(localStateOfEmergency);
            log.info("File save finished.");
        }

    }
}
