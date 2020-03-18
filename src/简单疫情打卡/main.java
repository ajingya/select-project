package 简单疫情打卡;

//功能选择界面
	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.awt.event.ActionEvent;

	public class main extends JFrame {
	    
		private JPanel contentPane;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						main frame = new main();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public main() {
			setTitle("\u529f\u80fd\u9009\u62e9");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 325, 177);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			//选择查询按钮讲进入管理员模式，需要登录
			JButton button = new JButton("\u67e5\u8be2");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new login();
					dispose();
				}
			});
			button.setBounds(101, 36, 93, 23);
			contentPane.add(button);
			
			JButton button_1 = new JButton("\u586b\u62a5");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//选择填报按钮可以进入一般用户模式进行信息填写
				}
			});
			button_1.setBounds(101, 82, 93, 23);
			contentPane.add(button_1);
		}
	}

