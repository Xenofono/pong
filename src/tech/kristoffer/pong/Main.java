package tech.kristoffer.pong;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                JFrame frame = new GameFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
