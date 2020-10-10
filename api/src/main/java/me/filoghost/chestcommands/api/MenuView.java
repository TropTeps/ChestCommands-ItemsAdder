/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.chestcommands.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * A menu view is a rendering of a menu and its icons, made of an {@link Inventory} and {@link ItemStack}s, which can be
 * displayed to a player.
 * <p>
 * Each menu view is linked only to one player, since the menu may contain player-relative placeholders.
 * <p>
 * A new view is created every time a menu is opened for a player.
 *
 * @since 1
 */
public interface MenuView {

    /**
     * Refreshes the current view, reflecting the changes in the icons of the menu and updating placeholders.
     * <p>
     * For example, this method should be called if clicking on an icon changes the amount of money of the player. Note
     * that {@link ClickHandler} exposes the menu view being interacted with, so you don't need to refresh all the views
     * with {@link Menu#refreshOpenMenuViews()}.
     *
     * @since 1
     */
    void refresh();

    /**
     * Returns the player linked to this view.
     *
     * @return the player
     * @since 1
     */
    @NotNull Player getViewer();

    /**
     * Returns the menu that generated this view.
     *
     * @return the menu
     * @since 1
     */
    @NotNull Menu getMenu();

}
