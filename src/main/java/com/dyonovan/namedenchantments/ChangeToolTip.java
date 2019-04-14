package com.dyonovan.namedenchantments;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class ChangeToolTip {

    private static final KeyBinding keyBindSneak = Minecraft.getMinecraft().gameSettings.keyBindSneak;

    ChangeToolTip() {
    }

    @SubscribeEvent
    public void changeToolTip(ItemTooltipEvent event) {

        ItemStack itemStack = event.getItemStack();

        if (itemStack.hasTagCompound()) {
            NBTTagCompound tagCompound = itemStack.getTagCompound();
            NBTTagList tagList = null;

            if (tagCompound != null && (tagCompound.hasKey("StoredEnchantments") || tagCompound.hasKey("ench"))) {

                if (tagCompound.hasKey("StoredEnchantments")) {
                    tagList = tagCompound.getTagList("StoredEnchantments", 10);
                } else if (tagCompound.hasKey("ench")) {
                    tagList = tagCompound.getTagList("ench", 10);
                }

                List<String> tooltip = event.getToolTip();
                if (!GameSettings.isKeyDown(keyBindSneak)) {
                    tooltip.add(I18n.format("namedenchantments:tooltip.activate", ChatFormatting.RED, keyBindSneak.getDisplayName(), ChatFormatting.GRAY));
                } else {
                    for (int i = 0; i < tagList.tagCount(); i++) {
                        NBTTagCompound tag = tagList.getCompoundTagAt(i);
                        short s = tag.getShort("id");
                        switch (s) {
                            case 0:
                                tooltip.add(I18n.format("namedenchantments:enchant.protection"));
                                break;
                            case 1:
                                tooltip.add(I18n.format("namedenchantments:enchant.fireprotection"));
                                break;
                            case 2:
                                tooltip.add(I18n.format("namedenchantments:enchant.featherfalling"));
                                break;
                            case 3:
                                tooltip.add(I18n.format("namedenchantments:enchant.blastprotection"));
                                break;
                            case 4:
                                tooltip.add(I18n.format("namedenchantments:enchant.projectileprotection"));
                                break;
                            case 5:
                                tooltip.add(I18n.format("namedenchantments:enchant.respiration"));
                                break;
                            case 6:
                                tooltip.add(I18n.format("namedenchantments:enchant.aquainfinity"));
                                break;
                            case 7:
                                tooltip.add(I18n.format("namedenchantments:enchant.thorns"));
                                break;
                            case 8:
                                tooltip.add(I18n.format("namedenchantments:enchant.depthstrider"));
                                break;
                            case 9:
                                tooltip.add(I18n.format("namedenchantments:enchant.frostwalker"));
                                break;
                            case 10:
                                tooltip.add(I18n.format("namedenchantments:enchant.curseofbinding"));
                                break;
                            case 16:
                                tooltip.add(I18n.format("namedenchantments:enchant.sharpness"));
                                break;
                            case 17:
                                tooltip.add(I18n.format("namedenchantments:enchant.smite"));
                                break;
                            case 18:
                                tooltip.add(I18n.format("namedenchantments:enchant.bane"));
                                break;
                            case 19:
                                tooltip.add(I18n.format("namedenchantments:enchant.knockback"));
                                break;
                            case 20:
                                tooltip.add(I18n.format("namedenchantments:enchant.fireaspect"));
                                break;
                            case 21:
                                tooltip.add(I18n.format("namedenchantments:enchant.looting"));
                                break;
                            case 22:
                                tooltip.add(I18n.format("namedenchantments:enchant.sweepingedge"));
                                break;
                            case 32:
                                tooltip.add(I18n.format("namedenchantments:enchant.efficiency"));
                                break;
                            case 33:
                                tooltip.add(I18n.format("namedenchantments:enchant.silktouch"));
                                break;
                            case 34:
                                tooltip.add(I18n.format("namedenchantments:enchant.unbreaking"));
                                break;
                            case 35:
                                tooltip.add(I18n.format("namedenchantments:enchant.fortune"));
                                break;
                            case 48:
                                tooltip.add(I18n.format("namedenchantments:enchant.power"));
                                break;
                            case 49:
                                tooltip.add(I18n.format("namedenchantments:enchant.punch"));
                                break;
                            case 50:
                                tooltip.add(I18n.format("namedenchantments:enchant.flame"));
                                break;
                            case 51:
                                tooltip.add(I18n.format("namedenchantments:enchant.infinity"));
                                break;
                            case 61:
                                tooltip.add(I18n.format("namedenchantments:enchant.luckofthesea"));
                                break;
                            case 62:
                                tooltip.add(I18n.format("namedenchantments:enchant.lure"));
                                break;
                            case 70:
                                tooltip.add(I18n.format("namedenchantments:enchant.mending"));
                                break;
                            case 71:
                                tooltip.add(I18n.format("namedenchantments:enchant.vanishing"));
                                break;
                            default:
                                String name = Enchantment.getEnchantmentByID(s).getRegistryName().getResourcePath();
                                String modid = Enchantment.getEnchantmentByID(s).getRegistryName().getResourceDomain();
                                if (modid.equalsIgnoreCase("endercore") || modid.equalsIgnoreCase("enderio")) {
                                    switch (name) {
                                        case "xpboost":
                                            tooltip.add(I18n.format("namedenchantments:enchant.xpboost"));
                                            break;
                                        case "repellent":
                                            tooltip.add(I18n.format("namedenchantments:enchant.repellent"));
                                            break;
                                        case "shimmer":
                                            tooltip.add(I18n.format("namedenchantments:enchant.shimmer"));
                                            break;
                                        case "witherweapon":
                                            tooltip.add(I18n.format("namedenchantments:enchant.witherweapon"));
                                            break;
                                        case "soulbound":
                                            tooltip.add(I18n.format("namedenchantments:enchant.soulbound"));
                                            break;
                                        case "witherarrow":
                                            tooltip.add(I18n.format("namedenchantments:enchant.witherarrow"));
                                            break;
                                        case "autosmelt":
                                            tooltip.add(I18n.format("namedenchantments:enchant.autosmelt"));
                                            break;
                                    }
                                }
                                //Soul Shards Respawn
                                if (modid.equalsIgnoreCase("soulshardsrespawn")) {
                                    if (name.equalsIgnoreCase("soul_stealer")) {
                                        tooltip.add(I18n.format("namedenchantments:enchant.soul_stealer"));
                                    }
                                }
                        }
                    }
                }
            }
        }
    }
}
