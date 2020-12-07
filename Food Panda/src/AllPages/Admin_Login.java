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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Admin_Login extends JFrame {

	private JPanel contentPane;
	private JTextField adminName;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
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
	public Admin_Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("LogIn Page");
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		label.setBounds(183, 39, 101, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setForeground(UIManager.getColor("Button.highlight"));
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		label_1.setBounds(53, 85, 72, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setForeground(UIManager.getColor("Button.highlight"));
		label_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		label_2.setBounds(53, 126, 72, 16);
		contentPane.add(label_2);
		
		adminName = new JTextField();
		adminName.setColumns(10);
		adminName.setBounds(135, 84, 138, 19);
		contentPane.add(adminName);
		
		JButton adminLoginButton = new JButton("LogIn");
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str1 = adminName.getText();
				String str2 = password.getText();
				
				if(str1.equals("shiza") && str2.equals("12345")) {
					dispose();
					Admin_Home obj = new Admin_Home();
					obj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect User Name or Password");
				}
				
			}
		});
		adminLoginButton.setBounds(254, 154, 85, 33);
		contentPane.add(adminLoginButton);
		
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
		Image img = new ImageIcon(this.getClass().getResource("/adminLogin.jpg")).getImage();
		//this refers to this class that is admin login
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 252);
		contentPane.add(background);
		
		
	}
}
