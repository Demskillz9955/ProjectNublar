package net.dumbcode.projectnublar.server.plants;

import com.google.common.collect.Lists;
import net.dumbcode.dumblibrary.server.ecs.component.EntityComponentTypes;

import static net.dumbcode.dumblibrary.server.ecs.component.EntityComponentAttacher.create;
import static net.minecraftforge.common.BiomeDictionary.Type.JUNGLE;

public class Cycad extends Plant {

    @Override
    public void attachComponents() {
        this.baseAttacher.addComponent(EntityComponentTypes.FLOWER_WORLDGEN)
                .setBiomeTypes(Lists.newArrayList(JUNGLE.getName()))
                .setGroupSpawnSize(5)
                .setChancePerChunk(0.1F);

        this.stateOverrides.put("age_0", create(a -> a.addComponent(EntityComponentTypes.BLOCK_GROWING).setGrowTo("age_1")));
        this.stateOverrides.put("age_1", create(a -> a.addComponent(EntityComponentTypes.BLOCK_GROWING).setGrowTo("age_2")));
        this.stateOverrides.put("age_2", create(a -> a.addComponent(EntityComponentTypes.BLOCK_GROWING).setGrowTo("age_3")));
        this.stateOverrides.put("age_3", create(a -> {}));
    }
}
