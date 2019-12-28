package de.craftagain.lobbysystem.command;

import de.alpharout.lobbysystem.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_info implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(command.getName().equals("info")){
                if(args.length != 0)
                    return false;

                player.sendMessage(Data.getPrefix() + "§7Version: §a" + Data.getVersion());
                player.sendMessage(Data.getPrefix() + "§7Author: - §alpharout");
                player.sendMessage(Data.getPrefix() + "§7Author: - §aCRAFTagain");
                return true;
            }
        }
        return false;
    }
}
