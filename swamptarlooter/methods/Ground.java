package swamptarlooter.methods;

import com.infibot.api.env.local.Camera;
import com.infibot.api.env.world.GroundItems;
import com.infibot.api.model.GroundItem;

public class Ground {

	public static final int TAR = 1939;

	public static boolean validateGroundItem(GroundItem g) {
		g = GroundItems.getNearest(TAR);
		return g != null && Camera.isVisible(g);
	}

}
