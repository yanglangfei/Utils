package jucaipen.jucaipen.com.utils.utils;
import org.xutils.http.RequestParams;
import java.util.Map;
/**
 * Created by jucaipen on 16/5/28.
 */
public class NetUtils {

    public  static  RequestParams sendHttpGet(String url, Map<String,Object> param){
        RequestParams p= new RequestParams(url);

        if(param!=null){
            for (Map.Entry<String,Object> entry : param.entrySet()){
                p.addParameter(entry.getKey(),entry.getValue());
            }
        }
        return  p;

    }




}
