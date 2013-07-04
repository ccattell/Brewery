package com.dre.brewery.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import com.dre.brewery.BCauldron;
import com.dre.brewery.BIngredients;
import com.dre.brewery.Brew;
import com.dre.brewery.Barrel;
import com.dre.brewery.BPlayer;
import com.dre.brewery.Words;

public class PlayerListener implements Listener {
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Block clickedBlock = event.getClickedBlock();

		if (clickedBlock != null) {
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (clickedBlock.getType() == Material.CAULDRON) {
					if (clickedBlock.getRelative(BlockFace.DOWN).getType() == Material.FIRE || clickedBlock.getRelative(BlockFace.DOWN).getType() == Material.STATIONARY_LAVA
							|| clickedBlock.getRelative(BlockFace.DOWN).getType() == Material.LAVA) {
						Material materialInHand = event.getMaterial();
						Player player = event.getPlayer();
						ItemStack item = event.getItem();

						// add ingredient to cauldron that meet the previous
						// contitions
						if (BIngredients.possibleIngredients.contains(materialInHand)) {
							if (BCauldron.ingredientAdd(clickedBlock, materialInHand)) {
								if (item.getAmount() > 1) {
									item.setAmount(item.getAmount() - 1);
								} else {
									player.setItemInHand(new ItemStack(0));
								}
							}
							// fill a glass bottle with potion
						} else if (materialInHand == Material.GLASS_BOTTLE) {
							if (BCauldron.fill(player, clickedBlock)) {
								event.setCancelled(true);
								if (item.getAmount() > 1) {
									item.setAmount(item.getAmount() - 1);
								} else {
									player.setItemInHand(new ItemStack(0));
								}
							}
							// reset cauldron when refilling to prevent
							// unlimited source of potions
						} else if (materialInHand == Material.WATER_BUCKET) {
							if (clickedBlock.getData() != 0) {
								if (clickedBlock.getData() < 3) {
									// will only remove when existing
									BCauldron.remove(clickedBlock);
								}
							}
						}
					}
					// access a barrel
				} else if (clickedBlock.getType() == Material.FENCE || clickedBlock.getType() == Material.NETHER_FENCE || clickedBlock.getType() == Material.SIGN
						|| clickedBlock.getType() == Material.WALL_SIGN) {
					Barrel barrel = Barrel.get(clickedBlock);
					if (barrel != null) {
						event.setCancelled(true);
						Block broken = Barrel.getBrokenBlock(clickedBlock);
						// barrel is built correctly
						if (broken == null) {
							barrel.open(event.getPlayer());
						} else {
							barrel.remove(broken);
						}
					}
				}
			}
		}

	}

	// player drinks a custom potion
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
		ItemStack item = event.getItem();
		if (item != null) {
			if (item.getType() == Material.POTION) {
				if (item.hasItemMeta()) {
					if (BPlayer.drink(Brew.getUID(item), event.getPlayer())) {
						if (event.getPlayer().getGameMode() != org.bukkit.GameMode.CREATIVE) {
							Brew.remove(item);
						}
					}
				}
			}
		}
	}

	// player walks while drunk, push him around!
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerMove(PlayerMoveEvent event) {
		if (BPlayer.players.containsKey(event.getPlayer().getName())) {
			BPlayer.playerMove(event);
		}
	}

	// player talks while drunk, but he cant speak very well
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		if (BPlayer.players.containsKey(event.getPlayer().getName())) {
			Words.playerChat(event);
		}
	}

	// player joins while passed out
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerLogin(PlayerLoginEvent event) {
		final Player player = event.getPlayer();
		BPlayer bplayer = BPlayer.get(player.getName());
		if (bplayer != null) {
			switch (bplayer.canJoin()) {
			case 0:
				bplayer.join(player);
				return;
			case 2:
				event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Dein Charakter ist betrunken und reagiert nicht. Versuch es noch einmal!");
				return;
			case 3:
				event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Dein Charakter ist sturzbesoffen und ohne Besinnung. Versuch es in 10 Minuten noch einmal!");
			}
		}
	}
}