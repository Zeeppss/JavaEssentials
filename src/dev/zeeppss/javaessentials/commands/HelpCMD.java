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
                p.sendMessage("/§aclearchat §7>> §8[§6essentials.clearchat§8]");
                p.sendMessage("/§afeed §7>> §8[§6essentials.feed§8]");
                p.sendMessage("/§afly §7>> §8[§6essentials.fly§8]");
                p.sendMessage("/§agamemode §7>> §8[§6essentials.gamemode§8]");
                p.sendMessage("/§agm §7>> §8[§6essentials.gamemode§8]");
                p.sendMessage("/§aheal §7>> §8[§6essentials.heal§8]");
                p.sendMessage("/§akick §7>> §8[§6essentials.kick§8]");
                p.sendMessage("/§aban §7>> §8[§6essentials.ban§8]");
                p.sendMessage("/§abroadcast §7>> §8[§6essentials.broadcast§8]");
                p.sendMessage("/§abc §7>> §8[§6essentials.broadcast§8]");
                p.sendMessage("/§aafk §7>> §8[§6essentials.afk§8]");
                p.sendMessage("/§aping §7>> §8[§6essentials.ping§8]");
                p.sendMessage("/§ainvsee §7>> §8[§6essentials.invsee§8]");
                p.sendMessage("/§ahat §7>> §8[§6essentials.hat§8]");
                p.sendMessage("/§atop §7>> §8[§6essentials.top§8]");
                p.sendMessage("/§aclearinventory §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("/§aci §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("/§ainvecsee §7>> §8[§6essentials.clearinventory§8]");
                p.sendMessage("/§aweather §7>> §8[§6essentials.weather§8]");
                p.sendMessage("/§amessage §7>> §8[§6essentials.message§8]");
                p.sendMessage("/§amsg §7>> §8[§6essentials.message§8]");
                p.sendMessage("/§asmite §7>> §8[§6essentials.smite§8]");
                p.sendMessage("/§alightning §7>> §8[§6essentials.smite§8]");
                p.sendMessage("/§asuicide §7>> §8[§6essentials.suicide§8]");
                p.sendMessage("§8==========§aList Troll Commands:§8========== ");
                p.sendMessage("§a/nuke §7>> §8[§6essentials.nuke§8]");
                p.sendMessage("§a/freeze §7>> §8[§6essentials.freeze§8]");
                p.sendMessage("§a/banish §7>> §8[§6essentials.banish§8]");
                p.sendMessage("§a/creeper §7>> §8[§6essentials.creeper§8]");
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.help permissions!");
            }
            return false;
        }
    }
}
