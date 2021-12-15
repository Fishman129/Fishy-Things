
package fishsthings.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fishsthings.itemgroup.GeneralItemGroup;

import fishsthings.FishsThingsModElements;

@FishsThingsModElements.ModElement.Tag
public class AntiTeleportItem extends FishsThingsModElements.ModElement {
	@ObjectHolder("fishs_things:anti_teleport")
	public static final Item block = null;
	public AntiTeleportItem(FishsThingsModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GeneralItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("anti_teleport");
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
