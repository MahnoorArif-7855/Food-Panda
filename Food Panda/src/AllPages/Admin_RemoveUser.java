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

public class Admin_RemoveUser extends JFrame {

	private JPanel contentPane;
	private JTextField eMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_RemoveUser frame = new Admin_RemoveUser();
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
	public Admin_RemoveUser() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoveUser = new JLabel("Remove Seller");
		lblRemoveUser.setFont(new Font("SimSun", Font.BOLD, 14));
		lblRemoveUser.setBounds(263, 10, 103, 32);
		contentPane.add(lblRemoveUser);
		
		JLabel userID = new JLabel("e-Mail");
		userID.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		userID.setBounds(44, 89, 65, 23);
		contentPane.add(userID);
		
		eMail = new JTextField();
		eMail.setColumns(10);
		eMail.setBounds(128, 91, 166, 19);
		contentPane.add(eMail);
		
		final JButton remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource() == remove) {
					try {
						 conn c = new conn();
						 
						 String s0 = eMail.getText();
						 
						 String str = "SELECT * FROM seller WHERE eMail = '" +s0+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str);
						 
						 if(rs.next()) {  //if match found
							 
							 // to delete data of person who have been approved in previous table
							 
							 String str2 = "DELETE FROM seller WHERE eMail =  '"+s0+"' ";
							 
							 c.s.execute(str2);
							 
							 JOptionPane.showMessageDialog(null, "Seller Successfully Removed");
							 
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Incorrect email entered");
							 

						 }
					}
					catch(Exception e){
						
					}
			}
				
			
				
			}
		});
		remove.setBounds(209, 132, 85, 21);
		contentPane.add(remove);
		
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
				
				//----------------------
				
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/adminRemoveUser.png")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 366, 189);
		contentPane.add(background);
	}

}
