package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Admin_Add_GiftCards extends JFrame {

	private JPanel contentPane;
	private JTextField codeField;
	private JTextField valueField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Add_GiftCards frame = new Admin_Add_GiftCards();
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
	public Admin_Add_GiftCards() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton refreshTable = new JButton("Refresh Table");
		refreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try{
					conn c = new conn();
					
					String str = "select * from giftcards";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
					
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			
			
		});
		refreshTable.setFont(new Font("Tahoma", Font.PLAIN, 9));
		refreshTable.setBounds(116, 101, 97, 21);
		contentPane.add(refreshTable);
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
		
		JLabel label_1 = new JLabel("Code");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(33, 142, 51, 21);
		contentPane.add(label_1);
		
		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(94, 144, 119, 19);
		contentPane.add(codeField);
		
		JLabel label_2 = new JLabel("Value");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(33, 173, 39, 21);
		contentPane.add(label_2);
		
		valueField = new JTextField();
		valueField.setColumns(10);
		valueField.setBounds(94, 175, 119, 19);
		contentPane.add(valueField);
		
		JLabel lblAddGiftCard = new JLabel("Add Gift Card");
		lblAddGiftCard.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblAddGiftCard.setBounds(259, 22, 138, 32);
		contentPane.add(lblAddGiftCard);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 101, 318, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == add) {
					try {
						 conn c = new conn();
						 
						 String code = codeField.getText();
						 String value = valueField.getText();
						 String status = "Active";     //because new gift cards are always active until they are used
						
						 String str0 = "SELECT * FROM giftcards WHERE CardCode = '" +code+ "' "; 
						 
						 ResultSet rs =c.s.executeQuery(str0);
						 
						 if(rs.next()) {  //if code is already present in system, then
							 
							 JOptionPane.showMessageDialog(null, "This code already exists","Error Adding", JOptionPane.ERROR_MESSAGE);
						 }
						 else {
							 
						 String str = "INSERT INTO giftcards" 
								 +"(CardCode, Amount, Status)"
								 +"VALUES ('"+code+"','"+value+"','"+status+"' ) "; 
						 
						 c.s.executeUpdate(str);
						 
						 JOptionPane.showMessageDialog(null, "Gift Card successfully added to system");
						 
					}
				}
				
					catch(Exception e){
						
					}
				}
				
				
			}
		});
		add.setBounds(116, 240, 97, 21);
		contentPane.add(add);
	}
}
