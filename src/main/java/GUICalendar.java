
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GUICalendar extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel lblMonthandYear, lblText;
    JButton btnPrev, btnNext, btnAdd;
    static JTable tblCal;
    Container pane;
    static DefaultTableModel defCal;
    static JScrollPane sCal;
    JPanel pnlCal;
    static int currentMonth, currentYear, currentDay, month, day, year;
    static int selectedRow, selectedCol;
    boolean annoyance = true;
    static boolean selectedCell = false;
    static FileWriter fw = null;
    File file = new File ("memory.txt");
	
   

    public GUICalendar(){   		
    	

        String [] week = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};
        
        currentMonth = 1;
        currentYear = 2017;
        currentDay = 9;

        this.setSize(900,500);
        this.setTitle("ICS4UR vs1.0");
        pane = this.getContentPane();
        pane.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setResizable(false);
        
        lblText = new JLabel();
        lblMonthandYear = new JLabel();
        
        btnPrev = new JButton("<");
        btnNext = new JButton(">");
        btnAdd = new JButton("+");
        btnAdd.setBackground(Color.PINK);
        defCal = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int col){
                return false;
            }
        };

        tblCal = new JTable(defCal);
        sCal = new JScrollPane(tblCal);
        pnlCal = new JPanel(null);

        pnlCal.setBorder(BorderFactory.createTitledBorder("calendar"));

        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnAdd.addActionListener(this);

        pane.add(pnlCal);
        pnlCal.add(lblMonthandYear);
        pnlCal.add(lblText);
        pnlCal.add(btnPrev);
        pnlCal.add(btnNext);
        pnlCal.add(btnAdd);
        pnlCal.add(sCal);

        this.setVisible(true);
        pnlCal.setBounds(0, 0,880, 460);
        lblMonthandYear.setBounds(190, 25, 100, 25);
        //lblText.setLocation(510, 25);
        lblText.setBounds(510, 25, 400, 400);
        lblText.setText("empty");
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(420, 25, 50, 25);
        btnAdd.setBounds(410, 390, 50, 50);
        tblCal.setBounds(10, 120, 460, 375);
        sCal.setBounds(10,65,460, 385);

        for(int i = 0; i < week.length; i++){
            defCal.addColumn(week[i]);
        }
        
        tblCal.getParent().setBackground(tblCal.getBackground());
        tblCal.getTableHeader().setResizingAllowed(false);

        tblCal.setColumnSelectionAllowed(true);
        tblCal.setRowSelectionAllowed(true);
        tblCal.setCellSelectionEnabled(true);
        tblCal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        tblCal.setRowHeight(60);
        defCal.setColumnCount(7);
        defCal.setRowCount(6);
    	

        changing(currentMonth, currentYear);


    }
    
    public static void reading(){
    	
    	//reads memory text
    	try{
    	String list="";
    	BufferedReader in;
    	in = new BufferedReader(new FileReader("memory.txt"));
    		String content = in.readLine();
    		
    		if(content!= null){
    		//GET THE WHILE LOOP TO WORK!!
    		while(content!=null){
    			if(selectedCell){
    				if(Integer.parseInt(content)== currentYear){
    					System.out.println(content);
    					content = in.readLine();
    					if(Integer.parseInt(content)==currentMonth){
    						System.out.println(content);
    						content = in.readLine();
    						if(Integer.parseInt(content)==selectedRow){
    							System.out.println(content);
    							content = in.readLine();
    							if(Integer.parseInt(content)==selectedCol){
    								System.out.println(content);
    								list += "\n" + in.readLine();
    								content = in.readLine();
    								System.out.println("HERE");
    								System.out.println(list+"\n"+content);
    								lblText.setText("<html>"+list + "<br>" + content+"</html>");
    								content = in.readLine();
    								System.out.println("A"+content);
    							}
    							else{
    								content = in.readLine();
    								content = in.readLine();
    								content = in.readLine();
    								System.out.println(content+"HEY");
    							}
    						}
    						else{
    							content = in.readLine();
    							content = in.readLine();
    							content = in.readLine();
    							content = in.readLine();
    						}
    					}
    					else{
    						content = in.readLine();
    						content = in.readLine();
    						content = in.readLine();
    						content = in.readLine();
    						content = in.readLine();
    					}
    				}
    				else{
    					content = in.readLine();
    					content = in.readLine();
    					content = in.readLine();
    					content = in.readLine();
    					content = in.readLine();
    					content = in.readLine();
    				}
    			}
    			else{
    				if(Integer.parseInt(content) == currentYear){
    					System.out.println(content);
    					content = in.readLine();
    				if(Integer.parseInt(content) == currentMonth){
    					System.out.println(content);
    					int row = Integer.parseInt(in.readLine());
    					System.out.println(row);
    					int col = Integer.parseInt(in.readLine());
    					System.out.println(col);
    					String name = in.readLine();
    					System.out.println(name);
    					//System.out.println(name);
    					content = in.readLine();
    					System.out.println(content);
    					defCal.setValueAt(defCal.getValueAt(row, col)+ "\n" + name, row, col);
    					lblText.setText(name + "\n" + content);
    					content = in.readLine();
    					System.out.println("H"+content);
    				}
    				}
    			}
    			
    		}
    		in.close();
    	}

    	in.close();
    	}
    	catch(FileNotFoundException e){
    		System.out.println("Error: Cannot open file for reading.");
    	}
    	catch (EOFException e){
    		System.out.println("Error: EOF encountered, file may be corrupt.");
    	}
    	catch(IOException e){
    		System.out.println("Error: Cannot read from file.");
    	}
    	
    	
    }

    public void actionPerformed(ActionEvent e){
    	
    	if(e.getActionCommand().equals("<")){
    		if(currentMonth == 0){
    			currentMonth = 11;
    			currentYear -= 1;
    		}
    		else{
    			currentMonth -= 1;
    		}
    		selectedCell = false;
    		changing1(currentMonth, currentYear);
    		//reading();
    	}
    	else if(e.getActionCommand().equals(">")){
    		if(currentMonth == 11){
    			currentMonth = 0;
    			currentYear += 1;
    		}
    		else{
    			currentMonth+=1;
    		}
    		selectedCell = false;
    		changing1(currentMonth, currentYear);
    		//reading();
    	}
    	else{
    		try{
    		if(defCal.getValueAt(selectedRow, selectedCol)==null){
    			JOptionPane.showMessageDialog(pnlCal, "Selected invalid cell.");
    			
        	}
    		else{
    			String name;
    			String from;
    			String to;
    			name = JOptionPane.showInputDialog("Event Name");
    			from = JOptionPane.showInputDialog("From: ");
    			to = JOptionPane.showInputDialog("To: ");
    			
    			System.out.println(selectedRow + " " + selectedCol);
    			
    			defCal.setValueAt(defCal.getValueAt(selectedRow, selectedCol)+ "\n" +name, selectedRow, selectedCol);
    			
    			sDate sday = new sDate(currentYear, currentMonth+1, currentDay+1, sDate.gethrs(from), sDate.getmin(from));
    			sDate sday1 = new sDate(currentYear, currentMonth+1, currentDay+1, sDate.gethrs(to), sDate.getmin(to));
    			
    			Schedule temp = new Event (sday, sday1, name);
        		
        		BufferedWriter out;
        			
        		if(annoyance){
        			fw = new FileWriter(file, true);
        			annoyance = false;
        		}
    //IT WON'T APPEND IF PROGRAM DOESN'T CLOSE.
        			
        			out = new BufferedWriter(fw);
            		out.append(Integer.toString(currentYear));
            		out.newLine();
            		out.append("" + currentMonth);
            		out.newLine();
            		out.append("" + selectedRow);
            		out.newLine();
            		out.append("" + selectedCol);
            		out.newLine();
            		out.append(temp.toString());
            		out.newLine();
            		out.close();
        		
        		defCal.setValueAt(defCal.getValueAt(selectedRow, selectedCol)+ "\n" +name, selectedRow, selectedCol);
        				
    		}
    		}
    		
    		catch(FileNotFoundException e1){
    			System.out.println ("Error: Cannot open file for writing");
    		}
    		catch (IOException e1){
    			System.out.println ("Error: Cannot write to file");
    		}
        	
        	}
    
    	
    }
    
    public static void changing1(int month, int year){
    	
        String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int numDays, chosenMonth;
        lblMonthandYear.setText(months[month] + " " + Integer.toString(year));

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                defCal.setValueAt(null, i, j);
            }
        }
        
        
        if(month == 1){
        	if((year%4)==0){
        		numDays = 29;
        	}
        	else{
        		numDays = 28;
        	}
        	
        }
        else if(month <= 6){
        	if((month%2)==0){
        		numDays = 31;
        	}
        	else{
        		numDays = 30;
        	}
        	
        }
        else if(month > 6){
        	if((month%2)==0){
        		numDays = 30;
        	}
        	else{
        		numDays = 31;
        	}
        }
        else{
        	numDays = 0;
        }
        
        GregorianCalendar temp = new GregorianCalendar(year,month,1);
        chosenMonth = temp.get(GregorianCalendar.DAY_OF_WEEK);
        
        for(int i = 1; i <= numDays; i++){
        	int row = new Integer((i+chosenMonth-2)/7);
        	int col = (i+chosenMonth-2)%7;
        	defCal.setValueAt(i, row, col);
        }
        
        
        
        tblCal.setDefaultRenderer(tblCal.getColumnClass(0), new tblCalRenderer());

    }

    public static void changing(int month, int year){
    	
        String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int numDays, chosenMonth;
        lblMonthandYear.setText(months[month] + " " + Integer.toString(year));

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                defCal.setValueAt(null, i, j);
            }
        }
        
        
        if(month == 1){
        	if((year%4)==0){
        		numDays = 29;
        	}
        	else{
        		numDays = 28;
        	}
        	
        }
        else if(month <= 6){
        	if((month%2)==0){
        		numDays = 31;
        	}
        	else{
        		numDays = 30;
        	}
        	
        }
        else if(month > 6){
        	if((month%2)==0){
        		numDays = 30;
        	}
        	else{
        		numDays = 31;
        	}
        }
        else{
        	numDays = 0;
        }
        
        GregorianCalendar temp = new GregorianCalendar(year,month,1);
        chosenMonth = temp.get(GregorianCalendar.DAY_OF_WEEK);
        
        for(int i = 1; i <= numDays; i++){
        	int row = new Integer((i+chosenMonth-2)/7);
        	int col = (i+chosenMonth-2)%7;
        	defCal.setValueAt(i, row, col);
        }
        
        
        
        tblCal.setDefaultRenderer(tblCal.getColumnClass(0), new tblCalRenderer());
        System.out.println("STEPH");
        reading();

    }
    
    static class tblCalRenderer extends DefaultTableCellRenderer{
 
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
    	super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
    	if(hasFocus){
    		setBackground(Color.cyan);
    		selectedRow = table.getSelectedRow();
    		selectedCol = table.getSelectedColumn();
    		System.out.println("CLICKED");
    		System.out.println(selectedRow + " " + selectedCol);
    		//CHANGING TO LABEL
    		//currentDay = (int) defCal.getValueAt(selectedRow, selectedCol);
    		selectedCell = true;
    		lblText.setText("empty");
    		reading();
    		
    	}
    	else if(isSelected){
    		setBackground(table.getSelectionBackground());
    	}
    	else{
    		setBackground(table.getBackground());
    	}

    	return this;
    	}
    }

    public static void main (String [] args){
        GUICalendar hello = new GUICalendar();
    }


}