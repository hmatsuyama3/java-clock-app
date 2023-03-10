import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    //Instances of these objects will go in the constructor.
    SimpleDateFormat timeFormat; //use this class to arrange date/time the way we want
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel; //Use this to display the time
    JLabel dateLabel;
    JLabel dayLabel;
    //Need string to store the time/day info to display
    String time;
    String date;
    String day;



    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Java Clock App");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);

        //Create these instances before setting to visible
        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //pass in a format specifier. how do we want the date to display? ->check to oracle documentation
        timeLabel = new JLabel();

        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.green);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true); //need this for background to show up

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 40));

        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 30));


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        //Need a way to make sure the time is updated every second. Otherwise, you only get the static display of when the swing box was first created.
        setTime();
    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try{
                Thread.sleep(1000); //makes this main thread sleep for 1000ms and update again.
                //it needs a try-catch block because it comes with an InterruptedException e that needs handled.
            }catch(InterruptedException e){
                System.out.println("Your clock broke");
                e.printStackTrace();
            }

        }

    }
}
