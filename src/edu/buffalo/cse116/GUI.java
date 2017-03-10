package edu.buffalo.cse116;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Yang Cai
 */
public class GUI extends JFrame {

	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem8;
	private JPanel jPanel1;

	public GUI() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel1 = new JPanel();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem1 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem4 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		jMenu3 = new JMenu();
		jMenuItem6 = new JMenuItem();
		jMenuItem7 = new JMenuItem();
		jMenuItem8 = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 479, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 309, Short.MAX_VALUE));

		jMenu1.setText("File");

		jMenuItem1.setText("Exit");
		jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Fractal");

		jMenuItem2.setText("Mandelbrot Set");
		jMenu2.add(jMenuItem2);

		jMenuItem3.setText("Julia Set");
		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("Burning Ship Set");
		jMenu2.add(jMenuItem4);

		jMenuItem5.setText("Multibrot Set");
		jMenu2.add(jMenuItem5);

		jMenuBar1.add(jMenu2);

		jMenu3.setText("Color");

		jMenuItem6.setText("Red");
		jMenu3.add(jMenuItem6);

		jMenuItem7.setText("Green");
		jMenuItem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem7);

		jMenuItem8.setText("Blue");
		jMenu3.add(jMenuItem8);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *
	 */
	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

}
