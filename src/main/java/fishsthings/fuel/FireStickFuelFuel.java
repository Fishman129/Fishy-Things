
package fishsthings.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import fishsthings.item.FireStickItem;

@Mod.EventBusSubscriber
public class FireStickFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == FireStickItem.block)
			event.setBurnTime(20400);
	}
}
