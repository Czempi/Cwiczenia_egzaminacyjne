package Lato_2023_01_SD;

/*************
 * nazwa klasy: film
 * pola: tytul - wartosc typu String
 *       liczbaWypozyczen - wartosc typu int
 * metody:
 */
class film {
    private String tytul;
    private int liczbaWypozyczen;

    public int getLiczbaWypozyczen() {
        return liczbaWypozyczen;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        if (tytul != null && tytul.length() <= 20) {
            this.tytul = tytul;
        } else {
            System.out.println("Tytuł musi mieć maksymalnie 20 znaków.");
        }
    }

    public void setLiczbaWypozyczen(int liczbaWypozyczen) {
        this.liczbaWypozyczen = liczbaWypozyczen;
    }

    void increment() {
        liczbaWypozyczen++;
    }

    public film() {
        this.tytul = null;
        this.liczbaWypozyczen = 0;
    }

    public void showInfo() {
        System.out.println("Tytuł: " + this.tytul);
        System.out.println("Liczba wypożyczeń: " + this.liczbaWypozyczen);
    }

    public static void main(String[] args) {
        film film = new film();
        System.out.println("Po inicjalizacji:");
        film.showInfo();

        film.setTytul("Incepcja");
        System.out.println("\nPo ustawieniu tytułu:");
        film.showInfo();


        String tytul = film.getTytul();
        System.out.println("\nPobrany tytuł: " + tytul);


        System.out.println("\nLiczba wypożyczeń przed inkrementacją: " + film.getLiczbaWypozyczen());
        film.increment();
        System.out.println("Liczba wypożyczeń po inkrementacji: " + film.getLiczbaWypozyczen());
    }

}
