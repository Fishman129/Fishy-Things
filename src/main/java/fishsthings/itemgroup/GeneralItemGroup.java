
package fishsthings.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fishsthings.item.RangeUpgradeItem;

import fishsthings.FishsThingsModElements;

@FishsThingsModElements.ModElement.Tag
public class GeneralItemGroup extends FishsThingsModElements.ModElement {
	public GeneralItemGroup(FishsThingsModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgeneral") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RangeUpgradeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
