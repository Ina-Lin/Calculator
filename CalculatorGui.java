import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class CalculatorGui extends JFrame{ //繼承JFrame class的 CalculatorGui class
	
	//宣告元件
	private JTextField tf;
	private JButton btnRe;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMul;
	private JButton btnDivi;
	private JButton btnEqual;
	private JButton btnPoint;
	private JPanel pan1;
	private JPanel pan2;
	
	//建構子
	CalculatorGui(){
		//建立元件之物件
		tf=new JTextField(40);
		btn0=new JButton("0");
		btn1=new JButton("1");
		btn2=new JButton("2");
		btn3=new JButton("3");
		btn4=new JButton("4");
		btn5=new JButton("5");
		btn6=new JButton("6");
		btn7=new JButton("7");
		btn8=new JButton("8");
		btn9=new JButton("9");
		btnPlus=new JButton("+");
		btnMinus=new JButton("-");
		btnMul=new JButton("*");
		btnDivi=new JButton("/");
		btnEqual=new JButton("=");
		btnPoint=new JButton(".");
		btnRe=new JButton("RESET");
		pan1=new JPanel();
		pan2=new JPanel();
		
		setLayout(new BorderLayout()); //設定面板
		
		//panel1
		pan1.setLayout(new GridLayout(2,1));
	    pan1.add(tf); //row1
	    pan1.add(btnRe); //row2
	    add(pan1,BorderLayout.PAGE_START); //將pan1新增至面板中
	    
	    //panel2
	    pan2.setLayout(new GridLayout(4,4));
	    //row1
	    pan2.add(btn1); //column1
	    pan2.add(btn2); //column2
	    pan2.add(btn3); //column3
	    pan2.add(btnPlus); //column4
	    //row2
	    pan2.add(btn4); //column1
	    pan2.add(btn5); //column2
	    pan2.add(btn6); //column3
	    pan2.add(btnMinus); //column4
	    //row3
	    pan2.add(btn7); //column1
	    pan2.add(btn8); //column2
	    pan2.add(btn9); //column3
	    pan2.add(btnMul); //column4
	    //row4
	    pan2.add(btn0); //column1
	    pan2.add(btnPoint); //column2
	    pan2.add(btnDivi); //column3
	    pan2.add(btnEqual); //column4
	    add(pan2); //將pan2新增至面板中
	    
	    Lis lis = new Lis();
	    
	    //設定按鈕事件處理之方法
	    btn1.addActionListener(lis);
	    btn2.addActionListener(lis);
	    btn3.addActionListener(lis);
	    btn4.addActionListener(lis);
	    btn5.addActionListener(lis);
	    btn6.addActionListener(lis);
	    btn7.addActionListener(lis);
	    btn8.addActionListener(lis);
	    btn9.addActionListener(lis);
	    btn0.addActionListener(lis);
	    btnRe.addActionListener(lis);
	    btnPlus.addActionListener(lis);
	    btnMinus.addActionListener(lis);
	    btnMul.addActionListener(lis);
	    btnDivi.addActionListener(lis);
	    btnPoint.addActionListener(lis);
	    btnEqual.addActionListener(lis);
	}
	private class Lis implements ActionListener{ //實作 ActionListener interface 的 Lis class
		double count = 0; //運算數值
		char sign = ' '; //運算符號
		boolean cal=false; //是否點擊運算符號
		boolean result=false; //是否已顯示結果
		public void actionPerformed(ActionEvent arg0) { //當使用者有行為表現 呼叫此方法
			String str=tf.getText();
			if(cal==true||str.equals("0")||result==true){ //若按了運算符號 或 螢幕顯示為0 或 已出現結果
				str=""; //暫存字串設定為空
				result=false; //將result設為false
			}
			if (arg0.getSource() == btn1){ //按數字鍵1
				tf.setText(str+"1"); //螢幕多顯示1
				cal=false; //代表不是按運算符號（按下數字鍵
			}
			else if (arg0.getSource() == btn2){
				tf.setText(str+"2");
				cal=false;
			}
			else if (arg0.getSource() == btn3){
				tf.setText(str+"3");
				cal=false;
			}
			else if (arg0.getSource() == btn4){
				tf.setText(str+"4");
				cal=false;
			}
			else if (arg0.getSource() == btn5){
				tf.setText(str+"5");
				cal=false;
			}
			else if (arg0.getSource() == btn6){
				tf.setText(str+"6");
				cal=false;
			}
			else if (arg0.getSource() == btn7){
				tf.setText(str+"7");
				cal=false;
			}
			else if (arg0.getSource() == btn8){
				tf.setText(str+"8");
				cal=false;
			}
			else if (arg0.getSource() == btn9){
				tf.setText(str+"9");
				cal=false;
			}
			else if (arg0.getSource() == btn0 && !str.equals("0")){ //當按下按鍵0 且 螢幕不是顯示0
				tf.setText(str+"0");
				cal=false;
			}
			else if (arg0.getSource() == btnRe){ //按下按鍵reset
				//將設定改成預設值
				tf.setText(null); 
				cal=false;
				result=false;
				sign=' ';
			}
			else if (arg0.getSource() == btnPoint&&str.indexOf('.')==-1){ //第一次按下小數點
				tf.setText(str+"."); //螢幕顯示出.
				cal=false;
			}
			else{
				if(sign!=' '&&cal==false){ //運算符號不為空 且 上一按鈕為數字鍵
					switch(sign){ //依據願算符號進行運算
					case '+':
						count+=Integer.parseInt(tf.getText());
						break;
					case '-':
						count-=Integer.parseInt(tf.getText());
						break;
					case '*':
						count*=Integer.parseInt(tf.getText());
						break;
					case '/':
						if(tf.getText()!="0"){ //將分母為0之算式過濾
							count/=Integer.parseInt(tf.getText());
						}
						break;
					}
					tf.setText(String.valueOf(count)); //將院算結果顯示在螢幕
					//恢復sign 和 cal
					sign=' ';
					cal=false;
					result=true; //代表已將結果輸出
				}
				if (arg0.getSource() == btnPlus){ //按下+
					count=Double.parseDouble(tf.getText());
					sign='+'; //改變sign符號 
					cal=true; //代表按下運算符號
				}
				if (arg0.getSource() == btnMinus){ //按下-
					count=Double.parseDouble(tf.getText());
					sign='-';
					cal=true;
				}
				if (arg0.getSource() == btnMul){ //按下*
					count=Double.parseDouble(tf.getText());
					sign='*';
					cal=true;
				}
				if (arg0.getSource() == btnDivi){ //按下/
					count=Double.parseDouble(tf.getText());
					sign='/';
					cal=true;
				}
				if (arg0.getSource() == btnEqual){ //按下=
					sign=' ';
					cal=false;
					result=true; //表示已計算結果
				}
			}
		}
	}
}