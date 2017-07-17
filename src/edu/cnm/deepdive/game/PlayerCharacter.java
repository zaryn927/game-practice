/**
 * 
 */
package edu.cnm.deepdive.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

/**
 * @author Sky Link
 *
 */
public class PlayerCharacter extends JPanel {
  
  public int x;
  public int y;
  public int walkFrame;
  public int walkDirection;
  public Image characterImage; 
  
  
  /**
   * 
   */
  private static final long serialVersionUID = 5345886941772129222L;
  private BufferedImageLoader loader = new BufferedImageLoader();
  private BufferedImage spriteSheet;
  private BufferedImage player;
  private static final int SCALED_HEIGHT = 128;
  private static final int SCALED_WIDTH = 128;
  public Image[] animation = new Image[4];
  //public Image[] characterAnimation;
  
  public PlayerCharacter(int walkFrame, int walkDirection, int x, int y) {
    super(true);
    this.walkFrame = walkFrame;
    this.walkDirection = walkDirection;
    this.x = x;
    this.y = y;
    characterImage = drawCharacter(walkFrame, walkDirection, x, y);
    
  }

  /* (non-Javadoc)
   * @see javax.swing.JComponent#getPreferredSize()
   */
  @Override
  public Dimension getPreferredSize() {
    // TODO Auto-generated method stub
    return super.getPreferredSize();
  }

  /* (non-Javadoc)
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(characterImage, x, y, this);
  }

  public Image drawCharacter( int walkDirection, int walkFrame, int x, int y) {
    synchronized (this) {
      Image scaledPlayer = null;
      try {
      spriteSheet = loader.loadImage("resources/gray_witch.png");
      SpriteSheet ss = new SpriteSheet(spriteSheet);
      player = ss.grabImage(walkFrame, walkDirection, SpriteSheet.SPRITE_WIDTH, SpriteSheet.SPRITE_HEIGHT);
      scaledPlayer = player.getScaledInstance(SCALED_WIDTH, SCALED_HEIGHT, Image.SCALE_REPLICATE);
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      return scaledPlayer;
    }
  }
  
  public Image[] animateCharacter(int walkDirection, int x, int y) {
    for(int i = 0; i < 4; i++) {
      animation[i] = drawCharacter(walkDirection, i, x, y);
    }
    return animation;
  }
 

  public synchronized void setCharacter() {
      repaint();
  }
  
  
  
}
