package test.oop;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class TestJFrame {
	public static void main(String[] args) {
		JFrame frame1 = new JFrame();
		frame1.setLocation(0, 0);
		frame1.setSize(400, 300);
		frame1.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2 - frame1.getWidth();
		int y = screen.height / 2 - frame1.getHeight();
		frame1.setLocation(x, y);
		// int[][] arr = new int[3][4];
	}

	// ���ع��췽��
	public TestJFrame(int x, int y, int weight, int height) {

	}

	public TestJFrame(int x, int y, int weight) {
		this(x, y, weight, weight); // ��this()�������ù����� �����ڷ����ĵ�һ�� ����ֻ�����ڹ�������
	}
}
