package view;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import controller.DatabaseController;
import controller.ProjectionController;
import model.DashboardTableModel;


public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DashboardTableModel dataModel;
	private ProjectionController list;

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		list = new ProjectionController();
		DatabaseController database = new DatabaseController();
		try {
			list = database.getDatasProjection(list);
			if(list!=null) {
				list.sort();
			}
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		JLabel lblRelatorio = new JLabel("Relat\u00F3rio");
		lblRelatorio.setForeground(orange);
		lblRelatorio.setFont(new Font("Arial", Font.PLAIN, 36));
		lblRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorio.setBounds(432, 33, 382, 71);
		contentPane.add(lblRelatorio);
		
		/*--------------------------Titulo---------------------------*/
		
		/*--------------------------Tabela---------------------------*/
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setRowHeight(32);
		dataModel = new DashboardTableModel(list);
		table.setModel(dataModel);
		JTableHeader th = table.getTableHeader(); 
		th.setPreferredSize(new Dimension(100, 40));
		table.getColumnModel().getColumn(3).setPreferredWidth(180);
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
		
		JButton btnAdd = new JButton("Gerar relatório");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean newTable = false;
				if(list == null) {
					newTable = true;
				}
				Create create = new Create();
				create.createProjection(list);
				if(newTable) {
					Dashboard dashboard = new Dashboard();
					dashboard.setVisible(true);
					dispose();
				}else {
					list.sort();
				}
				dataModel.addRow();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(779, 170, 157, 23);
		contentPane.add(btnAdd);
		/*--------------------------Tabela---------------------------*/
		
		
	}
}
