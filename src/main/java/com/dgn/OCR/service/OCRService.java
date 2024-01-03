package com.dgn.OCR.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class OCRService {
    private final Tesseract tesseract;

    public OCRService(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    public static final String BASEURL="C:\\Users\\dogan\\Desktop";

    public String getImageString(MultipartFile multipartFile) throws TesseractException {
        final String orginalFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Path filePath = Paths.get(BASEURL+"\\"+orginalFileName);
        final String orcToString = tesseract.doOCR(new File(String.valueOf(filePath)));
        return orcToString;
    }
}
