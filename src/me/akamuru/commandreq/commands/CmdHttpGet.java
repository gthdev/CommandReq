package me.akamuru.commandreq.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.akamuru.commandreq.CommandReq;

public class CmdHttpGet
implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length < 2) {
			CommandReq.sendMessage(sender, "&8[&eCommandReq&8]&e Error: You need to specify at least URL and one GET param.");
			return false;
		} 
		String server = args[0].toLowerCase();
		if(!server.startsWith("http")) {
			CommandReq.sendMessage(sender, "&8[&eCommandReq&8]&e Error: URL shall start with http(s).");
			return false;
		}
		CommandReq.sendMessage(sender, "&8[&aCommandReq&8]&a Sending HTTP request to: " + server);
		if(server.endsWith("/"))
			server = server.substring(0, server.length()-1);
		try {
			String params = "?";
			for(int i = 1; i < args.length; i++) {
				params += args[i];
				if (i != args.length - 1) 
					params += "&";
			}
			URL url = new URL(server + params);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(250);
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			CommandReq.sendMessage(sender, "&8[&bCommandReq&8]&b Server response: " + br.readLine());
			br.close();
		} catch (Exception e) {
			CommandReq.sendMessage(sender, "&8[&eCommandReq&8]&e Exception occured: " + e.toString());
			e.printStackTrace();
		}
		return true;
	}
	
}
