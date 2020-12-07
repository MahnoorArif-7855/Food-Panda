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

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JTextField phone;
	private JTextField email;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_SignUp frame = new User_SignUp();
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
	public User_SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SignUp Page");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(156, 10, 106, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblN = new JLabel("Name");
		lblN.setForeground(UIManager.getColor("Button.highlight"));
		lblN.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblN.setBounds(31, 54, 87, 23);
		contentPane.add(lblN);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(UIManager.getColor("Button.highlight"));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPassword.setBounds(31, 87, 87, 23);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone No.");
		lblPhone.setForeground(UIManager.getColor("Button.highlight"));
		lblPhone.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPhone.setBounds(31, 119, 87, 23);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(UIManager.getColor("Button.highlight"));
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEmail.setBounds(31, 152, 87, 23);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(UIManager.getColor("Button.highlight"));
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblAddress.setBounds(31, 185, 87, 23);
		contentPane.add(lblAddress);
		
		name = new JTextField();
		name.setBounds(109, 56, 174, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(109, 87, 174, 19);
		contentPane.add(password);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(109, 121, 174, 19);
		contentPane.add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(109, 152, 174, 19);
		contentPane.add(email);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(109, 187, 174, 19);
		contentPane.add(address);
		final JRadioButton terms = new JRadioButton("I accept the terms and Conditions.");
		terms.setBounds(31, 230, 252, 21);
		contentPane.add(terms);

		
		final JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
				if(ae.getSource() == signup) {
					try {
						
						 conn c = new conn();
						 String s1 = name.getText();
						 String s2 = password.getText();
						 String s3 = phone.getText();
						 String s4 = email.getText();
						 String s5 = address.getText();
						 String s6 = "0";    //because intitally customer balance is zero
						 
						 String str = "insert into customers" 
								 +"(Name, Password, Phone, eMail, Address, Balance)"
								 +"VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"', '"+s6+"') "; 
						 
						 if(terms.isSelected()) {
							 
							 c.s.executeUpdate(str);
							 
							 JOptionPane.showMessageDialog(null, "You have Successfully Signed Up");
						
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Please accept terms and conditions to Sign Up");
						 }
					}
					catch(Exception e){
						
					}
				
			}
				
			}
		});
		signup.setBounds(198, 262, 85, 21);
		contentPane.add(signup);
		
				
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						User_Login obj = new User_Login();
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
		Image img = new ImageIcon(this.getClass().getResource("/userLogin.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 411, 345);
		contentPane.add(background);
	}
}
