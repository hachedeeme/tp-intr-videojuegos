package com.uqbar.vainilla;

import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.LimitedAnimation;
import com.uqbar.vainilla.appearances.Sprite;

public class AnimationGenerator {
	public static Animation createAnimation(double time, double scale, String image, int imgWidth, int imgHeight, int spriteWidth, int spriteHeight){
		Sprite[] sprites = getImageSprites(scale, image, imgWidth, imgHeight,
				spriteWidth, spriteHeight);
		
		return new Animation(time, sprites);
	}
	
	public static LimitedAnimation createLimitedAnimation(double time, double scale, String image, int imgWidth, int imgHeight, int spriteWidth, int spriteHeight){
		return createLimitedAnimation(1, time, scale, image, imgWidth, imgHeight, spriteWidth, spriteHeight);
	}
	
	public static LimitedAnimation createLimitedAnimation(int times, double time, double scale, String image, int imgWidth, int imgHeight, int spriteWidth, int spriteHeight){
		Sprite[] sprites = getImageSprites(scale, image, imgWidth, imgHeight,
				spriteWidth, spriteHeight);
		
		return new LimitedAnimation(time, sprites, times);
	} 

	private static Sprite[] getImageSprites(double scale, String image,
			int imgWidth, int imgHeight, int spriteWidth, int spriteHeight) {
		Sprite[] sprites = new Sprite[imgWidth/spriteWidth * imgHeight/spriteHeight]; 
		
		int index = 0;
		for (int j = 0; j < imgHeight; j += spriteHeight) {
			for (int i = 0; i < imgWidth; i += spriteWidth) {
				sprites[index] = (Sprite.fromImage(image).crop(i, j, spriteWidth, spriteHeight).scale(scale));
				index++;
			}
		}
		return sprites;
	}
}
