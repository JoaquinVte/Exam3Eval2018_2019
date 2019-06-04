package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

public class Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4802283142713476458L;
	public JPanel contentPane;
	public JTable table;
	public JTextField textFieldDescription;
	public JTextField textFieldCost;
	public JTextField textFieldStock;
	public JComboBox comboBoxCategory;
	public JButton btnAdd;
	public JButton btnActualizar;
	public JButton btnDelete;
	public JButton btnCerrar;
	public JComboBox<String> comboBoxOrderBy;
	public JComboBox<String> comboBoxOrder;
	public JButton btnSort;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Final Exam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelTable = new JPanel();
		
		JPanel panelSort = new JPanel();
		
		JPanel panelDescription = new JPanel();
		
		JPanel panelButtons = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
						.addComponent(panelTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
						.addComponent(panelButtons, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
						.addComponent(panelSort, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelSort, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTable, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelDescription, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAdd = new JButton("Add");
		panelButtons.add(btnAdd);
		
		btnActualizar = new JButton("Update");
		panelButtons.add(btnActualizar);
		
		btnDelete = new JButton("Delete");
		panelButtons.add(btnDelete);
		
		btnCerrar = new JButton("Close");
		panelButtons.add(btnCerrar);
		panelSort.setLayout(new MigLayout("", "[][171.00,grow][][][grow][][]", "[]"));
		
		JLabel lblOrder = new JLabel("Order by:");
		panelSort.add(lblOrder, "cell 0 0,alignx trailing");
		
		comboBoxOrderBy = new JComboBox<String>();
		comboBoxOrderBy.setModel(new DefaultComboBoxModel(new String[] {"Cod", "CategoryId", "Description", "Stock", "Cost"}));
		panelSort.add(comboBoxOrderBy, "cell 1 0,growx");
		
		JLabel lblOrden = new JLabel("Order");
		panelSort.add(lblOrden, "cell 3 0,alignx trailing");
		
		comboBoxOrder = new JComboBox<String>();
		comboBoxOrder.setModel(new DefaultComboBoxModel<String>(new String[] {"ASC", "DESC"}));
		panelSort.add(comboBoxOrder, "cell 4 0,growx");
		
		btnSort = new JButton("Order");
		panelSort.add(btnSort, "cell 6 0");
		panelDescription.setLayout(new MigLayout("", "[][150.00,grow][301.00]", "[][][][]"));
		
		JLabel lblDescripcion = new JLabel("Description");
		panelDescription.add(lblDescripcion, "cell 0 0,alignx trailing");
		
		textFieldDescription = new JTextField();
		panelDescription.add(textFieldDescription, "cell 1 0 2 1,growx");
		textFieldDescription.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Cost");
		panelDescription.add(lblPrecio, "cell 0 1,alignx trailing");
		
		textFieldCost = new JTextField();
		panelDescription.add(textFieldCost, "cell 1 1,growx");
		textFieldCost.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		panelDescription.add(lblStock, "cell 0 2,alignx trailing");
		
		textFieldStock = new JTextField();
		panelDescription.add(textFieldStock, "cell 1 2,growx");
		textFieldStock.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Category");
		panelDescription.add(lblCategoria, "cell 0 3,alignx trailing");
		
		comboBoxCategory = new JComboBox();
		panelDescription.add(comboBoxCategory, "cell 1 3,growx");
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Cod.","Description","Category", "Stock", "Cost"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
