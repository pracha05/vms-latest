package com.vms.customer.model.vehiclesearch;

import com.google.gson.annotations.SerializedName;

public class Vehicles {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("body_type")
    private String bodyType;
    @SerializedName("images")
    private String images;
    @SerializedName("size")
    private String size;

    public Vehicles(String id, String name, String bodyType, String images, String size){
        this.setId(id);
        this.setName(name);
        this.setBodyType(bodyType);
        this.setImages(images);
        this.setSize(size);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
