/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 */
package vn.giakhanhvn.skysim.features.item.pet;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface PetAbility {
    public String getName();

    public List<String> getDescription(SItem var1);

    default public void onHurt(EntityDamageByEntityEvent e2, Entity damager) {
    }

    default public void onDamage(EntityDamageByEntityEvent e2) {
    }

    default public void onZealotAttempt(AtomicDouble chance) {
    }
}

