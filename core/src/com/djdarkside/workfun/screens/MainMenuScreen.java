package com.djdarkside.workfun.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.djdarkside.workfun.Application;

/**
 * Created by djdarkside on 10/13/2016.
 */
public class MainMenuScreen implements Screen {

    private final Application app;
    private Skin skin;
    private Stage stage;
    private TextButton button;

    public MainMenuScreen(final Application app) {
        this.app = app;
        stage = new Stage(new FitViewport(Application.V_WIDTH, Application.V_HEIGHT));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        skin = new Skin();
        skin.addRegions(app.manager.get("skin/uiskin.atlas", TextureAtlas.class));
        skin.add("default-font", app.font);
        skin.load(Gdx.files.internal("skin/uiskin.json"));

        createButton();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        stage.draw();

        app.batch.begin();
        app.font.draw(app.batch, "Main Menu", app.V_WIDTH / 2, 50);
        app.batch.end();

    }

    private void createButton() {
        button = new TextButton("START", skin, "default");
        button.setPosition((app.V_WIDTH / 2) - 140, app.V_HEIGHT - 120);
        button.setSize(280, 60);
        button.addListener(new ClickListener() {
            public void clicked(InputEvent e, float x, float y) {
                button.addAction(Actions.sequence(Actions.alpha(0f), Actions.parallel(Actions.fadeIn(2f), Actions.moveBy(0, -20))));
                //app.setScreen(app.playScreen);
            }
        });

        stage.addActor(button);
    }

    private void update(float delta) {
        stage.act(delta);
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
