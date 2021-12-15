
package fishsthings.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import fishsthings.item.FireBoneItem;

@Mod.EventBusSubscriber
public class FireBoneFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == FireBoneItem.block)
			event.setBurnTime(18000);
	}
}
