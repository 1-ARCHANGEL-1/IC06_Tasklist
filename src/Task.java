import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable
{
    private String mName;
    private String mDueDate;
    private String mDeadline;
    private int mPriority;

    public Task(String mName, String mDueDate, String mDeadline, int mPriority) {
        this.mName = mName;
        this.mDueDate = mDueDate;
        this.mDeadline = mDeadline;
        this.mPriority = mPriority;
    }
    public Task(Task copyTask)
    {
        this(copyTask.mName,copyTask.mDeadline,copyTask.mDueDate,copyTask.mPriority);
    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDueDate() {
        return mDueDate;
    }

    public void setmDueDate(String mDueDate) {
        this.mDueDate = mDueDate;
    }

    public String getmDeadline() {
        return mDeadline;
    }

    public void setmDeadline(String mDeadline) {
        this.mDeadline = mDeadline;
    }

    public int getmPriority() {
        return mPriority;
    }

    public void setmPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    @Override
    public String toString() {
        String priority;
        switch (mPriority){
            case 1:
                priority = "High";
                break;
            case 2:
                priority = "Medium";
                break;
            case 3:
                priority = "Low";
                break;
            default: priority = "Unknown";
        }

        return "Task{" +
                " mName='" + mName + '\'' +
                ", mDueDate='" + mDueDate + '\'' +
                ", mDeadline='" + mDeadline + '\'' +
                ", mPriority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mPriority == task.mPriority && Objects.equals(mName, task.mName) && Objects.equals(mDueDate, task.mDueDate) && Objects.equals(mDeadline, task.mDeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mDueDate, mDeadline, mPriority);
    }
}
