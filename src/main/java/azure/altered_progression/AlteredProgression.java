package azure.altered_progression;

import azure.altered_progression.items.modItems;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.ResourceType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AlteredProgression implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Example Mod");
	public static final String MOD_ID = "altered_progression";
	@Override
	public void onInitialize(ModContainer mod) {
		modItems.registerItems();
		Identifier recipeId = new Identifier("minecraft", "iron_sword");
		ResourceManagerHelper.registerBuiltinResourcePack(
			new Identifier(MOD_ID, "altered_progression"),
			FabricLoader.getInstance().getModContainer(MOD_ID).get(),
			ResourcePackActivationType.ALWAYS_ENABLED
		);


		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
			// Broadcast a message to all players when the server starts
			System.out.println("Custom recipes and datapack loaded!");

		});
	}
}
