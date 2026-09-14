package com.toy085.item;

import com.toy085.EmeraldTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final TagKey<Item> EMERALD_REPAIR_ITEMS = TagKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(EmeraldTools.MOD_ID, "emerald_repair_items")
    );


    public static final ToolMaterial EMERALD_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_GOLD_TOOL, 100, 6f, 1f, 13, EMERALD_REPAIR_ITEMS);
}