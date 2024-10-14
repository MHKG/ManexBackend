package com.manex.backend.service;

import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.entities.TbMm;
import com.manex.backend.enums.MultiMediaTypes;
import com.manex.backend.repositories.TbMmRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@Transactional
public class TbMmService implements TbMmDAO {

    @Autowired private TbMmRepository tbMmRepository;

    @Override
    public TbMm saveImageFileWithName(String uploadDir, MultipartFile file, String name, Integer id)
            throws IOException {
        String fileName =
                name + "." + Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
        Path filePath = Paths.get(uploadDir, fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        TbMm tbMm;
        if (id == null) {
            tbMm = new TbMm();
        } else {
            tbMm = tbMmRepository.findById(id).orElseThrow();
        }
        tbMm.setMM_FILE_NAME(filePath.toString());
        if (uploadDir.contains("supplier")) {
            tbMm.setMM_TITLE("Supplier Logo");
            tbMm.setDESCRIPTION("Supplier Logo");
        } else if (uploadDir.contains("customer")) {
            tbMm.setMM_TITLE("Customer Logo");
            tbMm.setDESCRIPTION("Customer Logo");
        } else if (uploadDir.contains("product")) {
            tbMm.setMM_TITLE("Product Image");
            tbMm.setDESCRIPTION("Product Image");
        } else if (uploadDir.contains("ctn")) {
            tbMm.setMM_TITLE("Carton Image");
            tbMm.setDESCRIPTION("Carton Image");
        }
        tbMm.setMM_TYPE(MultiMediaTypes.valueOf(file.getContentType().split("/")[1].toUpperCase()));
        tbMm.setMM_SIZE((int) file.getSize());
        tbMm.setSTATUS(true);
        return tbMmRepository.save(tbMm);
    }

    @Override
    public InputStream getImageResource(String folderName, String fileName)
            throws FileNotFoundException {
        String fullPath = folderName + File.separator + fileName;
        return new FileInputStream(fullPath);
    }
}
