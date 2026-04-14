package com.antinoir.steamtui.app;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableCaching
public class SteamApiConfig {
    
    @Bean
    public WebClient steamStoreWebClient() {
        return WebClient.builder()
                .baseUrl("https://store.steampowered.com/api")
                .defaultHeader("User-Agent", "SteamTUI/1.0")
                .build();
    }
    
    @Bean
    public WebClient steamApiWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.steampowered.com")
                .defaultHeader("User-Agent", "SteamTUI/1.0")
                .build();
    }
}