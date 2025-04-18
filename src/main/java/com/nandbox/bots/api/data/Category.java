package com.nandbox.bots.api.data;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String id;
    private String name;
    private String description;
    private String category;
    private String date;
    private String version;
    private String status;
    private List<Image> images;

    public Category(JSONObject jsonobj) {
        if (jsonobj == null) return;

        this.id = (String) jsonobj.get("id");
        this.name = (String) jsonobj.get("name");
        this.description = (String) jsonobj.get("description");
        this.category = (String) jsonobj.get("category");
        this.date = (String) jsonobj.get("date");
        this.version = (String) jsonobj.get("version");
        this.status = (String) jsonobj.get("status");

        this.images = new ArrayList<>();
        if (jsonobj.containsKey("image")) {
            JSONArray imgArray = (JSONArray) jsonobj.get("image");
            for (Object item : imgArray) {
                JSONObject imgObj = (JSONObject) item;
                this.images.add(new Image(imgObj));
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();

        if (this.id != null) obj.put("id", this.id);
        if (this.name != null) obj.put("name", this.name);
        if (this.description != null) obj.put("description", this.description);
        if (this.category != null) obj.put("category", this.category);
        if (this.date != null) obj.put("date", this.date);
        if (this.version != null) obj.put("version", this.version);
        if (this.status != null) obj.put("status", this.status);

        if (!this.images.isEmpty()) {
            JSONArray imgArray = new JSONArray();
            for (Image image : this.images) {
                imgArray.add(image.toJsonObject());
            }
            obj.put("image", imgArray);
        }

        return obj;
    }

}
