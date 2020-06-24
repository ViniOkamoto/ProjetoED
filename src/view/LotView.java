package view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import model.LotTableModel;

public class LotView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public LotView() {
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
		
		/*--------------------------Titulo---------------------------*/
		
		Color orange = new Color(219,153,80);
		
		JLabel lblLot = new JLabel("Lote");
		lblLot.setForeground(orange);
		lblLot.setFont(new Font("Arial", Font.PLAIN, 36));
		lblLot.setHorizontalAlignment(SwingConstants.CENTER);
		lblLot.setBounds(432, 33, 382, 71);
		contentPane.add(lblLot);
		
		/*--------------------------Titulo---------------------------*/
		
		/*--------------------------Tabela---------------------------*/
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setRowHeight(32);
		LotTableModel dataModel = new LotTableModel();
		table.setModel(dataModel);
		JTableHeader th = table.getTableHeader(); 
		th.setPreferredSize(new Dimension(100, 40));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2==0) {
                    setBackground(Color.LIGHT_GRAY);
                    setForeground(Color.BLACK);
                } else {
                	setBackground(Color.WHITE);
                    setForeground(Color.BLACK);
                }
                return this;
            }
        });
		contentPane.add(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(328, 204, 608, 272);
		contentPane.add(scroll);
		
		JButton btnAddLot = new JButton("Adicionar Lote");
		btnAddLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddLot.setBounds(779, 170, 157, 23);
		contentPane.add(btnAddLot);
		
		/*--------------------------Tabela---------------------------*/
		
		/*--------------------------Filtro---------------------------*/
		
		JComboBox<String> selectorFilterName = new JComboBox<String>();
		selectorFilterName.addItem("All");
		selectorFilterName.addItem("Exemplo");
		selectorFilterName.setBounds(328, 171, 107, 23);
		contentPane.add(selectorFilterName);
		
		JLabel lblFilter_1 = new JLabel("Fitrar por nome");
		lblFilter_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFilter_1.setBounds(328, 148, 107, 14);
		contentPane.add(lblFilter_1);
		
		/*--------------------------Filtro---------------------------*/
	}

}
