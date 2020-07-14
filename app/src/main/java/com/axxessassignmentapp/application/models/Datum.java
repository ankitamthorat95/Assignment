package com.axxessassignmentapp.application.models;

import com.fasterxml.jackson.annotation.*;

import java.util.Arrays;

public class Datum {
    private String id;
    private String title;
    private Object description;
    private long datetime;
    private String cover;
    private long coverWidth;
    private long coverHeight;
    private String accountURL;
    private long accountID;
    private String privacy;
    private String layout;
    private long views;
    private String link;
    private long ups;
    private long downs;
    private long points;
    private long score;
    private boolean isAlbum;
    private Object vote;
    private boolean favorite;
    private boolean nsfw;
    private String section;
    private long commentCount;
    private long favoriteCount;
    private String topic;
    private long topicID;
    private long imagesCount;
    private boolean inGallery;
    private boolean isAd;
    private Tag[] tags;
    private long adType;
    private String adURL;
    private boolean inMostViral;
    private boolean includeAlbumAds;
    private Image[] images;
    private AdConfig adConfig;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("description")
    public Object getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Object value) { this.description = value; }

    @JsonProperty("datetime")
    public long getDatetime() { return datetime; }
    @JsonProperty("datetime")
    public void setDatetime(long value) { this.datetime = value; }

    @JsonProperty("cover")
    public String getCover() { return cover; }
    @JsonProperty("cover")
    public void setCover(String value) { this.cover = value; }

    @JsonProperty("cover_width")
    public long getCoverWidth() { return coverWidth; }
    @JsonProperty("cover_width")
    public void setCoverWidth(long value) { this.coverWidth = value; }

    @JsonProperty("cover_height")
    public long getCoverHeight() { return coverHeight; }
    @JsonProperty("cover_height")
    public void setCoverHeight(long value) { this.coverHeight = value; }

    @JsonProperty("account_url")
    public String getAccountURL() { return accountURL; }
    @JsonProperty("account_url")
    public void setAccountURL(String value) { this.accountURL = value; }

    @JsonProperty("account_id")
    public long getAccountID() { return accountID; }
    @JsonProperty("account_id")
    public void setAccountID(long value) { this.accountID = value; }

    @JsonProperty("privacy")
    public String getPrivacy() { return privacy; }
    @JsonProperty("privacy")
    public void setPrivacy(String value) { this.privacy = value; }

    @JsonProperty("layout")
    public String getLayout() { return layout; }
    @JsonProperty("layout")
    public void setLayout(String value) { this.layout = value; }

    @JsonProperty("views")
    public long getViews() { return views; }
    @JsonProperty("views")
    public void setViews(long value) { this.views = value; }

    @JsonProperty("link")
    public String getLink() { return link; }
    @JsonProperty("link")
    public void setLink(String value) { this.link = value; }

    @JsonProperty("ups")
    public long getUPS() { return ups; }
    @JsonProperty("ups")
    public void setUPS(long value) { this.ups = value; }

    @JsonProperty("downs")
    public long getDowns() { return downs; }
    @JsonProperty("downs")
    public void setDowns(long value) { this.downs = value; }

    @JsonProperty("points")
    public long getPoints() { return points; }
    @JsonProperty("points")
    public void setPoints(long value) { this.points = value; }

    @JsonProperty("score")
    public long getScore() { return score; }
    @JsonProperty("score")
    public void setScore(long value) { this.score = value; }

    @JsonProperty("is_album")
    public boolean getIsAlbum() { return isAlbum; }
    @JsonProperty("is_album")
    public void setIsAlbum(boolean value) { this.isAlbum = value; }

    @JsonProperty("vote")
    public Object getVote() { return vote; }
    @JsonProperty("vote")
    public void setVote(Object value) { this.vote = value; }

    @JsonProperty("favorite")
    public boolean getFavorite() { return favorite; }
    @JsonProperty("favorite")
    public void setFavorite(boolean value) { this.favorite = value; }

    @JsonProperty("nsfw")
    public boolean getNsfw() { return nsfw; }
    @JsonProperty("nsfw")
    public void setNsfw(boolean value) { this.nsfw = value; }

    @JsonProperty("section")
    public String getSection() { return section; }
    @JsonProperty("section")
    public void setSection(String value) { this.section = value; }

    @JsonProperty("comment_count")
    public long getCommentCount() { return commentCount; }
    @JsonProperty("comment_count")
    public void setCommentCount(long value) { this.commentCount = value; }

    @JsonProperty("favorite_count")
    public long getFavoriteCount() { return favoriteCount; }
    @JsonProperty("favorite_count")
    public void setFavoriteCount(long value) { this.favoriteCount = value; }

    @JsonProperty("topic")
    public String getTopic() { return topic; }
    @JsonProperty("topic")
    public void setTopic(String value) { this.topic = value; }

    @JsonProperty("topic_id")
    public long getTopicID() { return topicID; }
    @JsonProperty("topic_id")
    public void setTopicID(long value) { this.topicID = value; }

    @JsonProperty("images_count")
    public long getImagesCount() { return imagesCount; }
    @JsonProperty("images_count")
    public void setImagesCount(long value) { this.imagesCount = value; }

    @JsonProperty("in_gallery")
    public boolean getInGallery() { return inGallery; }
    @JsonProperty("in_gallery")
    public void setInGallery(boolean value) { this.inGallery = value; }

    @JsonProperty("is_ad")
    public boolean getIsAd() { return isAd; }
    @JsonProperty("is_ad")
    public void setIsAd(boolean value) { this.isAd = value; }

    @JsonProperty("tags")
    public Tag[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(Tag[] value) { this.tags = value; }

    @JsonProperty("ad_type")
    public long getAdType() { return adType; }
    @JsonProperty("ad_type")
    public void setAdType(long value) { this.adType = value; }

    @JsonProperty("ad_url")
    public String getAdURL() { return adURL; }
    @JsonProperty("ad_url")
    public void setAdURL(String value) { this.adURL = value; }

    @JsonProperty("in_most_viral")
    public boolean getInMostViral() { return inMostViral; }
    @JsonProperty("in_most_viral")
    public void setInMostViral(boolean value) { this.inMostViral = value; }

    @JsonProperty("include_album_ads")
    public boolean getIncludeAlbumAds() { return includeAlbumAds; }
    @JsonProperty("include_album_ads")
    public void setIncludeAlbumAds(boolean value) { this.includeAlbumAds = value; }

    @JsonProperty("images")
    public Image[] getImages() { return images; }
    @JsonProperty("images")
    public void setImages(Image[] value) { this.images = value; }

    @JsonProperty("ad_config")
    public AdConfig getAdConfig() { return adConfig; }
    @JsonProperty("ad_config")
    public void setAdConfig(AdConfig value) { this.adConfig = value; }

    @Override
    public String toString() {
        return "Datum{" +
                "images=" + Arrays.toString(images) +
                '}';
    }
}
