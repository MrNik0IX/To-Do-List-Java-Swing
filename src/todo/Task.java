package todo;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class Task {

	//Taskattributes 
	private static int taskIdGen;
	private int taskId;
	private String taskTitle;
	private String taskDescription;
	private Date taskDueDate;
	private byte taskPriority;
	private short taskProgress = 0;
	private boolean isDone = false;
	private static HashMap<Integer, Task> allTasks = new HashMap<Integer, Task>();
	
	//Constructor
	public Task(String taskTitle, String taskDescription, java.util.Date taskDueDate, byte taskPriority) {

		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskDueDate = taskDueDate;
		this.taskPriority = taskPriority;
		taskId=++taskIdGen;
		allTasks.put(this.taskId, this);
	}
	
	
	
public int getTaskAmount() {
	return taskIdGen;
}


	//Getter and Setter
	public int getTaskId() {
		return taskId;
		
	}

	public static HashMap<Integer, Task> getAllTasks() {
		return allTasks;
	}
	public String getTaskTitle() {
		return taskTitle;
	}


	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
		
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public Date getTaskDueDate() {
		return taskDueDate;
	}


	public void setTaskDueDate(Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}


	public byte getTaskPriority() {
		return taskPriority;
	}


	public void setTaskPriority(byte taskPriority) {
		this.taskPriority = taskPriority;
	}


	public short getTaskProgress() {
		return taskProgress;
	}


	public void setTaskProgress(short taskProgress) {
		this.taskProgress = taskProgress;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public JPanel readTask() {
		JPanel taskDisplayPanel = new JPanel(new FlowLayout());
		taskDisplayPanel.add(new JLabel(Integer.toString(taskId)));
		taskDisplayPanel.add(new JLabel(taskTitle));
		taskDisplayPanel.add(new JLabel(taskDescription));
		taskDisplayPanel.add(new JLabel(taskDueDate.toString()));
		taskDisplayPanel.add(new JLabel(Integer.toString(taskPriority)));
		JButton button = new JButton();

		
		
		button.addActionListener(e->{
			deleteTask();
			JFrame appWindow = (JFrame) SwingUtilities.windowForComponent(button);
			System.out.println(button.getParent().getParent().getParent());
			JPanel taskPanel = (JPanel) button.getParent().getParent().getParent();
			
			taskPanel.removeAll();
			taskPanel.add(readTasks());
			appWindow.revalidate();
			});
		taskDisplayPanel.add(button);
		return taskDisplayPanel;
	}
	
	public static JPanel readTasks() {
		JPanel taskDisplayPanel = new JPanel(new FlowLayout());
		for (int taskId : allTasks.keySet()) {
			taskDisplayPanel.add(allTasks.get(taskId).readTask());
			}
		return taskDisplayPanel;
		}
	
	
	
	public static void printAllTasks() {
		for (int taskId : allTasks.keySet()) {
			System.out.println(allTasks.get(taskId));
		}
	}
	
	public void deleteTask() {
		allTasks.remove(taskId);
		
	}
	
}
