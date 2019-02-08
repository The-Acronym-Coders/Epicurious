package com.teamacronymcoders.epicurious.modules.patchouli;

import com.teamacronymcoders.base.modulesystem.Module;
import com.teamacronymcoders.base.modulesystem.ModuleBase;
import com.teamacronymcoders.base.modulesystem.dependencies.IDependency;
import com.teamacronymcoders.base.modulesystem.dependencies.ModDependency;
import com.teamacronymcoders.epicurious.Epicurious;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.List;

@Module(value = Epicurious.MODID)
public class PatchouliModule extends ModuleBase {

    @Override
    public String getName() {
        return "Patchouli";
    }

    @Override
    public List<IDependency> getDependencies(List<IDependency> dependencies) {
        dependencies.add(new ModDependency("patchouli"));
        return super.getDependencies(dependencies);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        PatchouliCompat.setupFlags();
        super.init(event);
    }
}
