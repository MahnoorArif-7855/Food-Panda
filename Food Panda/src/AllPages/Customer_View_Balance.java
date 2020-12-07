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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_View_Balance extends JFrame {

	private JPanel contentPane;
	private JTextField balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_View_Balance frame = new Customer_View_Balance();
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
	public Customer_View_Balance() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewBalance = new JLabel("View Balance");
		lblViewBalance.setForeground(UIManager.getColor("Button.highlight"));
		lblViewBalance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblViewBalance.setBounds(114, 45, 109, 17);
		contentPane.add(lblViewBalance);
		
		JLabel lblYourBalanceIs = new JLabel("Your balance is ...");
		lblYourBalanceIs.setForeground(UIManager.getColor("Button.highlight"));
		lblYourBalanceIs.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblYourBalanceIs.setBounds(24, 93, 122, 17);
		contentPane.add(lblYourBalanceIs);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setForeground(UIManager.getColor("Button.highlight"));
		lblBalance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblBalance.setBounds(24, 132, 58, 17);
		contentPane.add(lblBalance);
		
		balance = new JTextField();
		balance.setBounds(106, 131, 130, 19);
		contentPane.add(balance);
		balance.setColumns(10);
		
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
				
				
				
				
				final JButton btnNewButton = new JButton("View");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						try {
							 conn c = new conn();
							 
						//----------to get user email who logged in--------------
						 idIdentifierCustomer obj = new idIdentifierCustomer();
						 String s0 = obj.ID;
						 System.out.println(s0);
						 
						 //----------------------------
						 
						 String str = "SELECT * FROM customers WHERE eMail = '" +s0+ "' "; 
						 
						 ResultSet rs = c.s.executeQuery(str);
						 
						 if(rs.next()) {
							 
							 	String s1 = rs.getString(6);  //index 6 is balance
							 	String showBalance = "Rs. " + s1;
							 	balance.setText(showBalance);
							 	
							 	
						 }
						
					}
					
					catch(Exception e){
						
					}
					}
					
				});
				btnNewButton.setBounds(151, 157, 85, 21);
				contentPane.add(btnNewButton);
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				//----------------------
				
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/viewBalance.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 313, 196);
		contentPane.add(background);
	}

}
