package ru.redenergy.vault;


import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

@Mod(modid = "forge-vault", acceptableRemoteVersions = "*")
public class ForgeVault{
	
	@SideOnly(Side.SERVER)
	private static Economy economy;
	@SideOnly(Side.SERVER)
	private static Permission permission;
	@SideOnly(Side.SERVER)
	public static Chat chat;
	

	@Mod.Instance("forge-vault")
	public static ForgeVault instance;
	
	@SideOnly(Side.SERVER)
	public static Economy getEconomy(){
		return economy;
	}
	
	@SideOnly(Side.SERVER)
	public static Permission getPermission(){
		return permission;
	}

	@SideOnly(Side.SERVER)
	public static Chat getChat(){
		return chat;
	}
	
	@SideOnly(Side.SERVER)
	private static void setupEconomy() throws ClassNotFoundException{
		if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
			FMLLog.info("Cannot find Vault!");
			return;
		}
		RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if(rsp == null){
			FMLLog.info("Registered Service Provider for Economy.class not found");
			return;
		}
		economy = rsp.getProvider();
		FMLLog.info("Economy successfully hooked up");
	}
	
	@SideOnly(Side.SERVER)
	public static void setupPermissions() throws ClassNotFoundException{
		if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
			FMLLog.info("Cannot find Vault!");
			return;
		}
		RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if(rsp == null){
			FMLLog.info("Registered Service Provider for Permission.class not found");
			return;
		}
		permission = rsp.getProvider();
		FMLLog.info("Permission successfully hooked up");
		
	}
	
	@SideOnly(Side.SERVER)
	public static void setupChat() throws ClassNotFoundException{
		if(Bukkit.getServer().getPluginManager().getPlugin("Vault") == null){
			FMLLog.info("Cannot find Vault!");
			return;
		}
		RegisteredServiceProvider<Chat> rsp = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
		if(rsp == null){
			FMLLog.info("Registered Service Provider for Chat.class not found");
			return;
		}
		chat = rsp.getProvider();
		FMLLog.info("Vault Chat successfully hooked up");
	}
	
	
	@SideOnly(Side.SERVER)
	@Mod.EventHandler
	public static void serverLoad(FMLServerStartingEvent event){
		try {
			setupEconomy();
			setupPermissions();
			setupChat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

