package com.strzal.hungry.controller;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.strzal.hungry.HungrySpaceCats;
import com.strzal.hungry.config.GameSetting;
import com.strzal.hungry.constants.ImagesPaths;
import com.strzal.hungry.entity.HungryEntity;
import com.strzal.hungry.entity.OrderItemEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LevelOrderListLoaderController {

    HungrySpaceCats game;
    Stage stage;
    AssetManager assetManager;

    public LevelOrderListLoaderController(HungrySpaceCats game, Stage stage) {
        this.game = game;
        this.stage = stage;
        this.assetManager = game.getAssetManager();
    }


    public ArrayList<HungryEntity> getLevelList() {

        return getRandomOrderSize(GameSetting.NUMBER_OF_HUNGRY_IN_WAVE + game.getGameStats().getWave());

    }

    public ArrayList<HungryEntity> getRandomOrderSize(int levelSize) {

        ArrayList<HungryEntity> hungryEntityArrayList = new ArrayList<>();

        for (int i = 1; i <= levelSize; i++) {
            ArrayList<OrderItemEnum> orderItemEnumListRandom = new ArrayList<>();
            orderItemEnumListRandom.add(getRandomOrder());
            orderItemEnumListRandom.add(getRandomOrder());
            hungryEntityArrayList.add(new HungryEntity(game, stage, (Texture) assetManager.get(getRandomHungry()), orderItemEnumListRandom));
        }
        return hungryEntityArrayList;
    }


    private OrderItemEnum getRandomOrder() {

        List<OrderItemEnum> givenList = Arrays.asList(OrderItemEnum.WATER, OrderItemEnum.CHIPS_BOOL, OrderItemEnum.FISH_BOOL);
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }

    private String getRandomHungry() {

        List<String> givenList = Arrays.asList(ImagesPaths.HUNGRY_CAT, ImagesPaths.HUNGRY_CAT_2, ImagesPaths.HUNGRY_CAT_3);
        Random rand = new Random();
        return givenList.get(rand.nextInt(givenList.size()));
    }


}
