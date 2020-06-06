package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SaleView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SaleView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
/*-------------------------menu------------------------------*/
		
Color blue = new Color(72,94,136);
		
		JPanel menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		menu.setBounds(0, 0, 238, 681);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel menu_logo = new JLabel("");
		String path = new File("").getAbsolutePath();
		menu_logo.setIcon(new ImageIcon(path + "\\src\\view\\image\\menu_logo.png"));
		menu_logo.setBounds(37, 25, 160, 150);
		menu.add(menu_logo);
		
		JLabel menu_dashboard = new JLabel("Dashboard");
		menu_dashboard.setForeground(blue);
		menu_dashboard.setHorizontalAlignment(SwingConstants.CENTER);
		menu_dashboard.setFont(new Font("Arial", Font.PLAIN, 20));
		menu_dashboard.setBounds(69, 199, 96, 29);
		menu_dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_dashboard.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_dashboard.setForeground(blue);
			}
		});
		menu.add(menu_dashboard);
		
		JLabel menu_product = new JLabel("Produtos");
		menu_product.setForeground(blue);
		menu_product.setHorizontalAlignment(SwingConstants.CENTER);
		menu_product.setFont(new Font("Arial", Font.PLAIN, 20));
		menu_product.setBounds(69, 269, 96, 29);
		menu_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductView product = new ProductView();
				product.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_product.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_product.setForeground(blue);
			}
		});
		menu.add(menu_product);
		
		JLabel menu_lot = new JLabel("Lotes");
		menu_lot.setForeground(blue);
		menu_lot.setHorizontalAlignment(SwingConstants.CENTER);
		menu_lot.setFont(new Font("Arial", Font.PLAIN, 20));
		menu_lot.setBounds(69, 346, 96, 29);
		menu_lot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LotView lot = new LotView();
				lot.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_lot.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_lot.setForeground(blue);
			}
		});
		menu.add(menu_lot);
		
		JLabel menu_sale = new JLabel("Sa\u00EDda");
		menu_sale.setForeground(blue);
		menu_sale.setHorizontalAlignment(SwingConstants.CENTER);
		menu_sale.setFont(new Font("Arial", Font.PLAIN, 20));
		menu_sale.setBounds(69, 420, 96, 29);
		menu_sale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleView sale = new SaleView();
				sale.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				menu_sale.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menu_sale.setForeground(blue);
			}
		});
		menu.add(menu_sale);
		
		/*-------------------------menu------------------------------*/
		
		Color orange = new Color(219,153,80);
		
		JLabel lblSale = new JLabel("Sa\u00EDda");
		lblSale.setForeground(orange);
		lblSale.setFont(new Font("Arial", Font.PLAIN, 36));
		lblSale.setHorizontalAlignment(SwingConstants.CENTER);
		lblSale.setBounds(432, 33, 382, 71);
		contentPane.add(lblSale);
	}

}
