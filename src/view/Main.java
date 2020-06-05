package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//initialize
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		String path = new File("").getAbsolutePath();
		lblLogo.setIcon(new ImageIcon(path + "\\src\\view\\image\\project.png"));
		lblLogo.setBounds(296, 25, 434, 409);
		contentPane.add(lblLogo);
		
		JLabel lblBemVindo = new JLabel("Seja bem-vindo");
		lblBemVindo.setFont(new Font("Arial", Font.PLAIN, 38));
		lblBemVindo.setBounds(367, 458, 282, 71);
		contentPane.add(lblBemVindo);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewButton.setBounds(440, 540, 138, 36);
		contentPane.add(btnNewButton);
	}
}
