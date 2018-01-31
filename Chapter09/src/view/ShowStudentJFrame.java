package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowStudentJFrame extends JInternalFrame {
	private JScrollPane scrollPane;
	
	private JTable studentTable;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStudentJFrame frame = new ShowStudentJFrame();
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
	public ShowStudentJFrame() {
		setTitle("Show All Students");
		setClosable(true);
		setBounds(100, 100, 683, 453);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Show All Students", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 647, 401);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 627, 364);
		panel.add(scrollPane);
		
		prepareTable();

	}

	private void prepareTable() {
		model = new DefaultTableModel();
		
		model.addColumn("รหัสนักศึกษา");
		model.addColumn("ชื่อ-นามสกุล");
		model.addColumn("สาขา");
		model.addColumn("อายุ");
		
		studentTable = new JTable(model);
		
		studentTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		studentTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		studentTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		
		studentTable.setFillsViewportHeight(true);
		
		scrollPane.add(studentTable);
		
		scrollPane.setViewportView(studentTable);
	}
}
