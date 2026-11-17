package ar.roland.tractor;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public final class RolandTractorMod implements ModInitializer {
 public static final String MOD_ID="rolandtractor";
 public static final Logger LOGGER=LoggerFactory.getLogger(MOD_ID);
 @Override public void onInitialize(){ LOGGER.info("Roland H 5x4: mod cargado."); }
}
