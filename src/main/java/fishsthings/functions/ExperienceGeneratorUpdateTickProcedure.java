package fishsthings.functions;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;

import java.util.Map;

import fishsthings.FishsThingsMod;

public class ExperienceGeneratorUpdateTickfunction {
	public static void executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency x for function ExperienceGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency y for function ExperienceGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency z for function ExperienceGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency world for function ExperienceGeneratorUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) != 0)) {
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) == 1)) {
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 150);
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) == 2)) {
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 100);
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) == 3)) {
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 75);
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) == 4)) {
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 50);
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "SpeedUpgrade")) == 5)) {
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 25);
			}
		} else {
			world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
					world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 200);
		}
		if (((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) x, (int) y, (int) z)) : false)) {
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ProductUpgrade")) != 0)) {
				if (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ProductUpgrade")) == 1)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
					}
				} else if (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ProductUpgrade")) == 2)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
					}
				} else if (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ProductUpgrade")) == 3)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 4));
					}
				} else if (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "ProductUpgrade")) == 4)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 5));
					}
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
				}
			}
		}
	}
}
