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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Product extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField desc;
	private JTextField price;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product frame = new Add_Product();
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
	public Add_Product() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddDish = new JLabel("Add Dish");
		lblAddDish.setBackground(UIManager.getColor("Button.disabledForeground"));
		lblAddDish.setForeground(UIManager.getColor("Button.highlight"));
		lblAddDish.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblAddDish.setBounds(164, 37, 72, 16);
		contentPane.add(lblAddDish);
		
		JLabel lblDishName = new JLabel("Dish Name");
		lblDishName.setForeground(UIManager.getColor("Button.highlight"));
		lblDishName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblDishName.setBounds(36, 87, 72, 16);
		contentPane.add(lblDishName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(118, 86, 138, 19);
		contentPane.add(name);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(UIManager.getColor("Button.highlight"));
		lblDescription.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblDescription.setBounds(36, 114, 72, 16);
		contentPane.add(lblDescription);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(UIManager.getColor("Button.highlight"));
		lblPrice.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPrice.setBounds(36, 141, 72, 16);
		contentPane.add(lblPrice);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setForeground(UIManager.getColor("Button.highlight"));
		lblCategory.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblCategory.setBounds(36, 168, 72, 16);
		contentPane.add(lblCategory);
		
		desc = new JTextField();
		desc.setColumns(10);
		desc.setBounds(118, 113, 138, 19);
		contentPane.add(desc);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(118, 140, 138, 19);
		contentPane.add(price);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(118, 167, 138, 19);
		contentPane.add(textField_3);
		
		JButton saveDishButton = new JButton("Save");
		saveDishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
						
						String dishName = name.getText();
						String dishDescription = desc.getText();
						String dishPrice = price.getText();
						
						idIdentifierSeller obj = new idIdentifierSeller();
						String hotelName = obj.ID;
						
						 conn c = new conn();
					
						 
						 String str = "insert into products" 
								 +"(DishName, Description, Price, HotelName,)"
								 +"VALUES ('"+dishName+"','"+dishDescription+"','"+dishPrice+"','"+hotelName+"') "; 
						
							 c.s.executeUpdate(str);
							 
							 JOptionPane.showMessageDialog(null, "Product Successfully Added");
						
					}
					catch(Exception e){
						
					}
				
			}
				
		
		});
		saveDishButton.setBounds(255, 218, 85, 21);
		contentPane.add(saveDishButton);
		
		
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
		Image img = new ImageIcon(this.getClass().getResource("/addDish.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 392, 272);
		contentPane.add(background);
		
		
		
		
		
	}

}
