package me.akamuru.commandreq;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.akamuru.commandreq.commands.CmdHttpGet;


public class CommandReq 
extends JavaPlugin {
		
	public void onEnable() {
		this.getCommand("http-get").setExecutor(new CmdHttpGet());
		this.getCommand("pussie").setExecutor(new CommandExecutor() {

			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				sender.sendMessage("§8[§c§k|§r§8] §emeow");
				return true;
			}});
	}
	
	public void onDisable() {
		;
	}
	
	public static void sendMessage(CommandSender sender, String str) {
		sender.sendMessage(str.replace("&", "§"));
	}
}
