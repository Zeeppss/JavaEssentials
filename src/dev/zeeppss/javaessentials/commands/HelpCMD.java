package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCMD implements CommandExecutor {
    public HelpCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.help")) {
            p.sendMessage("§8==========§aList JavaEssentials Commands:§8========== ");
                p.sendMessage("§a/clearchat §7>> §8[§6essentials.clearchat§8]");
                p.sendMessage("§a/feed §7>> §8[§6essentials.feed§8]");
                p.sendMessage("§a/fly §7>> §8[§6essentials.fly§8]");
                p.sendMessage("§a/gamemode §7>> §8[§6essentials.gamemode§8]");
                p.sendMessage("§a/gm §7>> §8[§6essentials.gamemode§8]");
                p.sendMessage("§a/heal §7>> §8[§6essentials.heal§8]");
                p.sendMessage("§a/kick §7>> §8[§6essentials.kick§8]");
                p.sendMessage("§a/ban §7>> §8[§6essentials.ban§8]");
                p.sendMessage("§a/broadcast §7>> §8[§6essentials.broadcast§8]");
                p.sendMessage("§a/bc §7>> §8[§6essentials.broadcast§8]");
                p.sendMessage("§a/afk §7>> §8[§6essentials.afk§8]");
                p.sendMessage("§a/ping §7>> §8[§6essentials.ping§8]");
                p.sendMessage("§a/invsee §7>> §8[§6essentials.invsee§8]");
                p.sendMessage("§a/hat §7>> §8[§6essentials.hat§8]");
                p.sendMessage("§a/top §7>> §8[§6essentials.top§8]");
                p.sendMessage("§a/clearinventory §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("§a/ci §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("§a/invecsee §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("§a/weather §7>> §8[§6essentials.weather§8]");
                p.sendMessage("§a/message §7>> §8[§6essentials.message§8]");
                p.sendMessage("§a/msg §7>> §8[§6essentials.message§8]");
                p.sendMessage("§a/smite §7>> §8[§6essentials.smite§8]");
                p.sendMessage("§a/lightning §7>> §8[§6essentials.smite§8]");
                p.sendMessage("§a/suicide §7>> §8[§6essentials.suicide§8]");
                p.sendMessage("§a/nick §7>> §8[§6essentials.nick§8]");
                p.sendMessage("§a/vanish §7>> §8[§6essentials.vanish§8]");
                p.sendMessage("§a/v §7>> §8[§6essentials.vanish§8]");
                p.sendMessage("§a/rename §7>> §8[§6essentials.rename§8]");
                p.sendMessage("§a/relore §7>> §8[§6essentials.relore§8]");
                p.sendMessage("§a/workbench §7>> §8[§6essentials.workbench§8]");
                p.sendMessage("§a/wb §7>> §8[§6essentials.workbench§8]");
                p.sendMessage("§a/back §7>> §8[§6essentials.back§8]");
                p.sendMessage("§a/message §7>> §8[§6essentials.msg§8]");
                p.sendMessage("§a/msg §7>> §8[§6essentials.msg§8]");
                p.sendMessage("§a/repair §7>> §8[§6essentials.repair§8]");
                p.sendMessage("§a/particle §7>> §8[§6essentials.particle§8]");
                p.sendMessage("§8==========§aList Troll Commands:§8========== ");
                p.sendMessage("§a/nuke §7>> §8[§6essentials.nuke§8]");
                p.sendMessage("§a/freeze §7>> §8[§6essentials.freeze§8]");
                p.sendMessage("§a/banish §7>> §8[§6essentials.banish§8]");
                p.sendMessage("§a/creeper §7>> §8[§6essentials.creeper§8]");
                p.sendMessage("§a/kitop §7>> §8[§6essentials.kitop§8]");
                p.sendMessage("§a/kp §7>> §8[§6essentials.kitop§8]");
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.help permissions!");
            }
            return false;
        }
    }
}
