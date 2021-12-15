
package fishsthings.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fishsthings.itemgroup.TernalItemGroup;

import fishsthings.FishsThingsModElements;

@FishsThingsModElements.ModElement.Tag
public class BlazingSeedItem extends FishsThingsModElements.ModElement {
	@ObjectHolder("fishs_things:blazing_seed")
	public static final Item block = null;
	public BlazingSeedItem(FishsThingsModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TernalItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blazing_seed");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
