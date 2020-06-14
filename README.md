# Oraxen MythicMobs Integration

It's a bukkit plugin that can support [MythicMobs](https://www.spigotmc.org/resources/5702) to drop [Oraxen](https://www.spigotmc.org/resources/72448) items.

Current Verion: v2.0

Designed for MythicMobs v4.9.1 and Oraxen v1.29.0. It maybe support lower or higher versions.

# Custom Drops
`oraxen [oraxen item name] [amount to drop(number or region)] [chance to drop(0-100)]`  
For Example:  
`oraxen custom_material 3-4 70`  
means **70** percent chance to drop **3 to 4 custom_material** item.
# Custom Equipment
`oraxen [oraxen item(equipment) name]:[slot(0,1,2,3,4,5)]`  
**0** is **MainHand**, **1** is **OffHand**, **2** is **Helmet**, **3** is **ChestPlate**,  **4** is **Leggings**, **5** is **Boots**.  
For Example:  
`oraxen custom_sword:0`  
means put a **custom_sword** in **MainHand**.