package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Admin_Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Home frame = new Admin_Home();
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
	public Admin_Home() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_CreateUser obj = new Admin_CreateUser();
				obj.setVisible(true);
			}
		});
		addUserButton.setBounds(30, 73, 111, 49);
		contentPane.add(addUserButton);
		
		JButton removeUserButton = new JButton("Remove User");
		removeUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_RemoveUser obj = new Admin_RemoveUser();
				obj.setVisible(true);
			}
		});
		removeUserButton.setBounds(170, 73, 111, 49);
		contentPane.add(removeUserButton);
		
		JButton button_2 = new JButton("LogOut");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logout_Page obj = new Logout_Page();
				obj.setVisible(true);
			}
		});
		button_2.setBounds(311, 153, 111, 49);
		contentPane.add(button_2);
		
		JButton btnViewUser = new JButton("View User");
		btnViewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_View_Users obj = new Admin_View_Users();
				obj.setVisible(true);
			}
		});
		btnViewUser.setBounds(311, 73, 111, 49);
		contentPane.add(btnViewUser);
		
		JButton btnAddPromos = new JButton("Add Promos");
		btnAddPromos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_Add_Promotions obj = new Admin_Add_Promotions();
			    obj.setVisible(true);
				
			}
		});
		btnAddPromos.setBounds(30, 153, 111, 49);
		contentPane.add(btnAddPromos);
		
		JButton buttonAddFigtCards = new JButton("Add Gift Cards");
		buttonAddFigtCards.setFont(new Font("Tahoma", Font.BOLD, 9));
		buttonAddFigtCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin_Add_GiftCards obj =  new Admin_Add_GiftCards();
				obj.setVisible(true);
			}
		});
		buttonAddFigtCards.setBounds(170, 153, 111, 49);
		contentPane.add(buttonAddFigtCards);
		
		JLabel label = new JLabel("Home");
		label.setForeground(UIManager.getColor("Button.highlight"));
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		label.setBounds(196, 29, 47, 13);
		contentPane.add(label);
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/adminHome.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 456, 243);
		contentPane.add(background);
	}
}
