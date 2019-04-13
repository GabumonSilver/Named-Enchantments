package com.dyonovan.enchantmentdescriptions;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class ChangeToolTip {

    ChangeToolTip() {
    }

    @SubscribeEvent
    public void changeToolTip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (itemStack.getUnlocalizedName().equals("item.enchantedBook")) {
            if (itemStack.hasTagCompound()) {
                NBTTagCompound tagCompound = itemStack.getTagCompound();
                assert tagCompound != null;
                NBTTagList tagList = tagCompound.getTagList("StoredEnchantments", 10);
                for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = tagList.getCompoundTagAt(i);
                    short s = tag.getShort("id");
                    List<String> tooltip = event.getToolTip();
                    switch (s) {
                        case 0:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.protection"));
                            break;
                        case 1:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.fireprotection"));
                            break;
                        case 2:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.featherfalling"));
                            break;
                        case 3:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.blastprotection"));
                            break;
                        case 4:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.projectileprotection"));
                            break;
                        case 5:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.respiration"));
                            break;
                        case 6:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.aquainfinity"));
                            break;
                        case 7:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.thorns"));
                            break;
                        case 8:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.depthstrider"));
                            break;
                        case 9:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.frostwalker"));
                            break;
                        case 10:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.curseofbinding"));
                            break;
                        case 16:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.sharpness"));
                            break;
                        case 17:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.smite"));
                            break;
                        case 18:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.bane"));
                            break;
                        case 19:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.knockback"));
                            break;
                        case 20:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.fireaspect"));
                            break;
                        case 21:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.looting"));
                            break;
                        case 22:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.sweepingedge"));
                            break;
                        case 32:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.efficiency"));
                            break;
                        case 33:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.silktouch"));
                            break;
                        case 34:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.unbreaking"));
                            break;
                        case 35:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.fortune"));
                            break;
                        case 48:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.power"));
                            break;
                        case 49:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.punch"));
                            break;
                        case 50:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.flame"));
                            break;
                        case 51:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.infinity"));
                            break;
                        case 61:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.luckofthesea"));
                            break;
                        case 62:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.lure"));
                            break;
                        case 70:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.mending"));
                            break;
                        case 71:
                            tooltip.add(I18n.format("enchantmentdescriptions:enchant.vanishing"));
                            break;
                    }
                }
            }
        }
    }
}
