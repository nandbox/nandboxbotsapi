package com.nandbox.bots.api.data;

import net.minidev.json.JSONObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductItem {

    private static final String KEY_ADDONS = "addons";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_TYPE = "type";
    private static final String KEY_P_CODE = "p_code";
    private static final String KEY_PRICE = "price";
    private static final String KEY_VENDOR = "vendor";
    private static final String KEY_VARIANT = "variant";
    private static final String KEY_ID = "id";
    private static final String KEY_ATTRIBUTE = "attribute";
    private static final String KEY_TAG = "tag";
    private static final String KEY_SKU = "sku";
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_BUNDLE = "bundle";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_ASSIGN_COLLECTION = "assign_collection";
    private static final String KEY_COMPARE_AT_PRICE = "compare_at_price";
    private static final String KEY_MAIN_GROUP_ID = "main_group_id";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_SERVER_ID = "server_id";
    private static final String KEY_VERSION = "version";
    private static final String KEY_GROUP_ID = "group_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SERVICE_PROFILE_ID = "service_profile_id";
    private static final String KEY_CREATED_DATE = "created_date";
    private static final String KEY_UPDATED_DATE = "updated_date";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_STATUS = "status";
    private static final String KEY_OPTION = "option";

    private List<String> addons;
    private String description;
    private String type;
    private String pCode;
    private Double price;
    private String vendor;
    private String variant;
    private String id;
    private Attribute attribute;
    private String tag;
    private String sku;
    private String keyword;
    private String bundle;
    private List<Image> image;
    private String assignCollection;
    private Double compareAtPrice;
    private String mainGroupId;
    private Map<String, Object> params;
    private String serverId;
    private String version;
    private String groupId;
    private String name;
    private String serviceProfileId;
    private String createdDate;
    private String updatedDate;
    private String category;
    private String status;
    private Map<String, Object> option;

    public ProductItem() {}

    public ProductItem(JSONObject obj) {
        this.addons = (List<String>) obj.get(KEY_ADDONS);
        this.description = (String) obj.get(KEY_DESCRIPTION);
        this.type = (String) obj.get(KEY_TYPE);
        this.pCode = (String) obj.get(KEY_P_CODE);
        this.price = (Double) obj.get(KEY_PRICE);
        this.vendor = (String) obj.get(KEY_VENDOR);
        this.variant = (String) obj.get(KEY_VARIANT);
        this.id = (String) obj.get(KEY_ID);
        this.attribute = obj.get(KEY_ATTRIBUTE) != null ? new Attribute((JSONObject) obj.get(KEY_ATTRIBUTE)) : null;
        this.tag = (String) obj.get(KEY_TAG);
        this.sku = (String) obj.get(KEY_SKU);
        this.keyword = (String) obj.get(KEY_KEYWORD);
        this.bundle = (String) obj.get(KEY_BUNDLE);
        this.image = ((List<JSONObject>) obj.get(KEY_IMAGE)).stream().map(Image::new).collect(Collectors.toList());
        this.assignCollection = (String) obj.get(KEY_ASSIGN_COLLECTION);
        this.compareAtPrice = (Double) obj.get(KEY_COMPARE_AT_PRICE);
        this.mainGroupId = (String) obj.get(KEY_MAIN_GROUP_ID);
        this.params = (Map<String, Object>) obj.get(KEY_PARAMS);
        this.serverId = (String) obj.get(KEY_SERVER_ID);
        this.version = (String) obj.get(KEY_VERSION);
        this.groupId = (String) obj.get(KEY_GROUP_ID);
        this.name = (String) obj.get(KEY_NAME);
        this.serviceProfileId = (String) obj.get(KEY_SERVICE_PROFILE_ID);
        this.createdDate = (String) obj.get(KEY_CREATED_DATE);
        this.updatedDate = (String) obj.get(KEY_UPDATED_DATE);
        this.category = (String) obj.get(KEY_CATEGORY);
        this.status = (String) obj.get(KEY_STATUS);
        this.option = (Map<String, Object>) obj.get(KEY_OPTION);
    }

    public JSONObject toJsonObject() {
        JSONObject obj = new JSONObject();

        if (addons != null) obj.put(KEY_ADDONS, addons);
        if (description != null) obj.put(KEY_DESCRIPTION, description);
        if (type != null) obj.put(KEY_TYPE, type);
        if (pCode != null) obj.put(KEY_P_CODE, pCode);
        if (price != null) obj.put(KEY_PRICE, price);
        if (vendor != null) obj.put(KEY_VENDOR, vendor);
        if (variant != null) obj.put(KEY_VARIANT, variant);
        if (id != null) obj.put(KEY_ID, id);
        if (attribute != null) obj.put(KEY_ATTRIBUTE, attribute.toJsonObject());
        if (tag != null) obj.put(KEY_TAG, tag);
        if (sku != null) obj.put(KEY_SKU, sku);
        if (keyword != null) obj.put(KEY_KEYWORD, keyword);
        if (bundle != null) obj.put(KEY_BUNDLE, bundle);
        if (image != null) obj.put(KEY_IMAGE, image.stream().map(Image::toJsonObject).collect(Collectors.toList()));
        if (assignCollection != null) obj.put(KEY_ASSIGN_COLLECTION, assignCollection);
        if (compareAtPrice != null) obj.put(KEY_COMPARE_AT_PRICE, compareAtPrice);
        if (mainGroupId != null) obj.put(KEY_MAIN_GROUP_ID, mainGroupId);
        if (params != null) obj.put(KEY_PARAMS, params);
        if (serverId != null) obj.put(KEY_SERVER_ID, serverId);
        if (version != null) obj.put(KEY_VERSION, version);
        if (groupId != null) obj.put(KEY_GROUP_ID, groupId);
        if (name != null) obj.put(KEY_NAME, name);
        if (serviceProfileId != null) obj.put(KEY_SERVICE_PROFILE_ID, serviceProfileId);
        if (createdDate != null) obj.put(KEY_CREATED_DATE, createdDate);
        if (updatedDate != null) obj.put(KEY_UPDATED_DATE, updatedDate);
        if (category != null) obj.put(KEY_CATEGORY, category);
        if (status != null) obj.put(KEY_STATUS, status);
        if (option != null) obj.put(KEY_OPTION, option);

        return obj;
    }

    public static class Attribute {
        private static final String KEY_COST = "cost";
        private static final String KEY_QUANTITY = "quantity";
        private static final String KEY_HAS_SKU_OR_BARCODE = "hasSkuOrBarcode";
        private static final String KEY_TAX = "tax";
        private static final String KEY_MESSAGE = "message";
        private static final String KEY_BARCODE = "barcode";

        private Double cost;
        private Integer quantity;
        private Boolean hasSkuOrBarcode;
        private Double tax;
        private String message;
        private String barcode;

        public Attribute(JSONObject attribute) {
            this.cost = (Double) attribute.get(KEY_COST);
            this.quantity = (Integer) attribute.get(KEY_QUANTITY);
            this.hasSkuOrBarcode = (Boolean) attribute.get(KEY_HAS_SKU_OR_BARCODE);
            this.tax = (Double) attribute.get(KEY_TAX);
            this.message = (String) attribute.get(KEY_MESSAGE);
            this.barcode = (String) attribute.get(KEY_BARCODE);
        }

        public JSONObject toJsonObject() {
            JSONObject obj = new JSONObject();
            if (cost != null) obj.put(KEY_COST, cost);
            if (quantity != null) obj.put(KEY_QUANTITY, quantity);
            if (hasSkuOrBarcode != null) obj.put(KEY_HAS_SKU_OR_BARCODE, hasSkuOrBarcode);
            if (tax != null) obj.put(KEY_TAX, tax);
            if (message != null) obj.put(KEY_MESSAGE, message);
            if (barcode != null) obj.put(KEY_BARCODE, barcode);
            return obj;
        }
    }

    public static class Image {
        private static final String KEY_WIDTH = "width";
        private static final String KEY_URL = "url";
        private static final String KEY_HEIGHT = "height";

        private Integer width;
        private String url;
        private Integer height;

        public Image(JSONObject img) {
            this.width = (Integer) img.get(KEY_WIDTH);
            this.url = (String) img.get(KEY_URL);
            this.height = (Integer) img.get(KEY_HEIGHT);
        }

        public JSONObject toJsonObject() {
            JSONObject obj = new JSONObject();
            if (width != null) obj.put(KEY_WIDTH, width);
            if (url != null) obj.put(KEY_URL, url);
            if (height != null) obj.put(KEY_HEIGHT, height);
            return obj;
        }
    }


}
