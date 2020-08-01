package com.github.htdangkhoa.tikitestjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlashDealModel {
    /**
     * status : 2
     * url : deal-tracking-testing
     * tags : testhotdeal202
     * discount_percent : 51
     * special_price : 78000
     * special_from_date : 1596258000
     * from_date : 2020-08-01 12:00:00
     * special_to_date : 1596290400
     * progress : {"qty":20,"qty_ordered":1,"qty_remain":19,"percent":95,"status":"progress-bar-success"}
     * product : {"id":20508138,"sku":null,"name":"Áo khoác nhẹ nam nữ đi mưa, chống nắng mẫu mới phong cách hàn quốc","url_path":"ao-khoac-nhe-nam-nu-di-mua-chong-nang-mau-moi-phong-cach-han-quoc-p20508126.html?spid=20508138","price":78000,"list_price":159000,"badges":[],"discount":81000,"rating_average":0,"review_count":0,"order_count":0,"thumbnail_url":"https://salt.tikicdn.com/cache/280x280/ts/product/be/c7/ba/053e1e37e14e56dfd4933103c2cd17b6.jpg","is_visible":true,"is_fresh":false,"is_flower":false,"is_gift_card":false,"inventory":{"product_virtual_type":null,"fulfillment_type":"tiki_delivery"},"url_attendant_input_form":"","master_id":20508126,"seller_product_id":20508138,"price_prefix":"7x.xxx"}
     */

    @SerializedName("status")
    private int status;
    @SerializedName("url")
    private String url;
    @SerializedName("tags")
    private String tags;
    @SerializedName("discount_percent")
    private int discountPercent;
    @SerializedName("special_price")
    private int specialPrice;
    @SerializedName("special_from_date")
    private int specialFromDate;
    @SerializedName("from_date")
    private String fromDate;
    @SerializedName("special_to_date")
    private int specialToDate;
    @SerializedName("progress")
    private ProgressBean progress;
    @SerializedName("product")
    private ProductBean product;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(int specialPrice) {
        this.specialPrice = specialPrice;
    }

    public int getSpecialFromDate() {
        return specialFromDate;
    }

    public void setSpecialFromDate(int specialFromDate) {
        this.specialFromDate = specialFromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public int getSpecialToDate() {
        return specialToDate;
    }

    public void setSpecialToDate(int specialToDate) {
        this.specialToDate = specialToDate;
    }

    public ProgressBean getProgress() {
        return progress;
    }

    public void setProgress(ProgressBean progress) {
        this.progress = progress;
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProgressBean {
        /**
         * qty : 20
         * qty_ordered : 1
         * qty_remain : 19
         * percent : 95
         * status : progress-bar-success
         */

        @SerializedName("qty")
        private int qty;
        @SerializedName("qty_ordered")
        private int qtyOrdered;
        @SerializedName("qty_remain")
        private int qtyRemain;
        @SerializedName("percent")
        private double percent;
        @SerializedName("status")
        private String status;

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public int getQtyOrdered() {
            return qtyOrdered;
        }

        public void setQtyOrdered(int qtyOrdered) {
            this.qtyOrdered = qtyOrdered;
        }

        public int getQtyRemain() {
            return qtyRemain;
        }

        public void setQtyRemain(int qtyRemain) {
            this.qtyRemain = qtyRemain;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class ProductBean {
        /**
         * id : 20508138
         * sku : null
         * name : Áo khoác nhẹ nam nữ đi mưa, chống nắng mẫu mới phong cách hàn quốc
         * url_path : ao-khoac-nhe-nam-nu-di-mua-chong-nang-mau-moi-phong-cach-han-quoc-p20508126.html?spid=20508138
         * price : 78000
         * list_price : 159000
         * badges : []
         * discount : 81000
         * rating_average : 0
         * review_count : 0
         * order_count : 0
         * thumbnail_url : https://salt.tikicdn.com/cache/280x280/ts/product/be/c7/ba/053e1e37e14e56dfd4933103c2cd17b6.jpg
         * is_visible : true
         * is_fresh : false
         * is_flower : false
         * is_gift_card : false
         * inventory : {"product_virtual_type":null,"fulfillment_type":"tiki_delivery"}
         * url_attendant_input_form :
         * master_id : 20508126
         * seller_product_id : 20508138
         * price_prefix : 7x.xxx
         */

        @SerializedName("id")
        private int id;
        @SerializedName("sku")
        private Object sku;
        @SerializedName("name")
        private String name;
        @SerializedName("url_path")
        private String urlPath;
        @SerializedName("price")
        private int price;
        @SerializedName("list_price")
        private int listPrice;
        @SerializedName("discount")
        private int discount;
        @SerializedName("rating_average")
        private int ratingAverage;
        @SerializedName("review_count")
        private int reviewCount;
        @SerializedName("order_count")
        private int orderCount;
        @SerializedName("thumbnail_url")
        private String thumbnailUrl;
        @SerializedName("is_visible")
        private boolean isVisible;
        @SerializedName("is_fresh")
        private boolean isFresh;
        @SerializedName("is_flower")
        private boolean isFlower;
        @SerializedName("is_gift_card")
        private boolean isGiftCard;
        @SerializedName("inventory")
        private InventoryBean inventory;
        @SerializedName("url_attendant_input_form")
        private String urlAttendantInputForm;
        @SerializedName("master_id")
        private int masterId;
        @SerializedName("seller_product_id")
        private int sellerProductId;
        @SerializedName("price_prefix")
        private String pricePrefix;
        @SerializedName("badges")
        private List<Badge> badges;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getSku() {
            return sku;
        }

        public void setSku(Object sku) {
            this.sku = sku;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrlPath() {
            return urlPath;
        }

        public void setUrlPath(String urlPath) {
            this.urlPath = urlPath;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getListPrice() {
            return listPrice;
        }

        public void setListPrice(int listPrice) {
            this.listPrice = listPrice;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getRatingAverage() {
            return ratingAverage;
        }

        public void setRatingAverage(int ratingAverage) {
            this.ratingAverage = ratingAverage;
        }

        public int getReviewCount() {
            return reviewCount;
        }

        public void setReviewCount(int reviewCount) {
            this.reviewCount = reviewCount;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public boolean isIsVisible() {
            return isVisible;
        }

        public void setIsVisible(boolean isVisible) {
            this.isVisible = isVisible;
        }

        public boolean isIsFresh() {
            return isFresh;
        }

        public void setIsFresh(boolean isFresh) {
            this.isFresh = isFresh;
        }

        public boolean isIsFlower() {
            return isFlower;
        }

        public void setIsFlower(boolean isFlower) {
            this.isFlower = isFlower;
        }

        public boolean isIsGiftCard() {
            return isGiftCard;
        }

        public void setIsGiftCard(boolean isGiftCard) {
            this.isGiftCard = isGiftCard;
        }

        public InventoryBean getInventory() {
            return inventory;
        }

        public void setInventory(InventoryBean inventory) {
            this.inventory = inventory;
        }

        public String getUrlAttendantInputForm() {
            return urlAttendantInputForm;
        }

        public void setUrlAttendantInputForm(String urlAttendantInputForm) {
            this.urlAttendantInputForm = urlAttendantInputForm;
        }

        public int getMasterId() {
            return masterId;
        }

        public void setMasterId(int masterId) {
            this.masterId = masterId;
        }

        public int getSellerProductId() {
            return sellerProductId;
        }

        public void setSellerProductId(int sellerProductId) {
            this.sellerProductId = sellerProductId;
        }

        public String getPricePrefix() {
            return pricePrefix;
        }

        public void setPricePrefix(String pricePrefix) {
            this.pricePrefix = pricePrefix;
        }

        public List<Badge> getBadges() {
            return badges;
        }

        public void setBadges(List<Badge> badges) {
            this.badges = badges;
        }

        public static class InventoryBean {
            /**
             * product_virtual_type : null
             * fulfillment_type : tiki_delivery
             */

            @SerializedName("product_virtual_type")
            private Object productVirtualType;
            @SerializedName("fulfillment_type")
            private String fulfillmentType;

            public Object getProductVirtualType() {
                return productVirtualType;
            }

            public void setProductVirtualType(Object productVirtualType) {
                this.productVirtualType = productVirtualType;
            }

            public String getFulfillmentType() {
                return fulfillmentType;
            }

            public void setFulfillmentType(String fulfillmentType) {
                this.fulfillmentType = fulfillmentType;
            }
        }

        public static class Badge {
            @SerializedName("code")
            String code;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
