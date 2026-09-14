package com.toy085.item;

import com.toy085.EmeraldTools;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
    public static  final Item Emerald_Axe = registerItem("emerald_axe", properties -> new AxeItem(ModToolMaterials.EMERALD_TOOL_MATERIAL, 3f, -2.4f, properties));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(EmeraldTools.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EmeraldTools.MOD_ID, name)))));
    };

    public static void registerModItems() {
        EmeraldTools.LOGGER.info("Registering Mod Items for " + EmeraldTools.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {output.accept(Emerald_Axe);});
    }
}
