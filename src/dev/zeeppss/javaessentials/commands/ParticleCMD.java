package dev.zeeppss.javaessentials.commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCMD extends JavaPlugin implements CommandExecutor {
    public ParticleCMD() {
    }

    public HashMap<UUID, Effect> stored = new HashMap<UUID, Effect>();

    private static Plugin instance = null;

    private String[] effects = { "flames", "hearts", "happyvillager" };

    public String[] commands = { "/particle set <effect> [Set a particle effect on yourself]",
            "/particle list [list-effects]", "/particle remove [remove-effects]" };

    public static Plugin getInstance() {
        return instance;
    }

    private final String prefix = "§e[§3Java§bEssentials§e] | ";

    public void prefix(String msg, Player player) {
        player.sendMessage(prefix + msg);
    }

    @Override
    public void onEnable() {
        if (instance == null) {
            instance = this;
        }

    }

    public void setPlayerParticles(final Effect effect, final Player player) {
        @SuppressWarnings({ "deprecation", "unused" })
        int i = Bukkit.getScheduler().scheduleAsyncRepeatingTask(instance, new Runnable() {

            @Override
            public void run() {

                if (stored.containsKey(player.getUniqueId())) {
                    for (Player players : Bukkit.getOnlinePlayers()) {

                        Location location;

                        if (effect == Effect.MOBSPAWNER_FLAMES) {
                            players.playEffect(player.getLocation(), stored.get(player.getUniqueId()), 10);
                        } else if (effect == Effect.HEART) {
                            location = Bukkit.getPlayer(player.getUniqueId()).getEyeLocation()
                                    .add(new Location(player.getWorld(), 0, 0.1, 0));
                            players.playEffect(location, stored.get(player.getUniqueId()), 5);
                        } else if (effect == Effect.HAPPY_VILLAGER) {
                            location = Bukkit.getPlayer(player.getUniqueId()).getEyeLocation()
                                    .add(new Location(player.getWorld(), 0, 0.5, 0));
                            players.playEffect(location, stored.get(player.getUniqueId()), 10);
                        }

                    }
                } else {
                    return;
                }

            }

        }, 1, 25);
    }

    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.particle")) {
            if (args.length == 0) {
            } else if (args.length > 0 && args.length < 3) {
                String param = args[0];
                switch (param) {

                    case "remove":

                        if (this.stored.containsKey(p.getUniqueId())) {

                            this.stored.remove(p.getUniqueId());
                            this.prefix("§cParticles has removed!", p);
                            return true;

                        } else {
                            this.prefix("§cYou do not have particles!", p);
                            return true;
                        }

                    case "set":

                        try {

                            if (stored.containsKey(p.getUniqueId())) {
                                this.prefix("§cYou already have particles!", p);
                                return true;
                            }

                            Effect effect = null;

                            switch (args[1]) {

                                case "flames":
                                    effect = Effect.MOBSPAWNER_FLAMES;
                                    this.setPlayerParticles(effect, p);
                                    break;
                                case "hearts":
                                    effect = Effect.HEART;
                                    this.setPlayerParticles(effect, p);
                                    break;
                                case "happyvillager":
                                    effect = Effect.HAPPY_VILLAGER;
                                    this.setPlayerParticles(effect, p);
                                    break;
                                default:
                                    effect = null;
                            }

                            if (effect != null) {
                                this.prefix("§aYou have set your particles to " + args[1], p);
                                this.stored.put(p.getUniqueId(), effect);
                                return true;
                            } else {
                                this.prefix("Particles not found", p);
                                return true;
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            this.prefix(
                                    "§cSomething happened. Try again and make sure you are choosing a valid particle!",
                                    p);
                        }

                        break;

                }

            }

        }

        return false;
    }

}
