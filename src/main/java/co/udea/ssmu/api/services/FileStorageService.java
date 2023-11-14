package co.udea.ssmu.api.services;

import co.udea.ssmu.api.utils.common.FileStorageS3Util;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class FileStorageService {

    @Value("${amazon.s3.bucket-name.one}")
    private String bucketName;

    @Value("${amazon.s3.url.one}")
    private String urlBucket;

    private final static String pathformat = "%s/%s";

    private final FileStorageS3Util fileStorageS3Util;

    public FileStorageService(FileStorageS3Util fileStorageS3Util) {
        this.fileStorageS3Util = fileStorageS3Util;
    }

    public String createFilePdf(MultipartFile file, Long conductorId, String fileName) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is a PDF
        if (!Arrays.asList(ContentType.getByMimeType("application/pdf").toString()).contains(file.getContentType())) {
            throw new IllegalStateException("File uploaded is not a PDF");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save PDF in S3 and then save in the database
        String path = String.format(pathformat, bucketName, conductorId);
        try {
            fileStorageS3Util.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        return (path.concat("/").concat(fileName));
    }

    public String createFileImage(MultipartFile file, Long conductorId, String fileName) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        //Check if the file is a PDF
        if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_BMP.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File uploaded is not an IMAGE");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save PDF in S3 and then save in the database
        String path = String.format(pathformat, bucketName, conductorId);
        try {
            fileStorageS3Util.upload(path,fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        return (path.concat("/").concat(fileName));
    }

    public void deleteFile(String fileName, Long conductorId) {

        //Save Image in S3 and then save in the database
        String path = String.format(pathformat, bucketName, conductorId);
        fileStorageS3Util.delete(path, fileName);


    }

}