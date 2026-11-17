package ar.roland.tractor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

/**
 * Client controls prototype. This does not yet spawn or render a drivable tractor.
 * Keys are registered so the input plan can be tested independently.
 */
public final class RolandTractorClient implements ClientModInitializer {
    private KeyMapping engineKey, mowerKey, brakeKey, lightsKey, rangeKey;

    @Override
    public void onInitializeClient() {
        engineKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.rolandtractor.engine", GLFW.GLFW_KEY_E, KeyMapping.Category.MISC));
        mowerKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.rolandtractor.mower", GLFW.GLFW_KEY_F, KeyMapping.Category.MISC));
        brakeKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.rolandtractor.brake", GLFW.GLFW_KEY_G, KeyMapping.Category.MISC));
        lightsKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.rolandtractor.lights", GLFW.GLFW_KEY_L, KeyMapping.Category.MISC));
        rangeKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.rolandtractor.range", GLFW.GLFW_KEY_R, KeyMapping.Category.MISC));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            while (engineKey.consumeClick()) notify(client, "Control de motor: entrada recibida");
            while (mowerKey.consumeClick()) notify(client, "Control de cortadora: entrada recibida");
            while (brakeKey.consumeClick()) notify(client, "Control de freno: entrada recibida");
            while (lightsKey.consumeClick()) notify(client, "Control de luces: entrada recibida");
            while (rangeKey.consumeClick()) notify(client, "Control de rango: entrada recibida");
        });
    }

    private static void notify(Minecraft client, String message) {
        if (client.player != null) client.player.displayClientMessage(Component.literal(message), true);
    }
}
