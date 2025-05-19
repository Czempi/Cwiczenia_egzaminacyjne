import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumyMuzyczne {
    JPanel Panel;
    JButton strzalkiLewo, strzalkiPrawo, pobierz;
    JLabel nazwaWykonawcy, tytulAlbumu, liczbaUtworow, rokWydania, liczbaPobran, plytaWinylowa;

    List<MusicAlbum> albumy = new ArrayList<>();
    int aktulanyIndex = 0;

    public JPanel ContentPanel() {
        Panel = new JPanel(null);
        Panel.setBackground(Color.decode("#2E8B57"));

        wczytajAlbumy();

        strzalkiLewo = new JButton();
        strzalkiLewo.setBounds(30, 80, 90, 70);
        strzalkiLewo.setIcon(new ImageIcon("src/obraz3.png"));
        strzalkiLewo.addActionListener(e -> {
            aktulanyIndex = (aktulanyIndex - 1 + albumy.size()) % albumy.size();
            aktualizujEtykiety();
        });
        Panel.add(strzalkiLewo);

        strzalkiPrawo = new JButton();
        strzalkiPrawo.setBounds(920, 80, 90, 70);
        strzalkiPrawo.setIcon(new ImageIcon("src/obraz2.png"));
        strzalkiPrawo.addActionListener(e -> {
            aktulanyIndex = (aktulanyIndex + 1) % albumy.size();
            aktualizujEtykiety();
        });
        Panel.add(strzalkiPrawo);

        plytaWinylowa = new JLabel(new ImageIcon("src/obraz.png"));
        plytaWinylowa.setBounds(140, 20, 200, 200);
        Panel.add(plytaWinylowa);

        nazwaWykonawcy = new JLabel();
        nazwaWykonawcy.setBounds(370, 30, 550, 50);
        nazwaWykonawcy.setForeground(Color.white);
        nazwaWykonawcy.setFont(new Font(null, Font.PLAIN, 50));
        Panel.add(nazwaWykonawcy);

        tytulAlbumu = new JLabel();
        tytulAlbumu.setBounds(370, 80, 550, 50);
        tytulAlbumu.setForeground(Color.white);
        tytulAlbumu.setFont(new Font(null, Font.ITALIC, 30));
        Panel.add(tytulAlbumu);

        liczbaUtworow = new JLabel();
        liczbaUtworow.setBounds(370, 150, 225, 50);
        liczbaUtworow.setForeground(Color.green);
        liczbaUtworow.setFont(new Font(null, Font.PLAIN, 20));
        Panel.add(liczbaUtworow);

        rokWydania = new JLabel();
        rokWydania.setBounds(505, 150, 225, 50);
        rokWydania.setForeground(Color.green);
        rokWydania.setFont(new Font(null, Font.PLAIN, 20));
        Panel.add(rokWydania);

        liczbaPobran = new JLabel();
        liczbaPobran.setBounds(160, 230, 80, 40);
        Panel.add(liczbaPobran);

        pobierz = new JButton("Pobierz");
        pobierz.setBounds(310, 230, 80, 40);
        pobierz.addActionListener(e -> {
            albumy.get(aktulanyIndex).zwiekszPobrania();
            liczbaPobran.setText(String.valueOf(albumy.get(aktulanyIndex).getLiczbaPobran()));
        });
        Panel.add(pobierz);

        aktualizujEtykiety();

        return Panel;
    }

    private void wczytajAlbumy() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Dane.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String wykonawca = line.trim();
                String tytul = br.readLine().trim();
                int liczbaUtworow = Integer.parseInt(br.readLine().trim());
                int rokWydania = Integer.parseInt(br.readLine().trim());
                long liczbaPobran = Long.parseLong(br.readLine().trim());

                albumy.add(new MusicAlbum(wykonawca, tytul, liczbaUtworow, rokWydania, liczbaPobran));
            }
        } catch (IOException e) {
            System.err.println("Błąd wczytywania pliku: " + e.getMessage());
        }
    }

    private void aktualizujEtykiety() {
        MusicAlbum currentAlbum = albumy.get(aktulanyIndex);

        nazwaWykonawcy.setText(currentAlbum.getWykonawca());
        tytulAlbumu.setText(currentAlbum.getTytul());
        liczbaUtworow.setText("Utwory: " + currentAlbum.getLiczbaUtworow());
        rokWydania.setText("Rok: " + currentAlbum.getRokWydania());
        liczbaPobran.setText(String.valueOf(currentAlbum.getLiczbaPobran()));
    }

    public AlbumyMuzyczne() {
        JFrame myWindow = new JFrame("MojeDźwięki, Wykonał: 00000000000");
        myWindow.setContentPane(ContentPanel());
        myWindow.setSize(1060, 320);
        myWindow.setResizable(false);
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
    }

    public static void main(String[] args) {
        new AlbumyMuzyczne();
    }
}
