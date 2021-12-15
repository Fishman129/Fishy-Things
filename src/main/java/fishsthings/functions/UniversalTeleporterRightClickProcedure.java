package fishsthings.functions;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

import fishsthings.item.AntiTeleportItem;

import fishsthings.FishsThingsMod;

public class UniversalTeleporterRightClickfunction {
	public static void executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency x for function UniversalTeleporterRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency y for function UniversalTeleporterRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency z for function UniversalTeleporterRightClick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency world for function UniversalTeleporterRightClick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) x, (int) y, (int) z)) : false)) {
			if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "distanceUpgraded")) == 0)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == AntiTeleportItem.block)
								|| (((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getHeldItemOffhand()
										: ItemStack.EMPTY).getItem() == AntiTeleportItem.block)))) {
							if (((new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "isBlockLinked")) == (true))) {
								{
									Entity _ent = entityiterator;
									_ent.setPositionAndUpdate(((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("You are in a teleporter area"), (true));
							}
						}
					}
				}
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "distanceUpgraded")) == 1)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (8 / 2d), y - (8 / 2d), z - (8 / 2d), x + (8 / 2d), y + (8 / 2d), z + (8 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == AntiTeleportItem.block)
								|| (((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getHeldItemOffhand()
										: ItemStack.EMPTY).getItem() == AntiTeleportItem.block)))) {
							if (((new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "isBlockLinked")) == (true))) {
								{
									Entity _ent = entityiterator;
									_ent.setPositionAndUpdate(((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("You are in a teleporter area"), (true));
							}
						}
					}
				}
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "distanceUpgraded")) == 2)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (16 / 2d), y - (16 / 2d), z - (16 / 2d), x + (16 / 2d), y + (16 / 2d), z + (16 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == AntiTeleportItem.block)
								|| (((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getHeldItemOffhand()
										: ItemStack.EMPTY).getItem() == AntiTeleportItem.block)))) {
							if (((new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "isBlockLinked")) == (true))) {
								{
									Entity _ent = entityiterator;
									_ent.setPositionAndUpdate(((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("You are in a teleporter area"), (true));
							}
						}
					}
				}
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "distanceUpgraded")) == 3)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (32 / 2d), y - (32 / 2d), z - (32 / 2d), x + (32 / 2d), y + (32 / 2d), z + (32 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == AntiTeleportItem.block)
								|| (((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getHeldItemOffhand()
										: ItemStack.EMPTY).getItem() == AntiTeleportItem.block)))) {
							if (((new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "isBlockLinked")) == (true))) {
								{
									Entity _ent = entityiterator;
									_ent.setPositionAndUpdate(((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("You are in a teleporter area"), (true));
							}
						}
					}
				}
			} else if (((new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "distanceUpgraded")) == 4)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (64 / 2d), y - (64 / 2d), z - (64 / 2d), x + (64 / 2d), y + (64 / 2d), z + (64 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((!((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == AntiTeleportItem.block)
								|| (((entityiterator instanceof LivingEntity)
										? ((LivingEntity) entityiterator).getHeldItemOffhand()
										: ItemStack.EMPTY).getItem() == AntiTeleportItem.block)))) {
							if (((new Object() {
								public boolean getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getBoolean(tag);
									return false;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "isBlockLinked")) == (true))) {
								{
									Entity _ent = entityiterator;
									_ent.setPositionAndUpdate(((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosX")) + 0.5), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosY")) + 1), ((new Object() {
											public double getValue(IWorld world, BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "blockTeleporterPosZ")) + 0.5), _ent.rotationYaw,
												_ent.rotationPitch, Collections.emptySet());
									}
								}
							}
						} else {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("You are in a teleporter area"), (true));
							}
						}
					}
				}
			}
		}
	}
}
