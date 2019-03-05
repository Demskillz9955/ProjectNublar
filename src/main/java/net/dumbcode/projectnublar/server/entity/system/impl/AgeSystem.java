package net.dumbcode.projectnublar.server.entity.system.impl;

import net.dumbcode.projectnublar.server.entity.EntityFamily;
import net.dumbcode.projectnublar.server.entity.EntityManager;
import net.dumbcode.projectnublar.server.entity.ModelStage;
import net.dumbcode.projectnublar.server.entity.component.EntityComponentTypes;
import net.dumbcode.projectnublar.server.entity.component.impl.AgeComponent;
import net.dumbcode.projectnublar.server.entity.component.impl.DinosaurComponent;
import net.dumbcode.projectnublar.server.entity.system.EntitySystem;

import java.util.Map;

public enum AgeSystem implements EntitySystem {
    INSTANCE;
    private AgeComponent[] ages = new AgeComponent[0];

    @Override
    public void populateBuffers(EntityManager manager) {
        EntityFamily family = manager.resolveFamily(EntityComponentTypes.AGE);
        this.ages = family.populateBuffer(EntityComponentTypes.AGE);
    }

    @Override
    public void update() {
        for (int i = 0; i < this.ages.length; i++) {
            AgeComponent age = this.ages[i];
            int ageoff = 0;
            for (int j = 0; j < ModelStage.values().length; j++) {
                ModelStage stage = ModelStage.values()[j];
                int ticks = age.tickStageMap.get(stage);
                if(ageoff < age.ageInTicks && ageoff + ticks >= age.ageInTicks) {
                    age.stage = stage;
                    age.percentageStage = (age.ageInTicks - ageoff) / (float)ticks;
                    break;
                }
                ageoff += ticks;
            }

        }
    }
}
