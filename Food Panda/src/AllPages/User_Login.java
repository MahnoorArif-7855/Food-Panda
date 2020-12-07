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
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class User_Login extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public String abc;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
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
	
	public User_Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LogIn Page");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(174, 32, 93, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("e-Mail");
		lblName.setForeground(UIManager.getColor("Button.highlight"));
		lblName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblName.setBounds(53, 85, 72, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(UIManager.getColor("Button.highlight"));
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPassword.setBounds(53, 126, 72, 16);
		contentPane.add(lblPassword);
		
		email = new JTextField();
		email.setBounds(135, 84, 138, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		final JButton login = new JButton("LogIn");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource() == login) {
					try {
						 conn c = new conn();
						 String s1 = email.getText();
						 String s2 = password.getText();
						 
						 String str = "SELECT * FROM customers WHERE eMail = '" +s1+ "' and Password = '" +s2+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str);
						 
						 if(rs.next()) {
							 dispose();
							 User_Home obj = new User_Home();
							 idIdentifierCustomer obj1 = new idIdentifierCustomer();
							 obj1.getName(str);
							 System.out.println(obj1.ID);
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
		
		JLabel lblDontHaveAn = new JLabel("Don't have an accout ?.");
		lblDontHaveAn.setForeground(UIManager.getColor("Button.highlight"));
		lblDontHaveAn.setFont(new Font("SimSun", Font.BOLD, 12));
		lblDontHaveAn.setBounds(119, 216, 154, 16);
		contentPane.add(lblDontHaveAn);
		
		JButton signUpButton = new JButton("SignUp");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				User_SignUp obj = new User_SignUp();
				obj.setVisible(true);
				
			}
		});
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		signUpButton.setBounds(274, 215, 65, 18);
		contentPane.add(signUpButton);
		
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
		Image img = new ImageIcon(this.getClass().getResource("/userLogin.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 272);
		contentPane.add(background);
	}
}
