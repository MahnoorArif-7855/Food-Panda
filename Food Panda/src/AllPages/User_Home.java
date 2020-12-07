package AllPages;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class User_Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Home frame = new User_Home();
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
	public User_Home() {
		
		//setUndecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 329);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(238, 25, 63, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Order Food");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Choose_Resturant obj = new Choose_Resturant();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(37, 77, 103, 45);
		contentPane.add(btnNewButton);
		
		JButton btnPromotion = new JButton("Promotion");
		btnPromotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				User_Promotion obj = new User_Promotion();
				obj.setVisible(true);
			}
		});
		btnPromotion.setBounds(215, 77, 103, 45);
		contentPane.add(btnPromotion);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				User_Balance obj = new User_Balance();
				obj.setVisible(true);
			}
		});
		btnBalance.setBounds(400, 77, 103, 45);
		contentPane.add(btnBalance);
		
		JButton btnOrderHistory = new JButton("Order History");
		btnOrderHistory.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnOrderHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Order_History obj = new Order_History();
				obj.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				My_Cart obj = new My_Cart();
				dispose();
				obj.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(414, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		btnOrderHistory.setBounds(37, 167, 103, 45);
		contentPane.add(btnOrderHistory);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Edit_Profile_User obj = new Edit_Profile_User();
				obj.setVisible(true);
			}
		});
		btnEditProfile.setBounds(215, 167, 103, 45);
		contentPane.add(btnEditProfile);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logout_Page obj = new Logout_Page();
				obj.setVisible(true);
			}
		});
		btnLogOut.setBounds(400, 167, 103, 45);
		contentPane.add(btnLogOut);

		// for background images ---------------------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/foodbowl.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		
		background.setBounds(0, 0, 603, 303);
		
		contentPane.add(background);
		
	    //------------------------------------
		
		
		
	}
}
