package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class IDtoEdit extends idIdentifierCustomer{
	String a = ID;
}
public class Edit_Profile_User extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField phoneNoField;
	private JTextField addressField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_Profile_User frame = new Edit_Profile_User();
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
	public Edit_Profile_User() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditProfile = new JLabel("Edit Profile");
		lblEditProfile.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblEditProfile.setBounds(167, 30, 95, 17);
		contentPane.add(lblEditProfile);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPhoneNo.setBounds(50, 145, 95, 17);
		contentPane.add(lblPhoneNo);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblAddress.setBounds(50, 179, 95, 17);
		contentPane.add(lblAddress);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(157, 80, 173, 19);
		contentPane.add(nameField);
		
		final JButton saveChanges = new JButton("Save Changes");
		saveChanges.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource() == saveChanges) {
					try {
						
						 conn c = new conn();
						 
						 //getting values from user textfileds
						 String name = nameField.getText();
						 String password = passwordField.getText();
						 String phone = phoneNoField.getText();
						 String address = addressField.getText();
						 
						 
						 
						 //----------to get user email who logged in--------------
						 idIdentifierCustomer obj = new idIdentifierCustomer();
						 String s0 = obj.ID;
						 System.out.println(s0);
						 
						 //----------------------------
						 
						 String str = "SELECT * FROM customers WHERE eMail = '" +s0+ "'"; 
						 
						 ResultSet rs =c.s.executeQuery(str);
						 
						if(rs.next()) {
							 
							//if users leave blank fields then fetch data from database table and dont change them
							
							if(name.equals("")) {
								name = rs.getString(1);         //number shows column number in db table
							}
							
							if(password.equals("")) {
								password = rs.getString(2);
							}
							
							if(phone.equals("")) {
								phone = rs.getString(3);
							}
							if(address.equals("")) {
								address = rs.getString(5);
							}
							
 	
								 
								 String que = "Update customers set Name = '"+name+"', Password = '"+password+"', Phone = '"+phone+"',Address = '"+address+"' WHERE eMail = '"+s0+"' ";								 
								 c.s.execute(que);
								 
							 JOptionPane.showMessageDialog(null, "Wohoo! Changes Saved");
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Incorrect Details");
							 setVisible(false);

						 }
					}
					catch(Exception e){
						
					}
			}
				
			}
		});
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(157, 109, 173, 19);
		contentPane.add(passwordField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblName.setBounds(50, 80, 95, 17);
		contentPane.add(lblName);
		saveChanges.setFont(new Font("Tahoma", Font.PLAIN, 9));
		saveChanges.setBounds(235, 215, 95, 21);
		contentPane.add(saveChanges);
		
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
				
				phoneNoField = new JTextField();
				phoneNoField.setColumns(10);
				phoneNoField.setBounds(157, 145, 173, 19);
				contentPane.add(phoneNoField);
				
				addressField = new JTextField();
				addressField.setColumns(10);
				addressField.setBounds(157, 179, 173, 19);
				contentPane.add(addressField);
				
				JLabel lblPassword = new JLabel("New Password");
				lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
				lblPassword.setBounds(50, 109, 95, 17);
				contentPane.add(lblPassword);
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				//----------------------
				
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/editProfile.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 272);
		contentPane.add(background);
	}
}
