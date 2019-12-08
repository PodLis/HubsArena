package ru.hubsmc.hubsarena.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum MiItems {

    PYRO_SWORD("sword", "KITPVP_PYROSWORD");

    private final String command;

    MiItems(String itemType, String itemName) {
        this.command = "mi " + itemType + " " + itemName + " ";
    }

    public void giveToPlayer(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command + player.getName());
    }

}
