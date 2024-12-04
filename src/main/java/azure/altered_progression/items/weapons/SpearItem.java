package azure.altered_progression.items.weapons;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;

public class SpearItem extends SwordItem {
	private final int enchantability;

	// Constructor
	public SpearItem(ToolMaterial material, int attackDamage, float attackSpeed) {
		super(material, attackDamage, attackSpeed, new Item.Settings());
		this.enchantability = material.getEnchantability();
	}


	@Override
	public int getEnchantability() {
		return enchantability; // Enchantability from the material
	}

}
