package 简单疫情打卡;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class days extends JFrame {

	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=简单疫情打卡查询";  
    private static final String USERNAME="sa";  
    private static final String PASSWORD="zxcvbnm123";
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	String titles[]={"学院","所在班级","学号","姓名","目前所在省","目前所在市","是否确认被感染","是否疑似病例","是否与疫区人员接触过","是否今日返校","填报日期"};
	String[][] info=new String[66][13];
	
	public days() {
		this.setVisible(true);
		setTitle("\u67d0\u65e5\u4fe1\u606f\u586b\u62a5");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u67E5\u8BE2\u4FE1\u606F\u7684\u65E5\u671F\uFF1A");
		label.setBounds(46, 10, 202, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(257, 7, 151, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblyyyymmdd = new JLabel("\u683C\u5F0F\uFF1AYYYY-MM-DD");
		lblyyyymmdd.setBounds(96, 36, 132, 21);
		contentPane.add(lblyyyymmdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 67, 730, 400);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.setDataVector(info,titles);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        	Connection conn=DriverManager.getConnection(URL, USERNAME,PASSWORD); 
		        	PreparedStatement pstmt = conn.prepareStatement("select * from 疫情防控统计表  Where 填报日期=?");
		        	pstmt.setString(1, textField.getText());
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
		btnNewButton.setBounds(255, 35, 74, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new administrator();
				dispose();
			}
		});
		btnNewButton_1.setBounds(339, 35, 74, 23);
		contentPane.add(btnNewButton_1);
				
	}

}
