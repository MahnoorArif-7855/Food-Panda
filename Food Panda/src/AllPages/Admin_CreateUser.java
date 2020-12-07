package AllPages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_CreateUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JLabel label;
	private JTextField eMailAdmin;
	private JButton approveButton;
	private JLabel background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_CreateUser frame = new Admin_CreateUser();
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
	public Admin_CreateUser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//back button with image-------------
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
				
				JLabel lblNewLabel = new JLabel("Add Seller");
				lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
				lblNewLabel.setBounds(356, 23, 78, 32);
				contentPane.add(lblNewLabel);
				
				
				btnNewButton = new JButton("Refresh Data");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
					
							try{
							conn c = new conn();
							
							String str = "select * from sellerrequest";
							
							ResultSet rs = c.s.executeQuery(str);  //to get data
							 
							table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
							
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						}

					
				});
				btnNewButton.setBounds(43, 106, 123, 21);
				contentPane.add(btnNewButton);
				
				label = new JLabel("enter e-Mail");
				label.setFont(new Font("Tahoma", Font.PLAIN, 16));
				label.setBounds(10, 160, 96, 25);
				contentPane.add(label);
				
				eMailAdmin = new JTextField();
				eMailAdmin.setColumns(10);
				eMailAdmin.setBounds(111, 165, 133, 19);
				contentPane.add(eMailAdmin);
				
				approveButton = new JButton("Approve");
				approveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						
						if(ae.getSource() == approveButton) {
							try {
								 conn c = new conn();
								 String s0 = eMailAdmin.getText();
								
								 
								 String str = "SELECT * FROM sellerrequest WHERE eMail = '" +s0+ "' "; 
								 
								 ResultSet rs =c.s.executeQuery(str);
								 
								 if(rs.next()) {  //if match found
									 
								
									 //-----------------------------------------------------------
									 String s1 = rs.getString(1);  //getting values from table
									 String s2 = rs.getString(2);  //each number shows column number
									 String s3 = rs.getString(3);
									 String s4 = rs.getString(4);
									 String s5 = rs.getString(5);
									 String s6 = rs.getString(6);
									 
									 
									 String str1 = "insert into seller"            //copying to new table
											 +"(Name, eMail, Password , HotelName , HotelTel, HotelAddress)"
											 +"VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"' , '"+s6+"' ) ";
									 
									
									 c.s.executeUpdate(str1);
									 
									 JOptionPane.showMessageDialog(null, "Selller Successfully added");
									//-----------------------------------------------------------
									 
									                               // to delete data of person who have been approved in previous table
									 
									 String str2 = "DELETE FROM sellerrequest WHERE eMail =  '"+s0+"' ";
									 c.s.execute(str2);
									 
									 JOptionPane.showMessageDialog(null, "Press the Refresh Data Button");
									 
								 }
								 else {
									 JOptionPane.showMessageDialog(null, "Incorrect email entered");


								 }
							}
							catch(Exception e){
								
							}
					}
						
				}
			});
				approveButton.setBounds(159, 194, 85, 21);
				contentPane.add(approveButton);
				
				//setting background image--------
				JLabel background = new JLabel("");
				Image img = new ImageIcon(this.getClass().getResource("/adminAddUser.jpg")).getImage();
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(262, 103, 524, 311);
				contentPane.add(scrollPane);
				
				table = new JTable();
				
				
				
				scrollPane.setViewportView(table);
				background.setIcon(new ImageIcon(img));
			
				background.setBounds(0, 0, 796, 430);
				contentPane.add(background);
		
	}
}
