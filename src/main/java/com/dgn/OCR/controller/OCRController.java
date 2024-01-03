package com.dgn.OCR.controller;

import com.dgn.OCR.service.OCRService;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ocr")
public class OCRController {

    private final OCRService ocrService;

    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }
    @GetMapping("/addImage")
    public ResponseEntity<String> getImageToString(@RequestParam MultipartFile multipartFile) throws TesseractException {
        return new ResponseEntity<>(ocrService.getImageString(multipartFile), HttpStatus.OK);
    }
}
