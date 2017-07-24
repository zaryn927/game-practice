/**
 * 
 */
package edu.cnm.deepdive.game;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * @author Sky Link
 *
 */
public class Game extends JFrame{
  
  private static final String WINDOW_TITLE = "Working Title";
  private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(1920, 1080);
  
  public static Game game = new Game(WINDOW_TITLE);
  
  private PlayerCharacter character; //JPanel
  private boolean uiSetup = false;
  

  public Game(String title) {
    super(title);
  }
  
  public static void main(String[] args) {
    game.initialize();
  }
  
  public static void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener) {
    InputMap inMap = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    ActionMap acMap = comp.getActionMap();
    inMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
    acMap.put(id, new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        actionListener.actionPerformed(evt);
      }
    });
  }
  
  private void initialize() {
    SwingUtilities.invokeLater(() -> createGUI());
    synchronized (this) {
      while (!uiSetup) {
        try {
          wait();
        } catch (InterruptedException ex) {
          // Do nothing.
        }
      }
      addKeyBinding(character, KeyEvent.VK_UP, "up", (evt) -> {
        character.y -= 10;
        character.characterImage = character.drawCharacter(2, 1, character.x, character.y);
        character.setCharacter();
      });
      addKeyBinding(character, KeyEvent.VK_DOWN, "down", (evt) -> {
        character.y += 10;
        character.characterImage = character.drawCharacter(1, 1, character.x, character.y);
        character.setCharacter();
      });
      addKeyBinding(character, KeyEvent.VK_RIGHT, "right", (evt) -> {
        character.x += 10;
        character.characterImage = character.drawCharacter(3, 1, character.x, character.y);
        character.setCharacter();
      });
      addKeyBinding(character, KeyEvent.VK_LEFT, "left", (evt) -> {
        character.x -= 10;
        character.characterImage = character.drawCharacter(4, 1, character.x, character.y);
        character.setCharacter();
      });
    }
  }
  
  private void createGUI() {  
    game.setSize(DEFAULT_WINDOW_SIZE);
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setLocationRelativeTo(null);
    //frame.setResizable(false);
    game.setLayout(new BorderLayout());
    
    int initialX = game.getWidth() / 2 - 64;
    int initialY = game.getHeight() / 2 - 64;
    character = new PlayerCharacter(1, 1, initialX, initialY);
    character.setSize(32, 32);
    game.add(character, BorderLayout.CENTER);
    character.setCharacter();
    character.setFocusable(true);
    
    //frame.pack();
    game.setVisible(true);
    synchronized (this) {
      uiSetup = true;
      notify();
    }
  }
  

//  @Override
//  public void keyPressed(KeyEvent ke) {
//    int frame = 1;
////    if (keyPress) {
////      frame++;
////      if (frame > 4) {
////        frame = 1;
////      }
////    }
//    
//    if (ke.getKeyCode() == KeyEvent.VK_UP) {
//      character.y -= 10;
//      character.characterImage = character.drawCharacter(2, 1, character.x, character.y);
//      character.setCharacter();
//      keyPress = true;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
//      character.y += 10;
//      character.characterImage = character.drawCharacter(1, 1, character.x, character.y);
//      character.setCharacter();
//      keyPress = true;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//      character.x += 10;
//      character.characterImage = character.drawCharacter(3, 1, character.x, character.y);
//      character.setCharacter();
//      keyPress = true;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
//      character.x -= 10;
//      character.characterImage = character.drawCharacter(4, 1, character.x, character.y);
//      character.setCharacter();
//      keyPress = true;
//    }
//    
//  }
//
//  @Override
//  public void keyReleased(KeyEvent ke) {
//    if (ke.getKeyCode() == KeyEvent.VK_UP) {
//      keyPress = false;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
//      keyPress = false;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
//      keyPress = false;
//      
//    }else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
//      keyPress = false;
//      
//    }
//    
//  }
//
//  @Override
//  public void keyTyped(KeyEvent ke) {
//    // TODO Auto-generated method stub
//    
//  }
  
}
