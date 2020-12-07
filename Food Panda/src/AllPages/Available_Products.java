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

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Available_Products extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Available_Products frame = new Available_Products();
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
	public Available_Products() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setResizable(false);
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDishesAvailable = new JLabel("Dishes Available");
		lblDishesAvailable.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblDishesAvailable.setBounds(155, 32, 125, 33);
		contentPane.add(lblDishesAvailable);
		
		//back button with image-------------
				JLabel back = new JLabel("");
				back.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
				back.setIcon(new ImageIcon(img1));
				back.setBounds(10, 10, 32, 32);
				contentPane.add(back);
				
				//----------------------
				
	}

}
