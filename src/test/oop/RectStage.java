package test.oop;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RectStage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ��дpaint����
	public void paint(Graphics g){
		g.setColor(new Color(0,0,0));// ������ɫ����ɫ
		g.fillRect(10, 10, 20, 50);// ����������
	}
}
