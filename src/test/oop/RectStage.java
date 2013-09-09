package test.oop;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RectStage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 重写paint方法
	public void paint(Graphics g){
		g.setColor(new Color(0,0,0));// 设置颜色：黑色
		g.fillRect(10, 10, 20, 50);// 填充矩形区域
	}
}
