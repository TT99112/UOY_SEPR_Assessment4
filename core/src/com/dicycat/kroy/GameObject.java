package com.dicycat.kroy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Basic object for all displayable objects
 *  
 * @author Riju De
 *
 */
public abstract class GameObject {
	protected Sprite sprite;						//Sprite of the object
	protected Boolean remove, displayable;			//Should this GameObject be removed? Should this item be displayed?
	protected float rotation = 0;	//Current angle the truck is facing in degrees

	//For objects we should be saving, we set this bool to true (and also have redefined the respective function
	public boolean shouldSave = false;
	public GameObject(Vector2 spawnPos, Texture image, Vector2 imSize) {	//Constructor; takes the screen to be put on, spawn position vector, image and a vector for its size
		sprite = new Sprite(image,(int) spawnPos.x ,(int) spawnPos.y ,(int) imSize.x,(int) imSize.y); // sprite class stores the texture position and size of the object
		remove = false;
		displayable = false;
	}

	/**
	 * Called every frame.
	 * Update the game object.
	 */
	public abstract void update();

	/**
	 * Render the object.
	 * @param batch Batch to render
	 */
	public void render(SpriteBatch batch) {
		batch.draw(getTexture(), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getXScale(), getYScale(), getRotation(), 0, 0, getTextureWidth(), getTextureHeight(), false, false);
	}

	/**
	 * changes current position by vector v
	 * @param v Vector to move
	 */
	public void changePosition(Vector2 v) {
		sprite.setX(getX() + v.x);
		sprite.setY(getY() + v.y);
	}
	
	/**
	 * sets the current texture to a new texture (should be the same size)
	 * @param tex Texture to change to
	 */
	public void setTexture(Texture tex) {
		sprite.setTexture(tex);
	}

	//Getters
	public Texture getTexture() { return sprite.getTexture(); }
	public float getHeight() { return sprite.getHeight(); }
	public float getWidth() {return sprite.getWidth(); }
	public float getX() { return sprite.getX(); }
	public float getY() { return sprite.getY(); }
	public Boolean isRemove() { return remove; }
	public float getOriginX () { return sprite.getOriginX(); } // returns centre of sprite (25, 50) Use GetCentre for position on screen
	public float getOriginY() {return sprite.getOriginY(); }
	public  float getXScale() { return sprite.getScaleX(); }
	public float getYScale() { return sprite.getScaleY(); }
	public float getRotation() { return rotation; }
	public int getTextureWidth() { return sprite.getTexture().getWidth(); }
	public int getTextureHeight() {	return sprite.getTexture().getHeight(); }
	public Sprite getSprite() { return sprite; }
	public Vector2 getPosition() { return new Vector2(getX(), getY());  }
	public boolean isDisplayable() { return displayable; }

	/**
	 * Return centre of GameObject
	 * @return Centre of GameObject
	 */
	public Vector2 getCentre() {
		return new Vector2(getOriginX()+getX(), getOriginY()+getY());
	}

	//Setters
	public void setPosition(Vector2 pos) {
		sprite.setX(pos.x);
		sprite.setY(pos.y);
	}

	/**
	 * sets direction "degrees" to the direction currently facing
	 * @param degrees direction to face
	 */
	public void setRotation(float degrees) {
		rotation = degrees;
	}

	public void setRemove(Boolean x){
		remove = x;
	}
	
	/**
	 * Sets remove to true so it will not be rendered to the screen
	 */
	public void die() {
		remove = true;
	}

	/**
	 * Returns save data to be written to prefs file
	 * IMPORTANT:
	 * While you don't see it here, in other classes where we define an implementation of save(),
	 * we use the @ value to split values being saved. We cannot use , because vector.tostring() contains a , and would
	 * make things harder. I chose @ over . because . looks like , .
	 */
	public String save() {
		return null;
	}
	
	/**
	 * Loads the data from the prefs file
	 * 
	 * @param data The data to load
	 */
	public void load(String data) {
	}
	
	/**
	 * Gets a unique identifier for this GameObject
	 *
	 * @return The UUID for the object
	 */
	public String getUUID() {
		return null;
	}
	
	
	/**
	 * Check if a GameObject should be saved
	 * 
	 * @return A boolean value of whether to save or not
	 */
	public Boolean shouldSave() {
		return shouldSave;
	}
}
