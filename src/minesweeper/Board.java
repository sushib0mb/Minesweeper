/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package minesweeper;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Taizo
 */
public class Board extends javax.swing.JFrame {

    private ArrayList<Integer> bombNums = new ArrayList<Integer>();
    private ArrayList<Cell> allCells = new ArrayList<Cell>();

    /**
     * Creates new form Board
     */
    public Board() {

        initComponents();
        ArrayList<Integer> bombs = bombSetup();
        boardSetup(100, bombs);
    }

    public ArrayList<Integer> bombSetup() {

        int addedNum = 0;

        Random random = new Random();
        int bombsNum = Integer.parseInt(JOptionPane.showInputDialog(playBoard, "How many bombs?"));

        while (addedNum != bombsNum) {
            int num = random.nextInt(100);
            if (!bombNums.contains(num)) {
                bombNums.add(num);
                addedNum++;
            }
        }

        Collections.sort(bombNums);
        return bombNums;
    }

    public void boardSetup(int num, ArrayList<Integer> bombs) {

        int bombNum = 0;

        for (int i = 0; i < num; i++) {
            Cell cell = new Cell();
            try {
                if (bombs.get(bombNum) == i) {
                    cell.setBomb(true);
                    bombNum++;
                }
                playBoard.add(cell);
                allCells.add(cell);
            } catch (Exception e) {
                playBoard.add(cell);
                allCells.add(cell);
            }
        }
        adjacentSetup();
    }

    public void adjacentSetup() {
        int bombNum = 0;

        for (int i = 0; i < 100; i++) {
            try {
                if (i == bombNums.get(bombNum)) {
                    if (bombNums.get(bombNum) == 0) {
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 11).addAdjacent();
                    } else if (bombNums.get(bombNum) > 0 && bombNums.get(bombNum) < 9) {
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 11).addAdjacent();
                    } else if (bombNums.get(bombNum) == 9) {
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                    } else if (bombNums.get(bombNum) == 90) {
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 9).addAdjacent();
                    } else if (bombNums.get(bombNum) > 90 && bombNums.get(bombNum) < 99) {
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 11).addAdjacent();
                    } else if (bombNums.get(bombNum) == 99) {
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 11).addAdjacent();
                    } else if (bombNums.get(bombNum) % 10 == 0) {
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 11).addAdjacent();
                    } else if ((bombNums.get(bombNum) % 10) == 9) {
                        allCells.get(bombNums.get(bombNum) - 11).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                    } else{
                        allCells.get(bombNums.get(bombNum) - 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 1).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) - 11).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 9).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 10).addAdjacent();
                        allCells.get(bombNums.get(bombNum) + 11).addAdjacent();
                    }
                    bombNum++;
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playBoard.setLayout(new java.awt.GridLayout(10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel playBoard;
    // End of variables declaration//GEN-END:variables
}
