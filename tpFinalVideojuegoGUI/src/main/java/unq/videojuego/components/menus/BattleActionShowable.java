package unq.videojuego.components.menus;

import java.awt.Graphics2D;

import unq.videojuego.commands.Action;
import unq.videojuego.scenes.VideojuegoScene;

public class BattleActionShowable extends Showable {
	private double x;
	private double y;
	private Action action;
	private TextElement text;

	public BattleActionShowable(Action aCommand) {
		this.action = aCommand;
		this.text = new TextElement(0, 0, 0, this.action.getName());
	}
	
	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//
	@Override
	public void render(Graphics2D graphics) {
		this.text.render(graphics);
	}
	
	//*************//
	//** METHODS **//
	//*************//
	@Override
	public void setX(double start, double end) {
		this.x = start;
		this.text.setX(start);
	}

	@Override
	public void setY(double y) {
		this.y = y;
		this.text.setY(y);
	}
	
	public void execute(VideojuegoScene scene){
		this.action.execute(scene);
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public Action getCommand() {
		return action;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
