# Oraxen MythicMobs Integration

It's a bukkit plugin that can support [MythicMobs](https://www.spigotmc.org/resources/5702) to drop [Oraxen](https://www.spigotmc.org/resources/72448) items.

Current Verion: v3.0

Tested Version:  
MythicMobs v4.9.1  
Oraxen v1.29.0

#  Drops
`oraxen [oraxen item name] [amount to drop(number or region)] [chance to drop(0-1)]`  
For Example:  
`oraxen custom_material 3-4 0.75`  
means **75** percent chance to drop **3 to 4 custom_material** items.
#  Equipment
`oraxen [slot] [oraxen item(equipment) name]`  
Slots:  
* 0, mainhand, weapon
* 1, boots, shoes
* 2, leggings, pants
* 3, chestpiece, chestplate, body
* 4, helmet, helm   
* 5, shield  

_5 is OffHand, but you can't put **offhand**, because MythicMobs's Author didn't put the alias._

For Example:  
`oraxen mainhand custom_sword`  
means put a **custom_sword** item in **MainHand**.  
`oraxen 3 custom_chestplate`  
means put a **custom_chestplate** item in **ChestPlate** Slot
