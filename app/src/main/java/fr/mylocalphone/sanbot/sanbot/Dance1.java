package fr.mylocalphone.sanbot.sanbot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.beans.EmotionsType;
import com.qihancloud.opensdk.function.beans.LED;
import com.qihancloud.opensdk.function.unit.HardWareManager;
import com.qihancloud.opensdk.function.unit.SpeechManager;
import com.qihancloud.opensdk.function.unit.SystemManager;

public abstract class Dance1 extends TopBaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dance1);
        Log.d("MLP", "Dance1");
        danceMedia();
    }

    @Override
    public void onMainServiceConnected() {

    }

    private void danceMedia() {
        String text = "Human, my name is terminator. I kill you. bang, bang";
        Log.d("MLP", text);
        SpeechManager speechManager = (SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER);
        speechManager.startSpeak(text);

        HardWareManager hardWareManager = (HardWareManager) getUnitManager(FuncConstant.HARDWARE_MANAGER);
        hardWareManager.switchWhiteLight(true);
        hardWareManager.setLED(new LED(LED.PART_ALL, LED.MODE_FLICKER_RANDOM, (byte) 10, (byte) 3));

        SystemManager systemManager = (SystemManager) getUnitManager(FuncConstant.SYSTEM_MANAGER);
        systemManager.showEmotion(EmotionsType.SMILE);

        nextEtape();
    }

    private void nextEtape() {
        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(15000);
                } catch (Exception e) {
                }
                Intent intent = new Intent(getApplicationContext(), Media2.class);
                startActivity(intent);
            }
        };
        t.start();
    }

}
