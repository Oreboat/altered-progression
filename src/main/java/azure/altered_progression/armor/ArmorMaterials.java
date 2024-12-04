package azure.altered_progression.armor;

import azure.altered_progression.AlteredProgression;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {
	COPPER(
		"copper",
			new int[] {165, 240, 225, 195},
			new int[] {1, 4, 5, 2},
		0,
		SoundEvents.BLOCK_COPPER_PLACE,
		0f,
		0f,
		Ingredient.ofItems(Items.COPPER_INGOT)
	);

	private final String Name;
	private final int[] Durability;
	private final int[] Protection;
	private final int Enchantability;
	private final float Toughness;
	private final float KnockbackResistance;
	private final SoundEvent SoundEvent;
	private final Ingredient RepairIngredient;

	ArmorMaterials(String name, int[] durability, int[] protectionAmount, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairMaterial) {
		this.Name = name;
		this.Durability = durability;
		this.Protection = protectionAmount;
		this.Enchantability = enchantability;
		this.Toughness = toughness;
		this.KnockbackResistance = knockbackResistance;
		this.SoundEvent = equipSound;
		this.RepairIngredient = repairMaterial;
	}


	@Override
	public int getDurability(ArmorItem.ArmorSlot slot) {
		return Durability[slot.getEquipmentSlot().getEntitySlotId()];
	}

	@Override
	public int getProtection(ArmorItem.ArmorSlot slot) {
		return Protection[slot.getEquipmentSlot().getEntitySlotId()];
	}

	@Override
	public float getKnockbackResistance() {
		return KnockbackResistance;
	}

	@Override
	public int getEnchantability(){
		return Enchantability;
	}

	@Override
	public float getToughness() {
		return Toughness;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public SoundEvent getEquipSound(){
		return this.SoundEvent;
	}

	@Override
	public Ingredient getRepairIngredient(){
		return this.RepairIngredient;
	}
}
