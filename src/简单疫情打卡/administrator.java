package ¼òµ¥ÒßÇé´ò¿¨;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class administrator extends JFrame {

	private JPanel contentPane;
	public administrator() {
		setTitle("\u7ba1\u7406\u8005\u529f\u80fd");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bb1 = new JButton("\u67e5\u8be2\u6240\u6709\u586b\u62a5\u7684\u4fe1\u606f");
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new show();
			}
		});
		bb1.setBounds(120, 32, 200, 30);
		contentPane.add(bb1);
		
		JButton button = new JButton("\u8FD4 \u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main().setVisible(true);
				dispose();
			}
		});
		button.setBounds(120, 192, 200, 30);
		contentPane.add(button);
		
		JButton bcc1 = new JButton("\u67d0\u65e5\u586b\u62a5\u67e5\u8be2");
		bcc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new days();
			}
		});
		bcc1.setBounds(120, 72, 200, 30);
		contentPane.add(bcc1);
		
		JButton button_1 = new JButton("\u6309\u67d0\u4e00\u4fe1\u606f\u67e5\u8be2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new select();
			}
		});
		button_1.setBounds(120, 112, 200, 30);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("\u7EDF\u8BA1\u5206\u6790");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new chart();
			}
		});
		button_3.setBounds(120, 152, 200, 30);
		contentPane.add(button_3);
		this.setVisible(true);
	}

}
