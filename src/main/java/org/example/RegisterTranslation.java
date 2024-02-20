package org.example;

import java.util.Vector;

public class RegisterTranslation extends fileProcessing{
    public RegisterTranslation() {
        super();//вызываем конструктор родительского класса
    }

    public RegisterTranslation(Vector<String> nameFiles, String finalFile) {
        super(nameFiles,finalFile);//вызываем конструктор родительского класса
    }

    public String converting(String str){
        return str.toUpperCase();
    }
    public boolean searchByFiles(Vector<String> sample, String examineStr){
        return false;
    }
}
