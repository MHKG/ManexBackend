package com.manex.backend.DAO;

import com.manex.backend.entities.TbMm;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TbMmDAO {
    TbMm saveImageFileWithName(String uploadDir, MultipartFile file, String name, Integer id)
            throws IOException;
}
