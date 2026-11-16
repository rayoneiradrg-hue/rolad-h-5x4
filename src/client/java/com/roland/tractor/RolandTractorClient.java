package com.roland.tractor;

import net.fabricmc.api.ClientModInitializer;

public class RolandTractorClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RolandTractorMod.LOGGER.info("Roland H 5x4: inicializador de cliente cargado.");
    }
}
