package fr.mylocalphone.sanbot.sanbot;

import android.os.Bundle;
import android.util.Log;

import com.sanbot.opensdk.base.TopBaseActivity;
import com.sanbot.opensdk.beans.FuncConstant;
import com.sanbot.opensdk.function.beans.EmotionsType;
import com.sanbot.opensdk.function.beans.LED;
import com.sanbot.opensdk.function.unit.HardWareManager;
import com.sanbot.opensdk.function.unit.SpeechManager;
import com.sanbot.opensdk.function.unit.SystemManager;

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

        //nextEtape();
    }

    private void nextEtape() {
        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(15000);
                } catch (Exception e) {
                }
//                Intent intent = new Intent(getApplicationContext(), Dance.class);
//                startActivity(intent);
            }
        };
        t.start();
    }

}
