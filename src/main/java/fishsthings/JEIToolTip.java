package fishsthings;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import java.util.*;
import java.util.stream.Collectors;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.server.command.ModIdArgument;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import fishsthings.item.UltimateCalculatorItem;
import fishsthings.item.AdvancedCalculatorItem;
import fishsthings.item.CalculatorItem;
import fishsthings.item.BlazingBoneMealItem;
import fishsthings.block.MobEffectGiverBlock;
import fishsthings.block.UniversalTeleporterBlock;
import fishsthings.block.PlayerTeleporterBlock;
import fishsthings.block.ItemTeleporterBlock;
import fishsthings.item.TeleporterGemItem;
import fishsthings.block.MobFreezerBlock;
import fishsthings.block.TotemOfUndyingGeneratorBlock;
import fishsthings.block.ExperienceGeneratorBlock;
import fishsthings.block.MeatGeneratorBlock;
import fishsthings.block.MachineFrameBlock;
import fishsthings.item.GeneratorSpeedUpgradeItem;
import fishsthings.item.GeneratorProductUpgradeItem;
import fishsthings.block.BlazingFlowerBlock;
import fishsthings.item.BlazingSeedItem;
import fishsthings.item.FireStickItem;
import fishsthings.item.FireBoneItem;
import fishsthings.item.RangeUpgradeItem;
import fishsthings.item.TeleporterWrenchItem;
import fishsthings.item.AntiTeleportItem;
import fishsthings.item.TeleporterResetItem;
import fishsthings.item.NoExpirationGemItem;
import fishsthings.item.UnbreakableEmeraldItem;
import fishsthings.item.UnbreakableGoldItem;
import fishsthings.item.UnbrekableGemItem;
import fishsthings.block.BreakingNewsBlock;
import fishsthings.block.RedstoneLockBlock;

@mezz.jei.api.JeiPlugin
public class JEIToolTip implements IModPlugin { 
	
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("fishsthings", "default");
	}

	@Override
        public void registerRecipes(IRecipeRegistration registry) {
		IIngredientManager ingredientManager = registry.getIngredientManager();

		
		IIngredientType<ItemStack> itemType = ingredientManager.getIngredientType(ItemStack.class);
		//Items and Blocks which have a Tool Tip:

        registry.addIngredientInfo(new ItemStack(RedstoneLockBlock.block), itemType, "Will emit custom redstone power when activated with a custom code for security. Check Wiki for more information");
        registry.addIngredientInfo(new ItemStack(UltimateCalculatorItem.block), itemType, "The Ultimate Calculator to do simple math, Power Of, use Pi, generate random numbers from 0,1, find percentages, and square root numbers");
        registry.addIngredientInfo(new ItemStack(AdvancedCalculatorItem.block), itemType, "Advanced Calculator to do simple math and Power Of (eg: 2 ^ 7)");
        registry.addIngredientInfo(new ItemStack(CalculatorItem.block), itemType, "Simple Calculator to do simple math");
        registry.addIngredientInfo(new ItemStack(MobEffectGiverBlock.block), itemType, "Will add the desired effect to every mob on a radius of 8, 16, 32, or 128 depending on the number of Range Upgrades. For modded effects, you should write, {modid:effect_name}. And no Spaces!");
        registry.addIngredientInfo(new ItemStack(BreakingNewsBlock.block), itemType, "It is simply little jokes marked as news. Sorry if anyone is offended!");
        registry.addIngredientInfo(new ItemStack(UnbrekableGemItem.block), itemType, "When Right-Clicked with an item on Off Hand it will make the item Unbreakable (This doesn't mean it doesn't burn in lava! Please note that this doesn't work with energy and/or fluid using items)");
        registry.addIngredientInfo(new ItemStack(UnbreakableGoldItem.block), itemType, "Used to craft the Unbreakable Gem");
		registry.addIngredientInfo(new ItemStack(UnbreakableEmeraldItem.block), itemType, "Used to craft the Unbreakable Gem");
        registry.addIngredientInfo(new ItemStack(NoExpirationGemItem.block), itemType, "When Right-Clicked with an item on Off Hand it will add a No Expiration Enchantment to the item so it never disappears when thrown on the ground");
        registry.addIngredientInfo(new ItemStack(BlazingBoneMealItem.block), itemType, "Has a 30% chance of spawning Blazing Seeds when used on a Blazing Flower");
        registry.addIngredientInfo(new ItemStack(TeleporterResetItem.block), itemType, "Will reset any Teleporter to its default state, without losing upgrades");
        registry.addIngredientInfo(new ItemStack(AntiTeleportItem.block), itemType, "Able to avoid being teleported on the Teleporter Radius when in Main or Off Hand");        
        registry.addIngredientInfo(new ItemStack(TeleporterWrenchItem.block), itemType, "Able to break any Teleporter, will drop range upgrades if provided. Only way to break the Teleporter without creative!");
        registry.addIngredientInfo(new ItemStack(UniversalTeleporterBlock.block), itemType, "Will teleport Everything on a radius (default is square cube size of 4 or 1 block N, W, E, S, D, U) to the Linked teleporter. Link it with a Teleporter Gem. §aRange can be Upgraded");
        registry.addIngredientInfo(new ItemStack(UniversalTeleporterBlock.block), itemType, "§4§lIMPORTANT: IF THE CHUNK WHERE THE TELEPORTER IS IN IS UNLOADED, THE ITEMS/ENTITIES WILL DISSAPEAR UNTIL THE CHUNK IS LOADED AGAIN");       
        registry.addIngredientInfo(new ItemStack(PlayerTeleporterBlock.block), itemType, "Will teleport Players on a radius (default is square cube size of 4 or 1 block N, W, E, S, D, U) to the Linked teleporter. Link it with a Teleporter Gem. §aRange can be Upgraded");
        registry.addIngredientInfo(new ItemStack(ItemTeleporterBlock.block), itemType, "Will teleport items on a radius (default is square cube size of 4 or 1 block N, W, E, S, D, U) to the Linked teleporter. Link it with a Teleporter Gem. §aRange can be Upgraded");
        registry.addIngredientInfo(new ItemStack(ItemTeleporterBlock.block), itemType, "§4§lIMPORTANT: IF THE CHUNK WHERE THE TELEPORTER IS IN IS UNLOADED, THE ITEM WILL DISSAPEAR UNTIL THE CHUNK IS LOADED AGAIN");
        registry.addIngredientInfo(new ItemStack(RangeUpgradeItem.block), itemType, "Used to Upgrade the range of some machines that support it");
        registry.addIngredientInfo(new ItemStack(TeleporterGemItem.block), itemType, "Used to link Teleporters");
		registry.addIngredientInfo(new ItemStack(MobFreezerBlock.block), itemType, "Will teleport mobs on a radius (default is square cube size of 4 or 1 block N, W, E, S, D, U) to the Linked teleporter. Link it with a Teleporter Gem. §aRange can be Upgraded");
		registry.addIngredientInfo(new ItemStack(MobFreezerBlock.block), itemType, "§4§lIMPORTANT: IF THE CHUNK WHERE THE TELEPORTER IS IN IS UNLOADED, THE ENTITY WILL DISSAPEAR UNTIL THE CHUNK IS LOADED AGAIN");
		registry.addIngredientInfo(new ItemStack(FireBoneItem.block), itemType, "Used to craft §chot §0items");
        registry.addIngredientInfo(new ItemStack(FireStickItem.block), itemType, "Used to craft §chot §0items");
        registry.addIngredientInfo(new ItemStack(BlazingSeedItem.block), itemType, "Used to craft Blaze Rods. You can place it on sand to grow more. They are dropped by §cBlazing Flowers");
        registry.addIngredientInfo(new ItemStack(BlazingFlowerBlock.block), itemType, "Drops Blazing Seeds which can be crafted to §cBlaze Rods§0. §0Only natural spawn is Deserts");
        registry.addIngredientInfo(new ItemStack(ExperienceGeneratorBlock.block), itemType, "Will drop experience orbs when activated with redstone. §aOutput Number and Speed can be Upgraded §0(In order for it not to cause lag the orbs will give more exp instead of being more)");
		registry.addIngredientInfo(new ItemStack(TotemOfUndyingGeneratorBlock.block), itemType, "Will output Totems of Undying to the block above it (They will stack). §aOutput Number and Speed can be upgraded");
		registry.addIngredientInfo(new ItemStack(MeatGeneratorBlock.block), itemType, "Will output Steak to the block above it. §aOutput Number and Speed can be upgraded");
		registry.addIngredientInfo(new ItemStack(MachineFrameBlock.block), itemType, "Used for Machines and Upgrades crafting. §aSafe for decoration");
		registry.addIngredientInfo(new ItemStack(GeneratorSpeedUpgradeItem.block), itemType, "Used to upgrade the speed of Generators. §aMax of 5 per generator");
		registry.addIngredientInfo(new ItemStack(GeneratorProductUpgradeItem.block), itemType, "Used to upgrade the output product of Generators. §aMax of 4 per generator");
     }
}