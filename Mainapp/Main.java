package Mainapp;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args)
    {
        try{
            Scanner scanner=new Scanner(System.in);
            ArrayList<Mood> MoodList=new ArrayList<>();
            String choice;
            while(true)
            {
                System.out.println("Enter a for add mood\nEnter d for deleting mood\nEnter e for modifying mood\nEnter s for searching mood\nEnter w to save the moods\nPress any other key to Exit");
                System.out.print("Enter choice");
                choice=scanner.nextLine();
                switch(choice)
                {
                    case "a":
                        String name;
                        String date;
                        String time;
                        String notes;

                        System.out.print("Enter the mood name:");
                        name=scanner.nextLine();
                        System.out.print("Enter the date in dd-mm-yyyy: ");
                        date=scanner.nextLine();
                        DateTimeFormatter adddateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate addDate= LocalDate.parse(date,adddateformatter);
                        time=scanner.nextLine();
                        DateTimeFormatter addtimeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                        LocalTime addtime=LocalTime.parse(time,addtimeFormatter);

                        System.out.print("Add notes");
                        notes=scanner.nextLine();

                        
                        for(Mood mood:MoodList)
                        {
                            if(mood.getdate().equals(addDate) && mood.gettime().equals(addtime))
                            {
                                throw new ElementPresentException("Mood is already present on given date and time");
                                
                            }
                        }
                        
                        
                        MoodList.add(new Mood(name,addDate,addtime,notes));                 
                        
                        break;

                    case "d":

                        int i=0;
                        String delname;
                        String deldate;
                        String deltime;
                        int choice1;

                        System.out.print("Enter 1 to delete all moods on a date\nEnter 2 to delete a specific mood\nEnter: ");
                        choice1=scanner.nextInt();
                        scanner.nextLine();
                        if(choice1==1)
                        {
                            System.out.print("Enter the date in format dd-mm-yyyy ");
                            deldate=scanner.nextLine();
                            DateTimeFormatter dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate newdate=LocalDate.parse(deldate,dateformatter);

                            for(i=0;i<MoodList.size();i++)
                            {
                                if(newdate.equals((MoodList.get(i)).getdate()))
                                {
                                    MoodList.remove(i);
                                    i--;
                                }
                            }
                        }
                        else if(choice1==2)
                        {
                            System.out.print("Enter the name: ");
                            delname=scanner.nextLine();

                            System.out.print("Enter the date in format dd-mm-yyyy ");
                            deldate=scanner.nextLine();
                            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate newdate=LocalDate.parse(deldate,formatter);

                            System.out.print("Enter the time in format HH:mm");
                            deltime=scanner.nextLine();
                            DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime newtime=LocalTime.parse(deltime,timeFormatter);

                            for(i=0;i<MoodList.size();i++)
                            {
                                if(delname.equals((MoodList.get(i)).getname()) &&
                                newdate.equals((MoodList.get(i)).getdate()) && 
                                newtime.equals((MoodList.get(i)).gettime()))
                                {
                                    MoodList.remove(i);
                                    break;
                                }
                            }
                        }

                        break;

                    case "e":
                        break;
                    case "s":
                        break;
                    case "w":
                        break;
                    default:
                        scanner.close();
                        return;
                }

            }
        }
        catch(ElementPresentException e){
            System.out.println(e.getMessage());
        }
    }
}


class ElementPresentException extends    Exception
{
    public ElementPresentException(String message)
    {
        super(message);
    }
}