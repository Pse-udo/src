package swamptarlooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import swamptarlooter.methods.Ground;
import swamptarlooter.util.Time;

import com.infibot.api.env.Mouse;
import com.infibot.api.env.local.Inventory;

public class Paint {

	public static void drawMouse(Graphics g) {
		g.setColor(Color.ORANGE);
		final Point m = Mouse.getPosition();
		g.drawLine(m.x -5, m.y + 5, m.x + 5, m.y - 5);
		g.drawLine(m.x -5, m.y - 5, m.x + 5, m.y + 5);		
	}

	public static void drawPaint(Graphics g) {

		int tarGained = Inventory.count(true, Ground.TAR) - SwampTarLooter.startTar;

		drawMouse(g);
		g.drawString("Time Running: " + Time.format(SwampTarLooter.runTime.getElapsed()), 250, 250);
		g.drawString("Tar Gained: " + tarGained, 270, 270);
	}

}
