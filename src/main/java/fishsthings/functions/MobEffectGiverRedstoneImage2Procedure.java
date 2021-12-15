package fishsthings.functions;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;

import fishsthings.FishsThingsMod;

public class MobEffectGiverRedstoneImage2function {
	public static boolean executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency x for function MobEffectGiverRedstoneImage2!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency y for function MobEffectGiverRedstoneImage2!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency z for function MobEffectGiverRedstoneImage2!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency world for function MobEffectGiverRedstoneImage2!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "needsRedstone")) == (false))) {
			return (true);
		}
		return (false);
	}
}
