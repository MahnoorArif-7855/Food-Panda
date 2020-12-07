package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Choose_Resturant extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choose_Resturant frame = new Choose_Resturant();
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
	public Choose_Resturant() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseResturant = new JLabel("Choose Resturant");
		lblChooseResturant.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblChooseResturant.setBounds(212, 27, 134, 33);
		contentPane.add(lblChooseResturant);
		
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 560, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		try{
			conn c = new conn();
			
			//we are using table of products to show hotel names
			String str = "select Distinct HotelName from products";   //"Distinct" is used so that Duplicate Hotel Names are not shown
			
			ResultSet rs = c.s.executeQuery(str);  //to get data
			 
			table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		//-----------***********----------
				final ListSelectionModel model = table.getSelectionModel();
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(! model.isSelectionEmpty())
						{
							
							int column = 0;   //cause we show only one column
							int row = table.getSelectedRow();
							
							String value = table.getModel().getValueAt(row, column).toString();
							
						
							hotelNameIdentifier obj = new hotelNameIdentifier();
							
							obj.setName(value);   //saving HotelName of selected row
							System.out.println(obj.hotelName);
							
							Customer_View_Products obj1 = new Customer_View_Products();
							dispose();
							obj1.setVisible(true);
						
						}
						
						
					}
				});
				//********-----------------
		
		
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						User_Home obj = new User_Home();
						dispose();
						obj.setVisible(true);
					}
				});
				Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
							
				//----------------------
				
		
		
		
	}
}
