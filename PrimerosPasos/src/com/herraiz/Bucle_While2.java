package com.herraiz;

import javax.swing.*;

import static java.lang.Integer.parseInt;

public class Bucle_While2 {

        public static void main(String[] args) {

            int random_number = (int) (Math.random() * 100);

            int number = -1;

            int attempts = 0;

            while (random_number != number) {

                attempts++;
                number = parseInt(JOptionPane.showInputDialog(null,
                        "Por favor, introduce un número del 1 al 100",
                        "Adivina el número",
                        JOptionPane.INFORMATION_MESSAGE));

                if (random_number < number) {
                    JOptionPane.showMessageDialog(null,
                            "El número buscado es menor");
                } else if (random_number > number){
                    JOptionPane.showMessageDialog(null,
                            "El número buscado es mas alto");
                }

            }

            JOptionPane.showMessageDialog(null,
                    "Has acertado el número en " + attempts + " intentos");
        }
}
