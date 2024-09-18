/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import de.slikey.exp4j.Expression;
import de.slikey.exp4j.ExpressionBuilder;
import de.slikey.exp4j.function.Function;
import java.util.Random;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

public class EquationTransform
implements Transform {
    private Expression expression;
    private static Function randFunction;

    @Override
    public void load(ConfigurationSection parameters) {
        this.setEquation(parameters.getString("equation", ""));
    }

    public EquationTransform() {
    }

    public EquationTransform(String equation) {
        this.setEquation(equation);
    }

    public void setEquation(String equation) {
        try {
            if (randFunction == null) {
                randFunction = new Function("rand", 2){
                    private Random random;
                    {
                        this.random = new Random();
                    }

                    @Override
                    public double apply(double ... args) {
                        return this.random.nextDouble() * (args[1] - args[0]) + args[0];
                    }
                };
            }
            this.expression = new ExpressionBuilder(equation).function(randFunction).variables("t").build();
        } catch (Exception ex) {
            this.expression = null;
            Bukkit.getLogger().log(Level.WARNING, "Error parsing equation " + equation, ex);
        }
    }

    @Override
    public double get(double t2) {
        if (this.expression == null) {
            return 0.0;
        }
        this.expression.setVariable("t", t2);
        return this.expression.evaluate();
    }
}

