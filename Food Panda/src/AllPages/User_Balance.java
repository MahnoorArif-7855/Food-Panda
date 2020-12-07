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

import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class User_Balance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Balance frame = new User_Balance();
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
	public User_Balance() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setForeground(UIManager.getColor("Button.highlight"));
		lblBalance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblBalance.setBounds(141, 26, 70, 28);
		contentPane.add(lblBalance);
		
		JButton btnNewButton = new JButton("Add Balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer_Add_Balance obj = new Customer_Add_Balance();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(21, 79, 111, 36);
		contentPane.add(btnNewButton);
		
		JButton btnViewBalance = new JButton("View Balance");
		btnViewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer_View_Balance obj = new Customer_View_Balance();
				obj.setVisible(true);
			}
		});
		btnViewBalance.setBounds(204, 79, 111, 36);
		contentPane.add(btnViewBalance);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						User_Home obj = new User_Home();
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
		Image img = new ImageIcon(this.getClass().getResource("/balance.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 345, 175);
		contentPane.add(background);
	}

}
