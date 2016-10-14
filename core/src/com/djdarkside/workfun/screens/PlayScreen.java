package com.djdarkside.workfun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.djdarkside.workfun.Application;

/**
 * Created by djdarkside on 10/14/2016.
 */
public class PlayScreen implements Screen {

    private final Application app;
    private Stage stage;

    public PlayScreen(final Application app) {
        this.app = app;
        stage = new Stage(new FitViewport(app.V_WIDTH, app.V_HEIGHT));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();
    }

    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();

        app.batch.begin();
        app.font.draw(app.batch, "Play Screen", app.V_WIDTH / 2, 50);
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
        stage.dispose();
    }
}
