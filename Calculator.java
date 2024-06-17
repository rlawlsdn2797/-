import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MiniProject extends JFrame implements ActionListener{
	JTextField m_textfield;
	JTextField m_textfield2;
	JTextField m_textfield3;
	JTextField m_textfield4;
	
	JLabel m_label;
	JLabel m_label2;
	JLabel m_label3;
	JLabel m_label4;
	
	JButton submitbtn, deletebtn;
	
	JPanel CenterPanel;
	JPanel EastPanel;
	JPanel WestPanel;
	JPanel SouthPanel;
	JPanel NorthPanel;
	
	public MiniProject() {
		this.setSize(300, 300);
		
		m_textfield = new JTextField("");
		m_textfield2 = new JTextField("");
		m_textfield3 = new JTextField("");
		m_textfield4 = new JTextField("");
		
		m_label = new JLabel("2진수");
		m_label2 = new JLabel("8진수");
		m_label3 = new JLabel("10진수");
		m_label4 = new JLabel("16진수");
		
		m_label.setHorizontalAlignment(JLabel.CENTER);
		m_label2.setHorizontalAlignment(JLabel.CENTER);
		m_label3.setHorizontalAlignment(JLabel.CENTER);
		m_label4.setHorizontalAlignment(JLabel.CENTER);
		
		CenterPanel = new JPanel();
		SouthPanel = new JPanel();
		NorthPanel = new JPanel();
		EastPanel = new JPanel();
		WestPanel = new JPanel();
		
		CenterPanel.setLayout(new GridLayout(4, 2));
		
		CenterPanel.add(m_label);
		CenterPanel.add(m_textfield);
		CenterPanel.add(m_label2);
		CenterPanel.add(m_textfield2);
		CenterPanel.add(m_label3);
		CenterPanel.add(m_textfield3);
		CenterPanel.add(m_label4);
		CenterPanel.add(m_textfield4);
		
		submitbtn = new JButton("변환");
		deletebtn = new JButton("초기화");
		
		submitbtn.addActionListener(this);
		deletebtn.addActionListener(this);
		
		SouthPanel.add(submitbtn);
		SouthPanel.add(deletebtn);
		
		this.setLayout(new BorderLayout());
		
		this.add(CenterPanel, "Center");
		this.add(SouthPanel, "South");
		this.add(NorthPanel, "North");
		this.add(EastPanel, "East");
		this.add(WestPanel, "West");
		
		this.setTitle("진수 변환기");
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MiniProject();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitbtn) {
			if(!m_textfield.getText().isEmpty()) { //2진수에 입력이 있음
				int Ten = Integer.parseInt(m_textfield.getText(), 2);
				
				m_textfield2.setText(Integer.toOctalString(Ten));
				m_textfield3.setText(Ten + "");
				m_textfield4.setText(Integer.toHexString(Ten).toUpperCase());
			}
			else if(!m_textfield2.getText().isEmpty()) { //8진수에 입력이 있음
				int Ten = Integer.parseInt(m_textfield2.getText(), 8);
				
				m_textfield.setText(Integer.toBinaryString(Ten));
				m_textfield3.setText(Ten + "");
				m_textfield4.setText(Integer.toHexString(Ten).toUpperCase());
			}
			else if(!m_textfield3.getText().isEmpty()) { //10진수에 입력이 있음
				int Ten = Integer.parseInt(m_textfield3.getText(), 10);
				
				m_textfield.setText(Integer.toBinaryString(Ten));
				m_textfield2.setText(Integer.toOctalString(Ten));
				m_textfield4.setText(Integer.toHexString(Ten).toUpperCase());
			}
			else if(!m_textfield4.getText().isEmpty()) { //16진수에 입력이 있음
				int Ten = Integer.parseInt(m_textfield4.getText(), 16);
				
				m_textfield.setText(Integer.toBinaryString(Ten));
				m_textfield2.setText(Integer.toOctalString(Ten));
				m_textfield3.setText(Ten + "");
			}
		}
		else if(e.getSource() == deletebtn) {
			m_textfield.setText("");
			m_textfield2.setText("");
			m_textfield3.setText("");
			m_textfield4.setText("");
		}
	}
}