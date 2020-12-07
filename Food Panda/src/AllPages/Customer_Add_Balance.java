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
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Add_Balance extends JFrame {

	private JPanel contentPane;
	private JTextField giftCardField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Add_Balance frame = new Customer_Add_Balance();
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
	public Customer_Add_Balance() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddBalance = new JLabel("Add Balance");
		lblAddBalance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblAddBalance.setBounds(168, 43, 109, 17);
		contentPane.add(lblAddBalance);
		
		JLabel lblEnterCardCode = new JLabel("Enter Gift Card  Code");
		lblEnterCardCode.setFont(new Font("SimSun", Font.BOLD, 12));
		lblEnterCardCode.setBounds(10, 89, 145, 17);
		contentPane.add(lblEnterCardCode);
		
		giftCardField = new JTextField();
		giftCardField.setColumns(10);
		giftCardField.setBounds(165, 89, 198, 19);
		contentPane.add(giftCardField);
		
		
		JButton addBalance = new JButton("Add Balance");
		addBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
								
				try {
					 
					conn c = new conn();
					 
					String cardCode = giftCardField.getText();	 //user entered code in GUI	
					
					//checking this from Gift Cards table that whether this code exists or not
					String que1 = "SELECT * FROM giftcards WHERE CardCode = '" +cardCode+ "' "; 
					ResultSet rs =c.s.executeQuery(que1);
					 
					
					 if(rs.next()) {  //if match is found, then first add to customer balance and then change status to "used" from GiftCards
					
						 String codeCheck = rs.getString(3);   //index 3 shows Status from Gift cards
						 
						 if(codeCheck.equals("Active")) { //if gift card is active then move in this scope else go to else block
							 		 
							 //----------to get user email who logged in--------------
							 idIdentifierCustomer obj = new idIdentifierCustomer();
							 String s0 = obj.ID;
							 System.out.println(s0); 
							 //----------------------------					  
							 String giftCardBalance = rs.getString(2);  //getting balance from gift-cards						 
						 
							 //now we need another sql query to get customer tablle to get previous balance of that customer
							 
							 
							 String que2 = "SELECT * FROM customers WHERE eMail = '" +s0+ "' ";
							 ResultSet rs1 =c.s.executeQuery(que2);
							 
							 if(rs1.next()) {    //finding that customer through his eMail
							 
								 String previousBalance = rs1.getString(6);  //getting previous balance of that particular customer
								 
								 int total = 0;   //
								 
								 int a,b;
								 
								 a = Integer.parseInt(giftCardBalance);  //converting to integers
								 b = Integer.parseInt(previousBalance);
								 
								 total = a + b;
								 
								 String totalBalance = Integer.toString(total);  //so that it can be saved in table of customer
								
								 String que3 = "Update customers set Balance = '"+totalBalance+"' WHERE eMail = '"+s0+"' ";								 
								 c.s.execute(que3);
							 }
							 
							 
						 //setting used Gift card status to "used"
						 String status2 = "used";
						 
						 String str2 = "Update giftcards set Status = '"+status2+"' WHERE CardCode = '"+cardCode+"' ";	
						 c.s.execute(str2);
						 
						 JOptionPane.showMessageDialog(null, "Balance Successfully Added");
						//-----------------------------------------------------------
						 
						                          
					 }
						 
						 else {
							 JOptionPane.showMessageDialog(null, "Code already used","Error",JOptionPane.ERROR_MESSAGE);
						 }
						 
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Invalid Code","Error",JOptionPane.ERROR_MESSAGE);
						 

					 }
				}
				catch(Exception e){
					
				}
				
			}
		});
		addBalance.setBounds(247, 118, 116, 38);
		contentPane.add(addBalance);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						User_Balance obj = new User_Balance();
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
		Image img = new ImageIcon(this.getClass().getResource("/addBalance.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 421, 174);
		contentPane.add(background);
	}

}
