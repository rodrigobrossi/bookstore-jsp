import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame {
	
	private JTable table; 
	
	private String[][] rowData = {{"R1C1","R1C1"},{"R1C1","R1C1"},{"R1C1","R1C1"}};
	private String[] conlumns = {"C1","C2"};

	public Test() {
		// TODO Auto-generated constructor stub
		
		table = new JTable(this.rowData,this.conlumns);
		
		this.setLayout(new GridLayout(1, 1));
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		this.add(scrollPane);
		
		this.pack();
		
	}

	public static void main(String[] args) {
		
		Test x = new Test();
		x.setSize(new Dimension(300,300));
		x.setVisible(true);
		// TODO Auto-generated method stub

	}

}
