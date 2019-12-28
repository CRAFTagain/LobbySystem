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
                player.sendMessage(Data.getPrefix() + "§7Authors: §6alphaR0ut §7(Head-Developer), §6CRAFTagain §7(2. Head-Developer)");
                return true;
            }
        }
        return false;
    }
}
