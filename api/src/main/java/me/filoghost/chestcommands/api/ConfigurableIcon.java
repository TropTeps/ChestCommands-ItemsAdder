/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.chestcommands.api;

import me.filoghost.chestcommands.api.internal.BackendAPI;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * An {@link Icon} that displays an {@link ItemStack} based on its configurable properties.
 *
 * @since 1
 */
public interface ConfigurableIcon extends ClickableIcon {

    /**
     * Creates a new configurable icon with a given material.
     *
     * @param material the material
     * @return the created icon
     * @since 1
     */
    static @NotNull ConfigurableIcon create(@NotNull Material material) {
        return BackendAPI.getImplementation().createConfigurableIcon(material);
    }

    /**
     * Sets the material of the displayed item.
     *
     * @see ItemStack#setType(Material)
     * @since 1
     */
    void setMaterial(@NotNull Material material);

    /**
     * Returns the material of the displayed item.
     *
     * @see ItemStack#getType()
     * @since 1
     */
    @NotNull Material getMaterial();

    /**
     * Sets the amount of the displayed item.
     *
     * @see ItemStack#setAmount(int)
     * @since 1
     */
    void setAmount(int amount);

    /**
     * Returns the amount of the displayed item.
     *
     * @see ItemStack#getAmount()
     * @since 1
     */
    int getAmount();

    /**
     * Sets the durability of the displayed item.
     *
     * @see ItemStack#setDurability(short)
     * @since 1
     */
    void setDurability(short durability);

    /**
     * Returns the durability of the displayed item.
     *
     * @see ItemStack#getDurability()
     * @since 1
     */
    short getDurability();

    /**
     * Sets the NBT data of the displayed item. When creating the rendered item, all other options have higher priority
     * and override NBT values (for example, {@link ConfigurableIcon#setName(String)} overrides the name inside NBT
     * data).
     *
     * @param nbtData the NBT data as JSON string, or null to remove
     * @throws IllegalArgumentException if the NBT data JSON is not valid
     * @since 1
     */
    void setNBTData(@Nullable String nbtData);

    /**
     * Returns the NBT data of the displayed item.
     *
     * @return the NBT data as JSON string, or null if not present
     * @see ConfigurableIcon#setNBTData(String)
     * @since 1
     */
    @Nullable String getNBTData();

    /**
     * Sets the name, which is the first line in the tooltip of the displayed item. Can contain colors.
     *
     * @param name the name, or null to remove
     * @since 1
     */
    void setName(@Nullable String name);

    /**
     * Returns the name.
     *
     * @return the name, or null if not present
     * @see ConfigurableIcon#setName(String)
     * @since 1
     */
    @Nullable String getName();

    /**
     * @param lore the lore as array of lines, or null to remove
     * @see ConfigurableIcon#setLore(List)
     * @since 1
     */
    void setLore(@Nullable String... lore);

    /**
     * Sets the lore, which is displayed below the name when hovering the icon.
     *
     * @param lore the lore as list of lines, or null to remove
     * @since 1
     */
    void setLore(@Nullable List<String> lore);

    /**
     * Returns the lore.
     *
     * @return the lore, or null if not present
     * @see ConfigurableIcon#setLore(List)
     * @since 1
     */
    @Nullable List<String> getLore();

    /**
     * Sets the enchantments of the displayed item.
     *
     * @param enchantments the enchantments map
     * @since 1
     */
    void setEnchantments(@Nullable Map<Enchantment, Integer> enchantments);

    /**
     * Returns the enchantments of the displayed item.
     *
     * @since 1
     */
    @Nullable Map<Enchantment, Integer> getEnchantments();

    /**
     * Adds a level 1 enchantment to the displayed item.
     *
     * @param enchantment the enchantment
     * @since 1
     */
    void addEnchantment(@NotNull Enchantment enchantment);

    /**
     * Add enchantment.
     *
     * @param enchantment the enchantment
     * @param level       the level
     * @since 1
     */
    void addEnchantment(@NotNull Enchantment enchantment, int level);

    /**
     * Remove enchantment.
     *
     * @param enchantment the enchantment
     * @since 1
     */
    void removeEnchantment(Enchantment enchantment);

    /**
     * Returns the leather color.
     *
     * @return the leather color
     * @since 1
     */
    @Nullable Color getLeatherColor();

    /**
     * Sets the leather color.
     *
     * @param leatherColor the leather color
     * @since 1
     */
    void setLeatherColor(@Nullable Color leatherColor);

    /**
     * Returns the skull owner.
     *
     * @return the skull owner
     * @since 1
     */
    @Nullable String getSkullOwner();

    /**
     * Sets the skull owner.
     *
     * @param skullOwner the skull owner
     * @since 1
     */
    void setSkullOwner(@Nullable String skullOwner);

    /**
     * Returns the banner color.
     *
     * @return the banner color
     * @since 1
     */
    @Nullable DyeColor getBannerColor();

    /**
     * Sets the banner color.
     *
     * @param bannerColor the banner color
     * @since 1
     */
    void setBannerColor(@Nullable DyeColor bannerColor);

    /**
     * Returns the banner patterns.
     *
     * @return the banner patterns
     * @since 1
     */
    @Nullable List<Pattern> getBannerPatterns();

    /**
     * Sets the banner patterns.
     *
     * @param bannerPatterns the banner patterns
     * @since 1
     */
    void setBannerPatterns(@Nullable List<Pattern> bannerPatterns);

    /**
     * Sets if the placeholders should be enabled or not.
     *
     * @param enabled the enabled
     * @since 1
     */
    void setPlaceholdersEnabled(boolean enabled);

}
