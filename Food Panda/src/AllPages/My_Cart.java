package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class My_Cart extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField totalBillText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					My_Cart frame = new My_Cart();
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
	public My_Cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyCart = new JLabel("My Cart");
		lblMyCart.setBounds(196, 10, 46, 13);
		contentPane.add(lblMyCart);
		
		JButton button = new JButton("back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_Home obj = new User_Home();
				dispose();
				obj.setVisible(true);
			}
		});
		button.setBounds(445, 10, 85, 21);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 54, 250, 276);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try{
			conn c = new conn();
			
			//should call IDIDENTIFIERCUSTOMER to get id in table
			
			idIdentifierCustomer obj = new idIdentifierCustomer();
			
			String id = obj.ID;
			
			System.out.println(id);
			//-------------
			
			String str = "select products.DishName, products.Description, cart.Quantity, cart.Price from cart"
					+ " INNER JOIN products ON "
					+ "cart.DishId = products.DishId "
					+ "WHERE cart.eMail = '"+id+"' ";
			
			ResultSet rs = c.s.executeQuery(str);  //to get data
			 
			
			table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		JLabel lblTotalBill = new JLabel("Total Bill");
		lblTotalBill.setBounds(317, 121, 46, 13);
		contentPane.add(lblTotalBill);
		
		totalBillText = new JTextField();
		totalBillText.setBounds(391, 118, 139, 19);
		contentPane.add(totalBillText);
		totalBillText.setColumns(10);
		
		

		try {
		
			//should call IDIDENTIFIERCUSTOMER to get id in table
			

			idIdentifierCustomer obj = new idIdentifierCustomer();
			
			String id = obj.ID;
			
			conn c= new conn();
			
			String str = "select SUM(Price) as mySum from cart where eMail = '"+id+"' ";
			
			ResultSet rs = c.s.executeQuery(str);  //to get data
			
			if(rs.next()) {
				
			String sum = rs.getString("mySum");
			
			totalBillText.setText(sum);
			
			
			
			}
			
			
		}
		catch(Exception e) {
		
		}
		
		JButton button_1 = new JButton("Order Now");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Confirm Order ?", "QUESTION",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					Choose_Payment obj = new Choose_Payment();
			    	dispose();
			    	obj.setVisible(true);
			    
				   
				} 
				else {
				    //
				}
				
			}
		});
		button_1.setBounds(445, 159, 85, 21);
		contentPane.add(button_1);
	}
}
