/*
Basic NetworkTables desktop client
 */

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("datatable");
        NetworkTableEntry xEntry = table.getEntry("x");
        NetworkTableEntry yEntry = table.getEntry("y");
        inst.startClientTeam(4201);
        inst.startDSClient();  // recommended if running on DS computer; this gets the robot IP from the DS
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("interrupted");
                return;
            }
            double x = xEntry.getDouble(0.0);
            double y = yEntry.getDouble(0.0);
            System.out.println("X: " + x + " Y: " + y);
        }
    }
}