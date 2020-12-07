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

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Seller_Signup extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField hotelName;
	private JTextField phone;
	private JTextField address;
	private JTextField email;
	private JPasswordField password;
	private JRadioButton terms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller_Signup frame = new Seller_Signup();
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
	public Seller_Signup() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(163, 25, 131, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(UIManager.getColor("Button.highlight"));
		lblName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblName.setBounds(44, 58, 65, 23);
		contentPane.add(lblName);
		
		JLabel lblHotelName = new JLabel("Hotel Name");
		lblHotelName.setForeground(UIManager.getColor("Button.highlight"));
		lblHotelName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblHotelName.setBounds(44, 149, 76, 23);
		contentPane.add(lblHotelName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(UIManager.getColor("Button.highlight"));
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblAddress.setBounds(44, 215, 65, 23);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("Hotel Tel.");
		lblPhoneNo.setForeground(UIManager.getColor("Button.highlight"));
		lblPhoneNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPhoneNo.setBounds(44, 182, 65, 23);
		contentPane.add(lblPhoneNo);
		
		name = new JTextField();
		name.setBounds(128, 60, 166, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		hotelName = new JTextField();
		hotelName.setColumns(10);
		hotelName.setBounds(128, 151, 166, 19);
		contentPane.add(hotelName);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(128, 184, 166, 19);
		contentPane.add(phone);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(128, 217, 166, 19);
		contentPane.add(address);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEmail.setBounds(44, 85, 65, 23);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(128, 87, 166, 19);
		contentPane.add(email);
		
		terms = new JRadioButton("I accept terms & conditions.");
		terms.setForeground(Color.WHITE);
		terms.setOpaque(false);
		terms.setBounds(44, 244, 227, 21);
		contentPane.add(terms);
		
		final JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource() == submit) {
					try {
						 conn c = new conn();
						 String s1 = name.getText();
						 String s2 = email.getText();
						 String s3 = password.getText();
						 String s4 = hotelName.getText();
						 String s5 = phone.getText();
						 String s6 = address.getText();
						 
						
						 
						 String str = "insert into sellerrequest" 
								 +"(Name, eMail, Password , HotelName , HotelTel, HotelAddress)"
								 +"VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"' , '"+s6+"' ) "; 
						 
						 
						 if(terms.isSelected()) {
							 
						 c.s.executeUpdate(str);
						 JOptionPane.showMessageDialog(null, "Your request has been sent and will be approved by admin in 1-2 day(s)");
						 
						 Seller_Login obj = new Seller_Login();
						 dispose();
						 obj.setVisible(true);
						 
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
		
		password = new JPasswordField();
		password.setBounds(128, 116, 166, 19);
		contentPane.add(password);
		submit.setBounds(317, 232, 85, 21);
		contentPane.add(submit);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						Seller_Login obj = new Seller_Login();
						obj.setVisible(true);
						
					}
				});
				Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setForeground(Color.WHITE);
				lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
				lblPassword.setBounds(44, 116, 65, 23);
				contentPane.add(lblPassword);
				
				
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				//----------------------
				
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/sellerSignup.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 274);
		contentPane.add(background);
	}
}
