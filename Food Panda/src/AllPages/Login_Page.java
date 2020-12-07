package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page frame = new Login_Page();
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
	public Login_Page() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose LogIn");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 16));
		lblNewLabel.setBounds(165, 27, 111, 16);
		contentPane.add(lblNewLabel);
		
		JButton userLoginButton = new JButton("User LogIn");
		userLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				User_Login obj = new User_Login();
				obj.setVisible(true);
				
			}
		});
		userLoginButton.setBounds(165, 83, 102, 38);
		contentPane.add(userLoginButton);
		
		JButton adminLogin = new JButton("Admin LogIn");
		adminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Admin_Login obj = new Admin_Login();
				obj.setVisible(true);
			}
		});
		adminLogin.setFont(new Font("Tahoma", Font.PLAIN, 8));
		adminLogin.setBounds(322, 28, 83, 15);
		contentPane.add(adminLogin);
		
		JButton customerLogin = new JButton("HM LogIn");
		customerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Seller_Login obj = new Seller_Login();
				obj.setVisible(true);
			}
		});
		customerLogin.setFont(new Font("Tahoma", Font.PLAIN, 8));
		customerLogin.setBounds(320, 53, 85, 16);
		contentPane.add(customerLogin);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		closeButton.setBounds(322, 185, 85, 16);
		contentPane.add(closeButton);
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/chooseLogin.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 211);
		contentPane.add(background);
	}
}
