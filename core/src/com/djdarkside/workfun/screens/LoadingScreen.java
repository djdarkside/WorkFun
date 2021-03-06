package com.djdarkside.workfun.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.djdarkside.workfun.Application;

/**
 * Created by design on 10/13/2016.
 */
public class LoadingScreen implements Screen {

    private final Application app;
    private float progress;

    public LoadingScreen (final Application app) {
        this.app = app;
    }

    @Override
    public void show() {
        this.progress = 0f;
        queueAssets();
    }

    public void queueAssets() {
        app.manager.load("s1.png", Texture.class);
        app.manager.load("skin/uiskin.atlas", TextureAtlas.class);
    }

    public void update(float delta) {
        progress = MathUtils.lerp(progress, app.manager.getProgress(), 0.1f);
        if (app.manager.update() && progress >= app.manager.getProgress() - .01f) {
            app.setScreen(app.mmScreen);
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        app.batch.begin();
        app.font.draw(app.batch, "Loading", app.V_WIDTH / 2, 50);
        app.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
