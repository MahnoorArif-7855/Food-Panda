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

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class User_Promotion extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Promotion frame = new User_Promotion();
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
	public User_Promotion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPromotions = new JLabel("Promotions");
		lblPromotions.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblPromotions.setBounds(151, 23, 95, 17);
		contentPane.add(lblPromotions);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						User_Home obj = new User_Home();
						obj.setVisible(true);
					}
				});
				Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				//----------------------
				
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/promotions.png")).getImage();
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"View Promo codes available for a certain amount of time"}));
		
		//------------------------------database code----------------------
		
		try {
			 conn c = new conn();
			 
			 String str = "SELECT * FROM promotion"; 
			 ResultSet rs =c.s.executeQuery(str);
			 while(rs.next()) {
				 
				String name = rs.getString("Value");
				
				comboBox.addItem(name);
				
			 }
			 
		}
		catch(Exception e){
			
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String selectedValue = comboBox.getSelectedItem().toString();
				
				
			try{
					conn c = new conn();
					
					String str = "select Code, Description, Value, ValidTill from promotion where Value = '"+selectedValue+"' ";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					 
					
					table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
					
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				
			}
				
				
			
		});
		
		
		comboBox.setBounds(10, 72, 372, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 122, 372, 74);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 402, 221);
		contentPane.add(background);
	}
}
