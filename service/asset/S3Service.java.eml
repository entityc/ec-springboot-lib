package ${domain.namespace}.asset;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ${exceptionNamespace}.ServiceException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Log
@Service
@ConditionalOnProperty(name = "app.asset.binaryPersistence", havingValue = "s3")
public class S3Service implements BinaryPersistence {

    private AmazonS3 amazonS3;

    @Value("${$}{aws.s3.region:}")
    private String awsRegion;

    @Value("${$}{aws.s3.minioUrl:}")
    private String minioUrl;

    @Value("${$}{aws.s3.awsAccessKeyId:}")
    private String awsAccessKeyId;

    @Value("${$}{aws.s3.awsSecretAccessKey:}")
    private String awsSecretAccessKey;

    @Value("${$}{aws.cdn.hostname:}")
    private String awsCdnHostname;

    @PostConstruct
    private void initializeAmazon() {
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();

        boolean useMinio = StringUtils.isNotEmpty(minioUrl);
        if(useMinio){
            builder.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(minioUrl, Regions.US_EAST_1.name()));
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setSignerOverride("AWSS3V4SignerType");
            builder.withClientConfiguration(clientConfiguration);
            builder.withPathStyleAccessEnabled(true);
            log.info(String.format("[S3Service] - using minio %s for S3 integration", minioUrl));
        } else if (StringUtils.isNotEmpty(awsRegion)) {
            builder.withRegion(awsRegion);
        }

        if(StringUtils.isNotEmpty(awsAccessKeyId)
            && StringUtils.isNotEmpty(awsSecretAccessKey)) {
            builder.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKeyId, awsSecretAccessKey)));
            log.info("[S3Service] - using static credentials for S3 integration");
        }
        this.amazonS3 = builder.build();
    }

    @PreDestroy
    private void shutdownAmazonS3Client() {
        if (amazonS3 != null) {
            amazonS3.shutdown();
        }
    }

    @Override
    public void save(String path, String filename, InputStream inputStream, Metadata metadata) throws ServiceException {
        final ObjectMetadata objectMetadata = new ObjectMetadata();

        if (metadata.getContentLength() <= 0) {
            throw new IllegalArgumentException("Content length must be a positive number");
        }
        objectMetadata.setContentLength(metadata.getContentLength());

        if (metadata.getContentType() != null) {
            objectMetadata.setContentType(metadata.getContentType());
        }

        if (metadata.getContentDisposition() != null) {
            objectMetadata.setContentDisposition(metadata.getContentDisposition());
        }

        final PutObjectRequest putObjectRequest = new PutObjectRequest(path, filename, inputStream, objectMetadata);
        try {
            amazonS3.putObject(putObjectRequest);
        } catch (AmazonClientException e) {
            log.warning(String.format("S3 error saving file key %s into bucket %s", filename, path));
            throw new ServiceException(String.format("S3 error saving file key %s into bucket %s", filename, path), e);
        }
    }

    @Override
    public void delete(String path, String filename) throws ServiceException {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(path, filename));
        } catch (AmazonClientException e) {
            log.warning(String.format("S3 error deleting file key %s from bucket %s", filename, path));
            throw new ServiceException(String.format("S3 error deleting file key %s from bucket %s", filename, path), e);
        }
    }

    @Override
    public String getUrl(String path, String filename) {
        try {
            URL url = amazonS3.getUrl(path,filename);
            if (awsCdnHostname != null) {
                url = new URL(url.getProtocol(), awsCdnHostname, url.getPort(), url.getFile());
            }
            return url.toString();
        } catch (AmazonServiceException ase) {
            log.warning(String.format("S3 error retrieving URL for asset key %s from bucket %s", filename, path));
        } catch (AmazonClientException ace) {
            log.warning(String.format("S3 error retrieving URL for asset key %s from bucket %s", filename, path));
        } catch (MalformedURLException mue) {
            log.warning(String.format("S3 error retrieving URL for asset key %s from bucket %s", filename, path));
        }
        return null;
    }

}
