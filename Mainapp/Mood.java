package Mainapp;
import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;

    public Mood(String name,LocalDate date,LocalTime time)
    {
        this.name=name;
        this.time=time;
        this.date=date;
    }

    public Mood(String name,LocalDate date,LocalTime time,String notes)
    {
        this.name=name;
        this.time=time;
        this.date=date;
        this.notes=notes;
    }

    public String getname()
    {
        return name;
    }

    public LocalDate getdate()
    {
        return date;
    }

    public LocalTime gettime()
    {
        return time;
    }

    public String getnotes()
    {
        return notes;
    }

    public void setnewnotes(String newnotes)
    {
        this.notes=newnotes;
    }

    @Override
    public String toString()
    {
        return "Mood[name ="+name+",date="+date+"time:"+time+"\nNotes:"+notes+" ]";
    }
}

