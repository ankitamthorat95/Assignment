package com.axxessassignmentapp.application.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.*;

public class Image implements Parcelable {
    private String id;
    private Object title;
    private String description;
    private long datetime;
    private String type;
    private boolean animated;
    private long width;
    private long height;
    private long size;
    private long views;
    private long bandwidth;
    private Object vote;
    private boolean favorite;
    private Object nsfw;
    private Object section;
    private Object accountURL;
    private Object accountID;
    private boolean isAd;
    private boolean inMostViral;
    private boolean hasSound;
    private Object[] tags;
    private long adType;
    private String adURL;
    private String edited;
    private boolean inGallery;
    private String link;
    private Object commentCount;
    private Object favoriteCount;
    private Object ups;
    private Object downs;
    private Object points;
    private Object score;

    public Image() {
    }

    public Image(Parcel in) {
        id = in.readString();
        description = in.readString();
        datetime = in.readLong();
        type = in.readString();
        animated = in.readByte() != 0;
        width = in.readLong();
        height = in.readLong();
        size = in.readLong();
        views = in.readLong();
        bandwidth = in.readLong();
        favorite = in.readByte() != 0;
        isAd = in.readByte() != 0;
        inMostViral = in.readByte() != 0;
        hasSound = in.readByte() != 0;
        adType = in.readLong();
        adURL = in.readString();
        edited = in.readString();
        inGallery = in.readByte() != 0;
        link = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("title")
    public Object getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(Object value) { this.title = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("datetime")
    public long getDatetime() { return datetime; }
    @JsonProperty("datetime")
    public void setDatetime(long value) { this.datetime = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("animated")
    public boolean getAnimated() { return animated; }
    @JsonProperty("animated")
    public void setAnimated(boolean value) { this.animated = value; }

    @JsonProperty("width")
    public long getWidth() { return width; }
    @JsonProperty("width")
    public void setWidth(long value) { this.width = value; }

    @JsonProperty("height")
    public long getHeight() { return height; }
    @JsonProperty("height")
    public void setHeight(long value) { this.height = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }

    @JsonProperty("views")
    public long getViews() { return views; }
    @JsonProperty("views")
    public void setViews(long value) { this.views = value; }

    @JsonProperty("bandwidth")
    public long getBandwidth() { return bandwidth; }
    @JsonProperty("bandwidth")
    public void setBandwidth(long value) { this.bandwidth = value; }

    @JsonProperty("vote")
    public Object getVote() { return vote; }
    @JsonProperty("vote")
    public void setVote(Object value) { this.vote = value; }

    @JsonProperty("favorite")
    public boolean getFavorite() { return favorite; }
    @JsonProperty("favorite")
    public void setFavorite(boolean value) { this.favorite = value; }

    @JsonProperty("nsfw")
    public Object getNsfw() { return nsfw; }
    @JsonProperty("nsfw")
    public void setNsfw(Object value) { this.nsfw = value; }

    @JsonProperty("section")
    public Object getSection() { return section; }
    @JsonProperty("section")
    public void setSection(Object value) { this.section = value; }

    @JsonProperty("account_url")
    public Object getAccountURL() { return accountURL; }
    @JsonProperty("account_url")
    public void setAccountURL(Object value) { this.accountURL = value; }

    @JsonProperty("account_id")
    public Object getAccountID() { return accountID; }
    @JsonProperty("account_id")
    public void setAccountID(Object value) { this.accountID = value; }

    @JsonProperty("is_ad")
    public boolean getIsAd() { return isAd; }
    @JsonProperty("is_ad")
    public void setIsAd(boolean value) { this.isAd = value; }

    @JsonProperty("in_most_viral")
    public boolean getInMostViral() { return inMostViral; }
    @JsonProperty("in_most_viral")
    public void setInMostViral(boolean value) { this.inMostViral = value; }

    @JsonProperty("has_sound")
    public boolean getHasSound() { return hasSound; }
    @JsonProperty("has_sound")
    public void setHasSound(boolean value) { this.hasSound = value; }

    @JsonProperty("tags")
    public Object[] getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(Object[] value) { this.tags = value; }

    @JsonProperty("ad_type")
    public long getAdType() { return adType; }
    @JsonProperty("ad_type")
    public void setAdType(long value) { this.adType = value; }

    @JsonProperty("ad_url")
    public String getAdURL() { return adURL; }
    @JsonProperty("ad_url")
    public void setAdURL(String value) { this.adURL = value; }

    @JsonProperty("edited")
    public String getEdited() { return edited; }
    @JsonProperty("edited")
    public void setEdited(String value) { this.edited = value; }

    @JsonProperty("in_gallery")
    public boolean getInGallery() { return inGallery; }
    @JsonProperty("in_gallery")
    public void setInGallery(boolean value) { this.inGallery = value; }

    @JsonProperty("link")
    public String getLink() { return link; }
    @JsonProperty("link")
    public void setLink(String value) { this.link = value; }

    @JsonProperty("comment_count")
    public Object getCommentCount() { return commentCount; }
    @JsonProperty("comment_count")
    public void setCommentCount(Object value) { this.commentCount = value; }

    @JsonProperty("favorite_count")
    public Object getFavoriteCount() { return favoriteCount; }
    @JsonProperty("favorite_count")
    public void setFavoriteCount(Object value) { this.favoriteCount = value; }

    @JsonProperty("ups")
    public Object getUPS() { return ups; }
    @JsonProperty("ups")
    public void setUPS(Object value) { this.ups = value; }

    @JsonProperty("downs")
    public Object getDowns() { return downs; }
    @JsonProperty("downs")
    public void setDowns(Object value) { this.downs = value; }

    @JsonProperty("points")
    public Object getPoints() { return points; }
    @JsonProperty("points")
    public void setPoints(Object value) { this.points = value; }

    @JsonProperty("score")
    public Object getScore() { return score; }
    @JsonProperty("score")
    public void setScore(Object value) { this.score = value; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(description);
        dest.writeLong(datetime);
        dest.writeString(type);
        dest.writeByte((byte) (animated ? 1 : 0));
        dest.writeLong(width);
        dest.writeLong(height);
        dest.writeLong(size);
        dest.writeLong(views);
        dest.writeLong(bandwidth);
        dest.writeByte((byte) (favorite ? 1 : 0));
        dest.writeByte((byte) (isAd ? 1 : 0));
        dest.writeByte((byte) (inMostViral ? 1 : 0));
        dest.writeByte((byte) (hasSound ? 1 : 0));
        dest.writeLong(adType);
        dest.writeString(adURL);
        dest.writeString(edited);
        dest.writeByte((byte) (inGallery ? 1 : 0));
        dest.writeString(link);
    }
}
