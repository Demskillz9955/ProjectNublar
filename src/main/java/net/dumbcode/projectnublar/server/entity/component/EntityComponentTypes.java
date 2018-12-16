package net.dumbcode.projectnublar.server.entity.component;

import net.dumbcode.projectnublar.server.ProjectNublar;
import net.dumbcode.projectnublar.server.entity.component.impl.DinosaurComponent;
import net.dumbcode.projectnublar.server.entity.component.impl.GenderComponent;
import net.dumbcode.projectnublar.server.utils.InjectedUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = ProjectNublar.MODID)
@GameRegistry.ObjectHolder(ProjectNublar.MODID)
public class EntityComponentTypes {
    public static final EntityComponentType<DinosaurComponent> DINOSAUR = InjectedUtils.injected();
    public static final EntityComponentType<GenderComponent> GENDER = InjectedUtils.injected();

    @SubscribeEvent
    public static void onRegisterComponents(RegisterComponentsEvent event) {
        event.getRegistry().registerAll(
                SimpleComponentType.builder(DinosaurComponent.class)
                        .withIdentifier(new ResourceLocation(ProjectNublar.MODID, "dinosaur"))
                        .withConstructor(DinosaurComponent::new)
                        .build(),
                SimpleComponentType.builder(GenderComponent.class)
                        .withIdentifier(new ResourceLocation(ProjectNublar.MODID, "gender"))
                        .withConstructor(GenderComponent::new)
                        .build()
        );
    }
}