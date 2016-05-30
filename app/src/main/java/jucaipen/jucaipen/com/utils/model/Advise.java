package jucaipen.jucaipen.com.utils.model;

import java.io.Serializable;

/**
 * Created by jucaipen on 16/5/30.
 *
 * 广告
 */
public class Advise implements Serializable{
    /**
     *   id
     */
    private  int id;

    /**
     * 广告标题
     */
    private  String title;
    /**
     * 分类ID
     */
    private  int typeId;
    /**
     * 链接地址
     */
    private  String linkUrl;
    /**
     * 分类ID
     */
    private  int sortId;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public int getSortId() {
        return sortId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }
}
