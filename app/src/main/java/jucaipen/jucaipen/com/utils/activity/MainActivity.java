package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bm.library.PhotoView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.model.Advise;
import jucaipen.jucaipen.com.utils.utils.JsonUtil;
import jucaipen.jucaipen.com.utils.utils.NetUtils;

public class MainActivity extends Activity{
    private static final String TAG = MainActivity.class.getSimpleName();
    private  String url="http://192.168.1.134:8080/Jucaipen/jucaipen/getadvise";
    private TextView info;
    private Map<String, Object> param=new HashMap<>();
    private List<Advise> advises;
    private  StringBuffer buffer=new StringBuffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        findViewById(R.id.into).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent into=new Intent(MainActivity.this,PhoteActivity.class);
                MainActivity.this.startActivity(into);
            }
        });
        info= (TextView) findViewById(R.id.info);
        //获取广告信息
        param.put("type",1);
        RequestParams p=NetUtils.sendHttpGet(url,param);
        x.http().get(p, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                advises=JsonUtil.getAdvise(result);
                for(Advise advise : advises){
                    buffer.append("id: "+advise.getId()+"\t"+"linkUrl: "+advise.getLinkUrl()+"\t"+"typeId: "+advise.getTypeId()+"\t"+"title: "+advise.getTitle());
                }
                info.setText(buffer.toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });

    }


}
