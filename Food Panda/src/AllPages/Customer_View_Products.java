package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Customer_View_Products extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_View_Products frame = new Customer_View_Products();
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
	public Customer_View_Products() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 653, 310);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try{
			conn c = new conn();
			
			//first getting hottelName so to show only its products
			hotelNameIdentifier obj = new hotelNameIdentifier ();
			String hName = obj.hotelName;
			
			//-------------
			
			String str = "select DishID, DishName, Description, Price from products where HotelName = '"+hName+"'";
			
			ResultSet rs = c.s.executeQuery(str);  //to get data
			 
			table.setModel(DbUtils.resultSetToTableModel(rs));   //to set view of table
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 54, 35);
		contentPane.add(lblNewLabel);
		
		//back button with image-------------
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Choose_Resturant obj = new Choose_Resturant();
				dispose();
				obj.setVisible(true);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		back.setIcon(new ImageIcon(img1));
		back.setBounds(10, 10, 32, 32);
		contentPane.add(back);
		
					
		//----------------------
		
		//-----------***********----------
		
				final ListSelectionModel model = table.getSelectionModel();
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(! model.isSelectionEmpty())
						{
							
							int column = 0;   //cause we show only one column
							int row = table.getSelectedRow();
							
							String value = table.getModel().getValueAt(row, column).toString();
							
							//saving dish ID-------------
							dishIDidentifier obj = new dishIDidentifier();
							obj.setDishID(value);  
							
							//-----------------------------
							
							
							Product_Page obj1 = new Product_Page();
							dispose();
							obj1.setVisible(true);
							
						}
						
						
					}
				});
				
				//********-----------------
				
				
				
				
	}

}
