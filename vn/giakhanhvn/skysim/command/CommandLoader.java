/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.command;

import java.util.ArrayList;
import java.util.List;
import vn.giakhanhvn.skysim.command.SCommand;

public class CommandLoader {
    private final List<SCommand> commands = new ArrayList<SCommand>();

    public void register(SCommand command) {
        this.commands.add(command);
        command.register();
    }

    public int getCommandAmount() {
        return this.commands.size();
    }
}

