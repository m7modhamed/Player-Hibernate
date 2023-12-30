package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao{

	
	private SessionFactory factory;
	
	@Autowired
	public PlayerDaoImpl(SessionFactory factory) {
		this.factory=factory;
	}
	
	@Override
	public List<Player> getPlayers() {
		Session session=factory.getCurrentSession();
		Query<Player> query=session.createQuery("from Player",Player.class);

		return query.list();
	}

	@Override
	public void addPlayer(Player player) {
		Session session=factory.getCurrentSession();
		session.saveOrUpdate(player);
		
	}

	@Override
	public Player getPlayer(int id) {
		Session session=factory.getCurrentSession();

		return session.get(Player.class,id);
	}

	@Override
	public void deletePlayer(int id) {
		Session session=factory.getCurrentSession();
		Query<Player> q= session.createQuery("delete from Player where id=?1");
		q.setInteger(1,id);
		q.executeUpdate();
		
	}

}
