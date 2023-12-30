package com.spring.dao;

import java.util.List;

import com.spring.model.Player;

public interface PlayerDao {

	public List<Player> getPlayers();
	public void addPlayer(Player player);
	public Player getPlayer(int id);
	public void deletePlayer(int id);
}
