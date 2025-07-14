package com.manex.backend.DAO;

import com.manex.backend.entities.TbMm;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface TbMmDAO {
    TbMm saveImageFileWithName(String uploadDir, MultipartFile file, String name, Integer id)
            throws IOException;

    InputStream getImageResource(String folderName, String imageName) throws FileNotFoundException;
}
