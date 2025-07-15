package todo;
import java.awt.FlowLayout;
import java.util.Date;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	//Constructor
	public Task(String taskTitle, String taskDescription, java.util.Date taskDueDate, byte taskPriority) {

		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskDueDate = taskDueDate;
		this.taskPriority = taskPriority;
		taskId=++taskIdGen;
	}
	
	
	
public int getTaskAmount() {
	return taskIdGen;
}


	//Getter and Setter
	public int getTaskId() {
		return taskId;
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
	
	public JPanel displayTask() {
		JPanel taskDisplayPanel = new JPanel(new FlowLayout());
		taskDisplayPanel.add(new JLabel(Integer.toString(taskId)));
		taskDisplayPanel.add(new JLabel(taskTitle));
		taskDisplayPanel.add(new JLabel(taskDescription));
		taskDisplayPanel.add(new JLabel(taskDueDate.toString()));
		taskDisplayPanel.add(new JLabel(Integer.toString(taskPriority)));
		return taskDisplayPanel;
	}
	
}
