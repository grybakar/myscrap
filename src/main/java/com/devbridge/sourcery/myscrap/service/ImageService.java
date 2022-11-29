package com.devbridge.sourcery.myscrap.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ImageService {

  private final Path storageDirectory = Paths.get("images");

  public String uploadImage(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    if (!Files.exists(storageDirectory)) {
      try {
        Files.createDirectories(storageDirectory);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Path destination = Paths.get(storageDirectory.toString() + "\\" + fileName);

    try {
      Files.copy(file.getInputStream(), destination,
        StandardCopyOption.REPLACE_EXISTING);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("api/images/getImage/")
      .path(fileName)
      .toUriString();

  }

  public byte[] getImage(String imageName) throws IOException {
    Path destination = Paths.get(storageDirectory + "\\" + imageName);// retrieve the image by its name

    return IOUtils.toByteArray(destination.toUri());
  }


}
