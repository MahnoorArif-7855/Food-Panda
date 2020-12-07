package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Admin_View_Users extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_View_Users frame = new Admin_View_Users();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_View_Users() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Users");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(307, 23, 97, 31);
		contentPane.add(lblNewLabel);
		
		JButton customers = new JButton("Show Customers");
		customers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				
				try{
					conn c = new conn();
					
					String str = "select * from customers";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
					
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			
		});
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Admin_Home obj = new Admin_Home();
				obj.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		back.setIcon(new ImageIcon(img1));
		back.setBounds(10, 10, 32, 32);
		contentPane.add(back);
		
		customers.setBounds(139, 366, 131, 31);
		contentPane.add(customers);
		
		JButton sellers = new JButton("Show Sellers");
		sellers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try{
					conn c = new conn();
					
					String str = "select * from seller";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
					
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			
		});
		sellers.setBounds(433, 366, 115, 31);
		contentPane.add(sellers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 81, 649, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
