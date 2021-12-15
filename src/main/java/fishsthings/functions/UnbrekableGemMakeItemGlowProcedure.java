package fishsthings.functions;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import fishsthings.FishsThingsMod;

public class UnbrekableGemMakeItemGlowfunction {
	public static boolean executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency entity for function UnbrekableGemMakeItemGlow!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
				.asItem()))) {
			return (true);
		}
		return (false);
	}
}
