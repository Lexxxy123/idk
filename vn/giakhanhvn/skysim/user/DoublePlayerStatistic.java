/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.user;

import java.util.ArrayList;
import java.util.Arrays;
import vn.giakhanhvn.skysim.user.PlayerStatistic;

public class DoublePlayerStatistic
implements PlayerStatistic<Double> {
    private final double defaultValue;
    private final ArrayList<Double> values;

    public DoublePlayerStatistic(double defaultValue) {
        this.defaultValue = defaultValue;
        this.values = new ArrayList(6);
        this.values.addAll(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    }

    public DoublePlayerStatistic() {
        this(0.0);
    }

    @Override
    public Double addAll() {
        double result = this.defaultValue;
        for (Double value : this.values) {
            result += value.doubleValue();
        }
        return result;
    }

    @Override
    public void add(int slot, Double d2) {
        this.set(slot, this.safeGet(slot) + d2);
    }

    @Override
    public void sub(int slot, Double d2) {
        this.set(slot, this.safeGet(slot) - d2);
    }

    @Override
    public void zero(int slot) {
        this.set(slot, 0.0);
    }

    @Override
    public boolean contains(int slot) {
        return slot >= 0 && slot < this.values.size();
    }

    @Override
    public Double safeGet(int index) {
        if (index < 0 || index > this.values.size() - 1) {
            this.set(index, 0.0);
        }
        return this.values.get(index);
    }

    @Override
    public void set(int slot, Double d2) {
        this.values.ensureCapacity(slot + 1);
        while (this.values.size() < slot + 1) {
            this.values.add(0.0);
        }
        this.values.set(slot, d2);
    }

    @Override
    public int next() {
        return this.values.size();
    }

    @Override
    public Double getFor(int slot) {
        return this.safeGet(slot);
    }

    public ArrayList<Double> forInventory() {
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i2 = 6; i2 < this.values.size(); ++i2) {
            list.add(this.safeGet(i2));
        }
        return list;
    }

    public double getDefaultValue() {
        return this.defaultValue;
    }
}

