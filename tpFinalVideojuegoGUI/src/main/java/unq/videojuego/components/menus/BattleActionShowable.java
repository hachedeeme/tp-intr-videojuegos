package unq.videojuego.components.menus;

import java.awt.Graphics2D;

import unq.videojuego.commands.Command;

public class BattleActionShowable extends Showable{
	private double x;
	private double y;
	private Command command;
	private TextElement text;

	public BattleActionShowable(Command aCommand) {
		this.command = aCommand;
		this.text = new TextElement(0, 0, 0, this.command.getName());
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
	
	//**************//
	//** ACCESORS **//
	//**************//
	public Command getCommand() {
		return command;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
