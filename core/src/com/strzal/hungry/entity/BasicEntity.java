package com.strzal.hungry.entity;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.strzal.gdx.BasicGame;
import com.strzal.gdx.buttons.ButtonsUtils;
import com.strzal.hungry.constants.ImagesPaths;
import com.strzal.hungry.controller.GameController;
import lombok.Getter;

public class BasicEntity {

    protected BasicGame game;
    protected GameController gameController;
    protected Stage stage;
    protected AssetManager assetManager;

    protected ButtonsUtils buttonsUtils;

    @Getter
    protected int xPosition;
    protected int yPosition;

    //timer
    protected long initialClickTime;
    protected long cookingTime = 10; //seconds

    public BasicEntity(BasicGame game, final GameController gameController, Stage stage, int xPosition, int yPosition){
        this.game = game;
        this.gameController = gameController;
        this.stage = stage;
        this.assetManager = game.getAssetManager();

        this.xPosition = xPosition;
        this.yPosition = yPosition;

        buttonsUtils = new ButtonsUtils(assetManager, ImagesPaths.TRANSPARENT);
    }

    public void render(){

    }

    protected boolean checkCookingTimeHasPassed(){
        long currentTime = TimeUtils.millis();
        if((currentTime - initialClickTime)/1000 > cookingTime){
            System.out.println("Production Finished - Time");
            return true;
        }else{
            return false;
        }
    }
}
