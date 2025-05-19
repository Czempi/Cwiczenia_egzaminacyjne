/**
 * Klasa GraKosciGUI
 * @author Jakub Czepinski 5pp
 */


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

class GraKosciGUI {

    JPanel createContentPane() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.white);

        AtomicReference<ArrayList<Integer>> diceResults = new AtomicReference<>(new ArrayList<>());
        GraKosci diceGame = new GraKosci();
        int[] totalScore = {0};

        JLabel[] diceLabels = new JLabel[5];
        ImageIcon[] diceIcons = new ImageIcon[7];

        JLabel gameTitle = new JLabel("    Gra w kości. Autor: 0000000000");
        gameTitle.setForeground(Color.white);
        gameTitle.setBackground(Color.decode("#A52A2A"));
        gameTitle.setBounds(0, 20, 400, 50);
        gameTitle.setFont(new Font("Arial", Font.BOLD, 15));
        gameTitle.setOpaque(true);
        mainPanel.add(gameTitle);

        Button rollButton = new Button("RZUĆ KOŚĆMI");
        rollButton.setBounds(140, 80, 120, 30);
        rollButton.setBackground(Color.decode("#D2691E"));
        rollButton.setForeground(Color.white);
        rollButton.setFont(new Font("Arial", Font.BOLD, 12));
        mainPanel.add(rollButton);

        JButton resetButton = new JButton("RESETUJ WYNIK");
        resetButton.setSize(30,100);
        resetButton.setFont(new Font("Arial", Font.BOLD, 12));
        resetButton.setForeground(Color.white);
        resetButton.setBackground(Color.decode("#D2691E"));

        JPanel dicePanel = new JPanel(new GridLayout(1, 5));
        dicePanel.setBackground(Color.white);
        dicePanel.setBounds(0, 140, 400, 120);
        mainPanel.add(dicePanel);

        for (int i = 0; i < 5; i++) {
            diceLabels[i] = new JLabel();
            diceLabels[i].setVisible(true);
            dicePanel.add(diceLabels[i]);
        }

        for (int i = 0; i < 7; i++) {
            diceIcons[i] = new ImageIcon(new ImageIcon("src/" + (i == 0 ? "question" : "k" + i) + ".jpg").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        }

        for (JLabel diceLabel : diceLabels) {
            diceLabel.setIcon(diceIcons[0]);
        }

        JPanel scorePanel = new JPanel(new GridLayout(3, 1));
        scorePanel.setBounds(0, 250, 400, 100);
        scorePanel.setBackground(new Color(245, 245, 220));
        mainPanel.add(scorePanel);

        JLabel currentScoreLabel = new JLabel("Wynik tego losowania: 0");
        JLabel totalScoreLabel = new JLabel("Wynik gry: 0");
        scorePanel.add(currentScoreLabel);
        scorePanel.add(totalScoreLabel);
        scorePanel.add(resetButton);

        rollButton.addActionListener(e -> {
            diceResults.set(diceGame.rollDice(5));
            int currentScore = diceGame.calculatePoints(diceResults.get());
            totalScore[0] += currentScore;

            currentScoreLabel.setText("Wynik tego losowania: " + currentScore);
            totalScoreLabel.setText("Wynik gry: " + totalScore[0]);

            for (int i = 0; i < 5; i++) {
                diceLabels[i].setIcon(diceIcons[diceResults.get().get(i)]);
            }
        });

        resetButton.addActionListener(e -> {
            currentScoreLabel.setText("Wynik tego losowania: 0");
            totalScoreLabel.setText("Wynik gry: 0");
            totalScore[0] = 0;

            for (JLabel diceLabel : diceLabels) {
                diceLabel.setIcon(diceIcons[0]);
            }
        });

        return mainPanel;
    }

    GraKosciGUI() {
        JFrame window = new JFrame("Gra w Kości");
        window.setContentPane(createContentPane());
        window.setVisible(true);
        window.setSize(400, 450);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GraKosciGUI();
    }
}
