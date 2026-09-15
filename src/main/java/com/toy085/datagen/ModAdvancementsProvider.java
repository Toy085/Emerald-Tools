package com.toy085.datagen;

import com.toy085.EmeraldTools;
import com.toy085.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends AdvancementProvider {
    public ModAdvancementsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new EmeraldToolsAdvancements()));
    }

    public static class EmeraldToolsAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
            var items = registries.lookupOrThrow(Registries.ITEM);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            Items.EMERALD,
                            Component.translatable("advancement.emerald-tools.root.title"),
                            Component.translatable("advancement.emerald-tools.root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/stone"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    )
                    .addCriterion("has_emerald", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, Items.EMERALD)))
                    .save(output, EmeraldTools.MOD_ID + ":emerald-tools/root");
            AdvancementHolder craftAxe = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.Emerald_Axe,
                            Component.translatable("advancement.emerald-tools.emerald-axe.title"),
                            Component.translatable("advancement.emerald-tools.emerald-axe.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            false,
                            false
                    )
                    .addCriterion("has_emerald-axe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.Emerald_Axe)))
                    .save(output, EmeraldTools.MOD_ID + ":emerald-tools/emerald-axe");
        }
    }
}
