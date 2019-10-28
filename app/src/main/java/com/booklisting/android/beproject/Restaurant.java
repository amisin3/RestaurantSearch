package com.booklisting.android.beproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable {

    @SerializedName("R")
    @Expose
    private R_ r;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location_ location;
    @SerializedName("switch_to_order_menu")
    @Expose
    private Integer switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    private String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    private Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("offers")
    @Expose
    private List<Object> offers = null;
    @SerializedName("zomato_events")
    @Expose
    private List<ZomatoEvent> zomatoEvents = null;
    @SerializedName("opentable_support")
    @Expose
    private Integer opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    private Integer isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    private String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    private Integer isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    private String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    private String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("photos_url")
    @Expose
    private String photosUrl;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    private String featuredImage;
    @SerializedName("medio_provider")
    @Expose
    private Integer medioProvider;
    @SerializedName("has_online_delivery")
    @Expose
    private Integer hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    private Integer isDeliveringNow;
    @SerializedName("include_bogo_offers")
    @Expose
    private Boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("order_url")
    @Expose
    private String orderUrl;
    @SerializedName("order_deeplink")
    @Expose
    private String orderDeeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    private Integer isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    private Integer hasTableBooking;
    @SerializedName("book_url")
    @Expose
    private String bookUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;

    public Restaurant(R_ r, String apikey, String id, String name, String url, Location_ location, Integer switchToOrderMenu, String cuisines, Integer averageCostForTwo, Integer priceRange, String currency, List<Object> offers, List<ZomatoEvent> zomatoEvents, Integer opentableSupport, Integer isZomatoBookRes, String mezzoProvider, Integer isBookFormWebView, String bookFormWebViewUrl, String bookAgainUrl, String thumb, UserRating userRating, String photosUrl, String menuUrl, String featuredImage, Integer medioProvider, Integer hasOnlineDelivery, Integer isDeliveringNow, Boolean includeBogoOffers, String deeplink, String orderUrl, String orderDeeplink, Integer isTableReservationSupported, Integer hasTableBooking, String bookUrl, String eventsUrl) {
        this.r = r;
        this.apikey = apikey;
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.switchToOrderMenu = switchToOrderMenu;
        this.cuisines = cuisines;
        this.averageCostForTwo = averageCostForTwo;
        this.priceRange = priceRange;
        this.currency = currency;
        this.offers = offers;
        this.zomatoEvents = zomatoEvents;
        this.opentableSupport = opentableSupport;
        this.isZomatoBookRes = isZomatoBookRes;
        this.mezzoProvider = mezzoProvider;
        this.isBookFormWebView = isBookFormWebView;
        this.bookFormWebViewUrl = bookFormWebViewUrl;
        this.bookAgainUrl = bookAgainUrl;
        this.thumb = thumb;
        this.userRating = userRating;
        this.photosUrl = photosUrl;
        this.menuUrl = menuUrl;
        this.featuredImage = featuredImage;
        this.medioProvider = medioProvider;
        this.hasOnlineDelivery = hasOnlineDelivery;
        this.isDeliveringNow = isDeliveringNow;
        this.includeBogoOffers = includeBogoOffers;
        this.deeplink = deeplink;
        this.orderUrl = orderUrl;
        this.orderDeeplink = orderDeeplink;
        this.isTableReservationSupported = isTableReservationSupported;
        this.hasTableBooking = hasTableBooking;
        this.bookUrl = bookUrl;
        this.eventsUrl = eventsUrl;
    }

    public R_ getR() {
        return r;
    }

    public void setR(R_ r) {
        this.r = r;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location_ getLocation() {
        return location;
    }

    public void setLocation(Location_ location) {
        this.location = location;
    }

    public Integer getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public void setSwitchToOrderMenu(Integer switchToOrderMenu) {
        this.switchToOrderMenu = switchToOrderMenu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public Integer getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(Integer averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public List<ZomatoEvent> getZomatoEvents() {
        return zomatoEvents;
    }

    public void setZomatoEvents(List<ZomatoEvent> zomatoEvents) {
        this.zomatoEvents = zomatoEvents;
    }

    public Integer getOpentableSupport() {
        return opentableSupport;
    }

    public void setOpentableSupport(Integer opentableSupport) {
        this.opentableSupport = opentableSupport;
    }

    public Integer getIsZomatoBookRes() {
        return isZomatoBookRes;
    }

    public void setIsZomatoBookRes(Integer isZomatoBookRes) {
        this.isZomatoBookRes = isZomatoBookRes;
    }

    public String getMezzoProvider() {
        return mezzoProvider;
    }

    public void setMezzoProvider(String mezzoProvider) {
        this.mezzoProvider = mezzoProvider;
    }

    public Integer getIsBookFormWebView() {
        return isBookFormWebView;
    }

    public void setIsBookFormWebView(Integer isBookFormWebView) {
        this.isBookFormWebView = isBookFormWebView;
    }

    public String getBookFormWebViewUrl() {
        return bookFormWebViewUrl;
    }

    public void setBookFormWebViewUrl(String bookFormWebViewUrl) {
        this.bookFormWebViewUrl = bookFormWebViewUrl;
    }

    public String getBookAgainUrl() {
        return bookAgainUrl;
    }

    public void setBookAgainUrl(String bookAgainUrl) {
        this.bookAgainUrl = bookAgainUrl;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public Integer getMedioProvider() {
        return medioProvider;
    }

    public void setMedioProvider(Integer medioProvider) {
        this.medioProvider = medioProvider;
    }

    public Integer getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public void setHasOnlineDelivery(Integer hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    public Integer getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public void setIsDeliveringNow(Integer isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    public Boolean getIncludeBogoOffers() {
        return includeBogoOffers;
    }

    public void setIncludeBogoOffers(Boolean includeBogoOffers) {
        this.includeBogoOffers = includeBogoOffers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getOrderDeeplink() {
        return orderDeeplink;
    }

    public void setOrderDeeplink(String orderDeeplink) {
        this.orderDeeplink = orderDeeplink;
    }

    public Integer getIsTableReservationSupported() {
        return isTableReservationSupported;
    }

    public void setIsTableReservationSupported(Integer isTableReservationSupported) {
        this.isTableReservationSupported = isTableReservationSupported;
    }

    public Integer getHasTableBooking() {
        return hasTableBooking;
    }

    public void setHasTableBooking(Integer hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "r=" + r +
                ", apikey='" + apikey + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", location=" + location +
                ", switchToOrderMenu=" + switchToOrderMenu +
                ", cuisines='" + cuisines + '\'' +
                ", averageCostForTwo=" + averageCostForTwo +
                ", priceRange=" + priceRange +
                ", currency='" + currency + '\'' +
                ", offers=" + offers +
                ", zomatoEvents=" + zomatoEvents +
                ", opentableSupport=" + opentableSupport +
                ", isZomatoBookRes=" + isZomatoBookRes +
                ", mezzoProvider='" + mezzoProvider + '\'' +
                ", isBookFormWebView=" + isBookFormWebView +
                ", bookFormWebViewUrl='" + bookFormWebViewUrl + '\'' +
                ", bookAgainUrl='" + bookAgainUrl + '\'' +
                ", thumb='" + thumb + '\'' +
                ", userRating=" + userRating +
                ", photosUrl='" + photosUrl + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", featuredImage='" + featuredImage + '\'' +
                ", medioProvider=" + medioProvider +
                ", hasOnlineDelivery=" + hasOnlineDelivery +
                ", isDeliveringNow=" + isDeliveringNow +
                ", includeBogoOffers=" + includeBogoOffers +
                ", deeplink='" + deeplink + '\'' +
                ", orderUrl='" + orderUrl + '\'' +
                ", orderDeeplink='" + orderDeeplink + '\'' +
                ", isTableReservationSupported=" + isTableReservationSupported +
                ", hasTableBooking=" + hasTableBooking +
                ", bookUrl='" + bookUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                '}';
    }
}
