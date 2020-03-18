package 简单疫情打卡;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class show extends JFrame {
//数据库连接
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=简单疫情打卡查询";  
    private static final String USERNAME="sa";  
    private static final String PASSWORD="zxcvbnm123";
	private JPanel contentPane;
	private JTable table;
	String titles[]={"学院","所在班级","学号","姓名","目前所在省","目前所在市","是否确认被感染","是否疑似病例","是否与疫区人员接触过","是否今日返校","填报日期"};
	String[][] info=new String[66][13];
	

	public show() {
		setTitle("\u6240\u6709\u586b\u62a5\u4fe1\u606f");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 730, 400);
		contentPane.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(info,titles);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		this.setVisible(true);
		
		try{
			//加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Connection conn=DriverManager.getConnection(URL, USERNAME,PASSWORD); 
        	Statement pstmt = conn.createStatement();
            ResultSet rs=pstmt.executeQuery("select * from 疫情防控统计表");
        	int i=0;
        	//查询数据
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
	    	}if(i==0){
        		JOptionPane.showMessageDialog(contentPane,"无相关信息！","错误提示",JOptionPane.WARNING_MESSAGE);
        	}//条件选择，若有错误提示
			model.setDataVector(info,titles);
			rs.close();
        	conn.close();
        }catch (Exception e1) {    
            e1.printStackTrace();    
        }
		
	}
}
