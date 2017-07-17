/**
 * 
 */
package edu.cnm.deepdive.game;

import java.awt.image.BufferedImage;

/**
 * @author Sky Link
 *
 */
public class SpriteSheet  {
  
  
  
  static final int SPRITE_HEIGHT = 32;
  static final int SPRITE_WIDTH = 32;

  private BufferedImage image;
  
  public SpriteSheet(BufferedImage image) {
    this.image = image;
  }
  
  public BufferedImage grabImage(int col, int row, int width, int height) {
    BufferedImage img = image.getSubimage((col * SPRITE_WIDTH) - SPRITE_WIDTH, (row * SPRITE_HEIGHT) - SPRITE_HEIGHT, width, height);
    return img;
  }
}
