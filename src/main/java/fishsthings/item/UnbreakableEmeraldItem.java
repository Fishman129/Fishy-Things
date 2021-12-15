
package fishsthings.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fishsthings.itemgroup.TernalItemGroup;

import fishsthings.FishsThingsModElements;

@FishsThingsModElements.ModElement.Tag
public class UnbreakableEmeraldItem extends FishsThingsModElements.ModElement {
	@ObjectHolder("fishs_things:unbreakable_emerald")
	public static final Item block = null;
	public UnbreakableEmeraldItem(FishsThingsModElements instance) {
		super(instance, 97);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TernalItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("unbreakable_emerald");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
