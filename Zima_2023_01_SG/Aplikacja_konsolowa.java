package Zima_2023_01_SG;

import java.util.Scanner;

public class Aplikacja_konsolowa {
    /********************************************
     * nazwa funkcji: NWD
     * opis funkcji: Funkcja szuka najwiekszego wspólnego dzielnika
     * parametry:
     *           nazwa parametru 1 - jest to pierwsza liczba
     *           nazwa parametru 2 - jest to druga liczba
     * zwracany typ i opis: funkcja typu void, wypisuje dzielnik
     * autor: Jakub Czępiński
     ******************************************/

    public static void NWD(int a, int b) {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a>0&&b>0){
            NWD(a,b);
        }
    }
}
