package util;

import javafx.scene.paint.Color;

/**
 * util for graphics
 * @author Bhagat
 *
 */
public class GraphicsUtil {

	public static Color randomColor()
	{
		return Color.rgb(NumberUtil.rand(0, 255), NumberUtil.rand(0, 255), NumberUtil.rand(0, 255));
	}

}
