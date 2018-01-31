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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchStudentJFrame extends JInternalFrame {
	private JScrollPane scrollPane;
	
	private JTable studentTable;
	private DefaultTableModel model;
	private JPanel panel_1;
	private JTextField textName;

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
					SearchStudentJFrame frame = new SearchStudentJFrame();
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
	public SearchStudentJFrame() {
		setTitle("Show All Students");
		setClosable(true);
		setBounds(100, 100, 683, 453);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Show All Students", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 84, 647, 328);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 627, 290);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search Student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 647, 62);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("กรอกชื่อที่ต้องการค้นหา");
		lblNewLabel.setBounds(76, 32, 127, 14);
		panel_1.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(199, 29, 215, 20);
		panel_1.add(textName);
		textName.setColumns(10);
		
		JButton btnSearch = new JButton("ค้นหา");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textName.getText().trim();
				addStudentToTable(name);
				
			}
		});
		btnSearch.setBounds(424, 28, 89, 23);
		panel_1.add(btnSearch);
		
		prepareTable();
		addStudentToTable();

	}

	protected void addStudentToTable(String name) {
		Vector students = new Vector<>();
		StudentController controller = new StudentController();
		students = controller.showStudentByName(name);
		
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
		
		studentTable.setFillsViewportHeight(true);
		
		scrollPane.add(studentTable);
		
		scrollPane.setViewportView(studentTable);
	}
}
