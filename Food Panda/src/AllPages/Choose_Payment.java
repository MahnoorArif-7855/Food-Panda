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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choose_Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose_Payment frame = new Choose_Payment();
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
	public Choose_Payment() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChoosePaymentMethod = new JLabel("Choose Payment Method");
		lblChoosePaymentMethod.setForeground(UIManager.getColor("Button.highlight"));
		lblChoosePaymentMethod.setBackground(UIManager.getColor("Button.highlight"));
		lblChoosePaymentMethod.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblChoosePaymentMethod.setBounds(137, 26, 192, 33);
		contentPane.add(lblChoosePaymentMethod);
		
		//************************************************************
		
		
		
		JButton codButton = new JButton("Cash On Delivery");
		codButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					//should call IDIDENTIFIERCUSTOMER to get id in table
					
					idIdentifierCustomer obj = new idIdentifierCustomer();
					
					String id = obj.ID;
					
					conn c= new conn();
					
					String str = "select SUM(Price) as mySum from cart";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					
					int sum = 0; 
					
					if(rs.next()) {
						
					sum = Integer.parseInt(rs.getString("mySum"));
						
					}
					
					//now saving to order history table 
					String str1 = "insert into orderhistory" 
							 +"(Price,eMail)"
							 +"VALUES ('"+sum+"','"+id+"') "; 
					
					c.s.executeUpdate(str1);  //to get data
					JOptionPane.showMessageDialog(null, "Order Successfully Placed");
	
					
					String str4 = " DELETE FROM cart WHERE eMail =  '"+id+"' "; 
					 c.s.executeUpdate(str4);  //to get data
					 
					//make new page to show that order is placed and put back button for home page
					
					
				}
				catch(Exception ae) {
				
				}
				
				
			}
		});
		codButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		codButton.setBounds(71, 106, 117, 42);
		contentPane.add(codButton);
		
		JButton balanceButton = new JButton("Pay using Balance");
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					idIdentifierCustomer obj = new idIdentifierCustomer();
					
					String id = obj.ID;
					
					conn c= new conn();
					
					String str = "select SUM(Price) as mySum from cart";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					
					int sum = 0; 
					

					
					if(rs.next()) {
						
						sum = Integer.parseInt(rs.getString("mySum"));
						
					}
					
					
					String str1 = "select * from customers where eMail = '"+id+"' ";
					
					ResultSet rs1 = c.s.executeQuery(str1);  //to get data
		
					int userBalance = 0;
					
					if(rs1.next()){
						userBalance = Integer.parseInt(rs1.getString(6));
						
					}
					
					
					if(userBalance >= sum) {
						
						int newBalance = userBalance - sum;
						 
						 String str2 = "SELECT * FROM customers WHERE eMail = '" +id+ "'"; 
						 
						 ResultSet rs2 =c.s.executeQuery(str2);
						
						if(rs2.next()) {  //updating new remaining balance
						
							 String que = "Update customers set Balance = '"+newBalance+"' WHERE eMail = '"+id+"' ";								 
							 c.s.execute(que);
						 
						}
						
						String str3 = "insert into orderhistory" 
								 +"(Price, eMail)"
								 +"VALUES ('"+sum+"','"+id+"') "; 
						
						c.s.executeUpdate(str3);  //to get data
						
						//finalPage on = new finalPage();
						
						 JOptionPane.showMessageDialog(null,"Order Successfully Placed");
					
		
						 //now we remove it from cart
						 
						 String str4 = " DELETE FROM cart WHERE eMail =  '"+id+"' "; 
						 c.s.executeUpdate(str4);  //to get data
						 
						 
						 
						 
					}
					
					else {
						JOptionPane.showMessageDialog(null,"Insuffecient Funds");
					}
					
				
					
					//now saving to order history table 
								
				}
				catch(Exception ae) {
				
				}
				
			}
		});
		balanceButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		balanceButton.setBounds(259, 106, 117, 42);
		contentPane.add(balanceButton);
		
		JLabel lblPromotionCode = new JLabel("Promotion Code");
		lblPromotionCode.setForeground(UIManager.getColor("Button.highlight"));
		lblPromotionCode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblPromotionCode.setBounds(10, 181, 105, 33);
		contentPane.add(lblPromotionCode);
		
		textField = new JTextField();
		textField.setBounds(125, 189, 251, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCheckPromo = new JButton("Check Promo");
		btnCheckPromo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCheckPromo.setBounds(283, 220, 93, 21);
		contentPane.add(btnCheckPromo);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				
				//----------------------
				
				//setting background image--------
				JLabel background = new JLabel("");
				Image img = new ImageIcon(this.getClass().getResource("/payment.jpg")).getImage();
				background.setIcon(new ImageIcon(img));
				background.setBounds(0, 0, 446, 300);
				contentPane.add(background);
				
	}
}
