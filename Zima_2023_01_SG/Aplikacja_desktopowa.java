package Zima_2023_01_SG;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.Random;

public class Aplikacja_desktopowa {
    private JTextField Imie, Nazwisko, ileZnakow;
    private JComboBox<String> Stanowisko;
    private JCheckBox Wielkosc, Cyfry, ZnakiSpecjalne;
    private final String[] TablicaCombo = {"", "Kierownik", "Starszy programista", "Tester"};
    public StringBuilder haslo = new StringBuilder();

    public JPanel ContentPane() {
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.decode("#B0C4DE"));

        JPanel panelDane = new JPanel(null);
        panelDane.setBounds(50, 50, 275, 200);
        panelDane.setBackground(Color.decode("#B0C4DE"));
        panelDane.setVisible(true);
        panelDane.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.white, 4, true), "Dane pracownika"));

        JLabel imieLabel = new JLabel("Imię");
        imieLabel.setBounds(30, 20, 70, 25);
        panelDane.add(imieLabel);

        Imie = new JTextField();
        Imie.setBounds(120, 20, 130, 25);
        panelDane.add(Imie);

        JLabel nazwiskoLabel = new JLabel("Nazwisko");
        nazwiskoLabel.setBounds(30, 60, 70, 25);
        panelDane.add(nazwiskoLabel);

        Nazwisko = new JTextField();
        Nazwisko.setBounds(120, 60, 130, 25);
        panelDane.add(Nazwisko);

        JLabel stanowiskoLabel = new JLabel("Stanowisko");
        stanowiskoLabel.setBounds(30, 100, 70, 25);
        panelDane.add(stanowiskoLabel);

        Stanowisko = new JComboBox<>(TablicaCombo);
        Stanowisko.setBounds(120, 100, 130, 25);
        panelDane.add(Stanowisko);


        JPanel panelGenerowanie = new JPanel(null);
        panelGenerowanie.setBounds(375, 50, 275, 200);
        panelGenerowanie.setBackground(Color.decode("#B0C4DE"));
        panelGenerowanie.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.white, 4, true), "Generowanie hasła"));
        panelGenerowanie.setVisible(true);


        JLabel ileZnakowLabel = new JLabel("Ile znaków?");
        ileZnakowLabel.setBounds(30, 20, 70, 25);
        panelGenerowanie.add(ileZnakowLabel);

        ileZnakow = new JTextField();
        ileZnakow.setBounds(120, 20, 130, 25);
        panelGenerowanie.add(ileZnakow);

        Wielkosc = new JCheckBox();
        Wielkosc.setBounds(20, 55, 15, 15);
        Wielkosc.setSelected(true);
        Wielkosc.setBackground(Color.decode("#B0C4DE"));
        panelGenerowanie.add(Wielkosc);

        JLabel wielkoscLabel = new JLabel("Małe i wielkie litery");
        wielkoscLabel.setBounds(40, 50, 150, 25);
        panelGenerowanie.add(wielkoscLabel);

        Cyfry = new JCheckBox();
        Cyfry.setBounds(20, 85, 15, 15);
        Cyfry.setBackground(Color.decode("#B0C4DE"));
        panelGenerowanie.add(Cyfry);

        JLabel cyfryLabel = new JLabel("Małe i wielkie litery");
        cyfryLabel.setBounds(40, 80, 150, 25);
        panelGenerowanie.add(cyfryLabel);

        ZnakiSpecjalne = new JCheckBox();
        ZnakiSpecjalne.setBounds(20, 115, 15, 15);
        ZnakiSpecjalne.setBackground(Color.decode("#B0C4DE"));
        panelGenerowanie.add(ZnakiSpecjalne);

        JLabel znakiSpecjalneLabel = new JLabel("Znaki specjalne");
        znakiSpecjalneLabel.setBounds(40, 110, 150, 25);
        panelGenerowanie.add(znakiSpecjalneLabel);


        JButton hasloButton = new JButton("Generuj hasło");
        hasloButton.setBounds(90, 160, 100, 25);
        hasloButton.setForeground(Color.white);
        hasloButton.setBackground(Color.decode("#4682B4"));
        hasloButton.setBorder(new LineBorder(Color.white, 1, true));
        hasloButton.setHorizontalAlignment(SwingConstants.CENTER);
        panelGenerowanie.add(hasloButton);

        hasloButton.addActionListener(e -> {

            int iloscZnakow = Integer.parseInt(ileZnakow.getText());


            String maleLitery = "abcdefghijklmnopqrstuvwxyz";
            String duzeLitery = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String cyfry = "0123456789";
            String znakiSpecjalne = "!@#$%^&*()_+-=";

            StringBuilder dostepneZnaki = new StringBuilder(maleLitery);


            Random rand = new Random();

            if (Wielkosc.isSelected()) {
                dostepneZnaki.append(duzeLitery);
                haslo.append(duzeLitery.charAt(rand.nextInt(duzeLitery.length())));
            }

            if (Cyfry.isSelected()) {
                dostepneZnaki.append(cyfry);
                haslo.append(cyfry.charAt(rand.nextInt(cyfry.length())));
            }

            if (ZnakiSpecjalne.isSelected()) {
                dostepneZnaki.append(znakiSpecjalne);
                haslo.append(znakiSpecjalne.charAt(rand.nextInt(znakiSpecjalne.length())));
            }

            while (haslo.length() < iloscZnakow) {
                haslo.append(dostepneZnaki.charAt(rand.nextInt(dostepneZnaki.length())));
            }


            JOptionPane.showMessageDialog(null, new String(haslo), null, JOptionPane.INFORMATION_MESSAGE);


        });


        panel.add(panelDane);
        panel.add(panelGenerowanie);

        JButton zatwierdz = new JButton("Zatwierdź");
        zatwierdz.setBounds(250, 270, 200, 25);
        zatwierdz.setForeground(Color.white);
        zatwierdz.setBackground(Color.decode("#4682B4"));
        zatwierdz.setBorder(new LineBorder(Color.white, 1, true));
        zatwierdz.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(zatwierdz);

        zatwierdz.addActionListener(e -> JOptionPane.showMessageDialog(null, "Dane pracownika: " + Imie.getText() + " " + Nazwisko.getText() + " " + Stanowisko.getSelectedItem() + " Hasło: " + new String(haslo), null, JOptionPane.INFORMATION_MESSAGE));

        return panel;
    }

    public Aplikacja_desktopowa() {
        JFrame okno = new JFrame("Dodaj pracownika");
        okno.setSize(700, 350);
        okno.setContentPane(ContentPane());
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.setVisible(true);
        okno.setResizable(false);
    }

    public static void main(String[] args) {
        new Aplikacja_desktopowa();
    }
}
