package com.vms.customer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SelMaterialCategory {
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("message")
    @Expose
    public List<Message> message = null;
    @SerializedName("image_path")
    @Expose
    public String imagePath;
    public class Message {

        @SerializedName("cat_id")
        @Expose
        public String catId;
        @SerializedName("cat_name")
        @Expose
        public String catName;
        @SerializedName("cat_img")
        @Expose
        public String catImg;

    }
}
