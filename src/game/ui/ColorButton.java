package game.ui;

import javax.swing.*;
import java.awt.*;
import game.Colors;

public class ColorButton extends JButton {
	private final Color fillColor;
	private final Colors colorsObject;

	public ColorButton(Colors color){
		fillColor = getColor(color);
		colorsObject = color;
		setBackground(fillColor);
		setBorderPainted(false);
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public Colors getColorsObject(){
		return colorsObject;
	}

	public static Color getColor(Colors colorName){
		switch (colorName){
			case BLACK:
				return Color.BLACK;
			case WHITE:
				return Color.WHITE;
			case GRAY:
				return Color.GRAY;
			case RED:
				return Color.RED;
			case BLUE:
				return Color.BLUE;
			case YELLOW:
				return Color.YELLOW;
			case PINK:
				return Color.PINK;
			case GREEN:
				return Color.GREEN;
			case ORANGE:
				return Color.ORANGE;
			case MAGENTA:
				return Color.MAGENTA;
			default:
				return new Color(210, 210, 210);
		}
	}
}
