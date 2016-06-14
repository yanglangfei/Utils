package jucaipen.jucaipen.com.utils.utils;
import org.xutils.http.RequestParams;

import java.io.IOException;
import java.util.Map;

import sexy.code.FormBody;
import sexy.code.HttPizza;
import sexy.code.MediaType;
import sexy.code.Request;
import sexy.code.RequestBody;
import sexy.code.Response;

/**
 * Created by jucaipen on 16/5/28.
 *
 *    HttPizza 封装请求 git 项目地址  https://github.com/yanglangfei/HttPizza
 */
public class NetUtils {

    public  static  RequestParams sendXutilsGet(String url, Map<String,Object> param){
        RequestParams p= new RequestParams(url);

        if(param!=null){
            for (Map.Entry<String,Object> entry : param.entrySet()){
                p.addParameter(entry.getKey(),entry.getValue());
            }
        }
        return  p;

    }


    /*
       get  请求
     */
    public static  String sendHttpGet(String url,Map<String,Object> param){
        try {
            StringBuffer buffer=new StringBuffer(url);
            HttPizza client=new HttPizza();
            if(param!=null&&param.size()>0){
                 buffer.append("?");
                for(Map.Entry<String,Object> p : param.entrySet()){
                    buffer.append(p.getKey());
                    buffer.append("=");
                    buffer.append(p.getValue());
                    buffer.append("&");
                }
                buffer.delete(buffer.length()-1,buffer.length());
            }
            Request request=client.newRequest().url(buffer.toString()).get().build();
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()){
                return  response.message();
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }


    }

    /*
       post 请求
     */
    public static String sendHttpPost(String url,Map<String,Object> params){
        try {
            HttPizza client=new HttPizza();
            FormBody.Builder form = new FormBody.Builder();

            if(params!=null){
                for(Map.Entry<String,Object> p : params.entrySet()){
                    form.add(p.getKey(),p.getValue()+"");
                }
            }
            Request request=client.newRequest().url(url).post(form.build()).build();
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()){
                return  response.message();
            }else{
                return  null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

}
