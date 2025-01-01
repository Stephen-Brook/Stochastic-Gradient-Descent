import java.util.*;
public class functionGradientDescent {
    public static void main(String args[]) {
        double[][] data = {
                {1240, 145000},
                {370, 68000},
                {1130, 115000},
                {1120, 69000},
                {1710, 163000},
                {1010, 69900},
                {860, 50000},
                {1420, 137000},
                {1270, 121300},
                {1160, 70000},
                {1220, 64500},
                {1690, 167000},
                {1380, 114600},
                {1590, 103000},
                {1050, 101000},
                {770, 50000},
                {1410, 85000},
                {1060, 22500},
                {1300, 90000},
                {1500, 133000},
                {820, 90500},
                {2130, 260000},
                {1170, 142500},
                {1500, 160000},
                {2790, 240000},
                {1030, 87000},
                {1250, 118600},
                {1760, 140000},
                {1550, 148000},
                {1450, 65000},
                {2000, 176000},
                {1350, 86500},
                {1840, 180000},
                {2510, 179000},
                {3110, 338000},
                {1760, 130000},
                {1120, 77300},
                {1110, 125000},
                {1360, 100000},
                {1250, 100000},
                {1250, 100000},
                {1480, 146500},
                {1520, 144900},
                {2020, 183000},
                {1220, 77000},
                {1640, 60000},
                {940, 127000},
                {1580, 86000},
                {1270, 95000},
                {2440, 270500},
                {1520, 75000},
                {980, 81000},
                {2300, 188000},
                {1430, 85000},
                {1380, 137000},
                {1010, 92900},
                {1780, 93000},
                {1120, 109300},
                {1900, 131500},
                {2430, 200000},
                {1080, 81900},
                {1350, 91200},
                {1720, 124500},
                {4050, 225000},
                {1500, 136500},
                {2530, 268000},
                {1020, 70700},
                {2070, 70000},
                {1520, 140000},
                {1280, 89900},
                {1620, 137000},
                {1520, 103000},
                {2030, 183000},
                {1390, 140000},
                {1880, 160000},
                {2780, 192000},
                {1340, 130000},
                {940, 123000},
                {580, 21000},
                {1410, 85000},
                {1150, 69900},
                {1380, 125000},
                {1470, 162600},
                {1590, 156900},
                {1200, 105900},
                {1920, 167500},
                {2150, 151800},
                {2200, 118300},
                {860, 94300},
                {1230, 93900},
                {1140, 165000},
                {2650, 285000},
                {1060, 45000},
                {1770, 124900},
                {1860, 147000},
                {1060, 176000},
                {1730, 196500},
                {1370, 132200},
                {1560, 88400},
                {1340, 127200}
        };

        //learning rate
        double learning_rate = 0.000001;    //can be altered
        //decay rates and steps
        double decay_rate = 0.9;    //can be altered
        int decay_steps = 5;    //can be altered

        Random random = new Random();
        //initialize slope and intercept as random numbers n, where -0.01 <= n <= 0.01

        //update theta2 to be a 1xn vector
        double slope = (random.nextDouble() * 0.02 - 0.01);
        double intercept = random.nextDouble() * 0.02 - 0.01;

        //define the number of iterations SGD will run
        int num_iterations = 10000000;  //can be altered

        double slope_gradient = 0.0;
        double intercept_gradient = 0.0;

        for (int i = 0; i < num_iterations; i++) {
            //update to account for slope_gradient being a vector
            slope_gradient = 0.0;
            intercept_gradient = 0.0;

            int num_data = random.nextInt(data.length);
            for (int j = 0; j < num_data; j++) {
                int random_index = random.nextInt(data.length);
                double x_i = (data[random_index][0]);
                double y_i = data[random_index][1];

                double predicted_y = (slope*x_i + intercept);

                //update to account for slope_gradient and x_i being 1xn vectors
                slope_gradient += -x_i*(y_i - predicted_y);

                intercept_gradient += -(y_i - predicted_y);
            }

            //update parameters
            //update to account for slope being a 1xn vector
            slope -= learning_rate * (slope_gradient/data.length);
            intercept -= learning_rate * (intercept_gradient / data.length);

            //update the learning rate
            if(i != 0 && decay_steps % i ==0){
                learning_rate *= decay_rate;
            }
        }
        System.out.println("y = " + slope + "x + " + intercept);
    }
}