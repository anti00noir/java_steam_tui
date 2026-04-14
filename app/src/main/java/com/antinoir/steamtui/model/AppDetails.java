package com.antinoir.steamtui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Map;

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
            @JsonProperty("final")
            private Integer final_price;
            @JsonProperty("discount_percent")
            private Integer discountPercent;
        }
    }
}