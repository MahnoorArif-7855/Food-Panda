package AllPages;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Seller_View_Products extends JFrame {

	protected static final String DbUtils = null;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seller_View_Products frame = new Seller_View_Products();
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
	public Seller_View_Products() {
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 645, 318);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Dishes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					conn c = new conn();
					
					//hotelNameIdentifier obj = new hotelNameIdentifier();
					//String name = obj.hotelName;
				
					String name = "Pizza Hut";
					
					//System.out.println(name);
					String str = "select * from products where HotelName = '"+name+"' ";
					
					ResultSet rs = c.s.executeQuery(str);  //to get data
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
					
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				
		});
		btnNewButton.setBounds(534, 20, 121, 28);
		contentPane.add(btnNewButton);
		
		JLabel back = new JLabel("");
		
		//back button with image-------------
		
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
		
		
	}

}
