/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.caverns;

import vn.giakhanhvn.skysim.event.CreeperIgniteEvent;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.SEntity;

public interface CreeperFunction
extends EntityFunction {
    default public void onCreeperIgnite(CreeperIgniteEvent e2, SEntity sEntity) {
    }
}

