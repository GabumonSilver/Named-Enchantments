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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
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
                    for (int i = 0; i < (tagList != null ? tagList.tagCount() : 0); i++) {
                        NBTTagCompound tag = tagList.getCompoundTagAt(i);
                        short s = tag.getShort("id");

                        tooltip.add(I18n.format("namedenchantments:enchant." + getEnchant(s)));
                    }
                }
            }
        }
    }

    private String getEnchant(short id) {
            ResourceLocation enchant = Enchantment.getEnchantmentByID(id).getRegistryName();
            return enchant.getResourceDomain() + "." + enchant.getResourcePath();
    }
}
