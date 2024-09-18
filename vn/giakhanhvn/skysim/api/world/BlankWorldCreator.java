/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.World
 *  org.bukkit.WorldCreator
 *  org.bukkit.generator.ChunkGenerator
 *  org.bukkit.generator.ChunkGenerator$BiomeGrid
 *  org.bukkit.generator.ChunkGenerator$ChunkData
 */
package vn.giakhanhvn.skysim.api.world;

import java.util.Random;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

public class BlankWorldCreator
extends WorldCreator {
    public BlankWorldCreator(String name) {
        super(name);
    }

    public ChunkGenerator generator() {
        return new ChunkGenerator(){

            public ChunkGenerator.ChunkData generateChunkData(World world, Random random, int x2, int z2, ChunkGenerator.BiomeGrid biome) {
                return this.createChunkData(world);
            }

            public byte[] generate(World world, Random random, int x2, int z2) {
                return new byte[32768];
            }

            public byte[][] generateBlockSections(World world, Random random, int x2, int z2, ChunkGenerator.BiomeGrid biomes) {
                return new byte[16][16];
            }

            public short[][] generateExtBlockSections(World world, Random random, int x2, int z2, ChunkGenerator.BiomeGrid biomes) {
                return new short[world.getMaxHeight() / 16][];
            }
        };
    }
}

