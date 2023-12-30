package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.PlayerDao;
import com.spring.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	private PlayerDao playerDao;
	
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao=playerDao;
	}
	
	@Override
	@Transactional
	public List<Player> allPlayers() {
		return  playerDao.getPlayers();
	}

	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDao.addPlayer(player);
		
	}

	@Override
	@Transactional
	public Player showPlayer(int id) {
		
		return playerDao.getPlayer(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		
		playerDao.deletePlayer(id);
	}

}
