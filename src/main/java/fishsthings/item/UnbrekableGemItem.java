
package fishsthings.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import fishsthings.functions.UnbrekableGemMakeItemGlowfunction;
import fishsthings.functions.UnbreakableGemRightClickOnAirfunction;

import fishsthings.itemgroup.TernalItemGroup;

import fishsthings.FishsThingsModElements;

import com.google.common.collect.ImmutableMap;

@FishsThingsModElements.ModElement.Tag
public class UnbrekableGemItem extends FishsThingsModElements.ModElement {
	@ObjectHolder("fishs_things:unbrekable_gem")
	public static final Item block = null;
	public UnbrekableGemItem(FishsThingsModElements instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TernalItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("unbrekable_gem");
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
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (!(UnbrekableGemMakeItemGlowfunction.executefunction(ImmutableMap.of("entity", entity)))) {
				return false;
			}
			return true;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				UnbreakableGemRightClickOnAirfunction.executefunction($_dependencies);
			}
			return ar;
		}
	}
}
