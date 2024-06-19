package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "list", schema = "todolistapp")
public class ListEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "taskID")
    private int taskId;
    @Basic
    @Column(name = "Task")
    private String task;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListEntity that = (ListEntity) o;

        if (taskId != that.taskId) return false;
        if (task != null ? !task.equals(that.task) : that.task != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return task;
    }
}
