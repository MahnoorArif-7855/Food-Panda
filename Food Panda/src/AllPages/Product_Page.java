package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product_Page extends JFrame {

	private JPanel contentPane;
	private JTextField price;
	private JTextField ship;
	private JTextField total;
	private JTextField name;
	private JTextField desc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Page frame = new Product_Page();
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
	public Product_Page() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField = new TextField();
		textField.setText("This should have picture of product");
		textField.setBounds(10, 48, 352, 225);
		contentPane.add(textField);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(457, 81, 182, 19);
		contentPane.add(price);
		
		JLabel label = new JLabel("Price");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(384, 82, 46, 13);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Quantity");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(384, 118, 85, 21);
		contentPane.add(label_1);
		
		ship = new JTextField();
		ship.setText("50");
		ship.setColumns(10);
		ship.setBounds(554, 162, 85, 19);
		contentPane.add(ship);
		
		JLabel label_2 = new JLabel("Shipment Cost");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(384, 159, 127, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Total");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(384, 193, 59, 21);
		contentPane.add(label_3);
		
		total = new JTextField();
		total.setColumns(10);
		total.setBounds(457, 196, 182, 19);
		contentPane.add(total);
		
		
		JButton button_3 = new JButton("Order Now");
		button_3.setBounds(526, 281, 113, 32);
		contentPane.add(button_3);
		
		name = new JTextField();
		name.setOpaque(false);
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(10, 294, 182, 19);
		contentPane.add(name);
		
		JLabel label_4 = new JLabel("Description");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 321, 85, 25);
		contentPane.add(label_4);
		
		desc = new JTextField();
		desc.setEditable(false);
		desc.setColumns(10);
		desc.setBounds(10, 356, 352, 19);
		contentPane.add(desc);
		
		JLabel back = new JLabel("");
	
		//back button with image-------------

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer_View_Products obj = new Customer_View_Products();
				dispose();
				obj.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		back.setIcon(new ImageIcon(img1));
		back.setBounds(10, 10, 32, 32);
		contentPane.add(back);
		
	
		
		//********************getting products info and adding in textFields
				try {
					 conn c = new conn();
					 
					 //getting id of selected dish
					 
					 dishIDidentifier obj = new dishIDidentifier();
					 
					 String s1 = obj.dishID;
					 					 
					 String str = "SELECT * FROM products WHERE DishId = '" +s1+ "' "; 
					 ResultSet rs =c.s.executeQuery(str);
					 
					 if(rs.next()) {
						 
						  String dishName = rs.getString(2);
						  String dishDescription  = rs.getString(3);
						  String dishPrice  = rs.getString(4);
						  
						  
						  //setting on the textFileds

						  name.setText(dishName);
						  desc.setText(dishDescription);
						  price.setText(dishPrice);
						  
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Error Unknown");
						 

					 }
				}
				catch(Exception e){
					
				}
				//***************************************
				
				

				//to set price in total filed of textField after getting quantity
				
				int grandTotal = 0;
				
				//price of single product
				final int salePrice = Integer.parseInt(price.getText());
			
				//grandTotal = salePrice * quantity;
				
				//int shipment = Integer.parseInt(ship.getText());
				final int shipment = 50;
				grandTotal = shipment + salePrice;
				total.setText(Integer.toString(grandTotal));
				
				
				
				final JSpinner spinner = new JSpinner();
				spinner.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						String value=spinner.getValue().toString();
						int value1=Integer.parseInt(value);
						int totalPrice = (value1*salePrice) + shipment;
						total.setText(Integer.toString(totalPrice));
						
					}
				});
				spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
				spinner.setBounds(568, 110, 71, 32);
				contentPane.add(spinner);
				

				JButton button_2 = new JButton("Add to Cart");
				button_2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						idIdentifierCustomer ob= new idIdentifierCustomer();
						
						
						String userID = ob.ID;   
						String value = spinner.getValue().toString();
						
						int quantity = Integer.parseInt(value);
						
						int totalForCart = (quantity*salePrice) + shipment;
						
						System.out.println(totalForCart);//for debugging
						
						dishIDidentifier obj = new dishIDidentifier();
						
						String dishId = obj.dishID;
						
						
						//saving into cart table
						try {
						conn c = new conn();
						
						 String str1 = "insert into cart"            //copying to new table
								 +"(eMail, DishID , Quantity , Price)"
								 +"VALUES ('"+userID+"','"+dishId+"','"+quantity+"','"+totalForCart+"' ) ";
						 
						 c.s.executeUpdate(str1);
						 
						 JOptionPane.showMessageDialog(null, "Successfully added to Cart");
						 
						}
						catch(Exception ae){
							System.out.println(ae);
						}
						
						
					}
				});
				button_2.setBounds(384, 281, 113, 32);
				contentPane.add(button_2);
				
				
				
				
		
				
				
				
	}
}
