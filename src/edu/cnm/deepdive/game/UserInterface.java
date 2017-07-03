/**
 * 
 */
package edu.cnm.deepdive.game;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.*;

/**
 * @author Sky Link
 *
 */
public class UserInterface extends Canvas {
  
  private BufferedImage spriteSheet;
  private BufferedImage player;
  
  public static  void main(String[] args) {
    UserInterface UI = new UserInterface();
    createGUI();
    UI.render();
  }
  
  public static void createGUI() {
    
    JFrame window = new JFrame("Practice Game");
    window.setSize(500, 500);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    
    
  }
  
  public void intitChar() {
    BufferedImageLoader loader = new BufferedImageLoader();
    try {
      spriteSheet = loader.loadImage("/gray_witch.png");
      
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    
    SpriteSheet ss = new SpriteSheet(spriteSheet);
    player = ss.grabImage(1, 1, 32, 32);
  }
  
  private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(1);
      return;
    }
    
    Graphics g = bs.getDrawGraphics();
    g.drawImage(player, 100, 100, this);
    g.dispose();
    bs.show();
    
  }
  
}
