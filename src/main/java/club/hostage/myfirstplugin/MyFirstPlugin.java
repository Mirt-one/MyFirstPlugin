package club.hostage.myfirstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("Mi primer plugin se ha iniciado!!! Hola!!!");

        Bukkit.getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("Mi primer plugin se ha detenido!! Adios!!!");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(!player.hasPermission("myfirstplugin.mover")){

            e.setCancelled(true);

        }


    }

    @EventHandler
    public void onThrow(PlayerJoinEvent e){

        Player player = e.getPlayer();
        if(player.hasPermission("myfirstplugin.join")){
            e.setJoinMessage(ChatColor.WHITE + "[+]" + ChatColor.AQUA + player.getName());
        }


    }

}
