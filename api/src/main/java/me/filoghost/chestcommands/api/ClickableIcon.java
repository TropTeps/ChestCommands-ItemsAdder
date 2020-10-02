/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.chestcommands.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A simplified {@link Icon} with a settable click handler.
 *
 * @see ConfigurableIcon
 * @see StaticIcon
 * @since 1
 */
public interface ClickableIcon extends Icon {

    /**
     * Sets the click handler for this icon (null to remove it).
     *
     * @since 1
     */
    void setClickHandler(@Nullable ClickHandler clickHandler);

    /**
     * Returns the current click handler (null if not present).
     *
     * @since 1
     */
    @Nullable ClickHandler getClickHandler();

    /**
     * Delegates the click event to the current click handler. This method should not be overridden.
     *
     * @since 1
     */
    @Override
    default @NotNull ClickResult onClick(@NotNull MenuView menuView, @NotNull Player clicker) {
        if (getClickHandler() != null) {
            return getClickHandler().onClick(menuView, clicker);
        } else {
            return ClickResult.KEEP_OPEN;
        }
    }

}
