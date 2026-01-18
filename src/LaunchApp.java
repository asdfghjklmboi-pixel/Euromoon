import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchApp implements ActionListener {

    JButton regPassenger, createTrip, assignTrain, sellTicket, printBoardingList;
    JFrame frame;

    public LaunchApp(){
        regPassenger = new JButton("Register Passenger");
        regPassenger.setBounds(150, 10, 200, 100);
        regPassenger.addActionListener(this);

        createTrip = new JButton("Create Trip");
        createTrip.setBounds(150, 50, 200, 100);
        createTrip.addActionListener(this);

        assignTrain = new JButton("Assign Train to Trip");
        assignTrain.setBounds(150, 100, 200, 100);
        assignTrain.addActionListener(this);

        sellTicket = new JButton("Sell Ticket to Passenger");
        sellTicket.setBounds(150, 150, 200, 100);
        sellTicket.addActionListener(this);

        printBoardingList = new JButton("Print Boarding List");
        printBoardingList.setBounds(150, 200, 200, 100);
        printBoardingList.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(regPassenger);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()==regPassenger){
       }
    }
}
