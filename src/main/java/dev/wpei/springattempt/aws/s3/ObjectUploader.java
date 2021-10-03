package dev.wpei.springattempt.aws.s3;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import dev.wpei.springattempt.domain.LocalStateOfEmergency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ObjectUploader {
    private final String BUCKET_NAME = "wpei-dev-html";
    private final Regions REGION = Regions.AP_NORTHEAST_2;
    public void upload(LocalStateOfEmergency localStateOfEmergency) {
        log.info("Uploading %s to S3 bucket %s...\n", localStateOfEmergency.getPrefecture(), BUCKET_NAME);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(REGION).build();
        try {
            //s3.putObject(BUCKET_NAME, localStateOfEmergency.getPrefecture().toString(), localStateOfEmergency.getEffectiveTo().toString());
        } catch(AmazonServiceException e) {
            log.error(e.getMessage());
            throw e;
        }

    }
}
