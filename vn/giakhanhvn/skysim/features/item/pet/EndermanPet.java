/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 */
package vn.giakhanhvn.skysim.features.item.pet;

import com.google.common.util.concurrent.AtomicDouble;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.RarityValue;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.pet.Pet;
import vn.giakhanhvn.skysim.features.item.pet.PetAbility;
import vn.giakhanhvn.skysim.features.skill.CombatSkill;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.util.Groups;

public class EndermanPet
extends Pet {
    @Override
    public List<PetAbility> getPetAbilities(SItem instance) {
        RarityValue<Double> enderianMul = new RarityValue<Double>(0.1, 0.2, 0.2, 0.3, 0.3, 0.3);
        RarityValue<Double> savvyMul = new RarityValue<Double>(0.0, 0.0, 0.4, 0.5, 0.5, 0.5);
        int level = EndermanPet.getLevel(instance);
        final BigDecimal enderian = new BigDecimal((double)level * enderianMul.getForRarity(instance.getRarity())).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal savvy = new BigDecimal((double)level * savvyMul.getForRarity(instance.getRarity())).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal zealot = new BigDecimal((double)level * 0.25).setScale(2, RoundingMode.HALF_EVEN);
        ArrayList<PetAbility> abilities = new ArrayList<PetAbility>(Collections.singletonList(new PetAbility(){

            @Override
            public String getName() {
                return "Enderian";
            }

            @Override
            public List<String> getDescription(SItem instance) {
                return Arrays.asList("Take " + ChatColor.GREEN + enderian.toPlainString() + "%" + ChatColor.GRAY + " less damage", "from end monsters");
            }

            @Override
            public void onHurt(EntityDamageByEntityEvent e2, Entity damager) {
                SEntity entity = SEntity.findSEntity(damager);
                if (entity == null) {
                    return;
                }
                if (Groups.END_MOBS.contains((Object)entity.getSpecType())) {
                    e2.setDamage(e2.getDamage() - e2.getDamage() * enderian.doubleValue() * 0.01);
                }
            }
        }));
        if (instance.getRarity().isAtLeast(Rarity.RARE)) {
            abilities.add(new PetAbility(){

                @Override
                public String getName() {
                    return "Teleport Savvy";
                }

                @Override
                public List<String> getDescription(SItem instance) {
                    return Arrays.asList("Buffs the Aspect of the End", "ability granting " + ChatColor.GREEN + savvy.toPlainString() + ChatColor.GRAY + " weapon", "damage for 5s on use");
                }
            });
        }
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY)) {
            abilities.add(new PetAbility(){

                @Override
                public String getName() {
                    return "Zealot Madness";
                }

                @Override
                public List<String> getDescription(SItem instance) {
                    return Arrays.asList("Increases your odds to find a", "special Zealot by " + ChatColor.GREEN + zealot.toPlainString() + "%");
                }

                @Override
                public void onZealotAttempt(AtomicDouble chance) {
                    chance.set(chance.get() - chance.get() * zealot.doubleValue());
                }
            });
        }
        return abilities;
    }

    @Override
    public Skill getSkill() {
        return CombatSkill.INSTANCE;
    }

    @Override
    public String getURL() {
        return "6eab75eaa5c9f2c43a0d23cfdce35f4df632e9815001850377385f7b2f039ce1";
    }

    @Override
    public String getDisplayName() {
        return "Enderman";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.PET;
    }

    @Override
    public double getPerCritDamage() {
        return 0.0075;
    }

    @Override
    public void particleBelowA(Player p2, Location l2) {
        p2.spigot().playEffect(l2, Effect.WITCH_MAGIC, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
        p2.spigot().playEffect(l2, Effect.WITCH_MAGIC, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
        p2.spigot().playEffect(l2, Effect.WITCH_MAGIC, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
    }
}

