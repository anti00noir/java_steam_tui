package com.antinoir.steamtui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDeal {
    private Integer appId;
    private String name;
    private Integer originalPrice;
    private Integer finalPrice;
    private Integer discountPercent;
    private String currency;
    private String storeUrl;
    
    public String toJson() {
        return String.format(
            "{ \n" +
            "  \"appId\": %d,\n" +
            "  \"name\": \"%s\",\n" +
            "  \"discount\": %d,\n" +
            "  \"originalPrice\": %d,\n" +
            "  \"finalPrice\": %d,\n" +
            "  \"currency\": \"%s\",\n" +
            "  \"url\": \"%s\"\n" +
            "}",
            appId, name, discountPercent, originalPrice, finalPrice, currency, storeUrl
        );
    }
}