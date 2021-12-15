
package fishsthings.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fishsthings.block.BlazingFlowerBlock;

import fishsthings.FishsThingsModElements;

@FishsThingsModElements.ModElement.Tag
public class TernalItemGroup extends FishsThingsModElements.ModElement {
	public TernalItemGroup(FishsThingsModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabternal") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlazingFlowerBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
