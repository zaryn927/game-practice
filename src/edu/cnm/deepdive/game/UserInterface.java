/**
 * 
 */
package edu.cnm.deepdive.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Sky Link
 *
 */
public class UserInterface {
  
  public static  void main(String[] args) {
    createGUI();
  }
  
  public static void createGUI() {
    JFrame window = new JFrame("Practice Game");
    window.setSize(500, 500);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
  
}
