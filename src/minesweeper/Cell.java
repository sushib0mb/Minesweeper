/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package minesweeper;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Taizo
 */
public class Cell extends javax.swing.JPanel {

    private boolean hasBomb = false;
    private int adjacent = 0;
    private boolean edited = false;

    /**
     * Creates new form Cell
     */
    public Cell() {
        initComponents();

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (edited == false) {
                    if (e.getModifiers() == MouseEvent.BUTTON1_MASK && e.getClickCount() == 1) {
                        if (hasBomb == true) {
                            button.setBackground(Color.RED);
                            String[] buttons = {"Quit"};

                            int option = JOptionPane.showOptionDialog(null, "You had " + " bombs left", "You lost!",
                                    JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);

                            if(option == 0){
                                System.exit(0);
                            }
                        } else {
                            button.setBackground(Color.WHITE);
                            if(adjacent != 0){
                                button.setLabel(Integer.toString(adjacent));
                            }
                        }
                        edited = true;
                    }
                    if (e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1) {
                        try {
                            Image img = ImageIO.read(getClass().getResource("flag.png"));
                            button.setIcon(new ImageIcon(img));
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        button.setBackground(Color.WHITE);
                        edited = true;
                    }
                }
            }
        }
        );
    }

    public void setBomb(Boolean bomb) {
        if (bomb == true) {
            hasBomb = true;
        }
    }

    public void addAdjacent() {
        adjacent++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button = new javax.swing.JButton();

        button.setBackground(new java.awt.Color(102, 102, 255));
        button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    // End of variables declaration//GEN-END:variables
}
