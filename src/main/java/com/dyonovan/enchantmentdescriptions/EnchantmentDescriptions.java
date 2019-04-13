package com.dyonovan.enchantmentdescriptions;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EnchantmentDescriptions.MODID, name = EnchantmentDescriptions.NAME, version = EnchantmentDescriptions.VERSION, clientSideOnly = true)
public class EnchantmentDescriptions
{
    static final String MODID = "enchantmentdescriptions";
    static final String NAME = "Enchantment Descriptions";
    static final String VERSION = "1.0";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChangeToolTip());
    }


}
