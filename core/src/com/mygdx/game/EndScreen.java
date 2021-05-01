package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;

//new
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/* Things to be done:
End Screen
- make end screen look niceer
- Switch to the play screen when the button is clicked (both computers and touch screens) - bug
*/
public class EndScreen implements Screen {
    TalonPlatformer game;

    public EndScreen(TalonPlatformer game) {
        this.game = game;

        playerLost = Player.isPlayerDead();//state.get smthg
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keyCode) {
                //try this first. if nothing happens, try the second one that I commented out
                if (keyCode == Input.Keys.ANY_KEY) {
                    game.setScreen(new MenuScreen(game));
                }
            //    if(Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
            //        game.setScreen(new MenuScreen(game));
            //    }

                return true;
            }
        });
    }

    @Override
    public void render(float delta) 
    {
        //4.24.2021 new code

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		dx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.font.draw(game.batch, "Click anywhere to RESTART", rectX + 10, rectY + 50);//this should appear inside the box
        game.batch.end();

        game.batch.begin();
        if(Player.getState() == State.DEAD){
            game.font.draw(game.texture, "Game Over", Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        }else{
            game.font.draw(game.texture, "You win!", Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        game.batch.end();
        
    }

    @Override
    public void resize(int width, int height) 
    {
    

    }

    @Override
    public void pause() 
    {
    

    }

    @Override
    public void resume() 
    {
    

    }

    @Override
    public void hide() 
    {

    }

    @Override
    public void dispose() 
    {
        background.dispose();
    }
    
}