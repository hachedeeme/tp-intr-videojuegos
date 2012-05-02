package com.uqbar.vainilla;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Date;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

public class GameStatsLabel extends GameComponent {
	private Label label = null;
	
	public GameStatsLabel(int x, int y) {
		super(x, y);
		this.setZ(1000);
		Font font = new Font("", Font.BOLD, 14);
		this.label = new Label(font, Color.BLACK, "");
		this.setAppearance(this.label);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		
		this.label.setText("FPS: " + (int)(1/deltaState.getDelta()) + "\n" + //
				   		   "Cant Objs: " + (this.getScene().getComponentCount() - 1));
		this.setAppearance(this.label);
		
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);

	}
	
}
