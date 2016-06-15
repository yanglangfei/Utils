package jucaipen.jucaipen.com.utils.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.bm.library.Info;
import com.bm.library.PhotoView;
import com.liulishuo.share.ShareBlock;
import com.liulishuo.share.model.ILoginManager;
import com.liulishuo.share.model.IShareManager;
import com.liulishuo.share.model.PlatformActionListener;
import com.liulishuo.share.model.ShareContentWebpage;
import com.liulishuo.share.qq.QQLoginManager;
import com.liulishuo.share.qq.QQShareManager;
import com.quinny898.library.persistentsearch.SearchBox;
import com.quinny898.library.persistentsearch.SearchResult;
import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jucaipen.jucaipen.com.utils.R;
import jucaipen.jucaipen.com.utils.view.MovingImageView;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

/**
 * Created by jucaipen on 16/6/15.     kkkkk
 *
 *   移动图片   git 项目地址   https://github.com/yanglangfei/MovingImageView
 *
 *   权限处理框架 git 项目地址   https://github.com/yanglangfei/PermissionGen
 *
 *
 *   SearchBox    git 项目地址   https://github.com/yanglangfei/PersistentSearch
 *
 *
 *   第三方 登录 分享 框架    git  项目地址  https://github.com/yanglangfei/ShareLoginLib
 */
public class MoveActivity extends Activity{
    private MovingImageView move_iv;
    private SearchBox sb;


    PlatformActionListener listener=new PlatformActionListener() {
        @Override
        public void onComplete(HashMap<String, Object> userInfo) {
            Toast.makeText(MoveActivity.this, "success", Toast.LENGTH_SHORT).show();
            if(userInfo!=null){
                for(Map.Entry<String,Object> info :userInfo.entrySet()){
                    Log.i("111", "onComplete: "+"k:"+info.getKey()+" v:"+info.getValue());
                }
            }

        }

        @Override
        public void onError() {
            Toast.makeText(MoveActivity.this, "error", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MoveActivity.this, "cancel", Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_move);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initView() {
        move_iv= (MovingImageView) findViewById(R.id.move_iv);
        move_iv.getMovingAnimator().setInterpolator(new LinearInterpolator());
        move_iv.getMovingAnimator().setSpeed(100);
        move_iv.getMovingAnimator().addCustomMovement()
                .addDiagonalMoveToDownLeft().addDiagonalMoveToDownRight()
                .addDiagonalMoveToUpLeft().addDiagonalMoveToUpRight()
                .addHorizontalMoveToLeft().addHorizontalMoveToRight().start();


        sb= (SearchBox) findViewById(R.id.searchbox);
        sb.setLogoTextColor(Color.BLUE);
        sb.setMenuListener(new SearchBox.MenuListener() {
            @Override
            public void onMenuClick() {

            }
        });

        sb.setSearchListener(new SearchBox.SearchListener() {
            @Override
            public void onSearchOpened() {

            }

            @Override
            public void onSearchCleared() {

            }

            @Override
            public void onSearchClosed() {

            }

            @Override
            public void onSearchTermChanged(String term) {

            }

            @Override
            public void onSearch(String result) {

            }

            @Override
            public void onResultClick(SearchResult result) {

            }
        });
       // sb.enableVoiceRecognition(this);



        //第三方分享     登录框架
        //1 初始化分享
        ShareBlock.getInstance().initShare(null,null,"100226886",null);
        ShareBlock.getInstance().initWeiboRedriectUrl(""); //初始化微博回调地址



        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //QQ分享 到朋友圈
                IShareManager sm=new QQShareManager(MoveActivity.this);
                sm.share(new ShareContentWebpage("title", "content", "dataUrl",
                        "imageUrl"),QQShareManager.QZONE_SHARE_TYPE);
            }
        });

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //QQ登录
                ILoginManager lm= new QQLoginManager(MoveActivity.this);
                lm.login(listener);
            }
        });










        //检测权限
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int per=checkSelfPermission(Manifest.permission.READ_CONTACTS);
            if(per!= PackageManager.PERMISSION_GRANTED){
                requestPermission();
                // onRequestPermissionsResult();
            }
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         if(requestCode==SearchBox.VOICE_RECOGNITION_CODE&&resultCode==RESULT_OK){
             ArrayList<String> matches = data
                     .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
             sb.populateEditText(matches.toString());
         }
        super.onActivityResult(requestCode,resultCode,data);

    }





    //请求权限      第一次请求被拒绝  第二次弹框将不再提示   需要做无权限的处理
    public void requestPermission(){
        PermissionGen.with(this).addRequestCode(100)
                .permissions(Manifest.permission.READ_CONTACTS,Manifest.permission.CALL_PHONE).request();

       // PermissionGen.needPermission(this,100,new String[]{Manifest.permission.READ_CONTACTS,Manifest.permission.CALL_PHONE});


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this,requestCode,permissions,grantResults);


//        switch (requestCode){
//            case  100:
//                if(grantResults[0]==PackageManager.PERMISSION_DENIED){
//                    //权限未找到
//                    showMessageOKCancel("you not allow permission",null);
//                }else {
//                    //做权限的相应处理
//                }
//                break;
//            default:
//                break;
//        }
    }

    @PermissionSuccess(requestCode = 100)
    public  void success(){
        //请求权限成功
    }

    @PermissionFail(requestCode = 100)
    public void fail(){
        //请求权限失败
    }


    @Override
    public boolean shouldShowRequestPermissionRationale(String permission) {
        return super.shouldShowRequestPermissionRationale(permission);
    }


    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MoveActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


}
