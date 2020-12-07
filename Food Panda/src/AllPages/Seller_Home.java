package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seller_Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller_Home frame = new Seller_Home();
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
	public Seller_Home() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(217, 29, 47, 13);
		contentPane.add(lblNewLabel);
		
		JButton addProductButton = new JButton("Add Dish");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Add_Product obj = new Add_Product();
				obj.setVisible(true);
			}
		});
		addProductButton.setBounds(31, 94, 111, 49);
		contentPane.add(addProductButton);
		
		JButton removeProductButton = new JButton("Remove Dish");
		removeProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Remove_Product obj = new Remove_Product();
				obj.setVisible(true);
			}
		});
		removeProductButton.setBounds(177, 94, 111, 49);
		contentPane.add(removeProductButton);
		
		JButton logOutButton = new JButton("LogOut");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logout_Page obj = new Logout_Page();
				obj.setVisible(true);
			}
		});
		
		JButton btnViewDishes = new JButton("View Dishes");
		btnViewDishes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seller_View_Products obj = new Seller_View_Products();
				dispose();
				obj.setVisible(true);
				
			}
		});
		btnViewDishes.setBounds(319, 94, 111, 49);
		contentPane.add(btnViewDishes);
		logOutButton.setBounds(31, 153, 111, 49);
		contentPane.add(logOutButton);
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/sellerHome.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 482, 272);
		contentPane.add(background);
	}

}
