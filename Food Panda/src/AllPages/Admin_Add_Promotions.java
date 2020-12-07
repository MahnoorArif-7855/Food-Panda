package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;


import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Add_Promotions extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField code;
	private JTextField description;
	private JTextField value;
	private JTextField codeRemove;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Add_Promotions frame = new Admin_Add_Promotions();
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
	public Admin_Add_Promotions() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//back button with image-------------
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Admin_Home obj = new Admin_Home();
				obj.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		back.setIcon(new ImageIcon(img1));
		back.setBounds(10, 10, 32, 32);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("Add Promotions");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(356, 39, 138, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(239, 117, 585, 372);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JButton button = new JButton("Refresh Table");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					
					try{
						conn c = new conn();
						
						String str = "select * from promotion";
						
						ResultSet rs = c.s.executeQuery(str);  //to get data
						 
						table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
						
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
	

		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		button.setBounds(54, 117, 97, 21);
		contentPane.add(button);
		
		JLabel label = new JLabel("Code");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(33, 156, 51, 21);
		contentPane.add(label);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(94, 158, 119, 19);
		contentPane.add(code);
		
		JLabel label_1 = new JLabel("Description");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(21, 187, 72, 21);
		contentPane.add(label_1);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(94, 189, 119, 19);
		contentPane.add(description);
		
		JLabel label_2 = new JLabel("Value");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(33, 218, 39, 21);
		contentPane.add(label_2);
		
		value = new JTextField();
		value.setColumns(10);
		value.setBounds(94, 220, 119, 19);
		contentPane.add(value);
		
		JLabel label_3 = new JLabel("ValidTill");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(33, 247, 51, 21);
		contentPane.add(label_3);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(95, 249, 118, 19);
		contentPane.add(dateChooser);
		
		final JButton addPromo = new JButton("Add");
		addPromo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == addPromo) {
					try {
						 conn c = new conn();
						 
						 String s1 = code.getText();
						 String s2 = description.getText();
						 
						 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
						 String s3 = sdf.format(dateChooser.getDate());
						 
						 String s4 = value.getText();
						 
						 String str0 = "SELECT * FROM promotion WHERE Code = '" +s1+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str0);
						 
						 if(rs.next()) {  //if code is already present in system, then
							 
							 JOptionPane.showMessageDialog(null, "This code already exists","Error Adding", JOptionPane.ERROR_MESSAGE);
						 }
						 else {
							 
						 String str = "INSERT INTO promotion" 
								 +"(Code, Description, ValidTill, Value)"
								 +"VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"' ) "; 
						 
						 c.s.executeUpdate(str);
						 
						 JOptionPane.showMessageDialog(null, "Promotion code added to system");
						 
					}
				}
				
					catch(Exception e){
						
					}
				}
			}
		});
		addPromo.setBounds(116, 299, 97, 21);
		contentPane.add(addPromo);
		
		JLabel lblRemovePromotionCode = new JLabel("Remove Promotion Code");
		lblRemovePromotionCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRemovePromotionCode.setBounds(21, 369, 192, 21);
		contentPane.add(lblRemovePromotionCode);
		
		codeRemove = new JTextField();
		codeRemove.setToolTipText("");
		codeRemove.setColumns(10);
		codeRemove.setBounds(21, 400, 193, 19);
		contentPane.add(codeRemove);
		
		final JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == button_2) {
					try {
						 conn c = new conn();
						 String s0 = codeRemove.getText();
						
						 
						 String str = "SELECT * FROM promotion WHERE Code = '" +s0+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str);
						 
						int result = JOptionPane.showConfirmDialog(null, "Do you want to remove this Promo Code","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						
						if(result == JOptionPane.YES_OPTION) {
						
							if(rs.next()) {  //if match found
							 
							                               // to delete data of promo code
							 
							 String str1 = "DELETE FROM promotion WHERE Code =  '"+s0+"' ";
							 
							 c.s.execute(str1);
							 
							 JOptionPane.showMessageDialog(null, "Successfuly removed " +s0 +" from system");
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "No data found");
							 
						 }
					}
						else {
							JOptionPane.showMessageDialog(null, "No Promo Code Removed");
						}
					}
					catch(Exception e){
						
					}
				}
			}
		});
		button_2.setBounds(116, 438, 97, 21);
		contentPane.add(button_2);
		
		//----------------------
	}
}
