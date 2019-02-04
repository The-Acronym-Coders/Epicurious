package com.teamacronymcoders.epicurious;

import com.teamacronymcoders.base.BaseModFoundation;
import com.teamacronymcoders.base.registrysystem.BlockRegistry;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import com.teamacronymcoders.epicurious.common.CommonProxy;
import com.teamacronymcoders.epicurious.common.ModFluids;
import com.teamacronymcoders.epicurious.common.content.ItemYeast;
import com.teamacronymcoders.epicurious.common.content.beer.ItemBarleySeeds;
import com.teamacronymcoders.epicurious.common.content.beer.barley.BlockCropBarley;
import com.teamacronymcoders.epicurious.common.content.beer.barley.ItemBarley;
import com.teamacronymcoders.epicurious.common.content.wine.fluid.FluidBlockWine;
import com.teamacronymcoders.epicurious.common.content.wine.grape.BlockCropGrape;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapeSeeds;
import com.teamacronymcoders.epicurious.common.content.wine.grape.ItemGrapes;
import com.teamacronymcoders.epicurious.utils.EpicuriousConfigs;
import com.teamacronymcoders.epicurious.utils.EpicuriousTab;
import crafttweaker.IAction;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = Epicurious.MODID, name = Epicurious.NAME, version = Epicurious.VERSION, acceptedMinecraftVersions = Epicurious.MCVERSION, dependencies = Epicurious.DEPS)
public class Epicurious extends BaseModFoundation<Epicurious> {
    public static final String MODID = "epicurious";
    public static final EpicuriousTab TAB = new EpicuriousTab();
    public static final List<IAction> LATE_ADDITIONS = new LinkedList<>();
    public static final String NAME = "Epicurious";
    public static final String VERSION = "1.12.2-1.0.0";
    public static final String MCVERSION = "1.12,";
    public static final String DEPS = "" +
            "required-after:patchouli@[1.0-13,);";

    public static final Random RANDOM = new Random();

    private static final String COMMON = "com.teamacronymcoders.epicurious.common.CommonProxy";
    private static final String CLIENT = "com.teamacronymcoders.epicurious.client.ClientProxy";

    @SidedProxy(serverSide = COMMON, clientSide = CLIENT)
    public static CommonProxy proxy;

    @Instance
    public static Epicurious INSTANCE;

    private static Logger logger;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    public Epicurious() {
        super(MODID, NAME, VERSION, TAB);
    }

    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        proxy.preInit(event);
    }

    @Override
    public void beforeModuleHandlerInit(FMLPreInitializationEvent event) {
        EpicuriousConfigs.preInitLoadConfigs(event);
    }

    @Override
    public void registerBlocks(BlockRegistry registry) {
        if (EpicuriousConfigs.enableWineContent) {
            FluidRegistry.registerFluid(ModFluids.wine);
            FluidRegistry.addBucketForFluid(ModFluids.wine);
            registry.register(new BlockCropGrape());
            registry.register(new FluidBlockWine());
        }
        if (EpicuriousConfigs.enableBeerContent) {
            registry.register(new BlockCropBarley());
        }
    }

    @Override
    public void registerItems(ItemRegistry registry) {
        registry.register(new ItemYeast());

        if (EpicuriousConfigs.enableWineContent) {
            registry.register(new ItemGrapes());
            registry.register(new ItemGrapeSeeds());
        }
        if (EpicuriousConfigs.enableBeerContent) {
            registry.register(new ItemBarley());
            registry.register(new ItemBarleySeeds());
        }
    }

    @Override
    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
        proxy.init(event);
    }

    @Override
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        proxy.postInit(event);
    }

    @Override
    public Epicurious getInstance() {
        return this;
    }
}
