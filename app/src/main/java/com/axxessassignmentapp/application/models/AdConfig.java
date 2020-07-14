package com.axxessassignmentapp.application.models;

import com.fasterxml.jackson.annotation.*;

public class AdConfig {
    private String[] safeFlags;
    private Object[] highRiskFlags;
    private String[] unsafeFlags;
    private Object[] wallUnsafeFlags;
    private boolean showsAds;

    @JsonProperty("safeFlags")
    public String[] getSafeFlags() { return safeFlags; }
    @JsonProperty("safeFlags")
    public void setSafeFlags(String[] value) { this.safeFlags = value; }

    @JsonProperty("highRiskFlags")
    public Object[] getHighRiskFlags() { return highRiskFlags; }
    @JsonProperty("highRiskFlags")
    public void setHighRiskFlags(Object[] value) { this.highRiskFlags = value; }

    @JsonProperty("unsafeFlags")
    public String[] getUnsafeFlags() { return unsafeFlags; }
    @JsonProperty("unsafeFlags")
    public void setUnsafeFlags(String[] value) { this.unsafeFlags = value; }

    @JsonProperty("wallUnsafeFlags")
    public Object[] getWallUnsafeFlags() { return wallUnsafeFlags; }
    @JsonProperty("wallUnsafeFlags")
    public void setWallUnsafeFlags(Object[] value) { this.wallUnsafeFlags = value; }

    @JsonProperty("showsAds")
    public boolean getShowsAds() { return showsAds; }
    @JsonProperty("showsAds")
    public void setShowsAds(boolean value) { this.showsAds = value; }
}
