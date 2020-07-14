package com.axxessassignmentapp.application.models;

import com.fasterxml.jackson.annotation.*;

public class Tag {
    private String name;
    private String displayName;
    private long followers;
    private long totalItems;
    private boolean following;
    private boolean isWhitelisted;
    private String backgroundHash;
    private Object thumbnailHash;
    private String accent;
    private boolean backgroundIsAnimated;
    private boolean thumbnailIsAnimated;
    private boolean isPromoted;
    private String description;
    private Object logoHash;
    private Object logoDestinationURL;
    private DescriptionAnnotations descriptionAnnotations;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("display_name")
    public String getDisplayName() { return displayName; }
    @JsonProperty("display_name")
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("followers")
    public long getFollowers() { return followers; }
    @JsonProperty("followers")
    public void setFollowers(long value) { this.followers = value; }

    @JsonProperty("total_items")
    public long getTotalItems() { return totalItems; }
    @JsonProperty("total_items")
    public void setTotalItems(long value) { this.totalItems = value; }

    @JsonProperty("following")
    public boolean getFollowing() { return following; }
    @JsonProperty("following")
    public void setFollowing(boolean value) { this.following = value; }

    @JsonProperty("is_whitelisted")
    public boolean getIsWhitelisted() { return isWhitelisted; }
    @JsonProperty("is_whitelisted")
    public void setIsWhitelisted(boolean value) { this.isWhitelisted = value; }

    @JsonProperty("background_hash")
    public String getBackgroundHash() { return backgroundHash; }
    @JsonProperty("background_hash")
    public void setBackgroundHash(String value) { this.backgroundHash = value; }

    @JsonProperty("thumbnail_hash")
    public Object getThumbnailHash() { return thumbnailHash; }
    @JsonProperty("thumbnail_hash")
    public void setThumbnailHash(Object value) { this.thumbnailHash = value; }

    @JsonProperty("accent")
    public String getAccent() { return accent; }
    @JsonProperty("accent")
    public void setAccent(String value) { this.accent = value; }

    @JsonProperty("background_is_animated")
    public boolean getBackgroundIsAnimated() { return backgroundIsAnimated; }
    @JsonProperty("background_is_animated")
    public void setBackgroundIsAnimated(boolean value) { this.backgroundIsAnimated = value; }

    @JsonProperty("thumbnail_is_animated")
    public boolean getThumbnailIsAnimated() { return thumbnailIsAnimated; }
    @JsonProperty("thumbnail_is_animated")
    public void setThumbnailIsAnimated(boolean value) { this.thumbnailIsAnimated = value; }

    @JsonProperty("is_promoted")
    public boolean getIsPromoted() { return isPromoted; }
    @JsonProperty("is_promoted")
    public void setIsPromoted(boolean value) { this.isPromoted = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("logo_hash")
    public Object getLogoHash() { return logoHash; }
    @JsonProperty("logo_hash")
    public void setLogoHash(Object value) { this.logoHash = value; }

    @JsonProperty("logo_destination_url")
    public Object getLogoDestinationURL() { return logoDestinationURL; }
    @JsonProperty("logo_destination_url")
    public void setLogoDestinationURL(Object value) { this.logoDestinationURL = value; }

    @JsonProperty("description_annotations")
    public DescriptionAnnotations getDescriptionAnnotations() { return descriptionAnnotations; }
    @JsonProperty("description_annotations")
    public void setDescriptionAnnotations(DescriptionAnnotations value) { this.descriptionAnnotations = value; }
}
