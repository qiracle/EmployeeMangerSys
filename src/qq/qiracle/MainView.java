//======================================================================
 //
 //        Copyright (C) 2016   
 //        All rights reserved
 //
 //        filename :MainView
 //        
 //
 //        created by Qiangqiang Jinag in  2016.08.23
 //        https://github.com/qiracle
 //		   qiracle@foxmail.com
 //
//======================================================================
package qq.qiracle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import qq.qiracle.db.EmployeeContectDb;
import qq.qiracle.db.UserContectDb;
import qq.qiracle.pojo.Employee;

public class MainView extends javax.swing.JFrame {

	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem11;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;

	private JLabel l1, l2, l3, l4, l5, l6, l7;
	private JTextField t1;
	private JTextField tdate, tsalary;
	private JTextField tname, tage;
	private JRadioButton male;
	private JRadioButton female;

	private JRadioButton emp;
	private JRadioButton mana;
	private JRadioButton boss;
	private JPasswordField t2;
	private JPasswordField t3;
	private JButton b1 = new JButton("添加用户");
	private JButton save = new JButton("保存");
	private JButton update = new JButton("修改");
	private JButton delete = new JButton("删除");
	private JButton quer = new JButton("查找");
	private JTextField tdele = new JTextField(12);
	private JTextField tupdate = new JTextField(12);
	private JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8;
	private ButtonGroup groupsex;
	private ButtonGroup grouppos;
	private JButton qb1 = new JButton("查询所有");
	private JButton qb2 = new JButton("按编号查询");
	private JButton qb3 = new JButton("按性别查询");
	private JTextField qt1, qt2;
	JTable jtable;
	UserContectDb udb = new UserContectDb();
	EmployeeContectDb edb = new EmployeeContectDb();
	String oldid = "";

	public MainView() {
		initComponents();
	}

	private void initComponents() {

		jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jLabel1 = new javax.swing.JLabel();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem11 = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu6 = new javax.swing.JMenu();

		jCheckBoxMenuItem1.setSelected(true);
		jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

		jMenu3.setText("jMenu3");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("员工管理系统");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("user.jpg");
		this.setIconImage(image);
		// this.setSize(500, 400);
		// setLocation(500, 400);
		this.setBounds(500, 400, 500, 400);
		jLabel1.setFont(new java.awt.Font("宋体", 0, 32));
		jLabel1.setForeground(new java.awt.Color(51, 204, 255));
		jLabel1.setText("欢迎使用员工管理系统");

		jMenu4.setText("系统管理");
		jMenu4.setToolTipText("");
		jMenu4.setFont(new java.awt.Font("新宋体", 1, 14));

		jMenuItem11.setText("增加用户");
		jMenu4.add(jMenuItem11);

		jMenuBar2.add(jMenu4);

		jMenu5.setText("员工管理");
		jMenu5.setToolTipText("");
		jMenu5.setFont(new java.awt.Font("新宋体", 1, 14));

		jMenuItem1.setText("增加员工");
		jMenu5.add(jMenuItem1);

		jMenuItem2.setText("删除员工");
		jMenu5.add(jMenuItem2);

		jMenuItem3.setText("修改员工");
		jMenu5.add(jMenuItem3);

		jMenuBar2.add(jMenu5);

		jMenu1.setText("员工查询");
		jMenu1.setFont(new java.awt.Font("新宋体", 1, 14));
		jMenuBar2.add(jMenu1);

		jMenu2.setText("关于");
		jMenu2.setFont(new java.awt.Font("新宋体", 1, 14));
		jMenuBar2.add(jMenu2);

		jMenu6.setText("退出");
		jMenu6.setFont(new java.awt.Font("新宋体", 1, 14));
		jMenuBar2.add(jMenu6);

		jMenuItem11.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();
				System.out.println("abcdef");
				adduser();

				getContentPane().validate();

			}
		});

		jMenu6.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				MainView.this.dispose();

			}
		});

		jMenuItem1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();

				addemp();

				getContentPane().validate();
			}

		});
		
		
		jMenu2.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "All rights reserved\n created by Qiracle in  2016.08.23\n email:qiracle520@gmail.com\n github:https://github.com/qiracle", "提示", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sex = "";
				String postion = "";
				if (male.isSelected()) {
					sex = male.getText();
				} else if (female.isSelected()) {
					sex = female.getText();
				}
				if (emp.isSelected()) {
					postion = emp.getText();
				} else if (mana.isSelected()) {
					postion = mana.getText();
				} else if (boss.isSelected()) {
					postion = boss.getText();
				}

				System.out.println(sex + "--" + postion);
				int insert = edb.insert(t1.getText(), tname.getText(), tage.getText(), sex, postion, tdate.getText(),
						tsalary.getText());
				if (insert > 0) {
					System.out.println("添加成功");

					JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);

				} else {
					System.out.println("添加失败");

					JOptionPane.showMessageDialog(null, "已存在该员工", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Employee em = edb.beforeDelete(tdele.getText());
				if (em == null) {
					JOptionPane.showMessageDialog(null, "不存在该员工", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				String id = em.getId();
				String name2 = em.getName();
				String age = em.getAge();
				String sex = em.getSex();
				String position = em.getPosition();
				String jobdate = em.getJobdate();
				String salary = em.getSalary();
				String info = "编号：" + id +"\n"+ " 姓名：" + name2 +"\n"+ " 年龄：" + age+"\n" + " 性别:" + sex +"\n"+ " 职位：" + position+"\n" + " 入职日期："
						+ jobdate +"\n"+ " 薪水：" + salary;
				int n = JOptionPane.showConfirmDialog(null, info, "要删除员工信息如下", JOptionPane.YES_NO_OPTION);// 返回的是按钮的index
				if (n == 0) {

					System.out.println("111111");
					int delete = edb.delete(tdele.getText());
					if (delete > 0) {
						System.out.println("删除成功");

						JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("删除失败");

						JOptionPane.showMessageDialog(null, "删除失败,不存在该员工", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					System.out.println("222222");
				}

			}
		});

		quer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Employee em = edb.setUpdate(tupdate.getText());
				if (em == null) {
					JOptionPane.showMessageDialog(null, "不存在该员工", "提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				oldid = em.getId();
				String name2 = em.getName();
				String age = em.getAge();
				String sex = em.getSex();
				String position = em.getPosition();
				String jobdate = em.getJobdate();
				String salary = em.getSalary();

				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();

				setemp();
				t1.setText(oldid);

				tname.setText(name2);

				tage.setText(age);
				if (sex.equals("0")) {
					female.setSelected(true);
				} else if (sex.equals("1")) {
					male.setSelected(true);
				}

				if (position.equals("employee")) {
					emp.setSelected(true);
				} else if (position.equals("manager")) {
					mana.setSelected(true);
				} else if (position.equals("boss")) {
					boss.setSelected(true);
					;
				}

				tdate.setText(jobdate);
				tsalary.setText(salary);
				getContentPane().validate();

			}
		});
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sex = "";
				String postion = "";
				if (male.isSelected()) {
					sex = "1";
				} else if (female.isSelected()) {
					sex = "0";
				}
				if (emp.isSelected()) {
					postion = "employee";
				} else if (mana.isSelected()) {
					postion = "manager";
				} else if (boss.isSelected()) {
					postion = "boss";
				}
				int update2 = edb.update(oldid, t1.getText(), tname.getText(), tage.getText(), sex, postion,
						tdate.getText(), tsalary.getText());
				if (update2 > 0) {
					JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "更新失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		// tdele.addFocusListener(new FocusAdapter() {
		// @Override
		// public void focusGained(FocusEvent e) {
		// tdele.setText("");
		// }
		//
		// @Override
		// public void focusLost(FocusEvent e) {
		// tdele.setText("请输入要删除的员工编号");
		// }
		// });

		jMenuItem2.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();

				deleteemp();

				getContentPane().validate();
			}

		});

		jMenuItem3.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();

				updateemp();

				getContentPane().validate();
			}

		});
		b1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空", "提示", JOptionPane.INFORMATION_MESSAGE);
					return;

				}

				if (t2.getText().equals(t3.getText())) {
					if (udb.addUser(t1.getText(), t3.getText()) > 0) {
						JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("添加成功");
					}
				} else {
					JOptionPane.showMessageDialog(null, "密码和确认密码不一致", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		jMenu1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MainView.this.getContentPane().removeAll();
				getContentPane().repaint();

				query();

				getContentPane().validate();
			}

		});

		qb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainView.this.getContentPane().remove(jtable);
				getContentPane().repaint();
				int count = 0;
				List<Employee> list = edb.queryAll();
				String[][] rowData = new String[list.size()][7];

				String[] columnNames = { "编号", "姓名", "年龄", "性别", "职位", "入职日期", "薪水" };

				
				for (Employee emp : list) {
					String id = emp.getId();
					String name2 = emp.getName();
					String age = emp.getAge();
					String sex = emp.getSex();
					String position = emp.getPosition();
					String jobdate = emp.getJobdate();
					String salary = emp.getSalary();
					rowData[count][0] = id;
					rowData[count][1] = name2;
					rowData[count][2] = age;
					rowData[count][3] = sex;
					rowData[count][4] = position;
					rowData[count][5] = jobdate;
					rowData[count][6] = salary;
					count++;

				}

				DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
				 
				 jtable.setModel(dm);
				

				jp2.updateUI();

				//getContentPane().validate();;

			}
		});
		
		
		qb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainView.this.getContentPane().remove(jtable);
				getContentPane().repaint();
				int count = 0;
				List<Employee> list = edb.querybyId(qt1.getText());
				String[][] rowData = new String[list.size()][7];

				String[] columnNames = { "编号", "姓名", "年龄", "性别", "职位", "入职日期", "薪水" };

				
				for (Employee emp : list) {
					String id = emp.getId();
					String name2 = emp.getName();
					String age = emp.getAge();
					String sex = emp.getSex();
					String position = emp.getPosition();
					String jobdate = emp.getJobdate();
					String salary = emp.getSalary();
					rowData[count][0] = id;
					rowData[count][1] = name2;
					rowData[count][2] = age;
					rowData[count][3] = sex;
					rowData[count][4] = position;
					rowData[count][5] = jobdate;
					rowData[count][6] = salary;
					count++;

				}

				DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
				 
				 jtable.setModel(dm);
				

				jp2.updateUI();
				
			}
		});
		
		qb3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				MainView.this.getContentPane().remove(jtable);
				getContentPane().repaint();
				int count = 0;
				List<Employee> list = edb.querybysex(qt2.getText());
				String[][] rowData = new String[list.size()][7];

				String[] columnNames = { "编号", "姓名", "年龄", "性别", "职位", "入职日期", "薪水" };

				
				for (Employee emp : list) {
					String id = emp.getId();
					String name2 = emp.getName();
					String age = emp.getAge();
					String sex = emp.getSex();
					String position = emp.getPosition();
					String jobdate = emp.getJobdate();
					String salary = emp.getSalary();
					rowData[count][0] = id;
					rowData[count][1] = name2;
					rowData[count][2] = age;
					rowData[count][3] = sex;
					rowData[count][4] = position;
					rowData[count][5] = jobdate;
					rowData[count][6] = salary;
					count++;

				}

				DefaultTableModel dm = new DefaultTableModel(rowData, columnNames);
				 
				 jtable.setModel(dm);
				

				jp2.updateUI();	
				
				
			}
		});
		setJMenuBar(jMenuBar2);

		
	}

	private void addemp() {
		l1 = new JLabel("员工编号");
		l2 = new JLabel("员工姓名");
		l3 = new JLabel("员工年龄");
		l4 = new JLabel("员工性别         ");
		l5 = new JLabel("员工职位");
		l6 = new JLabel("入职日期");
		l7 = new JLabel("员工薪水");

		t1 = new JTextField(12);
		tname = new JTextField(12);
		tage = new JTextField(12);

		male = new JRadioButton("男");
		female = new JRadioButton("女");
		groupsex = new ButtonGroup();
		groupsex.add(male);
		groupsex.add(female);

		emp = new JRadioButton("员工");
		mana = new JRadioButton("经理");
		boss = new JRadioButton("老板");
		grouppos = new ButtonGroup();
		grouppos.add(emp);
		grouppos.add(mana);
		grouppos.add(boss);

		tdate = new JTextField(12);
		tsalary = new JTextField(12);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();

		jp1.add(l1);
		jp1.add(t1);
		jp2.add(l2);
		jp2.add(tname);
		jp3.add(l3);
		jp3.add(tage);
		jp4.add(l4);
		jp4.add(male);
		jp4.add(female);
		jp5.add(l5);
		jp5.add(emp);
		jp5.add(mana);
		jp5.add(boss);
		jp6.add(l6);
		jp6.add(tdate);
		jp7.add(l7);
		jp7.add(tsalary);
		jp8.add(save);

		MainView.this.add(jp1);
		MainView.this.add(jp2);
		MainView.this.add(jp3);
		MainView.this.add(jp4);
		MainView.this.add(jp5);
		MainView.this.add(jp6);
		MainView.this.add(jp7);
		MainView.this.add(jp8);
		MainView.this.setLayout(new GridLayout(8, 1));

	}

	private void setemp() {
		l1 = new JLabel("员工编号");
		l2 = new JLabel("员工姓名");
		l3 = new JLabel("员工年龄");
		l4 = new JLabel("员工性别         ");
		l5 = new JLabel("员工职位");
		l6 = new JLabel("入职日期");
		l7 = new JLabel("员工薪水");

		t1 = new JTextField(12);
		tname = new JTextField(12);
		tage = new JTextField(12);

		male = new JRadioButton("男");
		female = new JRadioButton("女");
		groupsex = new ButtonGroup();
		groupsex.add(male);
		groupsex.add(female);

		emp = new JRadioButton("员工");
		mana = new JRadioButton("经理");
		boss = new JRadioButton("老板");
		grouppos = new ButtonGroup();
		grouppos.add(emp);
		grouppos.add(mana);
		grouppos.add(boss);

		tdate = new JTextField(12);
		tsalary = new JTextField(12);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();

		jp1.add(l1);
		jp1.add(t1);
		jp2.add(l2);
		jp2.add(tname);
		jp3.add(l3);
		jp3.add(tage);
		jp4.add(l4);
		jp4.add(male);
		jp4.add(female);
		jp5.add(l5);
		jp5.add(emp);
		jp5.add(mana);
		jp5.add(boss);
		jp6.add(l6);
		jp6.add(tdate);
		jp7.add(l7);
		jp7.add(tsalary);
		jp8.add(update);

		MainView.this.add(jp1);
		MainView.this.add(jp2);
		MainView.this.add(jp3);
		MainView.this.add(jp4);
		MainView.this.add(jp5);
		MainView.this.add(jp6);
		MainView.this.add(jp7);
		MainView.this.add(jp8);
		MainView.this.setLayout(new GridLayout(8, 1));

	}

	private void adduser() {

		l1 = new JLabel("新用户名");
		l2 = new JLabel("密       码");
		l3 = new JLabel("确认密码");

		t1 = new JTextField(12);
		t2 = new JPasswordField(12);
		t3 = new JPasswordField(12);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		

		jp1.add(l1);
		jp1.add(t1);

		jp2.add(l2);
		jp2.add(t2);

		jp3.add(l3);
		jp3.add(t3);

		jp4.add(b1);

		MainView.this.add(jp1);
		MainView.this.add(jp2);
		MainView.this.add(jp3);
		MainView.this.add(jp4);

		MainView.this.setLayout(new GridLayout(4, 1));

	}

	private void deleteemp() {

		l1 = new JLabel("请输入要删除的编号");

		jp1 = new JPanel();
		jp2 = new JPanel();

		jp1.add(l1);
		jp1.add(tdele);

		jp1.add(delete);

//		MainView.this.add(jp1);
//		MainView.this.add(jp2);
//
//		MainView.this.setLayout(new GridLayout(2, 1));
		
		MainView.this.setLayout(new BorderLayout());
		MainView.this.add(jp1,BorderLayout.CENTER);
	//	MainView.this.add(jp2,BorderLayout.CENTER);
	}

	private void updateemp() {

		l1 = new JLabel("请输入要修改的编号");
		 
		jp1 = new JPanel();
		jp2 = new JPanel();

		jp1.add(l1);
		jp1.add(tupdate);

		jp1.add(quer);

		MainView.this.setLayout(new BorderLayout());
		MainView.this.add(jp1,BorderLayout.CENTER);

	}

	private void query() {
		this.setBounds(500, 400, 700, 400);

		qt1 = new JTextField(12);

		qt2 = new JTextField(12);

		jp1 = new JPanel();
		jp2 = new JPanel();
		
		//new code
		jp2.setPreferredSize(new Dimension(450, 200));

		jp1.add(qb1);
		jp1.add(qt1);
		jp1.add(qb2);
		jp1.add(qt2);
		jp1.add(qb3);
		jtable = new JTable();
		jp2.add(jtable);
		
		
		
		JScrollPane scroll = new JScrollPane(jtable);
		
		//new code
		scroll.setPreferredSize(new Dimension(400, 200));
		getContentPane().add(scroll);
		
		jp2.add(scroll);
		
		
		MainView.this.setLayout(new BorderLayout());
		MainView.this.add(jp1,BorderLayout.NORTH);
		MainView.this.add(jp2,BorderLayout.CENTER);

	}
	
	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainView().setVisible(true);
			}
		});
	}

}
