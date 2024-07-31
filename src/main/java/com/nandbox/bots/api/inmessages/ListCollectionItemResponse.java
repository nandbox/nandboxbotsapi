package com.nandbox.bots.api.inmessages;

import com.nandbox.bots.api.data.Category;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListCollectionItemResponse {
    private static final String KEY_DATA = "data";
    private List<Category> categories;

    public ListCollectionItemResponse(JSONObject obj) {
        this.categories = new ArrayList<>();
        if (obj.containsKey(KEY_DATA)) {
            JSONArray categoryArray = (JSONArray) obj.get(KEY_DATA);
            for (Object item : categoryArray) {
                JSONObject categoryObj = (JSONObject) item;
                this.categories.add(new Category(categoryObj));
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();
        JSONArray categoriesArray = new JSONArray();

        for (Category category : this.categories) {
            categoriesArray.add(category.toJsonObject());
        }

        if (!this.categories.isEmpty()) {
            obj.put(KEY_DATA, categoriesArray);
        }

        return obj;
    }

    // Getters and setters
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
