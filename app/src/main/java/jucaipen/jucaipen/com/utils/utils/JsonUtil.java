package jucaipen.jucaipen.com.utils.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import jucaipen.jucaipen.com.utils.model.Advise;

/**
 * Created by jucaipen on 16/5/30.
 */
public class JsonUtil {

    /*
       解析广告信息
     */
    public static List<Advise> getAdvise(String result) {
        List<Advise> advises=new ArrayList<>();
        try {
            JSONArray array=new JSONArray(result);
            for(int i=0;i<array.length();i++){
                JSONObject object=array.getJSONObject(i);
                int id=object.getInt("id");
                String title=object.getString("title");
                int typeId=object.getInt("typeId");
                String linkUrl=object.getString("linkUrl");
                int sortId=object.getInt("sortId");
                Advise advise=new Advise();
                advise.setId(id);
                advise.setTitle(title);
                advise.setTypeId(typeId);
                advise.setLinkUrl(linkUrl);
                advise.setSortId(sortId);
                advises.add(advise);
            }
            return  advises;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
