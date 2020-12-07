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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Seller_Login extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller_Login frame = new Seller_Login();
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
	public Seller_Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("LogIn Page");
		label.setForeground(UIManager.getColor("Button.highlight"));
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		label.setBounds(172, 33, 89, 22);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("e-Mail");
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblEmail.setBounds(53, 85, 72, 16);
		contentPane.add(lblEmail);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		label_2.setBounds(53, 126, 72, 16);
		contentPane.add(label_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(135, 84, 138, 19);
		contentPane.add(email);
		
		final JButton login = new JButton("LogIn");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == login) {
					try {
						 conn c = new conn();
						 String s1 = email.getText();
						 String s2 = password.getText();
						 
						 String str = "SELECT * FROM seller WHERE eMail = '" +s1+ "' and Password = '" +s2+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str);
						 if(rs.next()) {
							 
							 idIdentifierSeller obj1 = new idIdentifierSeller();
							 obj1.getName(str);
							 
							 hotelNameIdentifier obj2 = new hotelNameIdentifier();
							 obj2.setName(str);
							 
							 
							 dispose();
							 Seller_Home obj = new Seller_Home();
							 obj.setVisible(true);
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Incorrect User Name or Password");
							 setVisible(false);

						 }
					}
					catch(Exception e){
						
					}
			}
			}
		});
		login.setBounds(254, 154, 85, 33);
		contentPane.add(login);
		
		JLabel lblWantToRegister = new JLabel("Want to register your Hotel");
		lblWantToRegister.setForeground(UIManager.getColor("Button.highlight"));
		lblWantToRegister.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblWantToRegister.setBounds(53, 216, 182, 16);
		contentPane.add(lblWantToRegister);
		
		JButton sellerRegisterButton = new JButton("Register Now");
		sellerRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Seller_Signup obj = new Seller_Signup();
				obj.setVisible(true);
			}
		});
		sellerRegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		sellerRegisterButton.setBounds(241, 215, 98, 18);
		contentPane.add(sellerRegisterButton);
		
		password = new JPasswordField();
		password.setBounds(135, 125, 138, 19);
		contentPane.add(password);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						Login_Page obj = new Login_Page();
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
		Image img = new ImageIcon(this.getClass().getResource("/sellerLogin.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 272);
		contentPane.add(background);
	}

}
