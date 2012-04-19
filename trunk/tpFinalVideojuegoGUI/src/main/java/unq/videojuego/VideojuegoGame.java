package unq.videojuego;

import java.awt.Dimension;

import com.uqbar.vainilla.Game;

public class VideojuegoGame extends Game {
	private int screenWidth;
	private int screenHeight;

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(this.screenWidth, this.screenHeight);
	}

	@Override
	public String getTitle() {
		return "Videojuego";
	}

	@Override
	protected void initializeResources() {
	}

	@Override
	protected void setUpScenes() {
		
	}

}
