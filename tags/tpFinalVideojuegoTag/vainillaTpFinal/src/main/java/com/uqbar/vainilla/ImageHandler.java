package com.uqbar.vainilla;

import java.util.HashMap;
import java.util.Map;

import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.LimitedAnimation;
import com.uqbar.vainilla.appearances.Sprite;

public class ImageHandler {
	public static ImageHandler INSTANCE = new ImageHandler();
	private Map<String, Appearance> images = new HashMap<String, Appearance>();
	
	public void addSprite(String name){
		this.images.put(name, Sprite.fromImage("/images/" + name + ".png"));
	}
	
	public void addSprites(String...names){
		for (String name : names){
			this.addSprite(name);
		}
	}
	
	public Animation addAnimation(double time, double scale, int imgWidth, 
			int imgHeight, int spriteWidth, int spriteHeight, String name){
		Animation animation = AnimationGenerator.createAnimation(time, scale, ("/images/" + name + ".png"), imgWidth, imgHeight, spriteWidth, spriteHeight);
		this.images.put(name, animation);
		return animation;
	}
	
	public void addAnimation(String name, Animation animation){
		this.images.put(name, animation);
	}
	
	public void addLimitedAnimation(String name, LimitedAnimation animation){
		this.images.put(name, animation);
	}
	
	public LimitedAnimation addLimitedAnimation(double time, double scale, int imgWidth, 
			int imgHeight, int spriteWidth, int spriteHeight, String name){
		LimitedAnimation animation = AnimationGenerator.createLimitedAnimation(time, scale, ("/images/" + name + ".png"), imgWidth, imgHeight, spriteWidth, spriteHeight);
		this.images.put(name, animation);
		return animation;
	}
	
	public Sprite getSprite(String name){
		return (Sprite) this.images.get(name);
	}
	
	public Animation getAnimation(String name){
		return (Animation) this.images.get(name).copy();
	}
}
