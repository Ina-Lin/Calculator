import javax.swing.JFrame;

public class Calculator {
	public static void main(String[] args) {
		CalculatorGui gui=new CalculatorGui(); //建立gui(CalculatorGui)物件
		gui.setSize(230, 300); //設定大小
		gui.setVisible(true); //讓視窗顯示
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉視窗即結束城市
		gui.setTitle("My Calculator"); //設定視窗名稱
	}
}
