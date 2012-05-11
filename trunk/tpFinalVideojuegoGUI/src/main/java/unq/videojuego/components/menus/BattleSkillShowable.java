package unq.videojuego.components.menus;

import java.awt.Graphics2D;


import com.uqbar.videojuego.skills.Skill;

public class BattleSkillShowable extends Showable {
	private double x;
	private double y;
	private Skill skill;
	private TextElement text;
	private CounterElement cost;
	
	public BattleSkillShowable(Skill skill) {
		this.skill = skill;
		this.text = new TextElement(0, 0, 0, this.skill.getName());
		this.cost = new CounterElement(0, 0, 0, this.skill.getCost());
	}

	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//	
	@Override
	public void render(Graphics2D graphics) {
		this.text.render(graphics);
		this.cost.render(graphics);
	}

	//*************//
	//** METHODS **//
	//*************//	
	@Override
	public void setX(double start, double end) {
		this.x = start;
		this.text.setX(start);
		this.cost.setX(end - this.cost.getWidth() - 15);
	}

	@Override
	public void setY(double y) {
		this.y = y;
		this.text.setY(y);
		this.cost.setY(y);		
	}

	//**************//
	//** ACCESORS **//
	//**************//
	public Skill getSkill() {
		return skill;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
