package CzytanieZPliku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CzytanieZPliku {
    public static void main(String[] args) {


        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/CzytanieZPliku/dane.txt"));
            String imie = br.readLine();
            String nazwisko = br.readLine();
            int wiek = Integer.parseInt(br.readLine());
            String zawod = br.readLine();

            System.out.println(imie+" " + nazwisko + " " + wiek + " " + zawod);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
