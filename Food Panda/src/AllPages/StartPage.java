package AllPages;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class StartPage {

	private JFrame frmFoodPanda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.frmFoodPanda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoodPanda = new JFrame();
		frmFoodPanda.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Eclipse Workspace\\Online Food Ordering System\\Resources\\foodPanda.png"));
		frmFoodPanda.setTitle("Food Panda");
		frmFoodPanda.setResizable(false);
		frmFoodPanda.setBounds(100, 100, 450, 220);
		
		frmFoodPanda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoodPanda.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 14));
		lblNewLabel.setBounds(191, 26, 58, 35);
		frmFoodPanda.getContentPane().add(lblNewLabel);
		
		JButton startApp = new JButton("Start App");
		startApp.setFont(new Font("Tahoma", Font.PLAIN, 9));
		startApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Page obj = new Login_Page();
				
				obj.setVisible(true);
				
			}
		});
		startApp.setBounds(159, 67, 117, 35);
		frmFoodPanda.getContentPane().add(startApp);
		
		//setting background image--------
		JLabel background = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/start.jpg")).getImage();
		background.setIcon(new ImageIcon(img));
		
		background.setBounds(0, 0, 446, 192);
		frmFoodPanda.getContentPane().add(background);
	}
}
