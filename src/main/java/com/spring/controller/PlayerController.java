package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Player;
import com.spring.service.PlayerService;


//localhost:8080/Players_project
@Controller
@RequestMapping("/fifa")
//localhost:8080/Players_project/fifa
public class PlayerController {
	
	private PlayerService playerService;
	
	
	
	public PlayerService getPlayerService() {
		return playerService;
	}


	@Autowired
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}



	//localhost:8080/Players_project/fifa/players
	@GetMapping("/players")
	public String players(Model model){
		List<Player> players=playerService.allPlayers();
		model.addAttribute("players", players);
		return "fifa_players";
	}
	//localhost:8080/Players_project/fifa/add
	@GetMapping("/add")
	public String addPlayer(Model model){
		model.addAttribute("player",new Player());
		return "addPlayer";
	}
	
	
	//localhost:8080/Players_project/fifa/save
		@PostMapping("/save")
		public String addPlayer(@ModelAttribute("player") Player player){
			playerService.savePlayer(player);
			
			return "redirect:/fifa/players";
		}
		
		//localhost:8080/Players_project/fifa/showplayer
		@GetMapping("/showplayer")
		public String editPlayer(@RequestParam("playerId") int id,Model model){
			Player p=playerService.showPlayer(id);
			model.addAttribute("player", p);
			return "addPlayer";
		}
		
		//localhost:8080/Players_project/fifa/delete
		@GetMapping("/delete")
		public String deletePlayer(@ModelAttribute("playerId") int id){
			playerService.delete(id);
			return "redirect:/fifa/players";
		}
				
}
