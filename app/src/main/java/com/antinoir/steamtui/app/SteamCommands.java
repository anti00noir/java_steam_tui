package com.antinoir.steamtui.app;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class SteamCommands {

    private final SteamService steamService;

    public SteamCommands(SteamService steamService) {
        this.steamService = steamService;
    }

    @ShellMethod(key = "random-deal", value = "Fetch a random game on special from Steam")
    public String getRandomDeal() {
        try {
            SteamService.GameDeal deal = steamService.getRandomDiscountedGame();
            // Format output as JSON
            return String.format("{\"appId\": %d, \"name\": \"%s\", \"discount\": \"%d%%\"}",
                    deal.getAppId(), deal.getName(), deal.getDiscountPercent());
        } catch (Exception e) {
            return "{\"error\": \"Failed to fetch game deal: " + e.getMessage() + "\"}";
        }
    }
}
