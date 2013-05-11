package swamptarlooter.node;

import swamptarlooter.methods.Ground;
import swamptarlooter.util.Timer;

import com.infibot.api.Random;
import com.infibot.api.Sleep;
import com.infibot.api.env.local.Camera;
import com.infibot.api.env.local.Inventory;
import com.infibot.api.env.world.GroundItems;
import com.infibot.api.env.world.Players;
import com.infibot.api.env.world.route.Walking;
import com.infibot.api.model.GroundItem;
import com.infibot.api.model.Tile;
import com.infibot.bot.script.ProceduralScript;

public class LootHandler extends ProceduralScript.Procedure {

	@Override
	public boolean criteria() {
		GroundItem tar = GroundItems.getNearest(Ground.TAR);
		return Ground.validateGroundItem(tar) && !Inventory.isFull();
	}

	@Override
	public int execute() {
		Timer t = new Timer(3000);
		GroundItem tar = GroundItems.getNearest(Ground.TAR);
		Tile loc = tar.getLocation();
		while (!t.hasExpired() && Players.getMyPlayer().isMoving()) {
			Sleep.millis(50, 150);
		}
		if (Ground.validateGroundItem(tar)) {
			if (tar.interact("Take")) {
				Sleep.millis(300, 550);
			} else {
				if (tar != null && !Camera.isVisible(tar)) {
					Camera.face(loc);
					Walking.walkMinimap(loc);
				}
			}
		}
		return Random.next(30, 80);
	}
}