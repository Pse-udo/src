package swamptarlooter;

import java.awt.Graphics2D;

import swamptarlooter.methods.Ground;
import swamptarlooter.node.LootHandler;
import swamptarlooter.util.Timer;

import com.infibot.api.env.local.Game;
import com.infibot.api.env.local.Inventory;
import com.infibot.bot.script.Manifest;
import com.infibot.bot.script.ProceduralScript;

@Manifest(name = "pSwampTarLooter", description = "Loots Swamp Tar in Lumbridge Swamp", authors = { "Pseudo" }, version = 0.1)
public class SwampTarLooter extends ProceduralScript {
	
	public static Timer runTime = new Timer(0);
	public static int startTar;

	@Override
	public void onExit() {
		deregister(new LootHandler());
	}

	@Override
	public boolean onStart() {
		if(Game.isLoggedIn()) {
			startTar = Inventory.count(true, Ground.TAR);
			register(new LootHandler());
		}
		return false;
	}

	@Override
	public void render(Graphics2D arg0) {
		
	}
}