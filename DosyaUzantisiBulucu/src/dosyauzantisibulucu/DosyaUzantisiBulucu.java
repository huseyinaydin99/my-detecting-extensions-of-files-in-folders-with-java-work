/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosyauzantisibulucu;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hüseyin
 */
public class DosyaUzantisiBulucu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("D:\\Karsamba\\Bi\\İçerik\\Müziklerim\\Özel Müzik");
        List<String> mp3UzantiLitesi = new ArrayList<>();
        List<String> mp3OlmayanUzantiLitesi = new ArrayList<>();

        if (file.isDirectory()) {
            File[] dosyaDizi = file.listFiles();
            for (int i = 0; i < dosyaDizi.length; i++) {
                File dosya = dosyaDizi[i];
                if (dosya.isFile()) {
                    String tersUzanti = "";
                    String dosyaIsmi = dosya.getName().toString();
                    int count = dosyaIsmi.length();
                    for (int j = count - 1; j >= 0; j--) {
                        if (dosyaIsmi.charAt(j) != '.') {
                            tersUzanti += String.valueOf(dosyaIsmi.charAt(j));
                        } else if (dosyaIsmi.charAt(j) == '.') {
                            break;
                        }
                    }
                    String duzUzanti = "";
                    for (int j = tersUzanti.length() - 1; j >= 0; j--) {
                        duzUzanti += tersUzanti.charAt(j);
                    }
                    if (duzUzanti.equals("jpg")  ||
                        duzUzanti.equals("JPG")  ||
                        duzUzanti.equals("jpeg") ||
                        duzUzanti.equals("JPEG") ||
                        duzUzanti.equals("png")  ||
                        duzUzanti.equals("PNG")) {
                        boolean silinmeDurumu = dosya.delete();
                        if(silinmeDurumu)
                            System.out.println("dosya silindi");
                    }
                    if (duzUzanti.equals("mp3") || duzUzanti.equals("MP3")) {
                        mp3UzantiLitesi.add(dosya.getName());
                    } else if (!duzUzanti.equals("mp3") || !duzUzanti.equals("MP3")) {
                        mp3OlmayanUzantiLitesi.add(dosya.getName());
                    }
                    
                    Runtime.getRuntime().gc();
                }
            }
        }
        System.out.println("MP3 uzanti sayısı = " + mp3UzantiLitesi.size());
        PrintStream printStream = new PrintStream(System.out);
        try {
            printStream.write("Selam\n".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(DosyaUzantisiBulucu.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("MP3 olmayan uzanti sayısı = " + mp3OlmayanUzantiLitesi.size());

        for (int i = 0; i < mp3UzantiLitesi.size(); i++) {
            System.out.println(mp3UzantiLitesi.get(i));
        }

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < mp3OlmayanUzantiLitesi.size(); i++) {
            System.out.println(mp3OlmayanUzantiLitesi.get(i));
        }
        
        yap(1, 2);
    }
    
    private static void yap(int a,final int b){
        a = 3;
        System.out.println(String.valueOf((a + b)));
    }

}
