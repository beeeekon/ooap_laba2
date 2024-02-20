package org.example;

import java.util.Vector;

public class AreThereRightWords extends fileProcessing{
    public AreThereRightWords() {
        super();
    }

    public AreThereRightWords(Vector<String> nameFiles, String finalFile) {
        super(nameFiles, finalFile);
    }

    private String removingUnnecessarySpaces(String word){
        if(word=="")
            return "";

        while(word.charAt(0)==' ')//удаляем все пробелы в начале
            word = word.substring(1);

        while(word.charAt(word.length()-1)==' ')
            word = word.substring(0,word.length()-1);

        boolean oneSpace = false;
        String result = "";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==' ' && oneSpace==false) {
                result+=" ";
                oneSpace = true;
            }

            else if(word.charAt(i)==' ' && oneSpace==true){}//если один пробел уже записали то ничего не делаем, идем дальше
            else {
                result+= word.charAt(i);
                oneSpace = false;
            }
        }
        return result;
    }
    public Vector<String> stringToWords(String str){
        str=removingUnnecessarySpaces(str);
        Vector<String> maswords=new Vector<String>();
        String word="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ') {
                maswords.add(word);
                word="";
            }
            else if(i==str.length()-1){
                word+=str.charAt(i);
                maswords.add(word);
            }
            else{
                word+=str.charAt(i);
            }
        }
        return maswords;
    }
    public String converting(String str){
        return null;
    }
    public boolean searchByFiles(Vector<String> sample, String examineStr){
        boolean isWhereWord=false;
        Vector<String> sampleWords=new Vector<String>();
        Vector<String> examineWords=stringToWords(examineStr);
        for(int i=0;i<sample.size();i++){
            sampleWords=stringToWords(sample.get(i));
            //если мы хоть где-то нашли слово, то сразу и выйдем
            for(int j=0;j<sampleWords.size()&&!isWhereWord;j++)
                for(int k=0;k<examineWords.size()&&!isWhereWord;k++){
                    String a=sampleWords.get(j);
                    String b=examineWords.get(k);
                    if(a.equalsIgnoreCase(b)) {//тк == сравнивает ссылки, а не содержимое. Сравниваем без учета регистра с помощью метода
                        isWhereWord = true;
                    }
                }

        }
        return isWhereWord;
    }
}
