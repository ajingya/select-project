package 简单疫情打卡;
//代码中均使用ACSII码
	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JPasswordField;

	public class login extends JFrame {

		private JPanel contentPane;
		private JTextField zh;
		private JPasswordField mm;

		public login() {
			this.setVisible(true);
			setTitle("\u7ba1\u7406\u8005\u767b\u5f55");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 420, 213);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
			label.setBounds(99, 38, 54, 18);
			contentPane.add(label);
			
			zh = new JTextField();
			zh.setBounds(164, 35, 90, 21);
			contentPane.add(zh);
			zh.setColumns(10);
			
			JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
			label_1.setBounds(99, 86, 46, 21);
			contentPane.add(label_1);
			
			JButton button = new JButton("\u767B\u5F55");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String zh1=zh.getText();
					String mm1=mm.getText();
					if(zh1.equals("lee")&&mm1.equals("000000")){
						//管理员登录界面可使用账户名和密码进行身份验证
						new administrator();
						dispose();
					}else{
						JOptionPane.showMessageDialog(contentPane,"账号或密码错误，请重新输入！","错误提示",JOptionPane.ERROR_MESSAGE);
					}//输入错误时弹出提醒框
				}
			});
			button.setBounds(99, 128, 83, 23);
			contentPane.add(button);
			
			JButton button_1 = new JButton("\u91CD\u7F6E");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					zh.setText("") ;
	                mm.setText("") ;
				}
			});
			button_1.setBounds(192, 128, 83, 23);
			contentPane.add(button_1);
			
			mm = new JPasswordField();
			mm.setEchoChar('*');
			mm.setBounds(164, 86, 90, 21);
			contentPane.add(mm);
		}
	}

