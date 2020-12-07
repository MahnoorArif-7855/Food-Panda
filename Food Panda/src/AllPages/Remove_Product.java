package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.UIManager;

public class Remove_Product extends JFrame {

	private JPanel contentPane;
	private JTextField dishId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove_Product frame = new Remove_Product();
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
	public Remove_Product() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveProduct = new JLabel("Remove Dish");
		lblRemoveProduct.setForeground(UIManager.getColor("Button.highlight"));
		lblRemoveProduct.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblRemoveProduct.setBounds(142, 21, 104, 23);
		contentPane.add(lblRemoveProduct);
		
		JLabel lblDishId = new JLabel("Dish ID");
		lblDishId.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblDishId.setBounds(44, 89, 65, 23);
		contentPane.add(lblDishId);
		
		dishId = new JTextField();
		dishId.setColumns(10);
		dishId.setBounds(128, 91, 166, 19);
		contentPane.add(dishId);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(209, 132, 85, 21);
		contentPane.add(btnRemove);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						Seller_Home obj = new Seller_Home();
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
		Image img = new ImageIcon(this.getClass().getResource("/removeDish.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 363, 196);
		contentPane.add(background);
	}
}
