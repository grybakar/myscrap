package com.devbridge.sourcery.myscrap.utils;

import com.devbridge.sourcery.myscrap.exception.MyScrapException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class ImageUploadUtils {

  private final Path storageDirectory = Paths.get("images");


  public String uploadImage(MultipartFile file) {

    if (file == null) {
      throw new MyScrapException("File cannot be null");
    }
    try {
      byte[] data = file.getBytes();
      Path filePath = Paths.get(storageDirectory + File.separator + file.getOriginalFilename());
      Files.write(filePath, data);
    } catch (IOException e) {
      throw new MyScrapException("Error in uploading an image", e);
    }
    return Optional.of(file)
      .map(MultipartFile::getOriginalFilename)
      .map(name -> UriComponentsBuilder
        .fromPath("/images/getImage/")
        .path(name)
        .toUriString())
      .orElseThrow(() -> new MyScrapException("Error in image name or file"));
  }

  public byte[] getImage(String fileName) {
    Path filePath = Paths.get(storageDirectory + File.separator + fileName);
    try {
      return IOUtils.toByteArray(filePath.toUri());
    } catch (IOException e) {
      throw new MyScrapException("Error in getting an image", e);
    }
  }
}
