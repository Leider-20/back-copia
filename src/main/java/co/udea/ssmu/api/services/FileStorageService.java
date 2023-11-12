package co.udea.ssmu.api.services;

import co.udea.ssmu.api.model.jpa.model.Documentos;
import co.udea.ssmu.api.utils.common.FileStorageS3Util;
import com.amazonaws.services.kendra.model.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class FileStorageService {

    @Value("amazon.s3.bucket-name.one")
    private String bucketName;

    @Value("amazon.s3.url.one")
    private String urlBucket;

    private final FileStorageS3Util fileStorageS3Util;

    public FileStorageService(FileStorageS3Util fileStorageS3Util) {
        this.fileStorageS3Util = fileStorageS3Util;
    }

    public String createFilePdf(MultipartFile file, Long ConductorId, String fileName) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is a PDF
        if (!Arrays.asList(ContentType.PDF.toString()).contains(file.getContentType())) {
            throw new IllegalStateException("File uploaded is not a PDF");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save PDF in S3 and then save in the database
        String path = String.format("%s/%s", bucketName);
        try {
            fileStorageS3Util.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        return (urlBucket.concat(String.valueOf(ConductorId)).concat("/").concat(fileName));
    }

    public String createFileImage(MultipartFile file, Long conductorId, String fileName) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is a PDF
        if (!Arrays.asList(IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File uploaded is not an IMAGE");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save PDF in S3 and then save in the database
        String path = String.format("%s/%s", bucketName);
        try {
            fileStorageS3Util.upload(path,fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        return (urlBucket.concat(String.valueOf(conductorId)).concat("/").concat(fileName));
    }

    public void deleteFile(String fileName, Long conductorId) {

        //Save Image in S3 and then save in the database
        String path = String.format("%s/%s", bucketName, conductorId);
        fileStorageS3Util.delete(path, fileName);


    }

}