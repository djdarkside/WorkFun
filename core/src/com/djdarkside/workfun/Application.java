package com.djdarkside.workfun;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.djdarkside.workfun.screens.LoadingScreen;
import com.djdarkside.workfun.screens.MainMenuScreen;

public class Application extends Game {
	public static final int V_WIDTH = 1280;
    public static final int V_HEIGHT = 720;

    public LoadingScreen lScreen;
    public MainMenuScreen mmScreen;

    public AssetManager manager;
    public OrthographicCamera cam;
    public SpriteBatch batch;

    public BitmapFont font;

	@Override
	public void create () {
        manager = new AssetManager();
        cam = new OrthographicCamera();
        cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
        batch = new SpriteBatch();

        font = new BitmapFont();
        font.setColor(Color.BLACK);

        lScreen = new LoadingScreen(this);
        mmScreen = new MainMenuScreen(this);
        this.setScreen(lScreen);
	}

	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
        batch.dispose();
        font.dispose();
        manager.dispose();
	}
}
