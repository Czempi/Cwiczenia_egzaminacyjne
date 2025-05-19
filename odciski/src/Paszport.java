/***
 * Klasa Paszport
 * @author: Jakub Czępiński 5pp
 */


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

public class Paszport {
    private ImageIcon iconZdjecie;
    private ImageIcon iconOdcisk;
    private JRadioButton niebieskie, zielone, piwne;
    private JLabel zdjecie;
    private JLabel odcisk;
    private JTextField numerText, imieText, nazwiskoText;
    private String numer,kolor,wynik;

    public JPanel ContentPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(95, 158, 160));

        JPanel oczyRadio = new JPanel(new GridLayout(3, 1));
        oczyRadio.setBackground(new Color(95, 158, 160));
        oczyRadio.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
        panel.add(oczyRadio);

        ButtonGroup kolory = new ButtonGroup();

        niebieskie = new JRadioButton("niebieskie");
        niebieskie.setSelected(true);
        zielone = new JRadioButton("zielone");
        piwne = new JRadioButton("piwne");

        niebieskie.setBackground(new Color(95, 158, 160));
        zielone.setBackground(new Color(95, 158, 160));
        piwne.setBackground(new Color(95, 158, 160));

        kolory.add(niebieskie);
        kolory.add(zielone);
        kolory.add(piwne);

        oczyRadio.add(niebieskie);
        oczyRadio.add(zielone);
        oczyRadio.add(piwne);
        oczyRadio.setBounds(30, 140, 320, 120);

        JLabel numerLabel = new JLabel("Numer");
        numerLabel.setBounds(30, 30, 100, 20);
        panel.add(numerLabel);

        numerText = new JTextField();
        numerText.setBounds(140, 30, 210, 20);
        panel.add(numerText);

        JLabel imieLabel = new JLabel("Imię");
        imieLabel.setBounds(30, 60, 100, 20);
        panel.add(imieLabel);

        imieText = new JTextField();
        imieText.setBounds(140, 60, 210, 20);
        panel.add(imieText);

        JLabel nazwiskoLabel = new JLabel("Nazwisko");
        nazwiskoLabel.setBounds(30, 90, 100, 20);
        panel.add(nazwiskoLabel);

        nazwiskoText = new JTextField();
        nazwiskoText.setBounds(140, 90, 210, 20);
        panel.add(nazwiskoText);

        JButton startOK = new JButton("OK");
        startOK.setBounds(440, 220, 200, 30);
        startOK.addActionListener(e -> {
            if (imieText.getText().isEmpty() || nazwiskoText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wprowadź dane", "", JOptionPane.ERROR_MESSAGE);
            } else {
                kolor = "";
                if (niebieskie.isSelected()) kolor = "niebieskie";
                if (zielone.isSelected()) kolor = "zielone";
                if (piwne.isSelected()) kolor = "piwne";
                wynik = imieText.getText() + " " + nazwiskoText.getText() + " kolor oczu " + kolor;
                JOptionPane.showMessageDialog(null, wynik, "", JOptionPane.PLAIN_MESSAGE);
            }
        });
        panel.add(startOK);

        zdjecie = new JLabel();
        zdjecie.setBounds(390, 30, 120, 180);
        iconZdjecie = new ImageIcon("src\\album\\000-zdjecie.jpg");

        zdjecie.setVisible(false);
        Image imgZdjecie = iconZdjecie.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        zdjecie.setIcon(new ImageIcon(imgZdjecie));
        panel.add(zdjecie);

        odcisk = new JLabel();
        odcisk.setBounds(560, 30, 120, 180);
        iconOdcisk = new ImageIcon("src\\album\\000-odcisk.jpg");

        odcisk.setVisible(false);
        Image imgOdcisk = iconOdcisk.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
        odcisk.setIcon(new ImageIcon(imgOdcisk));
        panel.add(odcisk);


        numerText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                zmienObrazy();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                zmienObrazy();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                zmienObrazy();
            }

            private void zmienObrazy() {
                numer = numerText.getText().trim();

                switch (numer) {
                    case "000" -> {
                        iconZdjecie = new ImageIcon("src\\album\\000-zdjecie.jpg");
                        iconOdcisk = new ImageIcon("src\\album\\000-odcisk.jpg");
                        zdjecie.setVisible(true);
                        odcisk.setVisible(true);
                    }
                    case "111" -> {
                        iconZdjecie = new ImageIcon("src\\album\\111-zdjecie.jpg");
                        iconOdcisk = new ImageIcon("src\\album\\111-odcisk.jpg");
                        zdjecie.setVisible(true);
                        odcisk.setVisible(true);
                    }
                    case "333" -> {
                        iconZdjecie = new ImageIcon("src\\album\\333-zdjecie.jpg");
                        iconOdcisk = new ImageIcon("src\\album\\333-odcisk.jpg");
                        zdjecie.setVisible(true);
                        odcisk.setVisible(true);
                    }
                    default -> {
                        zdjecie.setIcon(null);
                        odcisk.setIcon(null);
                    }
                }

                Image imgZdjecie = iconZdjecie.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
                zdjecie.setIcon(new ImageIcon(imgZdjecie));
                Image imgOdcisk = iconOdcisk.getImage().getScaledInstance(120, 180, Image.SCALE_SMOOTH);
                odcisk.setIcon(new ImageIcon(imgOdcisk));
            }
        });


        return panel;
    }


    public Paszport() {
        JFrame myWindow = new JFrame("Wprowadzanie danych do paszportu. Wykonał: 00000000000");
        myWindow.setContentPane(ContentPanel());
        myWindow.setSize(720, 320);
        myWindow.setResizable(false);
        myWindow.setLocationRelativeTo(null);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setVisible(true);
    }

    public static void main(String[] args) {
        new Paszport();
    }
}