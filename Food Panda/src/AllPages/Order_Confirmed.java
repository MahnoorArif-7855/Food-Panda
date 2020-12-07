package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;

public class Order_Confirmed extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Confirmed frame = new Order_Confirmed();
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
	public Order_Confirmed() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderConfirmed = new JLabel("Order Confirmed");
		lblOrderConfirmed.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblOrderConfirmed.setBounds(156, 20, 128, 21);
		contentPane.add(lblOrderConfirmed);
		
		JLabel lblYourOrderHas = new JLabel("Your order has been confirmed and will\r\n");
		lblYourOrderHas.setToolTipText("");
		lblYourOrderHas.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrderHas.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblYourOrderHas.setBounds(78, 54, 293, 40);
		contentPane.add(lblYourOrderHas);
		
		JLabel lblArriveWithn = new JLabel("arrive withn 30 minutes.");
		lblArriveWithn.setToolTipText("");
		lblArriveWithn.setHorizontalAlignment(SwingConstants.CENTER);
		lblArriveWithn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblArriveWithn.setBounds(78, 76, 293, 56);
		contentPane.add(lblArriveWithn);
		
		JButton btnBackToHome = new JButton("back to Home");
		btnBackToHome.setBorder(null);
		btnBackToHome.setBackground(new Color(204, 51, 204));
		btnBackToHome.setBounds(156, 142, 118, 21);
		contentPane.add(btnBackToHome);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(173, 173, 85, 21);
		contentPane.add(btnLogout);
	}

}
