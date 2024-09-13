package com.manex.backend.service;

import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.entities.TbMm;
import com.manex.backend.enums.MultiMediaTypes;
import com.manex.backend.repositories.TbCompanyRepository;
import com.manex.backend.repositories.TbMmRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class TbMmService implements TbMmDAO {

    private final String uploadDir = "companyProfileImages/";

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Override
    public TbMm saveImageFileWithName(MultipartFile file, String name, Integer id)
            throws IOException {
        String fileName = name + "." + file.getOriginalFilename().split("\\.")[1];
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
        tbMm.setMM_TITLE("Supplier Logo");
        tbMm.setDESCRIPTION("Supplier Logo");
        tbMm.setMM_TYPE(MultiMediaTypes.valueOf(file.getContentType().split("/")[1].toUpperCase()));
        tbMm.setMM_SIZE((int) file.getSize());
        tbMm.setSTATUS(true);
        return tbMmRepository.save(tbMm);
    }
}