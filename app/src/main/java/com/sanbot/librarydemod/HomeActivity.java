package com.sanbot.librarydemod;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.sanbot.opensdk.base.TopBaseActivity;
import com.sanbot.opensdk.beans.FuncConstant;
import com.sanbot.opensdk.function.beans.SpeakOption;
import com.sanbot.opensdk.function.unit.SpeechManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * className: HomeActivity
 * function: Menu de fonction
 * <p/>
 * create at 2017/5/22 10:31
 *
 * @author gangpeng
 */

public class HomeActivity extends TopBaseActivity {

    /**
     * Titre
     */
    @BindView(R.id.tv_title)
    TextView tvTitle;
    /**
     * Contrôle vocal
     */
    @BindView(R.id.tv_speech_control)
    TextView tvSpeechControl;
    /**
     * Contrôle du matériel
     */
    @BindView(R.id.tv_hardware_control)
    TextView tvHardwareControl;
    /**
     * Contrôle de la tête
     */
    @BindView(R.id.tv_head_control)
    TextView tvHeadControl;
    /**
     * Contrôle des mains
     */
    @BindView(R.id.tv_hand_control)
    TextView tvHandControl;
    /**
     * Contrôle des roues
     */
    @BindView(R.id.tv_wheel_control)
    TextView tvWheelControl;
    /**
     * Contrôle du système
     */
    @BindView(R.id.tv_system_control)
    TextView tvSystemControl;
    /**
     * Contrôle multimédia (webcam)
     */
    @BindView(R.id.tv_media_control)
    TextView tvMediaControl;

    private SpeechManager speechManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        register(HomeActivity.class);
        // L'écran toujours allumé
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        super.onCreate(savedInstanceState);
        setBodyView(R.layout.activity_home);
        ButterKnife.bind(this);

        // Définir la couleur et le titre de la barre d'état supérieure
        GradientDrawable topDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT
                , new int[]{Color.parseColor("#2B6DF8"), Color.parseColor("#00A2ED")});
        setHeadBackground(topDrawable);
        tvTitle.setText(R.string.title);

        //Initialisation des variables
        speechManager = (SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER);
    }

    @Override
    protected void onMainServiceConnected() {
        cccStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.tv_speech_control, R.id.tv_hardware_control, R.id.tv_head_control,
            R.id.tv_hand_control, R.id.tv_wheel_control, R.id.tv_system_control,
            R.id.tv_media_control})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_speech_control:
                Intent intent = new Intent(HomeActivity.this, SpeechControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_hardware_control:
                intent = new Intent(HomeActivity.this, HardwareControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_head_control:
                intent = new Intent(HomeActivity.this, HeadControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_hand_control:
                intent = new Intent(HomeActivity.this, HandControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_wheel_control:
                intent = new Intent(HomeActivity.this, WheelControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_system_control:
                intent = new Intent(HomeActivity.this, SystemControlActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_media_control:
                intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void cccStart(){
        SpeakOption speakOption = new SpeakOption();
        speakOption.setLanguageType(SpeakOption.LAG_FRENCH_FRANCE);
        speakOption.setSpeed(Integer.parseInt(String.valueOf(100)));
        speakOption.setIntonation(Integer.parseInt(String.valueOf(100)));
        speechManager.startSpeak("Bonjour, Erwan comment ça va ?", speakOption);
    }

}
