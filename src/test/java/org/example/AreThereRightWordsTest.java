package org.example;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AreThereRightWordsTest {
    @Test
    void stringToWordsTestTrue(){
        Vector<String> sample=new Vector<String>();
        String str="door mur sweetheart";
        sample.add("door");
        sample.add("mur");
        sample.add("sweetheart");
        AreThereRightWords obj= new AreThereRightWords();
        assertEquals(sample,obj.stringToWords(str));
    }

    @Test
    void searchByFilesTestTrue() {
        Vector<String> sample=new Vector<String>();
        sample.add("mur myau");
        sample.add("i am bee and i say bzz");
        sample.add("my sweetheart");
        String examineStr="door mur sweetheart";
        AreThereRightWords obj= new AreThereRightWords();
        boolean flag=obj.searchByFiles(sample,examineStr);
        assertEquals(true,flag);
    }

    @Test
    void searchByFilesTestFalse() {
        Vector<String> sample=new Vector<String>();
        sample.add("mur myau");
        sample.add("i am bee and i say bzz");
        sample.add("my sweetheart");
        String examineStr="door tuk tuk";
        AreThereRightWords obj= new AreThereRightWords();
        boolean flag=obj.searchByFiles(sample,examineStr);
        assertEquals(false,flag);
    }
}