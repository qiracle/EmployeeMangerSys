//======================================================================
//
//        Copyright (C) 2016   
//        All rights reserved
//
//        filename :Login
//        
//
//        created by Qiangqiang Jinag in  2016.08.23
//        https://github.com/qiracle
//		   qiracle@foxmail.com
//
//======================================================================

package qq.qiracle;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import qq.qiracle.db.UserContectDb;
import qq.qiracle.utils.MyLookAndFeel;
import qq.qiracle.utils.RemPwdUtils;

public class Login extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField JPasswordField;
	private javax.swing.JCheckBox jCheckBox1;
	// End of variables declaration
	UserContectDb lcd = new UserContectDb();

	public Login() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		JPasswordField = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();

		String info = RemPwdUtils.readPwd();
		String[] infos = info.split("=");
		if (infos.length == 3) {
			jTextField1.setText(infos[0]);
			JPasswordField.setText(infos[1]);
			System.out.println(infos[0]+"--"+infos[1]+"--"+infos[2]);
			if(infos[2].trim().equals("true")){
				jCheckBox1.setSelected(true);
				System.out.println(" print true");
			}else {
				jCheckBox1.setSelected(false);
				System.out.println(" print false");
			}
		}

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("员工管理系统");

		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("user.jpg");
		this.setIconImage(image);

		// int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// int height = Toolkit.getDefaultToolkit().getScreenSize().height;

		this.setLocation(500, 400);
		jLabel1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
		jLabel1.setText("用户名");

		jLabel2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
		jLabel2.setText("密码");

		jButton1.setFont(new java.awt.Font("宋体", 0, 14));
		jButton1.setText("登录");

		jButton2.setFont(new java.awt.Font("宋体", 0, 14));
		jButton2.setText("重置");
		jCheckBox1.setText("记住密码");
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (jCheckBox1.isSelected()) {
					RemPwdUtils.writePwd(jTextField1.getText(), JPasswordField.getText(), true);
				} else {
					RemPwdUtils.writePwd("", "", false);
				}

				if (jTextField1.getText().isEmpty() || JPasswordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空", "提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				boolean login = lcd.login(jTextField1.getText(), JPasswordField.getText());
				if (login) {
					new MainView().setVisible(true);
					Login.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码出错", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Login.this.getGraphics().clearRect(500, 400, 500, 400);
					Login.this.getGraphics().dispose();
					
					Login.this.getGraphics().create();
					UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_SMART);
					
					Login.this.update(getGraphics());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				jTextField1.setText("");
//				JPasswordField.setText("");
//				jCheckBox1.setSelected(false);

			}
		});

		jLabel3.setFont(new java.awt.Font("宋体", 1, 22)); 
		jLabel3.setText("欢迎登录员工管理系统");
		jLabel3.setFont(new java.awt.Font("宋体", 1, 22)); 
		jLabel3.setForeground(new java.awt.Color(0, 153, 255));
		jLabel3.setIconTextGap(4);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(81, 81, 81).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout
												.createSequentialGroup()
												.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64,
														Short.MAX_VALUE)
												.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
																57, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jCheckBox1)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(jTextField1).addComponent(JPasswordField,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 153,
																		Short.MAX_VALUE)))))
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(105, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(24, 24, 24)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2).addComponent(JPasswordField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(12, 12, 12).addComponent(jCheckBox1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton1))
						.addContainerGap(63, Short.MAX_VALUE)));

		pack();
	}

	public static void main(String args[]) {

		try {

	//UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_BERNSTEIN);
			//UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_SMART);
			UIManager.setLookAndFeel(MyLookAndFeel.JTATTOO_HIFI);

		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (InstantiationException e1) {

			e1.printStackTrace();
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {

			e1.printStackTrace();
		}

		
		//new Login().setVisible(true);
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

}
