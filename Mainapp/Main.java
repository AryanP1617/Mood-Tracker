package Mainapp;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args)
    {
        try{
            Scanner scanner=new Scanner(System.in);
            ArrayList<Mood> MoodList=new ArrayList<>();
            String choice;
            

            while(true)
            {
                System.out.println("Enter a for add mood\nEnter d for deleting mood\nEnter e for modifying mood\nEnter s for searching mood\nEnter w to save the moods\nEnter l to print your moods\nPress any other key to Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextLine().trim().toLowerCase();
                switch(choice)
                {
                    case "a":
                        String name;
                        String date;
                        String time;
                        String notes;

                        System.out.print("Enter the mood name: ");
                        name=scanner.nextLine();
                        System.out.print("Enter the date in dd-mm-yyyy: ");
                        date=scanner.nextLine();
                        DateTimeFormatter dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate newDate= LocalDate.parse(date,dateformatter);
                        System.out.print("Enter the time in HH:mm: ");
                        time=scanner.nextLine();
                        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                        LocalTime newtime=LocalTime.parse(time,timeFormatter);

                        System.out.print("Add notes");
                        notes=scanner.nextLine();

                        
                        for(Mood mood:MoodList)
                        {
                            if(mood.getdate().equals(newDate) && mood.gettime().equals(newtime))
                            {
                                throw new ElementPresentException("Mood is already present on given date and time");
                                
                            }
                        }
                        
                        
                        MoodList.add(new Mood(name,newDate,newtime,notes));
                        System.out.println("Mood added succesfully");                 
                        
                        break;

                    case "d":

                        int i=0;
                        int choice1;

                        System.out.print("Enter 1 to delete all moods on a date\nEnter 2 to delete a specific mood\nEnter: ");
                        choice1=scanner.nextInt();
                        scanner.nextLine();
                        if(choice1==1)
                        {
                            System.out.print("Enter the date in format dd-mm-yyyy ");
                            date=scanner.nextLine();
                            dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate newdate=LocalDate.parse(date,dateformatter);

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
                            name=scanner.nextLine();

                            System.out.print("Enter the date in format dd-mm-yyyy ");
                            date=scanner.nextLine();
                            dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate newdate=LocalDate.parse(date,dateformatter);

                            System.out.print("Enter the time in format HH:mm");
                            time=scanner.nextLine();
                            timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                            newtime=LocalTime.parse(time,timeFormatter);

                            for(i=0;i<MoodList.size();i++)
                            {
                                if(name.equals((MoodList.get(i)).getname()) &&
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
                        Mood node=null;
                        System.out.print("Enter the name: ");
                        name=scanner.nextLine();

                        System.out.print("Enter the date in dd-mm-yyyy: ");
                        date=scanner.nextLine();
                        dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        newDate = LocalDate.parse(date,dateformatter);
                        
                        System.out.print("Enter the time in format HH:mm");
                        time=scanner.nextLine();
                        timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                        newtime=LocalTime.parse(time,timeFormatter);

                          for(i=0;i<MoodList.size();i++)
                            {
                                if(name.equals((MoodList.get(i)).getname()) &&
                                newDate.equals((MoodList.get(i)).getdate()) && 
                                newtime.equals((MoodList.get(i)).gettime()))
                                {
                                    node=MoodList.get(i);
                                    break;
                                }
                            }

                        System.out.println("Enter the new notes");
                        String newnotes=scanner.nextLine();
                        node.setnewnotes(newnotes);

                        
                        break;
                    case "s":
                        int choice2;
                        System.out.println("MoodList size: " + MoodList.size());
                        System.out.print("Enter 1 to search all moods on a date\nEnter 2 to search a specific moof\nEnter: ");
                        choice2=scanner.nextInt();
                        scanner.nextLine();
                        
                        if(choice2==1)
                        {
                            System.out.print("Enter the date in dd-mm-yyyy: ");
                            date=scanner.nextLine();
                            dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            newDate = LocalDate.parse(date,dateformatter);

                            for(i=0;i<MoodList.size();i++)
                            {
                                if(newDate.equals((MoodList.get(i)).getdate()))
                                {
                                    System.out.println("The mood given is "+ (MoodList.get(i)).getname());
                                }
                            }
                        }
                        else if(choice2==2)
                        {
                            System.out.print("Enter the name: ");
                            name=scanner.nextLine();

                            System.out.print("Enter the date in dd-mm-yyyy: ");
                            date=scanner.nextLine();
                            dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            newDate = LocalDate.parse(date,dateformatter);

                            System.out.print("Enter the time in format HH:mm");
                            time=scanner.nextLine();
                            timeFormatter=DateTimeFormatter.ofPattern("HH:mm");
                            newtime=LocalTime.parse(time,timeFormatter);

                            for(i=0;i<MoodList.size();i++)
                            {
                                if(name.equals((MoodList.get(i)).getname()) &&
                                newDate.equals((MoodList.get(i)).getdate()) && 
                                newtime.equals((MoodList.get(i)).gettime()))
                                {
                                    System.out.println("The mood given is "+ (MoodList.get(i)).getname());
                                    break;
                                }
                            }
                        
                            break;
                        }
                        break;
                    case "w":
                        
                        FileWriter writer=new FileWriter("C:\\Users\\krish\\repos\\Mood Tracker\\Mood-Tracker\\Mainapp\\mood.txt");
                        BufferedWriter bufferedWriter=new BufferedWriter(writer);
                        for(Mood mood:MoodList)
                        {
                            
                            bufferedWriter.write(mood.toString());
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();

                        break;
                    case "l":
                        System.out.println("Enter 1 to print all your moods on a specific date\nEnter 2 to print all your moods");
                        System.out.print("Enter your choice: ");
                        int choice3=scanner.nextInt();

                       

                        if(choice3==1)
                        {   
                            System.out.print("Enter the date in dd-mm-yyyy: ");
                            date=scanner.nextLine();
                            dateformatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            newDate = LocalDate.parse(date,dateformatter);
                            for(Mood mood:MoodList)
                            {
                                if(mood.getdate().equals(newDate))
                                {
                                    System.out.println(mood.getdate()+" "+mood.gettime()+" "+mood.getname()+" "+mood.getnotes());
                                }
                                else if(!(mood.getdate().equals(newDate)))
                                {
                                    break;
                                }
                            }
                        }
                        else if(choice3==2)
                        {
                            for(Mood mood:MoodList)
                            {
                               
                                System.out.println(mood.getdate()+" "+mood.gettime()+" "+mood.getname()+" "+mood.getnotes());
                               
                            }
                            break;
                        }



                    default:
                        scanner.close();
                        return;
                }

            }
        }
        catch(ElementPresentException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("An error occured: "+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Error occured");
        }
    }
}


class ElementPresentException extends Exception
{
    public ElementPresentException(String message)
    {
        super(message);
    }
}