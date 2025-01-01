import java.util.*;
public class smallStochasticGradientDescent {
    public static void main(String args[]) {
        double[][] data = {
                {1240, 2, 3, 145000},
                {370, 1, 1, 68000},
                {1130, 1.5, 3, 115000},
                {1120, 2, 3, 69000},
                {1710, 2, 3, 163000},
                {1010, 2, 3, 69900},
                {860, 2, 2, 50000},
                {1420, 2, 3, 137000},
                {1270, 2, 3, 121300},
                {1160, 2, 3, 70000},
                {1220, 2, 3, 64500},
                {1690, 2, 3, 167000},
                {1380, 2, 3, 114600},
                {1590, 2, 3, 103000},
                {1050, 1, 3, 101000},
                {770, 1, 2, 50000},
                {1410, 2, 3, 85000},
                {1060, 1, 3, 22500},
                {1300, 2, 2, 90000},
                {1500, 2, 3, 133000},
                {820, 1, 2, 90500},
                {2130, 2.5, 3, 260000},
                {1170, 1, 2, 142500},
                {1500, 2, 3, 160000},
                {2790, 2, 4, 240000},
                {1030, 1, 3, 87000},
                {1250, 2, 3, 118600},
                {1760, 2, 3, 140000},
                {1550, 3, 2, 148000},
                {1450, 1.5, 3, 65000},
                {2000, 2, 4, 176000},
                {1350, 1, 3, 86500},
                {1840, 2, 3, 180000},
                {2510, 2, 4, 179000},
                {3110, 3, 3, 338000},
                {1760, 2, 4, 130000},
                {1120, 1.5, 3, 77300},
                {1110, 1, 2, 125000},
                {1360, 2, 3, 100000},
                {1250, 1, 3, 100000},
                {1250, 1, 3, 100000},
                {1480, 2, 3, 146500},
                {1520, 2, 3, 144900},
                {2020, 2, 3, 183000},
                {1220, 1.5, 3, 77000},
                {1640, 2, 2, 60000},
                {940, 2, 2, 127000},
                {1580, 2, 3, 86000},
                {1270, 2.5, 3, 95000},
                {2440, 2.5, 4, 270500},
                {1520, 1.5, 4, 75000},
                {980, 1, 2, 81000},
                {2300, 2, 4, 188000},
                {1430, 2, 3, 85000},
                {1380, 2, 3, 137000},
                {1010, 1.5, 3, 92900},
                {1780, 1.5, 3, 93000},
                {1120, 2, 3, 109300},
                {1900, 2, 3, 131500},
                {2430, 3, 4, 200000},
                {1080, 2, 3, 81900},
                {1350, 1, 2, 91200},
                {1720, 3, 4, 124500},
                {4050, 3, 3, 225000},
                {1500, 2, 3, 136500},
                {2530, 2.5, 4, 268000},
                {1020, 1.5, 3, 70700},
                {2070, 2.5, 4, 70000},
                {1520, 2, 3, 140000},
                {1280, 2, 2, 89900},
                {1620, 2, 3, 137000},
                {1520, 2, 3, 103000},
                {2030, 2, 3, 183000},
                {1390, 2, 3, 140000},
                {1880, 2, 4, 160000},
                {2780, 2.5, 4, 192000},
                {1340, 1, 2, 130000},
                {940, 2, 2, 123000},
                {580, 1, 2, 21000},
                {1410, 2, 4, 85000},
                {1150, 2, 3, 69900},
                {1380, 2, 3, 125000},
                {1470, 2, 3, 162600},
                {1590, 2, 2, 156900},
                {1200, 2, 3, 105900},
                {1920, 2, 3, 167500},
                {2150, 2, 3, 151800},
                {2200, 3, 5, 118300},
                {860, 2, 2, 94300},
                {1230, 1, 3, 93900},
                {1140, 2, 4, 165000},
                {2650, 3, 4, 285000},
                {1060, 1, 3, 45000},
                {1770, 2, 3, 124900},
                {1860, 2, 4, 147000},
                {1060, 2, 2, 176000},
                {1730, 2, 3, 196500},
                {1370, 2, 3, 132200},
                {1560, 2, 3, 88400},
                {1340, 2, 3, 127200}
        };

        //learning rate
        double learning_rate = 0.000001;    //can be altered
        //decay rates and steps
        double decay_rate = 0.9;    //can be altered
        int decay_steps = 5;    //can be altered

        Random random = new Random();
        //initialize slope and intercept as random numbers n, where -0.01 <= n <= 0.01

        //update theta2 to be a 1xn vector
        double[] slope = {
                (random.nextDouble() * 0.02 - 0.01),
                (random.nextDouble() * 0.02 - 0.01),
                (random.nextDouble() * 0.02 - 0.01)
        };
        double intercept = random.nextDouble() * 0.02 - 0.01;

        //define the number of iterations SGD will run
        int num_iterations = 1000000000;  //can be altered

        //define two variables for gradients
        //update slope_gradient to be a 1xn vector
        double[] slope_gradient = {
                0.0,
                0.0,
                0.0
        };
        double intercept_gradient = 0.0;

        for (int i = 0; i < num_iterations; i++) {
            //update to account for slope_gradient being a vector
            slope_gradient[0] = 0.0;
            slope_gradient[1] = 0.0;
            slope_gradient[2] = 0.0;
            intercept_gradient = 0.0;

            int num_data = random.nextInt(data.length);
            for (int j = 0; j < num_data; j++) {
                int random_index = random.nextInt(data.length);
                //update x_i to be a 1xn vector
                double[] x_i = {
                        (data[random_index][0]),
                        (data[random_index][1]),
                        (data[random_index][2]),
                };
                double y_i = data[random_index][3];

                double predicted_y = (slope[0]*x_i[0] + slope[1]*x_i[1] + slope[2]*x_i[2]) + intercept;

                //update to account for slope_gradient and x_i being 1xn vectors
                slope_gradient[0] += -x_i[0]*(y_i - predicted_y);
                slope_gradient[1] += -x_i[1]*(y_i - predicted_y);
                slope_gradient[2] += -x_i[2]*(y_i - predicted_y);

                intercept_gradient += -(y_i - predicted_y);
            }

            //update parameters
            //update to account for slope being a 1xn vector
            slope[0] -= learning_rate * (slope_gradient[0]/data.length);
            slope[1] -= learning_rate * (slope_gradient[1]/data.length);
            slope[2] -= learning_rate * (slope_gradient[2]/data.length);
            intercept -= learning_rate * (intercept_gradient / data.length);

            //update the learning rate
            if(i != 0 && decay_steps % i ==0){
                learning_rate *= decay_rate;
            }
        }
        int[] sqft = {
                1240, 370, 1130, 1120, 1710, 1010, 860, 1420, 1270, 1160,
                1220, 1690, 1380, 1590, 1050, 770, 1410, 1060, 1300, 1500,
                820, 2130, 1170, 1500, 2790, 1030, 1250, 1760, 1550, 1450,
                2000, 1350, 1840, 2510, 3110, 1760, 1120, 1110, 1360, 1250,
                1250, 1480, 1520, 2020, 1220, 1640, 940, 1580, 1270, 2440,
                1520, 980, 2300, 1430, 1380, 1010, 1780, 1120, 1900, 2430,
                1080, 1350, 1720, 4050, 1500, 2530, 1020, 2070, 1520, 1280,
                1620, 1520, 2030, 1390, 1880, 2780, 1340, 940, 580, 1410,
                1150, 1380, 1470, 1590, 1200, 1920, 2150, 2200, 860, 1230,
                1140, 2650, 1060, 1770, 1860, 1060, 1730, 1370, 1560, 1340
        };
        double[] numBathrooms = {
                2, 1, 1.5, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 1, 1, 2, 1, 2, 2,
                1, 2.5, 1, 2, 2, 1, 2, 2, 3, 1.5,
                2, 1, 2, 2, 3, 2, 1.5, 1, 2, 1,
                1, 2, 2, 2, 1.5, 2, 2, 2, 2.5,
                2.5, 1.5, 1, 2, 2, 2, 1.5, 1.5,
                2, 2, 3, 2, 1, 3, 3, 2, 2.5,
                1.5, 2.5, 2, 2, 2, 2, 2, 2,
                2, 2.5, 1, 2, 1, 2, 2, 2,
                2, 2, 2, 2, 2, 3, 2, 1,
                2, 3, 1, 2, 2, 2, 2, 2,
                2, 2
        };
        int[] numBedrooms = {
                3, 1, 3, 3, 3, 3, 2, 3, 3, 3,
                3, 3, 3, 3, 3, 2, 3, 3, 2, 3,
                2, 3, 2, 3, 4, 3, 3, 3, 2, 3,
                4, 3, 3, 4, 3, 4, 3, 2, 3, 3,
                3, 3, 3, 3, 3, 2, 2, 3, 3, 4,
                4, 2, 4, 3, 3, 3, 3, 3, 3, 4,
                3, 2, 4, 3, 3, 4, 3, 4, 3, 2,
                3, 3, 3, 3, 4, 4, 2, 2, 2, 4,
                3, 3, 3, 2, 3, 3, 3, 5, 2, 3,
                4, 4, 3, 3, 4, 2, 3, 3, 3, 3
        };
        for(int i = 0; i < sqft.length; i++){
            int size = sqft[i];
            double bathrooms = numBathrooms[i];
            int bedrooms = numBedrooms[i];
            double price = (slope[0]*size + slope[1]*bathrooms + slope[2]*bedrooms) + intercept;
            //System.out.println("\nThe estimated cost for a house with " + size + " square feet, " + bathrooms + " bathrooms, and " + bedrooms + " bedrooms is: $" + price);
            System.out.println(size + ", " + price);
        }
    }
}