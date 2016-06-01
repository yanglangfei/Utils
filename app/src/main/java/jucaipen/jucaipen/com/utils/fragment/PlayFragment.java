package jucaipen.jucaipen.com.utils.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.utils.VoiceUtils;


/**
 * Created by jucaipen on 16/6/1.
 */
public class PlayFragment  extends Fragment implements View.OnClickListener {
    private Button voice;
    private View view;
    private EditText et_search;
    private TextView info;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_play,container,false);
        initView();
        return view;
    }

    private void initView() {
        SpeechUtility.createUtility(getActivity(), SpeechConstant.APPID+"="+ VoiceUtils.APP_ID);
        voice= (Button) view.findViewById(R.id.voice);
        info= (TextView) view.findViewById(R.id.infos);
        et_search= (EditText) view.findViewById(R.id.et_search);
        voice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       // parseVoice();
          createVoice();

    }


    // 语音识别
    public  void parseVoice(){
        SpeechRecognizer recogizer=SpeechRecognizer.createRecognizer(getActivity(),null);
        recogizer.setParameter(SpeechConstant.DOMAIN, "iat");
        recogizer.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        recogizer.setParameter(SpeechConstant.ACCENT, "mandarin ");
        recogizer.setParameter(SpeechConstant.VAD_BOS,"60000");
        recogizer.startListening(recognizerListener);
        Log.i("111", "createVoice: ");

    }

    private  RecognizerListener recognizerListener=new RecognizerListener() {
        @Override
        public void onVolumeChanged(int i, byte[] bytes) {

        }

        @Override
        public void onBeginOfSpeech() {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            info.append(recognizerResult.getResultString());
        }

        @Override
        public void onError(SpeechError speechError) {
            Toast.makeText(getActivity(), "err:"+speechError.getErrorCode(), Toast.LENGTH_SHORT).show();
            Log.i("111", "onError: "+speechError.getErrorCode());
            info.setText("err:"+speechError.getErrorCode());

        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {
            Log.i("111", "onEvent: "+i);

        }
    };


    //语音合成
    public void createVoice(){
        SpeechSynthesizer synthesizer=SpeechSynthesizer.createSynthesizer(getActivity(),null);
        synthesizer.setParameter(SpeechConstant.VOICE_NAME,"xiaoyan");
        synthesizer.setParameter(SpeechConstant.SPEED,"50");
        synthesizer.setParameter(SpeechConstant.VOLUME,"80");
        synthesizer.setParameter(SpeechConstant.ENGINE_TYPE,SpeechConstant.TYPE_CLOUD);
        synthesizer.startSpeaking(et_search.getText().toString(),synthesizerListener);

    }

    private SynthesizerListener synthesizerListener=new SynthesizerListener() {
        @Override
        public void onSpeakBegin() {

        }

        @Override
        public void onBufferProgress(int i, int i1, int i2, String s) {

        }

        @Override
        public void onSpeakPaused() {

        }

        @Override
        public void onSpeakResumed() {

        }

        @Override
        public void onSpeakProgress(int i, int i1, int i2) {

        }

        @Override
        public void onCompleted(SpeechError speechError) {

        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };

}
