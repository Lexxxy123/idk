/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.PlayerInventory
 */
package vn.giakhanhvn.skysim.features.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Material;
import org.bukkit.inventory.PlayerInventory;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.item.Ability;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.ItemData;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.PlayerBoostStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;
import vn.giakhanhvn.skysim.features.item.TickingMaterial;
import vn.giakhanhvn.skysim.features.item.accessory.AutoRecombobulator;
import vn.giakhanhvn.skysim.features.item.accessory.BrokenPiggyBank;
import vn.giakhanhvn.skysim.features.item.accessory.CrackedPiggyBank;
import vn.giakhanhvn.skysim.features.item.accessory.FarmingTalisman;
import vn.giakhanhvn.skysim.features.item.accessory.PerfectTalisman;
import vn.giakhanhvn.skysim.features.item.accessory.PiggyBank;
import vn.giakhanhvn.skysim.features.item.accessory.SuperspeedTalisman;
import vn.giakhanhvn.skysim.features.item.accessory.TarantulaTalisman;
import vn.giakhanhvn.skysim.features.item.armor.ArmorSet;
import vn.giakhanhvn.skysim.features.item.armor.BigBounceBoots;
import vn.giakhanhvn.skysim.features.item.armor.CrownOfGreed;
import vn.giakhanhvn.skysim.features.item.armor.DarkGoggles;
import vn.giakhanhvn.skysim.features.item.armor.ObsidianChestplate;
import vn.giakhanhvn.skysim.features.item.armor.PrecursorEye;
import vn.giakhanhvn.skysim.features.item.armor.ShadowGoggles;
import vn.giakhanhvn.skysim.features.item.armor.SpidersBoots;
import vn.giakhanhvn.skysim.features.item.armor.TarantulaHelmet;
import vn.giakhanhvn.skysim.features.item.armor.WardenHelmet;
import vn.giakhanhvn.skysim.features.item.armor.WitherGoggles;
import vn.giakhanhvn.skysim.features.item.armor.hardened.HardenedDiamondBoots;
import vn.giakhanhvn.skysim.features.item.armor.hardened.HardenedDiamondChestplate;
import vn.giakhanhvn.skysim.features.item.armor.hardened.HardenedDiamondHelmet;
import vn.giakhanhvn.skysim.features.item.armor.hardened.HardenedDiamondLeggings;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorBoots;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorChestplate;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorHelmet;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorLeggings;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorSet;
import vn.giakhanhvn.skysim.features.item.armor.miner.MinerBoots;
import vn.giakhanhvn.skysim.features.item.armor.miner.MinerChestplate;
import vn.giakhanhvn.skysim.features.item.armor.miner.MinerHelmet;
import vn.giakhanhvn.skysim.features.item.armor.miner.MinerLeggings;
import vn.giakhanhvn.skysim.features.item.armor.miner.MinerSet;
import vn.giakhanhvn.skysim.features.item.armor.necron.NecronBoots;
import vn.giakhanhvn.skysim.features.item.armor.necron.NecronChestplate;
import vn.giakhanhvn.skysim.features.item.armor.necron.NecronFullSet;
import vn.giakhanhvn.skysim.features.item.armor.necron.NecronHelmet;
import vn.giakhanhvn.skysim.features.item.armor.necron.NecronLeggings;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorBoots;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorChestplate;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorHelmet;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorLeggings;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorSet;
import vn.giakhanhvn.skysim.features.item.armor.storm.StormBoots;
import vn.giakhanhvn.skysim.features.item.armor.storm.StormChestplate;
import vn.giakhanhvn.skysim.features.item.armor.storm.StormFullSet;
import vn.giakhanhvn.skysim.features.item.armor.storm.StormHelmet;
import vn.giakhanhvn.skysim.features.item.armor.storm.StormLeggings;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.chainmail.ChainmailBoots;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.chainmail.ChainmailChestplate;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.chainmail.ChainmailHelmet;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.chainmail.ChainmailLeggings;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.diamond.DiamondBoots;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.diamond.DiamondChestplate;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.diamond.DiamondHelmet;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.diamond.DiamondLeggings;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.golden.GoldenBoots;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.golden.GoldenChestplate;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.golden.GoldenHelmet;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.golden.GoldenLeggings;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.iron.IronBoots;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.iron.IronChestplate;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.iron.IronHelmet;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.iron.IronLeggings;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.leather.LeatherBoots;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.leather.LeatherChestplate;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.leather.LeatherHelmet;
import vn.giakhanhvn.skysim.features.item.armor.vanilla.leather.LeatherLeggings;
import vn.giakhanhvn.skysim.features.item.axe.vanilla.DiamondAxe;
import vn.giakhanhvn.skysim.features.item.axe.vanilla.GoldenAxe;
import vn.giakhanhvn.skysim.features.item.axe.vanilla.IronAxe;
import vn.giakhanhvn.skysim.features.item.axe.vanilla.StoneAxe;
import vn.giakhanhvn.skysim.features.item.axe.vanilla.WoodenAxe;
import vn.giakhanhvn.skysim.features.item.bow.Bow;
import vn.giakhanhvn.skysim.features.item.bow.DeathBow;
import vn.giakhanhvn.skysim.features.item.bow.EndStoneBow;
import vn.giakhanhvn.skysim.features.item.bow.HurricaneBow;
import vn.giakhanhvn.skysim.features.item.bow.JujuShortBow;
import vn.giakhanhvn.skysim.features.item.bow.MosquitoBow;
import vn.giakhanhvn.skysim.features.item.bow.RunaansBow;
import vn.giakhanhvn.skysim.features.item.bow.Terminator;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.protector.ProtectorDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.strong.StrongDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.superior.SuperiorDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.wise.WiseDragonSet;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonFragment;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonLeggings;
import vn.giakhanhvn.skysim.features.item.dragon.young.YoungDragonSet;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedAcaciaWood;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedBirchWood;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedBone;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedCharcoal;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedCoal;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedDarkOakWood;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedDiamond;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedDiamondBlock;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedEndStone;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedEnderPearl;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedEyeOfEnder;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedJungleWood;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedOakWood;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedObsidian;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedPotato;
import vn.giakhanhvn.skysim.features.item.enchanted.EnchantedSpruceWood;
import vn.giakhanhvn.skysim.features.item.enchanting.EnchantedBook;
import vn.giakhanhvn.skysim.features.item.entity.AtonedHorrorHead;
import vn.giakhanhvn.skysim.features.item.entity.BS1;
import vn.giakhanhvn.skysim.features.item.entity.BS2;
import vn.giakhanhvn.skysim.features.item.entity.BS3;
import vn.giakhanhvn.skysim.features.item.entity.BS4;
import vn.giakhanhvn.skysim.features.item.entity.BS5;
import vn.giakhanhvn.skysim.features.item.entity.BS6;
import vn.giakhanhvn.skysim.features.item.entity.BS7;
import vn.giakhanhvn.skysim.features.item.entity.BS8;
import vn.giakhanhvn.skysim.features.item.entity.BS9;
import vn.giakhanhvn.skysim.features.item.entity.JerryGunBullet;
import vn.giakhanhvn.skysim.features.item.entity.Nukekubi;
import vn.giakhanhvn.skysim.features.item.entity.RevenantHorrorHead;
import vn.giakhanhvn.skysim.features.item.entity.RevenantHorrorHead2;
import vn.giakhanhvn.skysim.features.item.entity.TerracottaHead;
import vn.giakhanhvn.skysim.features.item.farming.BrownMushroom;
import vn.giakhanhvn.skysim.features.item.farming.Cactus;
import vn.giakhanhvn.skysim.features.item.farming.Carrot;
import vn.giakhanhvn.skysim.features.item.farming.CocoaBeans;
import vn.giakhanhvn.skysim.features.item.farming.Melon;
import vn.giakhanhvn.skysim.features.item.farming.Potato;
import vn.giakhanhvn.skysim.features.item.farming.Pumpkin;
import vn.giakhanhvn.skysim.features.item.farming.RedMushroom;
import vn.giakhanhvn.skysim.features.item.farming.SugarCane;
import vn.giakhanhvn.skysim.features.item.farming.WheatSeeds;
import vn.giakhanhvn.skysim.features.item.foraging.AcaciaWood;
import vn.giakhanhvn.skysim.features.item.foraging.BirchWood;
import vn.giakhanhvn.skysim.features.item.foraging.DarkOakWood;
import vn.giakhanhvn.skysim.features.item.foraging.JungleWood;
import vn.giakhanhvn.skysim.features.item.foraging.OakWood;
import vn.giakhanhvn.skysim.features.item.foraging.SpruceWood;
import vn.giakhanhvn.skysim.features.item.hoe.vanilla.DiamondHoe;
import vn.giakhanhvn.skysim.features.item.hoe.vanilla.GoldenHoe;
import vn.giakhanhvn.skysim.features.item.hoe.vanilla.IronHoe;
import vn.giakhanhvn.skysim.features.item.hoe.vanilla.StoneHoe;
import vn.giakhanhvn.skysim.features.item.hoe.vanilla.WoodenHoe;
import vn.giakhanhvn.skysim.features.item.mining.CoalOre;
import vn.giakhanhvn.skysim.features.item.mining.Cobblestone;
import vn.giakhanhvn.skysim.features.item.mining.DiamondBlock;
import vn.giakhanhvn.skysim.features.item.mining.DiamondOre;
import vn.giakhanhvn.skysim.features.item.mining.EmeraldOre;
import vn.giakhanhvn.skysim.features.item.mining.EndStone;
import vn.giakhanhvn.skysim.features.item.mining.Glowstone;
import vn.giakhanhvn.skysim.features.item.mining.GoldOre;
import vn.giakhanhvn.skysim.features.item.mining.Gravel;
import vn.giakhanhvn.skysim.features.item.mining.Ice;
import vn.giakhanhvn.skysim.features.item.mining.IronOre;
import vn.giakhanhvn.skysim.features.item.mining.LapisLazuliOre;
import vn.giakhanhvn.skysim.features.item.mining.Mitril;
import vn.giakhanhvn.skysim.features.item.mining.NetherQuartzOre;
import vn.giakhanhvn.skysim.features.item.mining.Netherrack;
import vn.giakhanhvn.skysim.features.item.mining.Obsidian;
import vn.giakhanhvn.skysim.features.item.mining.RedstoneOre;
import vn.giakhanhvn.skysim.features.item.mining.Sand;
import vn.giakhanhvn.skysim.features.item.mining.Stone;
import vn.giakhanhvn.skysim.features.item.mining.Titanium;
import vn.giakhanhvn.skysim.features.item.oddities.BagOfCoins;
import vn.giakhanhvn.skysim.features.item.oddities.Bedrock;
import vn.giakhanhvn.skysim.features.item.oddities.BoosterCookie;
import vn.giakhanhvn.skysim.features.item.oddities.CompressedBits;
import vn.giakhanhvn.skysim.features.item.oddities.CompressedVoidFrag;
import vn.giakhanhvn.skysim.features.item.oddities.CreativeMind;
import vn.giakhanhvn.skysim.features.item.oddities.CrystalFragment;
import vn.giakhanhvn.skysim.features.item.oddities.DeadBushOfLove;
import vn.giakhanhvn.skysim.features.item.oddities.DemonsPearl;
import vn.giakhanhvn.skysim.features.item.oddities.DiamondSadanTrophy;
import vn.giakhanhvn.skysim.features.item.oddities.DimoonCatalyst;
import vn.giakhanhvn.skysim.features.item.oddities.DimoonFragment;
import vn.giakhanhvn.skysim.features.item.oddities.EtherwarpConduit;
import vn.giakhanhvn.skysim.features.item.oddities.EtherwarpMerger;
import vn.giakhanhvn.skysim.features.item.oddities.EtherwarpTranscoder;
import vn.giakhanhvn.skysim.features.item.oddities.GameAnnihilator;
import vn.giakhanhvn.skysim.features.item.oddities.GameBreaker;
import vn.giakhanhvn.skysim.features.item.oddities.GodPot;
import vn.giakhanhvn.skysim.features.item.oddities.GoldSadanTrophy;
import vn.giakhanhvn.skysim.features.item.oddities.GoldenPowder;
import vn.giakhanhvn.skysim.features.item.oddities.GrapplingHook;
import vn.giakhanhvn.skysim.features.item.oddities.GyrokineticEye;
import vn.giakhanhvn.skysim.features.item.oddities.HotPotatoBook;
import vn.giakhanhvn.skysim.features.item.oddities.JudgementCore;
import vn.giakhanhvn.skysim.features.item.oddities.MaddoxBatphone;
import vn.giakhanhvn.skysim.features.item.oddities.NecronHandle;
import vn.giakhanhvn.skysim.features.item.oddities.NullSphere;
import vn.giakhanhvn.skysim.features.item.oddities.QuiverArrow;
import vn.giakhanhvn.skysim.features.item.oddities.Recombobulator3000;
import vn.giakhanhvn.skysim.features.item.oddities.RefinedPowder;
import vn.giakhanhvn.skysim.features.item.oddities.RemnantOfTheEye;
import vn.giakhanhvn.skysim.features.item.oddities.RevenantViscera;
import vn.giakhanhvn.skysim.features.item.oddities.ShardoftheDiamondOrb;
import vn.giakhanhvn.skysim.features.item.oddities.ShardoftheShredded;
import vn.giakhanhvn.skysim.features.item.oddities.SkyBlockMenu;
import vn.giakhanhvn.skysim.features.item.oddities.SleepingEye;
import vn.giakhanhvn.skysim.features.item.oddities.SummoningEye;
import vn.giakhanhvn.skysim.features.item.oddities.SummoningFrame;
import vn.giakhanhvn.skysim.features.item.oddities.VoidFragment;
import vn.giakhanhvn.skysim.features.item.oddities.WardenHeart;
import vn.giakhanhvn.skysim.features.item.oddities.WaterBottle;
import vn.giakhanhvn.skysim.features.item.oddities.WeakWolfCatalyst;
import vn.giakhanhvn.skysim.features.item.oddities.WeirdTuba;
import vn.giakhanhvn.skysim.features.item.orb.ManaFluxPowerOrb;
import vn.giakhanhvn.skysim.features.item.orb.OrbBuff;
import vn.giakhanhvn.skysim.features.item.orb.OverfluxPowerOrb;
import vn.giakhanhvn.skysim.features.item.orb.PlasmafluxPowerOrb;
import vn.giakhanhvn.skysim.features.item.orb.QuantumfluxPowerOrb;
import vn.giakhanhvn.skysim.features.item.orb.RadiantPowerOrb;
import vn.giakhanhvn.skysim.features.item.pet.BabyYeti;
import vn.giakhanhvn.skysim.features.item.pet.BabyYeti2;
import vn.giakhanhvn.skysim.features.item.pet.BlackCat;
import vn.giakhanhvn.skysim.features.item.pet.EnderDragonPet;
import vn.giakhanhvn.skysim.features.item.pet.EnderDragonPet2;
import vn.giakhanhvn.skysim.features.item.pet.EndermanPet;
import vn.giakhanhvn.skysim.features.item.pet.GoldenTigerPet;
import vn.giakhanhvn.skysim.features.item.pet.GungaPet;
import vn.giakhanhvn.skysim.features.item.pet.MagicivyPet;
import vn.giakhanhvn.skysim.features.item.pet.TankPet;
import vn.giakhanhvn.skysim.features.item.pickaxe.vanilla.DiamondPickaxe;
import vn.giakhanhvn.skysim.features.item.pickaxe.vanilla.GoldenPickaxe;
import vn.giakhanhvn.skysim.features.item.pickaxe.vanilla.IronPickaxe;
import vn.giakhanhvn.skysim.features.item.pickaxe.vanilla.StonePickaxe;
import vn.giakhanhvn.skysim.features.item.pickaxe.vanilla.WoodenPickaxe;
import vn.giakhanhvn.skysim.features.item.revenant.BeheadedHorror;
import vn.giakhanhvn.skysim.features.item.revenant.FoulFlesh;
import vn.giakhanhvn.skysim.features.item.revenant.RevenantCatalyst;
import vn.giakhanhvn.skysim.features.item.revenant.RevenantFlesh;
import vn.giakhanhvn.skysim.features.item.revenant.ScytheBlade;
import vn.giakhanhvn.skysim.features.item.revenant.UndeadCatalyst;
import vn.giakhanhvn.skysim.features.item.rune.BiteRune;
import vn.giakhanhvn.skysim.features.item.rune.CoutureRune;
import vn.giakhanhvn.skysim.features.item.rune.PestilenceRune;
import vn.giakhanhvn.skysim.features.item.rune.SnakeRune;
import vn.giakhanhvn.skysim.features.item.rune.SpiritRune;
import vn.giakhanhvn.skysim.features.item.shovel.vanilla.DiamondShovel;
import vn.giakhanhvn.skysim.features.item.shovel.vanilla.GoldenShovel;
import vn.giakhanhvn.skysim.features.item.shovel.vanilla.IronShovel;
import vn.giakhanhvn.skysim.features.item.shovel.vanilla.StoneShovel;
import vn.giakhanhvn.skysim.features.item.shovel.vanilla.WoodenShovel;
import vn.giakhanhvn.skysim.features.item.storage.GreaterBackpack;
import vn.giakhanhvn.skysim.features.item.storage.JumboBackpack;
import vn.giakhanhvn.skysim.features.item.storage.LargeBackpack;
import vn.giakhanhvn.skysim.features.item.storage.MediumBackpack;
import vn.giakhanhvn.skysim.features.item.storage.SmallBackpack;
import vn.giakhanhvn.skysim.features.item.sven.GrizzlyBait;
import vn.giakhanhvn.skysim.features.item.sven.HamsterWheel;
import vn.giakhanhvn.skysim.features.item.sven.OverfluxCapacitor;
import vn.giakhanhvn.skysim.features.item.sven.RedClawEgg;
import vn.giakhanhvn.skysim.features.item.sven.WolfTooth;
import vn.giakhanhvn.skysim.features.item.tarantula.DigestedMosquito;
import vn.giakhanhvn.skysim.features.item.tarantula.FlySwatter;
import vn.giakhanhvn.skysim.features.item.tarantula.SpiderCatalyst;
import vn.giakhanhvn.skysim.features.item.tarantula.TarantulaWeb;
import vn.giakhanhvn.skysim.features.item.tarantula.ToxicArrowPoison;
import vn.giakhanhvn.skysim.features.item.weapon.AspectOfTheDragons;
import vn.giakhanhvn.skysim.features.item.weapon.AspectOfTheEnd;
import vn.giakhanhvn.skysim.features.item.weapon.AspectOfTheJerry;
import vn.giakhanhvn.skysim.features.item.weapon.AspectOfTheVoid;
import vn.giakhanhvn.skysim.features.item.weapon.AtomsplitKatana;
import vn.giakhanhvn.skysim.features.item.weapon.AxeOfTheShredded;
import vn.giakhanhvn.skysim.features.item.weapon.Bonemerang;
import vn.giakhanhvn.skysim.features.item.weapon.BonzoStaff;
import vn.giakhanhvn.skysim.features.item.weapon.Dagger;
import vn.giakhanhvn.skysim.features.item.weapon.EdibleMace;
import vn.giakhanhvn.skysim.features.item.weapon.EmeraldBlade;
import vn.giakhanhvn.skysim.features.item.weapon.Excrarion;
import vn.giakhanhvn.skysim.features.item.weapon.FloridZombieSword;
import vn.giakhanhvn.skysim.features.item.weapon.FlowerOfTruth;
import vn.giakhanhvn.skysim.features.item.weapon.FrozenScythe;
import vn.giakhanhvn.skysim.features.item.weapon.GiantSword;
import vn.giakhanhvn.skysim.features.item.weapon.GyrokineticWand;
import vn.giakhanhvn.skysim.features.item.weapon.Hyperion;
import vn.giakhanhvn.skysim.features.item.weapon.IceSprayWand;
import vn.giakhanhvn.skysim.features.item.weapon.JerryChineGun;
import vn.giakhanhvn.skysim.features.item.weapon.LeapingSword;
import vn.giakhanhvn.skysim.features.item.weapon.LividDagger;
import vn.giakhanhvn.skysim.features.item.weapon.MidasStaff;
import vn.giakhanhvn.skysim.features.item.weapon.PoochSword;
import vn.giakhanhvn.skysim.features.item.weapon.PrismarineBlade;
import vn.giakhanhvn.skysim.features.item.weapon.ReaperFalchion;
import vn.giakhanhvn.skysim.features.item.weapon.RevantusSword;
import vn.giakhanhvn.skysim.features.item.weapon.RogueSword;
import vn.giakhanhvn.skysim.features.item.weapon.Scylla;
import vn.giakhanhvn.skysim.features.item.weapon.ShadowFury;
import vn.giakhanhvn.skysim.features.item.weapon.SoulWhip;
import vn.giakhanhvn.skysim.features.item.weapon.Valkyrie;
import vn.giakhanhvn.skysim.features.item.weapon.VoidedgeKatana;
import vn.giakhanhvn.skysim.features.item.weapon.VoidwalkerKatana;
import vn.giakhanhvn.skysim.features.item.weapon.VorpalKatana;
import vn.giakhanhvn.skysim.features.item.weapon.ZombieSword;
import vn.giakhanhvn.skysim.features.item.weapon.vanilla.DiamondSword;
import vn.giakhanhvn.skysim.features.item.weapon.vanilla.GoldenSword;
import vn.giakhanhvn.skysim.features.item.weapon.vanilla.IronSword;
import vn.giakhanhvn.skysim.features.item.weapon.vanilla.StoneSword;
import vn.giakhanhvn.skysim.features.item.weapon.vanilla.WoodenSword;
import vn.giakhanhvn.skysim.util.SUtil;

public enum SMaterial {
    DWARVEN_MITRIL(Material.PRISMARINE_CRYSTALS, Mitril.class),
    DWARVEN_TITANIUM(Material.SKULL_ITEM, Titanium.class),
    HIDDEN_BOOSTER_COOKIE(Material.COOKIE, BoosterCookie.class),
    HIDDEN_ETHERWARP_CONDUIT(Material.SKULL_ITEM, EtherwarpConduit.class),
    HIDDEN_ETHERWARP_MERGER(Material.SKULL_ITEM, EtherwarpMerger.class),
    HIDDEN_ETHERWARP_TRANSCODER(Material.SKULL_ITEM, EtherwarpTranscoder.class),
    HIDDEN_GYROKINETIC_WAND(Material.BLAZE_ROD, GyrokineticWand.class),
    HIDDEN_GOLDEN_TIGER_2022(Material.SKULL_ITEM, GoldenTigerPet.class),
    HIDDEN_MAGICIVY(Material.SKULL_ITEM, MagicivyPet.class),
    HIDDEN_USSR_T34_TANK_PET(Material.SKULL_ITEM, TankPet.class),
    HIDDEN_REFINED_POWDER(Material.SULPHUR, RefinedPowder.class),
    HIDDEN_COMPRESSED_BITS(Material.DIAMOND, CompressedBits.class),
    HIDDEN_GYRO_EYE(Material.EYE_OF_ENDER, GyrokineticEye.class),
    HIDDEN_SOUL_WHIP(Material.FISHING_ROD, SoulWhip.class),
    HIDDEN_VOID_FRAGMENT(Material.EYE_OF_ENDER, VoidFragment.class),
    HIDDEN_DEMONS_PEARL(Material.SKULL_ITEM, DemonsPearl.class),
    HIDDEN_COMPRESSED_VOID_FRAG(Material.SKULL_ITEM, CompressedVoidFrag.class),
    HIDDEN_DIMOON_GEM(Material.SKULL_ITEM, DimoonCatalyst.class),
    HIDDEN_DIMOON_FRAG(Material.SKULL_ITEM, DimoonFragment.class),
    DAGGER(Material.IRON_SWORD, Dagger.class),
    ASPECT_OF_THE_END(Material.DIAMOND_SWORD, AspectOfTheEnd.class),
    LEAPING_SWORD(Material.GOLD_SWORD, LeapingSword.class),
    ASPECT_OF_THE_DRAGONS(Material.DIAMOND_SWORD, AspectOfTheDragons.class),
    ASPECT_OF_THE_JERRY(Material.WOOD_SWORD, AspectOfTheJerry.class),
    ROGUE_SWORD(Material.GOLD_SWORD, RogueSword.class),
    EMERALD_BLADE(Material.EMERALD, EmeraldBlade.class),
    HYPERION(Material.IRON_SWORD, Hyperion.class),
    VALKYIRE(Material.IRON_SWORD, Valkyrie.class),
    SCYLLA(Material.IRON_SWORD, Scylla.class),
    GIANTS_SWORD(Material.IRON_SWORD, GiantSword.class),
    MIDAS_STAFF(Material.GOLD_SPADE, MidasStaff.class),
    BONEMERANG(Material.BONE, Bonemerang.class),
    AXE_OF_THE_SHREDDED(Material.DIAMOND_AXE, AxeOfTheShredded.class),
    TERMINATOR(Material.BOW, Terminator.class),
    REAPER_FALCHION(Material.DIAMOND_SWORD, ReaperFalchion.class),
    FLOWER_OF_TRUTH(Material.RED_ROSE, FlowerOfTruth.class),
    LIVID_DAGGER(Material.IRON_SWORD, LividDagger.class),
    EDIBLE_MACE(Material.MUTTON, EdibleMace.class),
    ASPECT_OF_THE_VOID(Material.DIAMOND_SPADE, AspectOfTheVoid.class),
    SHADOW_FURY(Material.DIAMOND_SWORD, ShadowFury.class),
    POOCH_SWORD(Material.GOLD_SWORD, PoochSword.class),
    FROZEN_SCYTHE(Material.IRON_HOE, FrozenScythe.class),
    BONZO_STAFF(Material.BLAZE_ROD, BonzoStaff.class),
    ICE_WAND(Material.STICK, IceSprayWand.class),
    ZOMBIE_SWORD_T2(Material.GOLD_SWORD, ZombieSword.class),
    ZOMBIE_SWORD_T3(Material.GOLD_SWORD, FloridZombieSword.class),
    PRISMARINE_BLADE(Material.PRISMARINE_SHARD, PrismarineBlade.class),
    HIDDEN_EXCRARION(Material.GOLD_SWORD, Excrarion.class),
    HIDDEN_SHARD_DIAMOND(Material.SKULL_ITEM, ShardoftheDiamondOrb.class),
    HIDDEN_REVANTUS_SWORD(Material.IRON_SWORD, RevantusSword.class),
    WARDEN_HELMET(Material.SKULL_ITEM, WardenHelmet.class),
    CROWN_OF_GREED(Material.GOLD_HELMET, CrownOfGreed.class),
    PRECURSOR_EYE(Material.SKULL_ITEM, PrecursorEye.class),
    NECRON_HELMET(Material.SKULL_ITEM, NecronHelmet.class),
    NECRON_CHESTPLATE(Material.LEATHER_CHESTPLATE, NecronChestplate.class),
    NECRON_LEGGINGS(Material.LEATHER_LEGGINGS, NecronLeggings.class),
    NECRON_BOOTS(Material.LEATHER_BOOTS, NecronBoots.class),
    STORM_HELMET(Material.SKULL_ITEM, StormHelmet.class),
    STORM_CHESTPLATE(Material.LEATHER_CHESTPLATE, StormChestplate.class),
    STORM_LEGGINGS(Material.LEATHER_LEGGINGS, StormLeggings.class),
    STORM_BOOTS(Material.LEATHER_BOOTS, StormBoots.class),
    VOIDWALKER_KATANA(Material.IRON_SWORD, VoidwalkerKatana.class),
    VOIDEDGE_KATANA(Material.DIAMOND_SWORD, VoidedgeKatana.class),
    VORPAL_KATANA(Material.DIAMOND_SWORD, VorpalKatana.class),
    ATOMSPLIT_KATANA(Material.DIAMOND_SWORD, AtomsplitKatana.class),
    TARANTULA_HELMET(Material.LEATHER_HELMET, TarantulaHelmet.class),
    NECRONS_HANDLE(Material.STICK, NecronHandle.class),
    SORROW_HELMET(Material.CHAINMAIL_HELMET, SorrowArmorHelmet.class),
    SORROW_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, SorrowArmorChestplate.class),
    SORROW_LEGGINGS(Material.CHAINMAIL_LEGGINGS, SorrowArmorLeggings.class),
    SORROW_BOOTS(Material.CHAINMAIL_BOOTS, SorrowArmorBoots.class),
    JUJU_SHORTBOW(Material.BOW, JujuShortBow.class),
    DEATH_BOW(Material.BOW, DeathBow.class),
    MOSQUITO_BOW(Material.BOW, MosquitoBow.class),
    RUNAANS_BOW(Material.BOW, RunaansBow.class),
    HURRICANE_BOW(Material.BOW, HurricaneBow.class),
    END_STONE_BOW(Material.BOW, EndStoneBow.class),
    ENDER_DRAGON_PET(Material.SKULL_ITEM, EnderDragonPet.class),
    ENDER_DRAGON_PET2(Material.SKULL_ITEM, EnderDragonPet2.class),
    BABY_YETI_PET(Material.SKULL_ITEM, BabyYeti.class),
    BABY_YETI_PET2(Material.SKULL_ITEM, BabyYeti2.class),
    BLACK_CAT_PET(Material.SKULL_ITEM, BlackCat.class),
    WEIRD_TUBA(Material.HOPPER, WeirdTuba.class),
    GOD_POT(Material.SKULL_ITEM, GodPot.class),
    RADIANT_POWER_ORB(Material.SKULL_ITEM, RadiantPowerOrb.class),
    MANA_FLUX_POWER_ORB(Material.SKULL_ITEM, ManaFluxPowerOrb.class),
    OVERFLUX_POWER_ORB(Material.SKULL_ITEM, OverfluxPowerOrb.class),
    PLASMAFLUX_POWER_ORB(Material.SKULL_ITEM, PlasmafluxPowerOrb.class),
    HIDDEN_QUANTUMFLUX_POWER_ORB(Material.SKULL_ITEM, QuantumfluxPowerOrb.class),
    HOT_POTATO_BOOK(Material.BOOK, HotPotatoBook.class),
    DEAD_BUSH_OF_LOVE(Material.DEAD_BUSH, DeadBushOfLove.class),
    GAME_BREAKER(Material.TNT, GameBreaker.class),
    GAME_ANNIHILATOR(Material.SKULL_ITEM, GameAnnihilator.class),
    CREATIVE_MIND(Material.PAINTING, CreativeMind.class),
    GOLDEN_TROPHY_SADAN(Material.SKULL_ITEM, GoldSadanTrophy.class),
    DIAMOND_TROPHY_SADAN(Material.SKULL_ITEM, DiamondSadanTrophy.class),
    SUMMONING_EYE(Material.SKULL_ITEM, SummoningEye.class),
    REMNANT_OF_THE_EYE(Material.SKULL_ITEM, RemnantOfTheEye.class),
    WITHER_GOGGLES(Material.SKULL_ITEM, WitherGoggles.class),
    SHADOW_GOGGLES(Material.SKULL_ITEM, ShadowGoggles.class),
    DARK_GOGGLES(Material.SKULL_ITEM, DarkGoggles.class),
    WISE_DRAGON_HELMET(Material.SKULL_ITEM, WiseDragonHelmet.class),
    WISE_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, WiseDragonChestplate.class),
    WISE_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, WiseDragonLeggings.class),
    WISE_DRAGON_BOOTS(Material.LEATHER_BOOTS, WiseDragonBoots.class),
    WISE_DRAGON_FRAGMENT(Material.SKULL_ITEM, WiseDragonFragment.class),
    YOUNG_DRAGON_HELMET(Material.SKULL_ITEM, YoungDragonHelmet.class),
    YOUNG_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, YoungDragonChestplate.class),
    YOUNG_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, YoungDragonLeggings.class),
    YOUNG_DRAGON_BOOTS(Material.LEATHER_BOOTS, YoungDragonBoots.class),
    YOUNG_DRAGON_FRAGMENT(Material.SKULL_ITEM, YoungDragonFragment.class),
    SUPERIOR_DRAGON_HELMET(Material.SKULL_ITEM, SuperiorDragonHelmet.class),
    SUPERIOR_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, SuperiorDragonChestplate.class),
    SUPERIOR_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, SuperiorDragonLeggings.class),
    SUPERIOR_DRAGON_BOOTS(Material.LEATHER_BOOTS, SuperiorDragonBoots.class),
    SUPERIOR_DRAGON_FRAGMENT(Material.SKULL_ITEM, SuperiorDragonFragment.class),
    UNSTABLE_DRAGON_HELMET(Material.SKULL_ITEM, UnstableDragonHelmet.class),
    UNSTABLE_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, UnstableDragonChestplate.class),
    UNSTABLE_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, UnstableDragonLeggings.class),
    UNSTABLE_DRAGON_BOOTS(Material.LEATHER_BOOTS, UnstableDragonBoots.class),
    UNSTABLE_DRAGON_FRAGMENT(Material.SKULL_ITEM, UnstableDragonFragment.class),
    STRONG_DRAGON_HELMET(Material.SKULL_ITEM, StrongDragonHelmet.class),
    STRONG_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, StrongDragonChestplate.class),
    STRONG_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, StrongDragonLeggings.class),
    STRONG_DRAGON_BOOTS(Material.LEATHER_BOOTS, StrongDragonBoots.class),
    STRONG_DRAGON_FRAGMENT(Material.SKULL_ITEM, StrongDragonFragment.class),
    OLD_DRAGON_HELMET(Material.SKULL_ITEM, OldDragonHelmet.class),
    OLD_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, OldDragonChestplate.class),
    OLD_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, OldDragonLeggings.class),
    OLD_DRAGON_BOOTS(Material.LEATHER_BOOTS, OldDragonBoots.class),
    OLD_DRAGON_FRAGMENT(Material.SKULL_ITEM, OldDragonFragment.class),
    PROTECTOR_DRAGON_HELMET(Material.SKULL_ITEM, ProtectorDragonHelmet.class),
    PROTECTOR_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, ProtectorDragonChestplate.class),
    PROTECTOR_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, ProtectorDragonLeggings.class),
    PROTECTOR_DRAGON_BOOTS(Material.LEATHER_BOOTS, ProtectorDragonBoots.class),
    PROTECTOR_DRAGON_FRAGMENT(Material.SKULL_ITEM, ProtectorDragonFragment.class),
    LAPIS_ARMOR_HELMET(Material.SEA_LANTERN, LapisArmorHelmet.class),
    LAPIS_ARMOR_CHESTPLATE(Material.LEATHER_CHESTPLATE, LapisArmorChestplate.class),
    LAPIS_ARMOR_LEGGINGS(Material.LEATHER_LEGGINGS, LapisArmorLeggings.class),
    LAPIS_ARMOR_BOOTS(Material.LEATHER_BOOTS, LapisArmorBoots.class),
    MINER_HELMET(Material.DIAMOND_HELMET, MinerHelmet.class),
    MINER_CHESTPLATE(Material.DIAMOND_CHESTPLATE, MinerChestplate.class),
    MINER_LEGGINGS(Material.DIAMOND_LEGGINGS, MinerLeggings.class),
    MINER_BOOTS(Material.DIAMOND_BOOTS, MinerBoots.class),
    HARDENED_DIAMOND_HELMET(Material.DIAMOND_HELMET, HardenedDiamondHelmet.class),
    HARDENED_DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE, HardenedDiamondChestplate.class),
    HARDENED_DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS, HardenedDiamondLeggings.class),
    HARDENED_DIAMOND_BOOTS(Material.DIAMOND_BOOTS, HardenedDiamondBoots.class),
    OBSIDIAN_CHESTPLATE(Material.LEATHER_CHESTPLATE, ObsidianChestplate.class),
    SPIDERS_BOOTS(Material.IRON_BOOTS, SpidersBoots.class),
    BIG_BOUNCE_BOOTS(Material.LEATHER_BOOTS, BigBounceBoots.class),
    SUPERSPEED_TALISMAN(Material.SKULL_ITEM, SuperspeedTalisman.class),
    AUTO_RECOMBOBULATOR(Material.SKULL_ITEM, AutoRecombobulator.class),
    PERFECT_TALISMAN(Material.SKULL_ITEM, PerfectTalisman.class),
    PIGGY_BANK(Material.SKULL_ITEM, PiggyBank.class),
    CRACKED_PIGGY_BANK(Material.SKULL_ITEM, CrackedPiggyBank.class),
    BROKEN_PIGGY_BANK(Material.SKULL_ITEM, BrokenPiggyBank.class),
    TARANTULA_TALISMAN(Material.SKULL_ITEM, TarantulaTalisman.class),
    FARMING_TALISMAN(Material.SKULL_ITEM, FarmingTalisman.class),
    ENCHANTED_BONE(Material.BONE, EnchantedBone.class),
    ENCHANTED_OBSIDIAN(Material.OBSIDIAN, EnchantedObsidian.class),
    ENCHANTED_ENDER_PEARL(Material.ENDER_PEARL, EnchantedEnderPearl.class),
    ENCHANTED_EYE_OF_ENDER(Material.EYE_OF_ENDER, EnchantedEyeOfEnder.class),
    ENCHANTED_END_STONE(Material.ENDER_STONE, EnchantedEndStone.class),
    ENCHANTED_COAL(Material.COAL, EnchantedCoal.class),
    ENCHANTED_CHARCOAL(Material.COAL, EnchantedCharcoal.class, 1),
    ENCHANTED_DIAMOND(Material.DIAMOND, EnchantedDiamond.class),
    ENCHANTED_DIAMOND_BLOCK(Material.DIAMOND_BLOCK, EnchantedDiamondBlock.class),
    ENCHANTED_OAK_WOOD(Material.LOG, EnchantedOakWood.class),
    ENCHANTED_SPRUCE_WOOD(Material.LOG, EnchantedSpruceWood.class, 1),
    ENCHANTED_BIRCH_WOOD(Material.LOG, EnchantedBirchWood.class, 2),
    ENCHANTED_JUNGLE_WOOD(Material.LOG, EnchantedJungleWood.class, 3),
    ENCHANTED_ACACIA_WOOD(Material.LOG_2, EnchantedAcaciaWood.class),
    ENCHANTED_DARK_OAK_WOOD(Material.LOG_2, EnchantedDarkOakWood.class, 1),
    ENCHANTED_POTATO(Material.POTATO_ITEM, EnchantedPotato.class),
    ENCHANTED_BAKED_POTATO(Material.BAKED_POTATO, EnchantedPotato.class),
    BAG_OF_COINS(Material.SKULL_ITEM, BagOfCoins.class),
    SKYBLOCK_MENU(Material.NETHER_STAR, SkyBlockMenu.class),
    QUIVER_ARROW(Material.ARROW, QuiverArrow.class),
    GRAPPLING_HOOK(Material.FISHING_ROD, GrapplingHook.class),
    WATER_BOTTLE(Material.POTION, WaterBottle.class),
    MADDOX_BATPHONE(Material.SKULL_ITEM, MaddoxBatphone.class),
    CRYSTAL_FRAGMENT(Material.QUARTZ, CrystalFragment.class),
    GOLDEN_POWDER(Material.GLOWSTONE_DUST, GoldenPowder.class),
    WEAK_WOLF_CATALYST(Material.BONE, WeakWolfCatalyst.class),
    REVENANT_HORROR_HEAD(Material.SKULL_ITEM, RevenantHorrorHead.class),
    ENCHANTED_BOOK(Material.ENCHANTED_BOOK, EnchantedBook.class, true),
    RECOMBOBULATOR_3000(Material.SKULL_ITEM, Recombobulator3000.class),
    SMALL_BACKPACK(Material.SKULL_ITEM, SmallBackpack.class),
    MEDIUM_BACKPACK(Material.SKULL_ITEM, MediumBackpack.class),
    LARGE_BACKPACK(Material.SKULL_ITEM, LargeBackpack.class),
    GREATER_BACKPACK(Material.SKULL_ITEM, GreaterBackpack.class),
    JUMBO_BACKPACK(Material.SKULL_ITEM, JumboBackpack.class),
    REVENANT_FLESH(Material.ROTTEN_FLESH, RevenantFlesh.class),
    FOUL_FLESH(Material.COAL, FoulFlesh.class, 1),
    UNDEAD_CATALYST(Material.SKULL_ITEM, UndeadCatalyst.class),
    BEHEADED_HORROR(Material.SKULL_ITEM, BeheadedHorror.class),
    REVENANT_CATALYST(Material.SKULL_ITEM, RevenantCatalyst.class),
    SCYTHE_BLADE(Material.DIAMOND, ScytheBlade.class),
    WARDEN_HEART(Material.SKULL_ITEM, WardenHeart.class),
    JUDGEMENT_CORE(Material.SKULL_ITEM, JudgementCore.class),
    SHARD_OF_THE_SHREDDED(Material.SKULL_ITEM, ShardoftheShredded.class),
    REVENANT_VISCERA(Material.GRILLED_PORK, RevenantViscera.class),
    TARANTULA_WEB(Material.STRING, TarantulaWeb.class),
    TOXIC_ARROW_POISON(Material.INK_SACK, ToxicArrowPoison.class, 10),
    SPIDER_CATALYST(Material.SKULL_ITEM, SpiderCatalyst.class),
    FLY_SWATTER(Material.GOLD_SPADE, FlySwatter.class),
    DIGESTED_MOSQUITO(Material.ROTTEN_FLESH, DigestedMosquito.class),
    WOLF_TOOTH(Material.GHAST_TEAR, WolfTooth.class),
    HAMSTER_WHEEL(Material.TRAP_DOOR, HamsterWheel.class),
    RED_CLAW_EGG(Material.MONSTER_EGG, RedClawEgg.class, 96),
    OVERFLUX_CAPACITOR(Material.QUARTZ, OverfluxCapacitor.class),
    GRIZZLY_BAIT(Material.RAW_FISH, GrizzlyBait.class, 1),
    NULL_SPHERE(Material.FIREWORK_CHARGE, NullSphere.class),
    PESTILENCE_RUNE(Material.SKULL_ITEM, PestilenceRune.class),
    SNAKE_RUNE(Material.SKULL_ITEM, SnakeRune.class),
    BITE_RUNE(Material.SKULL_ITEM, BiteRune.class),
    SPIRIT_RUNE(Material.SKULL_ITEM, SpiritRune.class),
    COUTURE_RUNE(Material.SKULL_ITEM, CoutureRune.class),
    ENDERMAN_PET(Material.SKULL_ITEM, EndermanPet.class),
    GUNGA_PET(Material.SKULL_ITEM, GungaPet.class),
    SLEEPING_EYE(Material.SKULL_ITEM, SleepingEye.class),
    SUMMONING_FRAME(Material.ENDER_PORTAL_FRAME, SummoningFrame.class),
    AIR(Material.AIR),
    STONE(Material.STONE, Stone.class, true),
    GRASS_BLOCK(Material.GRASS),
    DIRT(Material.DIRT),
    COBBLESTONE(Material.COBBLESTONE, Cobblestone.class, true),
    OAK_WOOD_PLANKS(Material.WOOD),
    SAPLING(Material.SAPLING),
    BEDROCK(Material.BEDROCK, Bedrock.class, true),
    WATER(Material.WATER),
    STATIONARY_WATER(Material.STATIONARY_WATER),
    LAVA(Material.LAVA),
    STATIONARY_LAVA(Material.STATIONARY_LAVA),
    SAND(Material.SAND, Sand.class, true),
    GRAVEL(Material.GRAVEL, Gravel.class, true),
    GOLD_ORE(Material.GOLD_ORE, GoldOre.class, true),
    IRON_ORE(Material.IRON_ORE, IronOre.class, true),
    COAL_ORE(Material.COAL_ORE, CoalOre.class, true),
    OAK_WOOD(Material.LOG, OakWood.class, true),
    LEAVES(Material.LEAVES),
    SPONGE(Material.SPONGE),
    GLASS(Material.GLASS),
    LAPIS_LAZULI_ORE(Material.LAPIS_ORE, LapisLazuliOre.class, true),
    LAPIS_BLOCK(Material.LAPIS_BLOCK),
    DISPENSER(Material.DISPENSER),
    SANDSTONE(Material.SANDSTONE),
    NOTE_BLOCK(Material.NOTE_BLOCK),
    BED_BLOCK(Material.BED_BLOCK),
    POWERED_RAIL(Material.POWERED_RAIL),
    DETECTOR_RAIL(Material.DETECTOR_RAIL),
    PISTON_STICKY_BASE(Material.PISTON_STICKY_BASE),
    WEB(Material.WEB),
    LONG_GRASS(Material.LONG_GRASS),
    DEAD_BUSH(Material.DEAD_BUSH),
    PISTON_BASE(Material.PISTON_BASE),
    PISTON_EXTENSION(Material.PISTON_EXTENSION),
    WOOL(Material.WOOL),
    PISTON_MOVING_PIECE(Material.PISTON_MOVING_PIECE),
    YELLOW_FLOWER(Material.YELLOW_FLOWER),
    RED_ROSE(Material.RED_ROSE),
    BROWN_MUSHROOM(Material.BROWN_MUSHROOM, BrownMushroom.class, true),
    RED_MUSHROOM(Material.RED_MUSHROOM, RedMushroom.class, true),
    GOLD_BLOCK(Material.GOLD_BLOCK),
    IRON_BLOCK(Material.IRON_BLOCK),
    DOUBLE_STEP(Material.DOUBLE_STEP),
    STEP(Material.STEP),
    BRICK(Material.BRICK),
    TNT(Material.TNT),
    BOOKSHELF(Material.BOOKSHELF),
    MOSSY_COBBLESTONE(Material.MOSSY_COBBLESTONE),
    OBSIDIAN(Material.OBSIDIAN, Obsidian.class, true),
    TORCH(Material.TORCH),
    FIRE(Material.FIRE),
    MOB_SPAWNER(Material.MOB_SPAWNER),
    WOOD_STAIRS(Material.WOOD_STAIRS),
    CHEST(Material.CHEST),
    REDSTONE_WIRE(Material.REDSTONE_WIRE),
    DIAMOND_ORE(Material.DIAMOND_ORE, DiamondOre.class, true),
    DIAMOND_BLOCK(Material.DIAMOND_BLOCK, DiamondBlock.class, true),
    CRAFTING_TABLE(Material.WORKBENCH),
    WHEAT_SEEDS(Material.CROPS, WheatSeeds.class, true),
    SOIL(Material.SOIL),
    FURNACE(Material.FURNACE),
    BURNING_FURNACE(Material.BURNING_FURNACE),
    SIGN_POST(Material.SIGN_POST),
    WOODEN_DOOR(Material.WOODEN_DOOR),
    LADDER(Material.LADDER),
    RAILS(Material.RAILS),
    COBBLESTONE_STAIRS(Material.COBBLESTONE_STAIRS),
    WALL_SIGN(Material.WALL_SIGN),
    LEVER(Material.LEVER),
    STONE_PLATE(Material.STONE_PLATE),
    IRON_DOOR_BLOCK(Material.IRON_DOOR_BLOCK),
    WOOD_PLATE(Material.WOOD_PLATE),
    REDSTONE_ORE(Material.REDSTONE_ORE, RedstoneOre.class, true),
    GLOWING_REDSTONE_ORE(Material.GLOWING_REDSTONE_ORE),
    REDSTONE_TORCH_OFF(Material.REDSTONE_TORCH_OFF),
    REDSTONE_TORCH_ON(Material.REDSTONE_TORCH_ON),
    STONE_BUTTON(Material.STONE_BUTTON),
    SNOW(Material.SNOW),
    ICE(Material.ICE, Ice.class, true),
    SNOW_BLOCK(Material.SNOW_BLOCK),
    CACTUS(Material.CACTUS, Cactus.class, true),
    CLAY(Material.CLAY),
    SUGAR_CANE_BLOCK(Material.SUGAR_CANE_BLOCK, SugarCane.class, true),
    JUKEBOX(Material.JUKEBOX),
    FENCE(Material.FENCE),
    PUMPKIN(Material.PUMPKIN, Pumpkin.class, true),
    NETHERRACK(Material.NETHERRACK, Netherrack.class, true),
    SOUL_SAND(Material.SOUL_SAND),
    GLOWSTONE(Material.GLOWSTONE, Glowstone.class, true),
    PORTAL(Material.PORTAL),
    JACK_O_LANTERN(Material.JACK_O_LANTERN),
    CAKE_BLOCK(Material.CAKE_BLOCK),
    DIODE_BLOCK_OFF(Material.DIODE_BLOCK_OFF),
    DIODE_BLOCK_ON(Material.DIODE_BLOCK_ON),
    STAINED_GLASS(Material.STAINED_GLASS),
    TRAP_DOOR(Material.TRAP_DOOR),
    MONSTER_EGGS(Material.MONSTER_EGGS),
    SMOOTH_BRICK(Material.SMOOTH_BRICK),
    HUGE_MUSHROOM_1(Material.HUGE_MUSHROOM_1),
    HUGE_MUSHROOM_2(Material.HUGE_MUSHROOM_2),
    IRON_FENCE(Material.IRON_FENCE),
    THIN_GLASS(Material.THIN_GLASS),
    MELON_BLOCK(Material.MELON_BLOCK, Melon.class, true),
    PUMPKIN_STEM(Material.PUMPKIN_STEM),
    MELON_STEM(Material.MELON_STEM),
    VINE(Material.VINE),
    FENCE_GATE(Material.FENCE_GATE),
    BRICK_STAIRS(Material.BRICK_STAIRS),
    SMOOTH_STAIRS(Material.SMOOTH_STAIRS),
    MYCEL(Material.MYCEL),
    WATER_LILY(Material.WATER_LILY),
    NETHER_BRICK(Material.NETHER_BRICK),
    NETHER_FENCE(Material.NETHER_FENCE),
    NETHER_BRICK_STAIRS(Material.NETHER_BRICK_STAIRS),
    NETHER_WARTS(Material.NETHER_WARTS),
    ENCHANTMENT_TABLE(Material.ENCHANTMENT_TABLE),
    BREWING_STAND(Material.BREWING_STAND),
    CAULDRON(Material.CAULDRON),
    END_PORTAL(Material.ENDER_PORTAL),
    END_PORTAL_FRAME(Material.ENDER_PORTAL_FRAME),
    END_STONE(Material.ENDER_STONE, EndStone.class, true),
    DRAGON_EGG(Material.DRAGON_EGG),
    REDSTONE_LAMP_OFF(Material.REDSTONE_LAMP_OFF),
    REDSTONE_LAMP_ON(Material.REDSTONE_LAMP_ON),
    WOOD_DOUBLE_STEP(Material.WOOD_DOUBLE_STEP),
    WOOD_STEP(Material.WOOD_STEP),
    COCOA(Material.COCOA, CocoaBeans.class, true),
    SANDSTONE_STAIRS(Material.SANDSTONE_STAIRS),
    EMERALD_ORE(Material.EMERALD_ORE, EmeraldOre.class, true),
    ENDER_CHEST(Material.ENDER_CHEST),
    TRIPWIRE_HOOK(Material.TRIPWIRE_HOOK),
    TRIPWIRE(Material.TRIPWIRE),
    EMERALD_BLOCK(Material.EMERALD_BLOCK),
    SPRUCE_WOOD_STAIRS(Material.SPRUCE_WOOD_STAIRS),
    BIRCH_WOOD_STAIRS(Material.BIRCH_WOOD_STAIRS),
    JUNGLE_WOOD_STAIRS(Material.JUNGLE_WOOD_STAIRS),
    COMMAND(Material.COMMAND),
    BEACON(Material.BEACON),
    COBBLE_WALL(Material.COBBLE_WALL),
    FLOWER_POT(Material.FLOWER_POT),
    CARROT(Material.CARROT, Carrot.class, true),
    POTATO(Material.POTATO, Potato.class, true),
    WOOD_BUTTON(Material.WOOD_BUTTON),
    SKULL(Material.SKULL),
    ANVIL(Material.ANVIL),
    TRAPPED_CHEST(Material.TRAPPED_CHEST),
    GOLD_PLATE(Material.GOLD_PLATE),
    IRON_PLATE(Material.IRON_PLATE),
    REDSTONE_COMPARATOR_OFF(Material.REDSTONE_COMPARATOR_OFF),
    REDSTONE_COMPARATOR_ON(Material.REDSTONE_COMPARATOR_ON),
    DAYLIGHT_DETECTOR(Material.DAYLIGHT_DETECTOR),
    REDSTONE_BLOCK(Material.REDSTONE_BLOCK),
    NETHER_QUARTZ_ORE(Material.QUARTZ_ORE, NetherQuartzOre.class, true),
    HOPPER(Material.HOPPER),
    QUARTZ_BLOCK(Material.QUARTZ_BLOCK),
    QUARTZ_STAIRS(Material.QUARTZ_STAIRS),
    ACTIVATOR_RAIL(Material.ACTIVATOR_RAIL),
    DROPPER(Material.DROPPER),
    STAINED_CLAY(Material.STAINED_CLAY),
    STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE),
    LEAVES_2(Material.LEAVES_2),
    ACACIA_WOOD(Material.LOG_2, AcaciaWood.class, true),
    ACACIA_STAIRS(Material.ACACIA_STAIRS),
    DARK_OAK_STAIRS(Material.DARK_OAK_STAIRS),
    SLIME_BLOCK(Material.SLIME_BLOCK),
    BARRIER(Material.BARRIER),
    IRON_TRAPDOOR(Material.IRON_TRAPDOOR),
    PRISMARINE(Material.PRISMARINE),
    SEA_LANTERN(Material.SEA_LANTERN),
    HAY_BLOCK(Material.HAY_BLOCK),
    CARPET(Material.CARPET),
    HARD_CLAY(Material.HARD_CLAY),
    COAL_BLOCK(Material.COAL_BLOCK),
    PACKED_ICE(Material.PACKED_ICE),
    DOUBLE_PLANT(Material.DOUBLE_PLANT),
    STANDING_BANNER(Material.STANDING_BANNER),
    WALL_BANNER(Material.WALL_BANNER),
    DAYLIGHT_DETECTOR_INVERTED(Material.DAYLIGHT_DETECTOR_INVERTED),
    RED_SANDSTONE(Material.RED_SANDSTONE),
    RED_SANDSTONE_STAIRS(Material.RED_SANDSTONE_STAIRS),
    DOUBLE_STONE_SLAB2(Material.DOUBLE_STONE_SLAB2),
    STONE_SLAB2(Material.STONE_SLAB2),
    SPRUCE_FENCE_GATE(Material.SPRUCE_FENCE_GATE),
    BIRCH_FENCE_GATE(Material.BIRCH_FENCE_GATE),
    JUNGLE_FENCE_GATE(Material.JUNGLE_FENCE_GATE),
    DARK_OAK_FENCE_GATE(Material.DARK_OAK_FENCE_GATE),
    ACACIA_FENCE_GATE(Material.ACACIA_FENCE_GATE),
    SPRUCE_FENCE(Material.SPRUCE_FENCE),
    BIRCH_FENCE(Material.BIRCH_FENCE),
    JUNGLE_FENCE(Material.JUNGLE_FENCE),
    DARK_OAK_FENCE(Material.DARK_OAK_FENCE),
    ACACIA_FENCE(Material.ACACIA_FENCE),
    SPRUCE_DOOR(Material.SPRUCE_DOOR),
    BIRCH_DOOR(Material.BIRCH_DOOR),
    JUNGLE_DOOR(Material.JUNGLE_DOOR),
    ACACIA_DOOR(Material.ACACIA_DOOR),
    DARK_OAK_DOOR(Material.DARK_OAK_DOOR),
    IRON_SHOVEL(Material.IRON_SPADE, IronShovel.class, true),
    IRON_PICKAXE(Material.IRON_PICKAXE, IronPickaxe.class, true),
    IRON_AXE(Material.IRON_AXE, IronAxe.class, true),
    FLINT_AND_STEEL(Material.FLINT_AND_STEEL),
    APPLE(Material.APPLE),
    BOW(Material.BOW, Bow.class, true),
    ARROW(Material.ARROW),
    COAL(Material.COAL),
    DIAMOND(Material.DIAMOND),
    IRON_INGOT(Material.IRON_INGOT),
    GOLD_INGOT(Material.GOLD_INGOT),
    IRON_SWORD(Material.IRON_SWORD, IronSword.class, true),
    WOOD_SWORD(Material.WOOD_SWORD, WoodenSword.class, true),
    WOOD_SHOVEL(Material.WOOD_SPADE, WoodenShovel.class, true),
    WOOD_PICKAXE(Material.WOOD_PICKAXE, WoodenPickaxe.class, true),
    WOOD_AXE(Material.WOOD_AXE, WoodenAxe.class, true),
    STONE_SWORD(Material.STONE_SWORD, StoneSword.class, true),
    STONE_SHOVEL(Material.STONE_SPADE, StoneShovel.class, true),
    STONE_PICKAXE(Material.STONE_PICKAXE, StonePickaxe.class, true),
    STONE_AXE(Material.STONE_AXE, StoneAxe.class, true),
    DIAMOND_SWORD(Material.DIAMOND_SWORD, DiamondSword.class, true),
    DIAMOND_SHOVEL(Material.DIAMOND_SPADE, DiamondShovel.class, true),
    DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE, DiamondPickaxe.class, true),
    DIAMOND_AXE(Material.DIAMOND_AXE, DiamondAxe.class, true),
    STICK(Material.STICK),
    BOWL(Material.BOWL),
    MUSHROOM_SOUP(Material.MUSHROOM_SOUP),
    GOLD_SWORD(Material.GOLD_SWORD, GoldenSword.class, true),
    GOLD_SHOVEL(Material.GOLD_SPADE, GoldenShovel.class, true),
    GOLD_PICKAXE(Material.GOLD_PICKAXE, GoldenPickaxe.class, true),
    GOLD_AXE(Material.GOLD_AXE, GoldenAxe.class, true),
    STRING(Material.STRING),
    FEATHER(Material.FEATHER),
    GUNPOWDER(Material.SULPHUR),
    WOOD_HOE(Material.WOOD_HOE, WoodenHoe.class, true),
    STONE_HOE(Material.STONE_HOE, StoneHoe.class, true),
    IRON_HOE(Material.IRON_HOE, IronHoe.class, true),
    DIAMOND_HOE(Material.DIAMOND_HOE, DiamondHoe.class, true),
    GOLD_HOE(Material.GOLD_HOE, GoldenHoe.class, true),
    SEEDS(Material.SEEDS),
    WHEAT(Material.WHEAT),
    BREAD(Material.BREAD),
    LEATHER_HELMET(Material.LEATHER_HELMET, LeatherHelmet.class, true),
    LEATHER_CHESTPLATE(Material.LEATHER_CHESTPLATE, LeatherChestplate.class, true),
    LEATHER_LEGGINGS(Material.LEATHER_LEGGINGS, LeatherLeggings.class, true),
    LEATHER_BOOTS(Material.LEATHER_BOOTS, LeatherBoots.class, true),
    CHAINMAIL_HELMET(Material.CHAINMAIL_HELMET, ChainmailHelmet.class, true),
    CHAINMAIL_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, ChainmailChestplate.class, true),
    CHAINMAIL_LEGGINGS(Material.CHAINMAIL_LEGGINGS, ChainmailLeggings.class, true),
    CHAINMAIL_BOOTS(Material.CHAINMAIL_BOOTS, ChainmailBoots.class, true),
    IRON_HELMET(Material.IRON_HELMET, IronHelmet.class, true),
    IRON_CHESTPLATE(Material.IRON_CHESTPLATE, IronChestplate.class, true),
    IRON_LEGGINGS(Material.IRON_LEGGINGS, IronLeggings.class, true),
    IRON_BOOTS(Material.IRON_BOOTS, IronBoots.class, true),
    DIAMOND_HELMET(Material.DIAMOND_HELMET, DiamondHelmet.class, true),
    DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE, DiamondChestplate.class, true),
    DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS, DiamondLeggings.class, true),
    DIAMOND_BOOTS(Material.DIAMOND_BOOTS, DiamondBoots.class, true),
    GOLDEN_HELMET(Material.GOLD_HELMET, GoldenHelmet.class, true),
    GOLDEN_CHESTPLATE(Material.GOLD_CHESTPLATE, GoldenChestplate.class, true),
    GOLDEN_LEGGINGS(Material.GOLD_LEGGINGS, GoldenLeggings.class, true),
    GOLDEN_BOOTS(Material.GOLD_BOOTS, GoldenBoots.class, true),
    FLINT(Material.FLINT),
    PORK(Material.PORK),
    GRILLED_PORK(Material.GRILLED_PORK),
    PAINTING(Material.PAINTING),
    GOLDEN_APPLE(Material.GOLDEN_APPLE),
    SIGN(Material.SIGN),
    WOOD_DOOR(Material.WOOD_DOOR),
    BUCKET(Material.BUCKET),
    WATER_BUCKET(Material.WATER_BUCKET),
    LAVA_BUCKET(Material.LAVA_BUCKET),
    MINECART(Material.MINECART),
    SADDLE(Material.SADDLE),
    IRON_DOOR(Material.IRON_DOOR),
    REDSTONE(Material.REDSTONE),
    SNOW_BALL(Material.SNOW_BALL),
    BOAT(Material.BOAT),
    LEATHER(Material.LEATHER),
    MILK_BUCKET(Material.MILK_BUCKET),
    CLAY_BRICK(Material.CLAY_BRICK),
    CLAY_BALL(Material.CLAY_BALL),
    SUGAR_CANE(Material.SUGAR_CANE),
    PAPER(Material.PAPER),
    BOOK(Material.BOOK),
    SLIME_BALL(Material.SLIME_BALL),
    STORAGE_MINECART(Material.STORAGE_MINECART),
    POWERED_MINECART(Material.POWERED_MINECART),
    EGG(Material.EGG),
    COMPASS(Material.COMPASS),
    FISHING_ROD(Material.FISHING_ROD),
    WATCH(Material.WATCH),
    GLOWSTONE_DUST(Material.GLOWSTONE_DUST),
    RAW_FISH(Material.RAW_FISH),
    COOKED_FISH(Material.COOKED_FISH),
    INK_SACK(Material.INK_SACK),
    BONE(Material.BONE),
    SUGAR(Material.SUGAR),
    CAKE(Material.CAKE),
    BED(Material.BED),
    DIODE(Material.DIODE),
    COOKIE(Material.COOKIE),
    MAP(Material.MAP),
    SHEARS(Material.SHEARS),
    MELON(Material.MELON),
    PUMPKIN_SEEDS(Material.PUMPKIN_SEEDS),
    MELON_SEEDS(Material.MELON_SEEDS),
    RAW_BEEF(Material.RAW_BEEF),
    COOKED_BEEF(Material.COOKED_BEEF),
    RAW_CHICKEN(Material.RAW_CHICKEN),
    COOKED_CHICKEN(Material.COOKED_CHICKEN),
    ROTTEN_FLESH(Material.ROTTEN_FLESH),
    ENDER_PEARL(Material.ENDER_PEARL),
    BLAZE_ROD(Material.BLAZE_ROD),
    GHAST_TEAR(Material.GHAST_TEAR),
    GOLD_NUGGET(Material.GOLD_NUGGET),
    NETHER_STALK(Material.NETHER_STALK),
    GLASS_BOTTLE(Material.GLASS_BOTTLE),
    SPIDER_EYE(Material.SPIDER_EYE),
    FERMENTED_SPIDER_EYE(Material.FERMENTED_SPIDER_EYE),
    BLAZE_POWDER(Material.BLAZE_POWDER),
    MAGMA_CREAM(Material.MAGMA_CREAM),
    BREWING_STAND_ITEM(Material.BREWING_STAND_ITEM),
    CAULDRON_ITEM(Material.CAULDRON_ITEM),
    EYE_OF_ENDER(Material.EYE_OF_ENDER),
    SPECKLED_MELON(Material.SPECKLED_MELON),
    MONSTER_EGG(Material.MONSTER_EGG),
    EXP_BOTTLE(Material.EXP_BOTTLE),
    FIREBALL(Material.FIREBALL),
    BOOK_AND_QUILL(Material.BOOK_AND_QUILL),
    WRITTEN_BOOK(Material.WRITTEN_BOOK),
    EMERALD(Material.EMERALD),
    ITEM_FRAME(Material.ITEM_FRAME),
    FLOWER_POT_ITEM(Material.FLOWER_POT_ITEM),
    CARROT_ITEM(Material.CARROT_ITEM),
    POTATO_ITEM(Material.POTATO_ITEM),
    BAKED_POTATO(Material.BAKED_POTATO),
    POISONOUS_POTATO(Material.POISONOUS_POTATO),
    EMPTY_MAP(Material.EMPTY_MAP),
    GOLDEN_CARROT(Material.GOLDEN_CARROT),
    SKULL_ITEM(Material.SKULL_ITEM),
    CARROT_STICK(Material.CARROT_STICK),
    NETHER_STAR(Material.NETHER_STAR),
    PUMPKIN_PIE(Material.PUMPKIN_PIE),
    FIREWORK(Material.FIREWORK),
    FIREWORK_CHARGE(Material.FIREWORK_CHARGE),
    REDSTONE_COMPARATOR(Material.REDSTONE_COMPARATOR),
    NETHER_BRICK_ITEM(Material.NETHER_BRICK_ITEM),
    QUARTZ(Material.QUARTZ),
    EXPLOSIVE_MINECART(Material.EXPLOSIVE_MINECART),
    HOPPER_MINECART(Material.HOPPER_MINECART),
    PRISMARINE_SHARD(Material.PRISMARINE_SHARD),
    PRISMARINE_CRYSTALS(Material.PRISMARINE_CRYSTALS),
    RABBIT(Material.RABBIT),
    COOKED_RABBIT(Material.COOKED_RABBIT),
    RABBIT_STEW(Material.RABBIT_STEW),
    RABBIT_FOOT(Material.RABBIT_FOOT),
    RABBIT_HIDE(Material.RABBIT_HIDE),
    ARMOR_STAND(Material.ARMOR_STAND),
    IRON_BARDING(Material.IRON_BARDING),
    GOLD_BARDING(Material.GOLD_BARDING),
    DIAMOND_BARDING(Material.DIAMOND_BARDING),
    LEASH(Material.LEASH),
    NAME_TAG(Material.NAME_TAG),
    COMMAND_MINECART(Material.COMMAND_MINECART),
    MUTTON(Material.MUTTON),
    COOKED_MUTTON(Material.COOKED_MUTTON),
    BANNER(Material.BANNER),
    SPRUCE_DOOR_ITEM(Material.SPRUCE_DOOR_ITEM),
    BIRCH_DOOR_ITEM(Material.BIRCH_DOOR_ITEM),
    JUNGLE_DOOR_ITEM(Material.JUNGLE_DOOR_ITEM),
    ACACIA_DOOR_ITEM(Material.ACACIA_DOOR_ITEM),
    DARK_OAK_DOOR_ITEM(Material.DARK_OAK_DOOR_ITEM),
    GOLD_RECORD(Material.GOLD_RECORD),
    GREEN_RECORD(Material.GREEN_RECORD),
    RECORD_3(Material.RECORD_3),
    RECORD_4(Material.RECORD_4),
    RECORD_5(Material.RECORD_5),
    RECORD_6(Material.RECORD_6),
    RECORD_7(Material.RECORD_7),
    RECORD_8(Material.RECORD_8),
    RECORD_9(Material.RECORD_9),
    RECORD_10(Material.RECORD_10),
    RECORD_11(Material.RECORD_11),
    RECORD_12(Material.RECORD_12),
    SLIGHTLY_DAMAGED_ANVIL(Material.ANVIL, 1, "Slightly Damaged Anvil"),
    VERY_DAMAGED_ANVIL(Material.ANVIL, 2, "Very Damaged Anvil"),
    RED_BANNER(Material.BANNER, 1, "Red Banner"),
    GREEN_BANNER(Material.BANNER, 2, "Green Banner"),
    BROWN_BANNER(Material.BANNER, 3, "Brown Banner"),
    BLUE_BANNER(Material.BANNER, 4, "Blue Banner"),
    PURPLE_BANNER(Material.BANNER, 5, "Purple Banner"),
    CYAN_BANNER(Material.BANNER, 6, "Cyan Banner"),
    LIGHT_GRAY_BANNER(Material.BANNER, 7, "Light Gray Banner"),
    GRAY_BANNER(Material.BANNER, 8, "Gray Banner"),
    PINK_BANNER(Material.BANNER, 9, "Pink Banner"),
    LIME_BANNER(Material.BANNER, 10, "Lime Banner"),
    YELLOW_BANNER(Material.BANNER, 11, "Yellow Banner"),
    LIGHT_BLUE_BANNER(Material.BANNER, 12, "Light Blue Banner"),
    MAGENTA_BANNER(Material.BANNER, 13, "Magenta Banner"),
    ORANGE_BANNER(Material.BANNER, 14, "Orange Banner"),
    ORANGE_CARPET(Material.CARPET, 1, "Orange Carpet"),
    MAGENTA_CARPET(Material.CARPET, 2, "Magenta Carpet"),
    LIGHT_BLUE_CARPET(Material.CARPET, 3, "Light Blue Carpet"),
    YELLOW_CARPET(Material.CARPET, 4, "Yellow Carpet"),
    LIME_CARPET(Material.CARPET, 5, "Lime Carpet"),
    PINK_CARPET(Material.CARPET, 6, "Pink Carpet"),
    GRAY_CARPET(Material.CARPET, 7, "Gray Carpet"),
    LIGHT_GRAY_CARPET(Material.CARPET, 8, "Light Gray Carpet"),
    CYAN_CARPET(Material.CARPET, 9, "Cyan Carpet"),
    PURPLE_CARPET(Material.CARPET, 10, "Purple Carpet"),
    BLUE_CARPET(Material.CARPET, 11, "Blue Carpet"),
    BROWN_CARPET(Material.CARPET, 12, "Brown Carpet"),
    GREEN_CARPET(Material.CARPET, 13, "Green Carpet"),
    RED_CARPET(Material.CARPET, 14, "Red Carpet"),
    BLACK_CARPET(Material.CARPET, 15, "Black Carpet"),
    CHARCOAL(Material.COAL, 1, "Charcoal"),
    MOSSY_COBBLESTONE_WALL(Material.COBBLE_WALL, 1, "Mossy Cobblestone Wall"),
    COOKED_SALMON(Material.COOKED_FISH, 1, "Cooked Salmon"),
    COARSE_DIRT(Material.DIRT, 1, "Coarse Dirt"),
    PODZOL(Material.DIRT, 2, "Podzol"),
    LILAC(Material.DOUBLE_PLANT, 1, "Lilac"),
    DOUBLE_TALLGRASS(Material.DOUBLE_PLANT, 2, "Double Tallgrass"),
    LARGE_FERN(Material.DOUBLE_PLANT, 3, "Large Fern"),
    ROSE_BUSH(Material.DOUBLE_PLANT, 4, "Rose Bush"),
    PEONY(Material.DOUBLE_PLANT, 5, "Peony"),
    RED_DYE(Material.INK_SACK, 1, "Red Dye"),
    GREEN_DYE(Material.INK_SACK, 2, "Green Dye"),
    COCOA_BEANS(Material.INK_SACK, 3, "Cocoa Beans"),
    LAPIS_LAZULI(Material.INK_SACK, 4, "Lapis Lazuli"),
    PURPLE_DYE(Material.INK_SACK, 5, "Purple Dye"),
    CYAN_DYE(Material.INK_SACK, 6, "Cyan Dye"),
    LIGHT_GRAY_DYE(Material.INK_SACK, 7, "Light Gray Dye"),
    GRAY_DYE(Material.INK_SACK, 8, "Gray Dye"),
    PINK_DYE(Material.INK_SACK, 9, "Pink Dye"),
    LIME_DYE(Material.INK_SACK, 10, "Lime Dye"),
    YELLOW_DYE(Material.INK_SACK, 11, "Yellow Dye"),
    LIGHT_BLUE_DYE(Material.INK_SACK, 12, "Light Blue Dye"),
    MAGENTA_DYE(Material.INK_SACK, 13, "Magenta Dye"),
    ORANGE_DYE(Material.INK_SACK, 14, "Orange Dye"),
    BONE_MEAL(Material.INK_SACK, 15, "Bone Meal"),
    RAW_SALMON(Material.RAW_FISH, 1, "Raw Salmon"),
    TROPICAL_FISH(Material.RAW_FISH, 2, "Tropical Fish"),
    PUFFERFISH(Material.RAW_FISH, 3, "Pufferfish"),
    ENCHANTED_GOLDEN_APPLE(Material.GOLDEN_APPLE, 1, "Enchanted Golden Apple"),
    SPRUCE_LEAVES(Material.LEAVES, 1, "Spruce Leaves"),
    BIRCH_LEAVES(Material.LEAVES, 2, "Birch Leaves"),
    JUNGLE_LEAVES(Material.LEAVES, 3, "Jungle Leaves"),
    DARK_OAK_LEAVES(Material.LEAVES_2, 1, "Dark Oak Leaves"),
    SPRUCE_WOOD(Material.LOG, 1, SpruceWood.class, true),
    BIRCH_WOOD(Material.LOG, 2, BirchWood.class, true),
    JUNGLE_WOOD(Material.LOG, 3, JungleWood.class, true),
    DARK_OAK_WOOD(Material.LOG_2, 1, DarkOakWood.class, true),
    COBBLESTONE_MONSTER_EGG(Material.MONSTER_EGGS, 1, "Cobblestone Monster Egg"),
    STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, 2, "Stone Brick Monster Egg"),
    MOSSY_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, 3, "Mossy Stone Brick Monster Egg"),
    CRACKED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, 4, "Cracked Stone Brick Monster Egg"),
    CHISELED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, 5, "Chiseled Stone Brick Monster Egg"),
    SPRUCE_WOOD_PLANKS(Material.WOOD, 1, "Spruce Wood Planks"),
    BIRCH_WOOD_PLANKS(Material.WOOD, 2, "Birch Wood Planks"),
    JUNGLE_WOOD_PLANKS(Material.WOOD, 3, "Jungle Wood Planks"),
    ACACIA_WOOD_PLANKS(Material.WOOD, 4, "Acacia Wood Planks"),
    DARK_OAK_WOOD_PLANKS(Material.WOOD, 5, "Dark Oak Wood Planks"),
    PRISMARINE_BRICKS(Material.PRISMARINE, 1, "Prismarine Bricks"),
    DARK_PRISMARINE(Material.PRISMARINE, 2, "Dark Prismarine"),
    CHISELED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, 1, "Chiseled Quartz Block"),
    PILLAR_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, 2, "Pillar Quartz Block"),
    BLUE_ORCHID(Material.RED_ROSE, 1, "Blue Orchid"),
    ALLIUM(Material.RED_ROSE, 2, "Allium"),
    AZURE_BLUET(Material.RED_ROSE, 3, "Azure Bluet"),
    RED_TULIP(Material.RED_ROSE, 4, "Red Tulip"),
    ORANGE_TULIP(Material.RED_ROSE, 5, "Orange Tulip"),
    WHITE_TULIP(Material.RED_ROSE, 6, "White Tulip"),
    PINK_TULIP(Material.RED_ROSE, 7, "Pink Tulip"),
    OXEYE_DAISY(Material.RED_ROSE, 8, "Oxeye Daisy"),
    CHISELED_RED_SANDSTONE(Material.RED_SANDSTONE, 1, "Chiseled Red Sandstone"),
    PILLAR_RED_SANDSTONE(Material.RED_SANDSTONE, 2, "Pillar Red Sandstone"),
    RED_SAND(Material.SAND, 1, "Red Sand"),
    CHISELED_SANDSTONE(Material.SANDSTONE, 1, "Chiseled Sandstone"),
    SMOOTH_SANDSTONE(Material.SANDSTONE, 2, "Smooth Sandstone"),
    SPRUCE_SAPLING(Material.SAPLING, 1, "Spruce Sapling"),
    BIRCH_SAPLING(Material.SAPLING, 2, "Birch Sapling"),
    JUNGLE_SAPLING(Material.SAPLING, 3, "Jungle Sapling"),
    ACACIA_SAPLING(Material.SAPLING, 4, "Acacia Sapling"),
    DARK_OAK_SAPLING(Material.SAPLING, 5, "Dark Oak Sapling"),
    WITHER_SKELETON_SKULL(Material.SKULL_ITEM, 1, "Wither Skeleton Skull"),
    ZOMBIE_HEAD(Material.SKULL_ITEM, 2, "Zombie Head"),
    HEAD(Material.SKULL_ITEM, 3, "Head"),
    T_(Material.SKULL_ITEM, TerracottaHead.class),
    JERRY_GUN(Material.GOLD_BARDING, JerryChineGun.class),
    CREEPER_HEAD(Material.SKULL_ITEM, 4, "Creeper Head"),
    CREEPER_SPAWN_EGG(Material.MONSTER_EGG, 50, "Spawn Creeper"),
    SKELETON_SPAWN_EGG(Material.MONSTER_EGG, 51, "Spawn Skeleton"),
    SPIDER_SPAWN_EGG(Material.MONSTER_EGG, 52, "Spawn Spider"),
    ZOMBIE_SPAWN_EGG(Material.MONSTER_EGG, 54, "Spawn Zombie"),
    SLIME_SPAWN_EGG(Material.MONSTER_EGG, 55, "Spawn Slime"),
    GHAST_SPAWN_EGG(Material.MONSTER_EGG, 56, "Spawn Ghast"),
    ZOMBIE_PIGMAN_SPAWN_EGG(Material.MONSTER_EGG, 57, "Spawn Zombie Pigman"),
    ENDERMAN_SPAWN_EGG(Material.MONSTER_EGG, 58, "Spawn Enderman"),
    CAVE_SPIDER_SPAWN_EGG(Material.MONSTER_EGG, 59, "Spawn Cave Spider"),
    SILVERFISH_SPAWN_EGG(Material.MONSTER_EGG, 60, "Spawn Silverfish"),
    BLAZE_SPAWN_EGG(Material.MONSTER_EGG, 61, "Spawn Blaze"),
    MAGMA_CUBE_SPAWN_EGG(Material.MONSTER_EGG, 62, "Spawn Magma Cube"),
    BAT_SPAWN_EGG(Material.MONSTER_EGG, 65, "Spawn Bat"),
    WITCH_SPAWN_EGG(Material.MONSTER_EGG, 66, "Spawn Witch"),
    ENDERMITE_SPAWN_EGG(Material.MONSTER_EGG, 67, "Spawn Endermite"),
    GUARDIAN_SPAWN_EGG(Material.MONSTER_EGG, 68, "Spawn Guardian"),
    PIG_SPAWN_EGG(Material.MONSTER_EGG, 90, "Spawn Pig"),
    SHEEP_SPAWN_EGG(Material.MONSTER_EGG, 91, "Spawn Sheep"),
    COW_SPAWN_EGG(Material.MONSTER_EGG, 92, "Spawn Cow"),
    CHICKEN_SPAWN_EGG(Material.MONSTER_EGG, 93, "Spawn Chicken"),
    SQUID_SPAWN_EGG(Material.MONSTER_EGG, 94, "Spawn Squid"),
    WOLF_SPAWN_EGG(Material.MONSTER_EGG, 95, "Spawn Wolf"),
    MOOSHROOM_SPAWN_EGG(Material.MONSTER_EGG, 96, "Spawn Mooshroom"),
    OCELOT_SPAWN_EGG(Material.MONSTER_EGG, 98, "Spawn Ocelot"),
    HORSE_SPAWN_EGG(Material.MONSTER_EGG, 100, "Spawn Horse"),
    RABBIT_SPAWN_EGG(Material.MONSTER_EGG, 101, "Spawn Rabbit"),
    VILLAGER_SPAWN_EGG(Material.MONSTER_EGG, 120, "Spawn Villager"),
    WET_SPONGE(Material.SPONGE, 1, "Wet Sponge"),
    ORANGE_STAINED_GLASS(Material.STAINED_GLASS, 1, "Orange Stained Glass"),
    MAGENTA_STAINED_GLASS(Material.STAINED_GLASS, 2, "Magenta Stained Glass"),
    LIGHT_BLUE_STAINED_GLASS(Material.STAINED_GLASS, 3, "Light Blue Stained Glass"),
    YELLOW_STAINED_GLASS(Material.STAINED_GLASS, 4, "Yellow Stained Glass"),
    LIME_STAINED_GLASS(Material.STAINED_GLASS, 5, "Lime Stained Glass"),
    PINK_STAINED_GLASS(Material.STAINED_GLASS, 6, "Pink Stained Glass"),
    GRAY_STAINED_GLASS(Material.STAINED_GLASS, 7, "Gray Stained Glass"),
    LIGHT_GRAY_STAINED_GLASS(Material.STAINED_GLASS, 8, "Light Gray Stained Glass"),
    CYAN_STAINED_GLASS(Material.STAINED_GLASS, 9, "Cyan Stained Glass"),
    PURPLE_STAINED_GLASS(Material.STAINED_GLASS, 10, "Purple Stained Glass"),
    BLUE_STAINED_GLASS(Material.STAINED_GLASS, 11, "Blue Stained Glass"),
    BROWN_STAINED_GLASS(Material.STAINED_GLASS, 12, "Brown Stained Glass"),
    GREEN_STAINED_GLASS(Material.STAINED_GLASS, 13, "Green Stained Glass"),
    RED_STAINED_GLASS(Material.STAINED_GLASS, 14, "Red Stained Glass"),
    BLACK_STAINED_GLASS(Material.STAINED_GLASS, 15, "Black Stained Glass"),
    ORANGE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 1, "Orange Stained Glass Pane"),
    MAGENTA_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 2, "Magenta Stained Glass Pane"),
    LIGHT_BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 3, "Light Blue Stained Glass Pane"),
    YELLOW_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 4, "Yellow Stained Glass Pane"),
    LIME_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 5, "Lime Stained Glass Pane"),
    PINK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 6, "Pink Stained Glass Pane"),
    GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 7, "Gray Stained Glass Pane"),
    LIGHT_GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 8, "Light Gray Stained Glass Pane"),
    CYAN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 9, "Cyan Stained Glass Pane"),
    PURPLE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 10, "Purple Stained Glass Pane"),
    BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 11, "Blue Stained Glass Pane"),
    BROWN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 12, "Brown Stained Glass Pane"),
    GREEN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 13, "Green Stained Glass Pane"),
    RED_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 14, "Red Stained Glass Pane"),
    BLACK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, 15, "Black Stained Glass Pane"),
    ORANGE_STAINED_CLAY(Material.STAINED_CLAY, 1, "Orange Stained Clay"),
    MAGENTA_STAINED_CLAY(Material.STAINED_CLAY, 2, "Magenta Stained Clay"),
    LIGHT_BLUE_STAINED_CLAY(Material.STAINED_CLAY, 3, "Light Blue Stained Clay"),
    YELLOW_STAINED_CLAY(Material.STAINED_CLAY, 4, "Yellow Stained Clay"),
    LIME_STAINED_CLAY(Material.STAINED_CLAY, 5, "Lime Stained Clay"),
    PINK_STAINED_CLAY(Material.STAINED_CLAY, 6, "Pink Stained Clay"),
    GRAY_STAINED_CLAY(Material.STAINED_CLAY, 7, "Gray Stained Clay"),
    LIGHT_GRAY_STAINED_CLAY(Material.STAINED_CLAY, 8, "Light Gray Stained Clay"),
    CYAN_STAINED_CLAY(Material.STAINED_CLAY, 9, "Cyan Stained Clay"),
    PURPLE_STAINED_CLAY(Material.STAINED_CLAY, 10, "Purple Stained Clay"),
    BLUE_STAINED_CLAY(Material.STAINED_CLAY, 11, "Blue Stained Clay"),
    BROWN_STAINED_CLAY(Material.STAINED_CLAY, 12, "Brown Stained Clay"),
    GREEN_STAINED_CLAY(Material.STAINED_CLAY, 13, "Green Stained Clay"),
    RED_STAINED_CLAY(Material.STAINED_CLAY, 14, "Red Stained Clay"),
    BLACK_STAINED_CLAY(Material.STAINED_CLAY, 15, "Black Stained Clay"),
    GRANITE(Material.STONE, 1, "Granite"),
    POLISHED_GRANITE(Material.STONE, 2, "Polished Granite"),
    DIORITE(Material.STONE, 3, "Diorite"),
    POLISHED_DIORITE(Material.STONE, 4, "Polished Diorite"),
    ANDESITE(Material.STONE, 5, "Andesite"),
    POLISHED_ANDESITE(Material.STONE, 6, "Polished Andesite"),
    SANDSTONE_SLAB(Material.STEP, 1, "Sandstone Slab"),
    COBBLESTONE_SLAB(Material.STEP, 3, "Cobblestone Slab"),
    BRICK_SLAB(Material.STEP, 4, "Brick Slab"),
    STONE_BRICK_SLAB(Material.STEP, 5, "Stone Brick Slab"),
    NETHER_BRICK_SLAB(Material.STEP, 6, "Nether Brick Slab"),
    QUARTZ_SLAB(Material.STEP, 7, "Quartz Slab"),
    MOSSY_STONE_BRICKS(Material.SMOOTH_BRICK, 1, "Mossy Stone Bricks"),
    CRACKED_STONE_BRICKS(Material.SMOOTH_BRICK, 2, "Cracked Stone Bricks"),
    CHISELED_STONE_BRICKS(Material.SMOOTH_BRICK, 3, "Chiseled Stone Bricks"),
    GRASS(Material.LONG_GRASS, 1, "Grass"),
    FERN(Material.LONG_GRASS, 2, "Fern"),
    SPRUCE_WOOD_SLAB(Material.WOOD_STEP, 1, "Spruce Wood Slab"),
    BIRCH_WOOD_SLAB(Material.WOOD_STEP, 2, "Birch Wood Slab"),
    JUNGLE_WOOD_SLAB(Material.WOOD_STEP, 3, "Jungle Wood Slab"),
    ACACIA_WOOD_SLAB(Material.WOOD_STEP, 4, "Acacia Wood Slab"),
    DARK_OAK_WOOD_SLAB(Material.WOOD_STEP, 5, "Dark Oak Wood Slab"),
    ORANGE_WOOL(Material.WOOL, 1, "Orange Wool"),
    MAGENTA_WOOL(Material.WOOL, 2, "Magenta Wool"),
    LIGHT_BLUE_WOOL(Material.WOOL, 3, "Light Blue Wool"),
    YELLOW_WOOL(Material.WOOL, 4, "Yellow Wool"),
    LIME_WOOL(Material.WOOL, 5, "Lime Wool"),
    PINK_WOOL(Material.WOOL, 6, "Pink Wool"),
    GRAY_WOOL(Material.WOOL, 7, "Gray Wool"),
    LIGHT_GRAY_WOOL(Material.WOOL, 8, "Light Gray Wool"),
    CYAN_WOOL(Material.WOOL, 9, "Cyan Wool"),
    PURPLE_WOOL(Material.WOOL, 10, "Purple Wool"),
    BLUE_WOOL(Material.WOOL, 11, "Blue Wool"),
    BROWN_WOOL(Material.WOOL, 12, "Brown Wool"),
    GREEN_WOOL(Material.WOOL, 13, "Green Wool"),
    RED_WOOL(Material.WOOL, 14, "Red Wool"),
    JERRY_HEAD(Material.SKULL_ITEM, JerryGunBullet.class),
    ATONED_HEAD(Material.SKULL_ITEM, AtonedHorrorHead.class),
    REV_HORROR_2(Material.SKULL_ITEM, RevenantHorrorHead2.class),
    NUKEKUBI(Material.SKULL_ITEM, Nukekubi.class),
    BONZO_BALLOON_1(Material.SKULL_ITEM, BS1.class),
    BONZO_BALLOON_2(Material.SKULL_ITEM, BS2.class),
    BONZO_BALLOON_3(Material.SKULL_ITEM, BS3.class),
    BONZO_BALLOON_4(Material.SKULL_ITEM, BS4.class),
    BONZO_BALLOON_5(Material.SKULL_ITEM, BS5.class),
    BONZO_BALLOON_6(Material.SKULL_ITEM, BS6.class),
    BONZO_BALLOON_7(Material.SKULL_ITEM, BS7.class),
    BONZO_BALLOON_8(Material.SKULL_ITEM, BS8.class),
    BONZO_BALLOON_9(Material.SKULL_ITEM, BS9.class),
    BLACK_WOOL(Material.WOOL, 15, "Black Wool");

    private static final List<ArmorSet> CACHED_SETS;
    public static YoungDragonSet YOUNG_DRAGON_SET;
    public static SuperiorDragonSet SUPERIOR_DRAGON_SET;
    public static WiseDragonSet WISE_DRAGON_SET;
    public static UnstableDragonSet UNSTABLE_DRAGON_SET;
    public static StrongDragonSet STRONG_DRAGON_SET;
    public static OldDragonSet OLD_DRAGON_SET;
    public static ProtectorDragonSet PROTECTOR_DRAGON_SET;
    public static LapisArmorSet LAPIS_ARMOR_SET;
    public static MinerSet MINER_SET;
    public static NecronFullSet NECRONS_SET;
    public static StormFullSet STORMS_SET;
    public static SorrowArmorSet SORROW_SET;
    private final Material craftMaterial;
    private final short data;
    private final Class<?> clazz;
    private final boolean craft;
    private final String baseName;

    private SMaterial(Material craftMaterial, short data, Class<?> clazz, boolean craft, String baseName) {
        this.craftMaterial = craftMaterial;
        this.data = data;
        this.clazz = clazz;
        this.craft = craft;
        this.baseName = baseName;
    }

    private SMaterial(Material craftMaterial, short data, Class<?> clazz, boolean craft) {
        this(craftMaterial, data, clazz, craft, null);
    }

    private SMaterial(Material craftMaterial, Class<?> clazz, boolean craft) {
        this(craftMaterial, 0, clazz, craft);
    }

    private SMaterial(Material craftMaterial, Class<?> clazz) {
        this(craftMaterial, clazz, false);
    }

    private SMaterial(Material craftMaterial, Class<?> clazz, short data) {
        this(craftMaterial, data, clazz, false);
    }

    private SMaterial(Material craftMaterial, short data, String baseName) {
        this(craftMaterial, data, null, true, baseName);
    }

    private SMaterial(Material craftMaterial) {
        this(craftMaterial, null, true);
    }

    public static SMaterial getMaterial(String name) {
        try {
            return SMaterial.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public static SMaterial getSpecEquivalent(Material material, short data) {
        if (material == Material.LOG || material == Material.LOG_2 || material == Material.LEAVES || material == Material.LEAVES_2) {
            data = (short)(data % 4);
        }
        List results = Arrays.stream(SMaterial.values()).filter(m2 -> m2.craft && m2.getCraftMaterial() == material).collect(Collectors.toList());
        for (SMaterial result : results) {
            if (result.data != data) continue;
            return result;
        }
        if (results.isEmpty()) {
            return null;
        }
        return (SMaterial)((Object)results.get(0));
    }

    public static <T extends ArmorSet> T registerArmorSet(Class<? extends ArmorSet> set) {
        try {
            ArmorSet s2 = set.newInstance();
            CACHED_SETS.add(s2);
            return (T)s2;
        } catch (IllegalAccessException | InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static ArmorSet findArmorSet(SMaterial helmet, SMaterial chestplate, SMaterial leggings, SMaterial boots) {
        List subList = CACHED_SETS.stream().filter(s2 -> s2.getHelmet().equals(helmet.getStatistics().getClass()) && s2.getChestplate().equals(chestplate.getStatistics().getClass()) && s2.getLeggings().equals(leggings.getStatistics().getClass()) && s2.getBoots().equals(boots.getStatistics().getClass())).collect(Collectors.toList());
        if (subList.size() == 0) {
            return null;
        }
        return (ArmorSet)subList.get(0);
    }

    public static ArmorSet findArmorSet(SMaterial piece) {
        List subList = CACHED_SETS.stream().filter(s2 -> s2.getHelmet().equals(piece.getStatistics().getClass()) || s2.getChestplate().equals(piece.getStatistics().getClass()) || s2.getLeggings().equals(piece.getStatistics().getClass()) || s2.getBoots().equals(piece.getStatistics().getClass())).collect(Collectors.toList());
        if (subList.size() == 0) {
            return null;
        }
        return (ArmorSet)subList.get(0);
    }

    public MaterialFunction getFunction() {
        Object generic = this.getGenericInstance();
        if (generic instanceof MaterialFunction) {
            return (MaterialFunction)generic;
        }
        return null;
    }

    public MaterialStatistics getStatistics() {
        if (!this.hasClass()) {
            return new MaterialStatistics(){

                @Override
                public String getDisplayName() {
                    return null;
                }

                @Override
                public Rarity getRarity() {
                    return Rarity.COMMON;
                }

                @Override
                public String getLore() {
                    return null;
                }

                @Override
                public GenericItemType getType() {
                    return SUtil.getItemType(SMaterial.this.craftMaterial);
                }
            };
        }
        Object generic = this.getGenericInstance();
        if (generic instanceof MaterialStatistics) {
            return (MaterialStatistics)generic;
        }
        return null;
    }

    public String getDisplayName(short variant) {
        if (this.hasClass()) {
            return this.getStatistics().getDisplayName();
        }
        return SUtil.getMaterialDisplayName(this.craftMaterial, variant);
    }

    public TickingMaterial getTickingInstance() {
        Object generic = this.getGenericInstance();
        if (generic instanceof TickingMaterial) {
            return (TickingMaterial)generic;
        }
        return null;
    }

    public PlayerBoostStatistics getBoostStatistics() {
        MaterialStatistics statistics = this.getStatistics();
        if (!(statistics instanceof PlayerBoostStatistics)) {
            return null;
        }
        return (PlayerBoostStatistics)statistics;
    }

    public SkullStatistics getSkullStatistics() {
        MaterialStatistics statistics = this.getStatistics();
        if (!(statistics instanceof SkullStatistics)) {
            return null;
        }
        return (SkullStatistics)statistics;
    }

    public Ability getAbility() {
        if (!this.hasClass()) {
            return null;
        }
        Object generic = this.getGenericInstance();
        if (generic instanceof Ability) {
            return (Ability)generic;
        }
        return null;
    }

    public OrbBuff getOrbBuff() {
        if (!this.hasClass()) {
            return null;
        }
        Object generic = this.getGenericInstance();
        if (generic instanceof OrbBuff) {
            return (OrbBuff)generic;
        }
        return null;
    }

    public ItemData getItemData() {
        if (!this.hasClass()) {
            return null;
        }
        Object generic = this.getGenericInstance();
        if (generic instanceof ItemData) {
            return (ItemData)generic;
        }
        return null;
    }

    public Object getGenericInstance() {
        if (this.clazz == null) {
            return null;
        }
        try {
            return this.clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            return null;
        }
    }

    public boolean hasClass() {
        return this.clazz != null;
    }

    public static ArmorSet getIncompleteArmorSet(PlayerInventory inventory) {
        SItem helmet = SItem.find(inventory.getHelmet());
        SItem chestplate = SItem.find(inventory.getChestplate());
        SItem leggings = SItem.find(inventory.getLeggings());
        SItem boots = SItem.find(inventory.getBoots());
        for (ArmorSet set : CACHED_SETS) {
            if (set.getHelmet() != null && helmet != null && helmet.getType().getStatistics().getClass() == set.getHelmet()) {
                return set;
            }
            if (set.getChestplate() != null && chestplate != null && chestplate.getType().getStatistics().getClass() == set.getChestplate()) {
                return set;
            }
            if (set.getLeggings() != null && leggings != null && leggings.getType().getStatistics().getClass() == set.getLeggings()) {
                return set;
            }
            if (set.getBoots() == null || boots == null || boots.getType().getStatistics().getClass() != set.getBoots()) continue;
            return set;
        }
        return null;
    }

    public Material getCraftMaterial() {
        return this.craftMaterial;
    }

    public short getData() {
        return this.data;
    }

    public boolean isCraft() {
        return this.craft;
    }

    public String getBaseName() {
        return this.baseName;
    }

    static {
        CACHED_SETS = new ArrayList<ArmorSet>();
        YOUNG_DRAGON_SET = (YoungDragonSet)SMaterial.registerArmorSet(YoungDragonSet.class);
        SUPERIOR_DRAGON_SET = (SuperiorDragonSet)SMaterial.registerArmorSet(SuperiorDragonSet.class);
        WISE_DRAGON_SET = (WiseDragonSet)SMaterial.registerArmorSet(WiseDragonSet.class);
        UNSTABLE_DRAGON_SET = (UnstableDragonSet)SMaterial.registerArmorSet(UnstableDragonSet.class);
        STRONG_DRAGON_SET = (StrongDragonSet)SMaterial.registerArmorSet(StrongDragonSet.class);
        OLD_DRAGON_SET = (OldDragonSet)SMaterial.registerArmorSet(OldDragonSet.class);
        PROTECTOR_DRAGON_SET = (ProtectorDragonSet)SMaterial.registerArmorSet(ProtectorDragonSet.class);
        LAPIS_ARMOR_SET = (LapisArmorSet)SMaterial.registerArmorSet(LapisArmorSet.class);
        MINER_SET = (MinerSet)SMaterial.registerArmorSet(MinerSet.class);
        NECRONS_SET = (NecronFullSet)SMaterial.registerArmorSet(NecronFullSet.class);
        STORMS_SET = (StormFullSet)SMaterial.registerArmorSet(StormFullSet.class);
        SORROW_SET = (SorrowArmorSet)SMaterial.registerArmorSet(SorrowArmorSet.class);
    }

    public static enum VagueEntityMaterial {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        FRAGMENT;


        public SMaterial getEntityArmorPiece(SEntityType type) {
            return SMaterial.getMaterial(type.name() + "_" + this.name());
        }
    }
}

