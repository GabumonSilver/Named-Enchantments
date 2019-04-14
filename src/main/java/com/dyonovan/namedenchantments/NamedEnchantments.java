package com.dyonovan.namedenchantments;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = NamedEnchantments.MODID, name = NamedEnchantments.NAME, version = NamedEnchantments.VERSION, clientSideOnly = true)
public class NamedEnchantments
{
    static final String MODID = "namedenchantments";
    static final String NAME = "Named Enchantments";
    static final String VERSION = "1.2";

    static final Logger LOGGER = LogManager.getLogger(MODID);


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChangeToolTip());
        ClientCommandHandler.instance.registerCommand(new GetEnchantmentList());
    }


}
