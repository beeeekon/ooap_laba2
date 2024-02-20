package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class fileProcessingTest {

    @Test
    void analysisFilesTestRegisterTranslation() throws IOException {
        Vector<String> nameFiles= new Vector<String>();
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file1.txt");
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file2.txt");
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file3.txt");
        String finalFile="D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\finalFile.txt";
        fileProcessing obj= new RegisterTranslation(nameFiles,finalFile);
        obj.analysisFiles();
    }

    @Test
    void analysisFilesTestAreThereRightWords() throws IOException {
        Vector<String> nameFiles= new Vector<String>();
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file1.txt");
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file2.txt");
        nameFiles.add("D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\file3.txt");
        String finalFile="D:\\универ\\3 курс\\ООАиП 6 сем\\ooap_laba2\\src\\main\\resources\\finalFile.txt";
        fileProcessing obj= new AreThereRightWords(nameFiles,finalFile);
        obj.analysisFiles();
    }
}