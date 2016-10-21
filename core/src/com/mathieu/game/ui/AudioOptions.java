package com.mathieu.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mathieu.game.config.Enums;

/**
 * Name : CasseBrique
 * Created by Debaerdm on 20/10/2016.
 * This Package : com.mathieu.game.ui.
 */
public class AudioOptions extends Table {

    private Slider soundSlider;
    private Slider musicSlider;

    private CheckBox soundCheckBox;
    private CheckBox musicCheckBox;

    public AudioOptions(Skin skin) {

        setName("Volume configuration");

        Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        skin.add("default-horizontal", sliderStyle);

        soundSlider = new Slider(0, 1, 0.05f, false, skin);
        soundSlider.setValue(Enums.FloatValue.AUDIO_SOUND_VOLUME.defaultValue);
        musicSlider = new Slider(0, 1, 0.05f, false, skin);
        musicSlider.setValue(Enums.FloatValue.AUDIO_MUSIC_VOLUME.defaultValue);

        CheckBox.CheckBoxStyle checkBoxStyle = new CheckBox.CheckBoxStyle();
        checkBoxStyle.font = skin.getFont("default");

        skin.add("default", checkBoxStyle);
        musicCheckBox = new CheckBox("Music Enabled", skin);
        musicCheckBox.setChecked(Enums.BooleanValue.AUDIO_MUSIC_ENABLED.defaultValue);
        soundCheckBox = new CheckBox("Sound Enabled", skin);
        soundCheckBox.setChecked(Enums.BooleanValue.AUDIO_MUSIC_ENABLED.defaultValue);

        Table soundTable = new Table();
        soundTable.add(soundSlider);
        soundTable.add(soundCheckBox);

        Table musicTable = new Table();
        musicTable.add(musicSlider);
        musicTable.add(musicCheckBox);

        add(soundTable);
        row();
        add(musicTable);

    }

}
