import java.io.*;
import java.util.*;

class MusicAlbum {
    private final String wykonawca;
    private final String tytul;
    private final int liczbaUtworow;
    private final int rokWydania;
    private long liczbaPobran;

    public MusicAlbum(String wykonawca, String tytul, int liczbaUtworow, int rokWydania, long liczbaPobran) {
        this.wykonawca = wykonawca;
        this.tytul = tytul;
        this.liczbaUtworow = liczbaUtworow;
        this.rokWydania = rokWydania;
        this.liczbaPobran = liczbaPobran;
    }

    public String getWykonawca() {
        return wykonawca;
    }

    public String getTytul() {
        return tytul;
    }

    public int getLiczbaUtworow() {
        return liczbaUtworow;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public long getLiczbaPobran() {
        return liczbaPobran;
    }

    public void zwiekszPobrania() {
        this.liczbaPobran++;
    }

    @Override
    public String toString() {
        return String.format("%s - \"%s\", %d utworów, %d, Pobrania: %d", wykonawca, tytul, liczbaUtworow, rokWydania, liczbaPobran);
    }
}

public class konsola {
    private final List<MusicAlbum> albumy = new ArrayList<>();

    public void wczytajAlbumy(String nazwaPliku) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (linia.trim().isEmpty()) {
                    continue;
                }

                String tytul = br.readLine();
                String liczbaUtworowStr = br.readLine();
                String rokWydaniaStr = br.readLine();
                String liczbaPobranStr = br.readLine();


                if (tytul == null || liczbaUtworowStr == null || rokWydaniaStr == null || liczbaPobranStr == null) {
                    System.err.println("Błędny format danych - brak wymaganych pól!");
                    break;
                }

                try {
                    int liczbaUtworow = Integer.parseInt(liczbaUtworowStr.trim());
                    int rokWydania = Integer.parseInt(rokWydaniaStr.trim());
                    long liczbaPobran = Long.parseLong(liczbaPobranStr.trim());

                    albumy.add(new MusicAlbum(linia, tytul, liczbaUtworow, rokWydania, liczbaPobran));
                } catch (NumberFormatException e) {
                    System.err.println("Błędne dane liczbowe dla albumu: " + linia + " - " + tytul);
                }
            }
        }
    }


    public void wyswietlAlbumy() {
        for (MusicAlbum album : albumy) {
            System.out.println(album);
        }
    }

    public static void main(String[] args) {
        konsola app = new konsola();
        try {
            app.wczytajAlbumy("src/Dane.txt");
            app.wyswietlAlbumy();
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania danych: " + e.getMessage());
        }
    }
}
