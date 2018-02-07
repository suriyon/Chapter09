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

public class UpdateStudentJFrame extends JInternalFrame {
	private JScrollPane scrollPane;
	
	private JTable studentTable;
	private DefaultTableModel model;
	private JPanel panel_1;
	private JTextField textSearch;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textId;
	private JTextField textName;
	private JTextField textBranch;
	private JTextField textAge;
	private JButton btnUpdate;

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
					UpdateStudentJFrame frame = new UpdateStudentJFrame();
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
	public UpdateStudentJFrame() {
		setFrameIcon(new ImageIcon(UpdateStudentJFrame.class.getResource("/images32/list.png")));
		setTitle("Show All Students");
		setClosable(true);
		setBounds(100, 100, 683, 453);
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
		btnSearch.setIcon(new ImageIcon(UpdateStudentJFrame.class.getResource("/images16/binocular.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textSearch.getText().trim();
				addStudentToTable(name);
				
			}
		});
		btnSearch.setBounds(424, 20, 50, 30);
		panel_1.add(btnSearch);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Edit Student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 263, 647, 149);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("รหัสนักศึกษา");
		lblNewLabel_1.setBounds(10, 28, 86, 14);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ชื่อ-นามสกุล");
		lblNewLabel_2.setBounds(130, 28, 86, 14);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("สาขาวิชา");
		lblNewLabel_3.setBounds(315, 28, 96, 14);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("อายุ");
		lblNewLabel_4.setBounds(537, 28, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setBounds(10, 53, 110, 20);
		panel_2.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(130, 53, 175, 20);
		panel_2.add(textName);
		textName.setColumns(10);
		
		textBranch = new JTextField();
		textBranch.setBounds(315, 53, 213, 20);
		panel_2.add(textBranch);
		textBranch.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(537, 53, 86, 20);
		panel_2.add(textAge);
		textAge.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(UpdateStudentJFrame.class.getResource("/images32/update.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textName.getText().equals("") || 
						textBranch.getText().equals("") || 
						textAge.getText().equals("") || 
						textId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบก่อน");
				} else {
					String id = textId.getText();
					String name = textName.getText();
					String branch = textBranch.getText();
					int age = Integer.parseInt(textAge.getText());
					
					Student student = new Student(id, name, branch, age);
					
					StudentController controller = new StudentController();
					boolean result = controller.update(student);
					
					if(result) {
						JOptionPane.showMessageDialog(null, "ปรับปรุงข้อมูลสำเร็จ");
					}else {
						JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาดในการปรับปรุงข้อมูล");
					}
					clearText();
					addStudentToTable();
				}
			}
		});
		btnUpdate.setBounds(260, 97, 121, 41);
		panel_2.add(btnUpdate);
		
		prepareTable();
		addStudentToTable();

	}

	protected void clearText() {
		// TODO Auto-generated method stub
		textId.setText("");
		textBranch.setText("");
		textName.setText("");
		textSearch.setText("");
		textAge.setText("");
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
				textId.setText(model.getValueAt(row, 0).toString());
				textName.setText(model.getValueAt(row, 1).toString());
				textBranch.setText(model.getValueAt(row, 2).toString());
				textAge.setText(model.getValueAt(row, 3).toString());
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
