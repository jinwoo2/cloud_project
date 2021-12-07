import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import java.util.Scanner;
import java.io.IOException;

public class procjet {
    public static void main(String[] arg) {
//        init();
        Region region = Region.US_EAST_2;
        System.out.println("실행");
//        AwsBasicCredentials credentials = AwsBasicCredentials.create("AKIAQQO4D7BZJWUDUQV6", "KUIrngX+ZaVPSRBuXTB9SzWkVRQhWYH9iLmu3pLU");
//        AmazonDynamoDBClient client = new AmazonDynamoDBClient(credentials).withRegion(Regions.US_EAST_1);

        Ec2Client ec2 = Ec2Client.builder()
                .region(region)
                .build();



        describeEC2Instances(ec2);
        //ec2.close();

//        Scanner menu = new Scanner(System.in);
//        Scanner id_string = new Scanner(System.in);
        int number = 0;
//        while (true) {
//            System.out.println("                                                            ");
//            System.out.println("                                                            ");
//            System.out.println("------------------------------------------------------------");
//            System.out.println("           Amazon AWS Control Panel using SDK               ");
//            System.out.println("                                                            ");
//            System.out.println("  Cloud Computing, Computer Science Department              ");
//            System.out.println("                           at ChungbukNational University  ");
//            System.out.println("------------------------------------------------------------");
//            System.out.println("  1. list instance                2. available zones         ");
//            System.out.println("  3. start instance               4. available regions      ");
//            System.out.println("  5. stop instance                6. create instance        ");
//            System.out.println("  7. reboot instance              8. list images            ");
//            System.out.println("                                 99. quit                   ");
//            System.out.println("------------------------------------------------------------");
//            System.out.print("Enter an integer: ");
//
//            switch (number) {
//                case 1:
//                    describeEC2Instances(ec2);
//                    break;
//            }
//        }

        //describeEC2Instances(ec2);
    }

/*

*/
/**
public class awsTest {
    /**
     * Cloud Computing, Data Computing Laboratory* Department of Computer Science * ChungbukNational University
     *//*

    static AmazonEC2 ec2;

    private static void init() throws Exception {*/
/** The ProfileCredentialsProviderwill return your [default]* credential profile by reading from the credentials file located at* (~/.aws/credentials).*//*

        ProfileCredentialsProvidercredentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. " + "Please make sure that your credentials file is at the correct " + "location (~/.aws/credentials), and is in valid format.", e);
        }
        ec2 = AmazonEC2ClientBuilder.standard().withCredentials(credentialsProvider).withRegion("us-east-2")*/
/* check the region at AWS console *//*
.build();
    }

}

    public static void listInstances() {
        System.out.println("Listing instances....");
        booleandone = false;
        DescribeInstancesRequestrequest = new DescribeInstancesRequest();
        while (!done) {
            DescribeInstancesResultresponse = ec2.describeInstances(request);
            for (Reservation reservation : response.getReservations()) {
                for (Instance instance : reservation.getInstances()) {
                    System.out.printf("[id] %s, " + "[AMI] %s, " + "[type] %s, " + "[state] %10s, " + "[monitoring state] %s", instance.getInstanceId(), instance.getImageId(), instance.getInstanceType(), instance.getState().getName(), instance.getMonitoring().getState());
                }
                System.out.println();
            }
            request.setNextToken(response.getNextToken());
            if (response.getNextToken() == null) {
                done = true;
            }
        }
    }*/

// 현재 인스턴스 목록 조회 메소드 - 위에 주석처리된 listInstances랑 동일
public static void describeEC2Instances( Ec2Client ec2) {

    boolean done = false;
    String nextToken = null;
            System.out.println("                                                            ");
            System.out.println("                                                            ");
            System.out.println("------------------------------------------------------------");
           System.out.println("           Amazon AWS Control Panel using SDK               ");
            System.out.println("                                                            ");
            System.out.println("  Cloud Computing, Computer Science Department              ");
            System.out.println("                           at ChungbukNational University  ");
            System.out.println("------------------------------------------------------------");
            System.out.println("  1. list instance                2. available zones         ");
            System.out.println("  3. start instance               4. available regions      ");
            System.out.println("  5. stop instance                6. create instance        ");
            System.out.println("  7. reboot instance              8. list images            ");
            System.out.println("                                 99. quit                   ");
            System.out.println("------------------------------------------------------------");
            System.out.print("Enter an integer: ");

    try {

        do {
            DescribeInstancesRequest request = DescribeInstancesRequest.builder().maxResults(6).nextToken(nextToken).build();
            DescribeInstancesResponse response = ec2.describeInstances(request);
// instance. 까지 찍으면 나오는 변수들은 많으니 혹시 추가적으로 하실 부분있으면 활용
            for (Reservation reservation : response.reservations()) {
                for (Instance instance : reservation.instances()) {
                    System.out.println("Instance Id is " + instance.instanceId());
                    System.out.println("Image id is " + instance.imageId());
                    System.out.println("Instance type is " + instance.instanceType());
                    System.out.println("Instance state name is " + instance.state().name());
                    System.out.println("monitoring information is " + instance.monitoring().state());

                }
            }
            nextToken = response.nextToken();
        } while (nextToken != null);

    } catch (Ec2Exception e) {
        System.err.println(e.awsErrorDetails().errorMessage());
        System.exit(1);
    }
}

}