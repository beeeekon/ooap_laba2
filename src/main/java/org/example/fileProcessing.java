package org.example;

import java.io.*;
import java.util.Vector;

public abstract class fileProcessing {
    Vector<String> nameFile;
    String finalFile;
    public fileProcessing(){
        nameFile= new Vector<String>();
        finalFile=new String();
    }

   public fileProcessing(Vector<String> namesfile, String namefinalfile){
        nameFile= namesfile;
        finalFile=namefinalfile;
    }
    final void analysisFiles() throws IOException {
        if(nameFile==null||finalFile==null)
            throw new NumberFormatException();
        BufferedReader reader = null;//объявляем читалку
        FileWriter writer = null;//объявляем писалку
        writer=new FileWriter(finalFile,false);
        writer.write("");//обновляем содержимое файла на пустую строку, т.е очищаем файл
        Vector<String> sample=new Vector<String>();
        for(int i=0;i<nameFile.size();i++) {
            try {
                reader = new BufferedReader(new FileReader(nameFile.get(i)));
                writer = new FileWriter(finalFile,true);//для дозаписи
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String str=reader.readLine();
            if(i==0){//если это первый файл, то загоняем его весь в вектор строк
                while(str!=null){
                    sample.add(str);
                    str=reader.readLine();
                }
                reader.close();
                reader = new BufferedReader(new FileReader(nameFile.get(0)));
                str=reader.readLine();//возвращаем снова первую строку первого файла
            }
            boolean isRecordedFile=false;
            while(str!=null){
                String convertStr=converting(str);
                if(convertStr!=null)
                    writer.write(convertStr+"\n");
                if(searchByFiles(sample,str) && !isRecordedFile && i!=0) {//если метод найдет там слова и мы этот файл еще не писали, то пишем
                    writer.write(nameFile.get(i) + "\n");
                    isRecordedFile=true;
                }
                str=reader.readLine();
            }
            reader.close();
            writer.close();
        }
    }

    abstract String converting(String str);
    abstract boolean searchByFiles(Vector<String> sample, String examineStr);
}
