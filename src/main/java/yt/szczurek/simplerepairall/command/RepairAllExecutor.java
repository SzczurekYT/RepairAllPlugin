package yt.szczurek.simplerepairall.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepairAllExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You aren't a player!");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("simplerepairall.repairall")) {
            player.sendMessage(ChatColor.RED + "You don't have the required permission!");
            return true;
        }
        PlayerInventory inventory = player.getInventory();
        List<ItemStack> items = new ArrayList<>();
        Collections.addAll(items, inventory.getContents());
        Collections.addAll(items, inventory.getArmorContents());
        Collections.addAll(items, inventory.getExtraContents());
        for (ItemStack item: items) {
            if (item == null) continue;
            if (!(item.getItemMeta() instanceof Damageable)) continue;
            Damageable meta = (Damageable) item.getItemMeta();
            meta.setDamage(0);
            item.setItemMeta(meta);
        }
        player.sendMessage(ChatColor.GREEN + "Repaired all you tools.");
        return true;
    }
}
