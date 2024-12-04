package azure.altered_progression.items;

import azure.altered_progression.items.weapons.SpearItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import azure.altered_progression.armor.ArmorMaterials;


public class modItems {
	//upgrade Templates
	public static final Item Stone_Upgrade = new Item(new Item.Settings());
	public static final Item Iron_Upgrade = new Item(new Item.Settings());
	public static final Item Gold_Downgrade = new Item(new Item.Settings());
	public static final Item Diamond_Upgrade = new Item(new Item.Settings());
	public static final Item Ocean_Upgrade = new Item(new Item.Settings());
	//copper armor
	public static final Item COPPER_HELMET = new ArmorItem(ArmorMaterials.COPPER, ArmorItem.ArmorSlot.HELMET, new Item.Settings());
	public static final Item COPPER_CHESTPLATE = new ArmorItem(ArmorMaterials.COPPER, ArmorItem.ArmorSlot.CHESTPLATE, new Item.Settings());
	public static final Item COPPER_LEGGINGS = new ArmorItem(ArmorMaterials.COPPER, ArmorItem.ArmorSlot.LEGGINGS, new Item.Settings());
	public static final Item COPPER_BOOTS = new ArmorItem(ArmorMaterials.COPPER, ArmorItem.ArmorSlot.BOOTS, new Item.Settings());
	//spears
	public static final Item WOOD_SPEAR = new SpearItem(ToolMaterials.WOOD, 1, 3.2f);
	public static final Item STONE_SPEAR = new SpearItem(ToolMaterials.STONE, 1, 3.2f);
	public static final Item IRON_SPEAR = new SpearItem(ToolMaterials.IRON, 1, 3.2f);
	public static final Item GOLD_SPEAR = new SpearItem(ToolMaterials.GOLD, 1, 3.2f);
	public static final Item DIAMOND_SPEAR = new SpearItem(ToolMaterials.DIAMOND, 1, 3.2f);
	public static final Item NETHERITE_SPEAR = new SpearItem(ToolMaterials.NETHERITE, 1, 3.2f);
	//aquatic gear
	public static final Item Atlantean_Sword = new Item(new Item.Settings());
	public static final Item Nautical_Axe = new Item(new Item.Settings());

	public static void registerItems() {

		//upgrades
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "primitive_upgrade"), Stone_Upgrade);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "iron_upgrade"), Iron_Upgrade);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "golden_downgrade"), Gold_Downgrade);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "diamond_upgrade"), Diamond_Upgrade);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "ocean_upgrade"), Ocean_Upgrade);
		//copper armor
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "copper_helmet"), COPPER_HELMET);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "copper_chestplate"), COPPER_CHESTPLATE);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "copper_leggings"), COPPER_LEGGINGS);
		Registry.register(Registries.ITEM,new Identifier("altered_progression", "copper_boots"), COPPER_BOOTS);
// Spears in progression, using addBefore to add them before the next spear (or Trident for Netherite Spear)
		Registry.register(Registries.ITEM, new Identifier("altered_progression", "netherite_spear"), NETHERITE_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(Items.TRIDENT, NETHERITE_SPEAR));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "diamond_spear"), DIAMOND_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(NETHERITE_SPEAR, DIAMOND_SPEAR));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "golden_spear"), GOLD_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(DIAMOND_SPEAR, GOLD_SPEAR));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "iron_spear"), IRON_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(GOLD_SPEAR, IRON_SPEAR));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "stone_spear"), STONE_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(IRON_SPEAR, STONE_SPEAR));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "wooden_spear"), WOOD_SPEAR);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(STONE_SPEAR, WOOD_SPEAR));

// Aquatic Gear after Netherite Weapons
		Registry.register(Registries.ITEM, new Identifier("altered_progression", "nautical_axe"), Nautical_Axe);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addAfter(Items.NETHERITE_AXE, Nautical_Axe));

		Registry.register(Registries.ITEM, new Identifier("altered_progression", "atlantean_sword"), Atlantean_Sword);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addAfter(Items.NETHERITE_SWORD, Atlantean_Sword));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addAfter(Items.LEATHER_BOOTS, COPPER_HELMET, COPPER_CHESTPLATE, COPPER_LEGGINGS, COPPER_BOOTS);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,Stone_Upgrade));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Stone_Upgrade, Iron_Upgrade));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Iron_Upgrade, Gold_Downgrade));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Gold_Downgrade, Diamond_Upgrade));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addAfter(Diamond_Upgrade, Ocean_Upgrade));
	}

}
