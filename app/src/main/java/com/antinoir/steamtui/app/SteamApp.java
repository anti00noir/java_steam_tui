package com.antinoir.steamtui.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamApp {
    private Integer appid;
    private String name;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppDetails {
    private boolean success;
    private AppData data;
    
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AppData {
        private String name;
        @JsonProperty("steam_appid")
        private Integer steamAppid;
        @JsonProperty("is_free")
        private boolean isFree;
        @JsonProperty("price_overview")
        private PriceOverview priceOverview;
        private Map<String, Object> platforms;
        
        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PriceOverview {
            private String currency;
            private Integer initial;
            private Integer final_price;
            @JsonProperty("discount_percent")
            private Integer discountPercent;
        }
    }
}

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