public class Test {
    public void test(Body M1, Body M2, Body M3, int[] F, int[] t){
        int m1 = M1.getMass();
        int m2 = M2.getMass();
        int m3 = M3.getMass();

        int g = 10;

        double mu1 = M1.getFricCoeff();
        double mu2 = M2.getFricCoeff();
        double mu3 = M3.getFricCoeff();

        double x1 = (double) M1.getPosX();
        double x2 = (double) M2.getPosX();
        double x3 = (double) M3.getPosX();
        double y1 = (double) M1.getPosY();
        double y2 = (double) M2.getPosY();
        double y3 = (double) M3.getPosY();

        double V1 = 0;
        double V2 = 0;
        double V3 = 0;

        for(int i = 0; i < F.length; ++i){
            int currF = F[i];
            double currMu1;
            double currMu2;
            double currMu3;
            if(currF < 0){
                currMu1 = -1*mu1;
                currMu2 = -1*mu2;
                currMu3 = -1*mu3;
            }
            else{
                currMu1 = mu1;
                currMu2 = mu2;
                currMu3 = mu3;
            }
            int currT = t[i];

            System.out.println("Force Applied: " + currF + ", time: " + currT);
            System.out.println("X1: " + x1 + ", Y1: " + y1);
            System.out.println("X2: " + x2 + ", Y2: " + y2);
            System.out.println("X3: " + x3 + ", Y3: " + y3);
            System.out.println("=====================================================");
            double f2 = mu2*m2*g;
            double a1Upp = (-currF*m3 + currMu1*m1*m3*g - m3*f2 - currMu1*m3*f2 + m2*m3*g + currMu1*m2*m3*g - currF*m2 + currMu1*m1*m2*g);
            double a1Low = (-2*m1*m2 - 2*m2*m3 + currMu1*m2*m3 + currMu1*currMu3*m3*m3 - m3*m3 - currMu3*m2*m3);
            double a1 = a1Upp / a1Low;
            double N1 = (m1*g + currF - currMu3*m3*a1 - m1*a1 - m3*a1) / (1 + currMu1);
            double a2 = (currF - currMu1*N1 - m2*g - m1*a1 - m3*a1 + f2) / m2;
            double a3y = a1 - a2;

            double S1 = V1*currT + 1/2*a1*currT*currT;
            double S2 = V2*currT + 1/2*a2*currT*currT;
            double S3 = V3*currT + 1/2*a3y*currT*currT;

            if(S2 >= x1-x2){
                x2 = x1;
                V2 = 0;
                V3 = 0;
            }
            else if(S3 > y1-y3){
                y3 = y1;
                V2 = 0;
                V3 = 0;
            }
            else{
                V1 = V1 + a1*currT;
                V2 = V2 + a2*currT;
                V3 = V3 + a3y*currT;
                x1 = x1 + S1;
                x2 = x2 + S2;
                y3 = y3 + S3;
            }

        }
    }
}
