package view;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import model.Student;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class DeleteStudentJFrame extends JInternalFrame {
	private JScrollPane scrollPane;
	
	private JTable studentTable;
	private DefaultTableModel model;
	private JPanel panel_1;
	private JTextField textSearch;
	
	private String id;

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
					DeleteStudentJFrame frame = new DeleteStudentJFrame();
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
	public DeleteStudentJFrame() {
		setFrameIcon(new ImageIcon(DeleteStudentJFrame.class.getResource("/images32/delete.png")));
		setTitle("Delete Students");
		setClosable(true);
		setBounds(100, 100, 683, 361);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Show All Students", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 84, 647, 168);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 627, 127);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search Student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 647, 62);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("กรอกชื่อที่ต้องการค้นหา");
		lblNewLabel.setBounds(76, 32, 127, 14);
		panel_1.add(lblNewLabel);
		
		textSearch = new JTextField();
		textSearch.setBounds(199, 29, 215, 20);
		panel_1.add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(DeleteStudentJFrame.class.getResource("/images16/binocular.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textSearch.getText().trim();
				addStudentToTable(name);
				
			}
		});
		btnSearch.setBounds(424, 20, 50, 30);
		panel_1.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(DeleteStudentJFrame.class.getResource("/images32/delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentController controller = new StudentController();
				boolean result = controller.delete(id);
				
				if(result) {
					JOptionPane.showMessageDialog(null, "ลบข้อมูลสำเร็จ");
				}else {
					JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาดในการลบข้อมูล");
				}
				
				addStudentToTable();
			}
		});
		btnDelete.setBounds(276, 274, 128, 42);
		getContentPane().add(btnDelete);
		
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
		
		studentTable = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int row = studentTable.getSelectedRow();
				id = model.getValueAt(row, 0).toString();
			}
		});
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
