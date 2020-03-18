package 简单疫情打卡;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.awt.event.ActionEvent;

public class select extends JFrame {

	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=简单疫情打卡查询";  
    private static final String USERNAME="sa";  
    private static final String PASSWORD="zxcvbnm123";
	private JPanel contentPane;
	private JTable table;
	String titles[]={"学院","所在班级","学号","姓名","目前所在省","目前所在市","是否确认被感染","是否疑似病例","是否与疫区人员接触过","是否今日返校","填报日期"};
	String[][] info=new String[66][13];
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
	public select() {
		setTitle("\u67e5\u8be2\u4fe1\u606f");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 48, 730, 400);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(info,titles);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		label = new JLabel("\u76F8\u5173\u4FE1\u606F\uFF1A");
		label.setBounds(35, 20, 70, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(105, 17, 89, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u67E5\u627E");
		button.setToolTipText("根据某一信息查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        	Connection conn=DriverManager.getConnection(URL, USERNAME,PASSWORD); 
		        	PreparedStatement pstmt = conn.prepareStatement("select * from 疫情防控统计表  Where 学院=? or 所在班级=? or 姓名=? or 学号=? or 目前所在省=? or 目前所在市=?");
		        	pstmt.setString(1, textField.getText());
		        	pstmt.setString(2, textField.getText());
		        	pstmt.setString(3, textField.getText());
		        	pstmt.setString(4, textField.getText());
		        	pstmt.setString(5, textField.getText());
		        	pstmt.setString(6, textField.getText());
		        	ResultSet rs=pstmt.executeQuery();
		        	int i=0;
		        	while(rs.next()){  
			    		int j=0;
			    		info[i][j]=rs.getString(1);j++;
			    		info[i][j]=rs.getString(2);;j++;
			    		info[i][j]=rs.getString(3);;j++;
			    		info[i][j]=rs.getString(4);;j++;
			    		info[i][j]=rs.getString(5);;j++;
			    		info[i][j]=rs.getString(6);;j++;
			    		info[i][j]=rs.getString(7);;j++;
			    		info[i][j]=rs.getString(8);;j++;
			    		info[i][j]=rs.getString(9);;j++;
			    		info[i][j]=rs.getString(10);;j++; 
			    		info[i][j]=rs.getString(11);;j++; 
			    		i++;
			    	}
				if(i==0){
		        		JOptionPane.showMessageDialog(contentPane,"无相关信息！","错误提示",JOptionPane.WARNING_MESSAGE);
		        	}
				
			    	table.setEnabled(false);
					model.setDataVector(info,titles);
					rs.close();
		        	conn.close();
		        }catch (Exception e1) {    
		            e1.printStackTrace();    
		        } 
		        
			}
		});
		button.setBounds(210, 15, 70, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new administrator().setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(285, 15, 70, 23);
		contentPane.add(button_1);
		this.setVisible(true);
	}

}
