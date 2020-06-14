package cn.leomc.OraxenMythicMobsIntegration;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobLootDropEvent;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobSpawnEvent;
import io.th0rgal.oraxen.items.OraxenItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public class OraxenMythicMobsIntegration extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onMythicMobLootDrop(MythicMobLootDropEvent mmlde) {

        List<String> mmdrops = mmlde.getMobType().getConfig().getStringList("Drops");
        for(String str : mmdrops) {
            if(str.contains("oraxen") && str.split(" ").length == 4 && OraxenItems.isAnItem(str.split(" ")[1])) {
                ItemStack odrops = OraxenItems.getItemById(str.split(" ")[1]).build();
                String am = str.split(" ")[2];
                int amount = 1;
                if(am.split("-").length == 2) {
                    amount = getRandomNumber(Integer.parseInt(am.split("-")[0]),Integer.parseInt(am.split("-")[1]));

                }
                if(getChance(Integer.parseInt(str.split(" ")[3])))
                    for(int i = 0;i < amount;i++)
                        mmlde.getEntity().getWorld().dropItem(mmlde.getEntity().getLocation(), odrops);
            }

        }
    }

    @EventHandler
    public void onMythicMobSpawn(MythicMobSpawnEvent mmse) {

        List<String> mmequipment = mmse.getMobType().getConfig().getStringList("Equipment");
        for(String str : mmequipment) {
            if(str.contains("oraxen") && str.split(" ").length == 2 && OraxenItems.isAnItem(str.split(" ")[1].split(":")[0])) {
                ItemStack oequip = OraxenItems.getItemById(str.split(" ")[1].split(":")[0]).build();
                LivingEntity mob = (LivingEntity) mmse.getEntity();
                EntityEquipment mmequip = mob.getEquipment();
                switch(str.split(" ")[1].split(":")[1]) {
                    case "0": mmequip.setItemInMainHand(oequip); mmequip.setItemInMainHandDropChance(0); break;
                    case "1": mmequip.setBoots(oequip); mmequip.setBootsDropChance(0); break;
                    case "2": mmequip.setLeggings(oequip); mmequip.setLeggingsDropChance(0); break;
                    case "3": mmequip.setChestplate(oequip); mmequip.setChestplateDropChance(0); break;
                    case "4": mmequip.setHelmet(oequip); mmequip.setHelmetDropChance(0); break;
                    case "5": mmequip.setItemInOffHand(oequip); mmequip.setItemInOffHandDropChance(0); break;
                }

            }


        }

    }


    public boolean getChance(int percentage){
        int r = new Random().nextInt(99);
        if(r >=0 && r < percentage)
            return true;
        else
            return false;
    }


    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

}
