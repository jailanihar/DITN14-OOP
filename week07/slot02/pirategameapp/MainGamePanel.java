package week07.slot02.pirategameapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import week05.slot02.assets.Map;
import week05.slot02.assets.Pirate;
import week05.slot02.assets.Potion;
import week05.slot02.assets.interfaces.Placeable;
import week05.slot02.assets.weapons.Sword;

public class MainGamePanel extends JPanel {
	
	private final static int MAX_WIDTH = 6, MAX_HEIGHT = 6;
	private Map map = new Map(MAX_WIDTH, MAX_HEIGHT);
	private JPanel mapPanel, buttonsPanel;
	private JTextArea prevSelectedPlaceable;
	private int selectedX = -1, selectedY = -1;
	
	public MainGamePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(MAX_HEIGHT, MAX_WIDTH));
		mapPanel.setPreferredSize(new Dimension(800, 400));
		
		map.addAssets(0, 1, new Sword(4));
		map.addAssets(1, 1, new Potion(2));
		map.addPirate(4, 3, new Pirate());
		map.addPirate(3, 3, new Pirate());
		
		generateMap();
		
		buttonsPanel = new JPanel();
		
		generateMovePirateButtons();
		
		this.add(mapPanel);
		this.add(buttonsPanel);
	}
	
	public void refreshMap() {
		mapPanel.removeAll();
		generateMap();
		mapPanel.revalidate();
		mapPanel.repaint();
	}
	
	public void generateMovePirateButtons() {
		JButton leftButton = new JButton("Left");
		JButton upButton = new JButton("Up");
		JButton downButton = new JButton("Down");
		JButton rightButton = new JButton("Right");
		
		leftButton.addActionListener(e -> {
			map.movePirateLeft(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {
				selectedX = selectedX - 1;
			}
			refreshMap();
		});
		
		upButton.addActionListener(e -> {
			map.movePirateUp(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {
				selectedY = selectedY - 1;
			}
			refreshMap();
		});
		
		downButton.addActionListener(e -> {
			map.movePirateDown(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {
				selectedY = selectedY + 1;
			}
			refreshMap();
		});
		
		rightButton.addActionListener(e -> {
			map.movePirateRight(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {
				selectedX = selectedX + 1;
			}
			refreshMap();
		});
		
		buttonsPanel.add(leftButton);
		buttonsPanel.add(upButton);
		buttonsPanel.add(downButton);
		buttonsPanel.add(rightButton);
	}
	
	public void generateMap() {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				PlaceableTextArea placeableTextArea =
						new PlaceableTextArea(x, y);
				placeableTextArea.setLineWrap(true);
				placeableTextArea.setEditable(false);
				placeableTextArea.setBorder(
						BorderFactory.createLineBorder(Color.BLACK)
						);
				
				Placeable asset = map.selectAssets(x, y);
				if(asset != null) {					
					placeableTextArea.setText(asset.toString());
				}
				
				if(x == selectedX && y == selectedY) {
					prevSelectedPlaceable = placeableTextArea;
					placeableTextArea.setBackground(Color.LIGHT_GRAY);
				}
				
				placeableTextArea.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {
						if(prevSelectedPlaceable != null) {
							prevSelectedPlaceable.setBackground(Color.WHITE);
						}
						prevSelectedPlaceable = placeableTextArea;
						selectedX = placeableTextArea.getArenaXLoc();
						selectedY = placeableTextArea.getArenaYLoc();
						placeableTextArea.setBackground(Color.LIGHT_GRAY);
					}

					@Override
					public void mouseReleased(MouseEvent e) {}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}
					
				});
				
				mapPanel.add(placeableTextArea);
			}
		}
	}

}
