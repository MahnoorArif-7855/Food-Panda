package AllPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Logout_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout_Page frame = new Logout_Page();
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
	public Logout_Page() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/foodPanda.png")));
		setTitle("Food Panda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LogOut Page");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblNewLabel.setBounds(160, 29, 108, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblYouHaveSuccessfully = new JLabel("You have successfully logged out.");
		lblYouHaveSuccessfully.setForeground(UIManager.getColor("Button.highlight"));
		lblYouHaveSuccessfully.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblYouHaveSuccessfully.setBounds(34, 81, 216, 16);
		contentPane.add(lblYouHaveSuccessfully);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login_Page obj = new Login_Page();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(174, 127, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(174, 169, 85, 21);
		contentPane.add(btnClose);
		
		//setting background image--------
		JLabel background = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logOut.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 446, 322);
		contentPane.add(background);
	}

}
