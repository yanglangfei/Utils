package jucaipen.jucaipen.com.utils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import jucaipen.jucaipen.com.utils.R;

/**
 * Created by jucaipen on 16/6/14.
 *
 *   自定义相册  拍照框架    git项目地址    https://github.com/yanglangfei/GalleryFinal
 */
public class PictureActivity extends Activity{
    private Button openPic;
    private  Button openCam;
    private  Button editPic;
    private  Button scorePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_picture);
        initView();

    }

    private void initView() {
        openPic= (Button) findViewById(R.id.onpenPic);
        openCam= (Button) findViewById(R.id.openCam);
        editPic= (Button) findViewById(R.id.editPic);
        scorePic= (Button) findViewById(R.id.scorePic);

        //打开相册  包含  单选 和多选照片
        openPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFinal.openGallerySingle(100, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        Log.i("111", "onHanlderSuccess: ");
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {
                        Log.i("111", "onHanlderFailure: "+errorMsg);

                    }
                });

            }
        });

        //打开相机
        openCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFinal.openCamera(200, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        Log.i("111", "onHanlderSuccess: camera");
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {
                        Log.i("111", "onHanlderFailure: camera---"+errorMsg);

                    }
                });
            }
        });

        //编辑图片
        editPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFinal.openEdit(400, "path", new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        Log.i("111", "onHanlderSuccess: ");
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {
                        Log.i("111", "onHanlderFailure: ");

                    }
                });

            }
        });

         //裁剪图片
        scorePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryFinal.openCrop(300, "path", new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        Log.i("111", "onHanlderSuccess: ");
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {
                        Log.i("111", "onHanlderFailure: ");

                    }
                });

            }
        });


    }
}
