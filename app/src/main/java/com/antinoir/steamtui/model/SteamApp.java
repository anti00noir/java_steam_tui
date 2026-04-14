package com.antinoir.steamtui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamApp {
    private Integer appid;
    private String name;
}