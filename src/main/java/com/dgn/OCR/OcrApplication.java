package com.dgn.OCR;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OcrApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcrApplication.class, args);
    }

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("C:\\Users\\dogan\\Desktop\\tess\\tessdata");
        return tesseract;
    }

}
