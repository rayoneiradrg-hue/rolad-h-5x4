package ar.roland.tractor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;
public final class RolandTractorClient implements ClientModInitializer {
 private KeyMapping infoKey;
 @Override public void onInitializeClient(){
  infoKey=KeyBindingHelper.registerKeyBinding(new KeyMapping("key.rolandtractor.info",GLFW.GLFW_KEY_K,KeyMapping.Category.MISC));
  ClientTickEvents.END_CLIENT_TICK.register(client->{while(infoKey.consumeClick()){
   Minecraft mc=Minecraft.getInstance();
   if(mc.player!=null) mc.player.displayClientMessage(Component.literal("Roland H 5x4: mod cargado. Modelo y conduccion aun en desarrollo."),false);
  }});
 }
}
