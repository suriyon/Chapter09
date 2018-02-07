package view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

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
		setFrameIcon(new ImageIcon(ShowStudentJFrame.class.getResource("/images32/list.png")));
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
		addStudentToTable();

	}

	private void addStudentToTable() {
		Vector students = new Vector<>();
		StudentController controller = new StudentController();
		students = controller.showStudent();
		
		//System.out.println(students.get(0).toString());
		
		int rows = model.getRowCount();
		if(rows > 0) {
			for(int i=0; i<rows; i++) {
				model.removeRow(0);
			}
		}
		
		int size = students.size();
		for(int i=0; i<size; i++) {
			model.addRow((Vector) students.get(i));
		}
	}

	private void prepareTable() {
		model = new DefaultTableModel();
		
		model.addColumn("รหัสนักศึกษา");
		model.addColumn("ชื่อ-นามสกุล");
		model.addColumn("สาขา");
		model.addColumn("อายุ");
		
		studentTable = new JTable(model);
		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		studentTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		studentTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		studentTable.getColumnModel().getColumn(2).setPreferredWidth(250);
		studentTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		
		studentTable.getTableHeader().setReorderingAllowed(false);
		
		studentTable.setFillsViewportHeight(true);
		
		scrollPane.add(studentTable);
		
		scrollPane.setViewportView(studentTable);
	}
}
