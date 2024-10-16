import java.util.*;
class Credentials{
    static int db_uid,db_pwd;
    static long db_cno;
    static boolean did_signup_done;
    static Scanner sc = new Scanner(System.in);

    public static void signup()throws Exception{
        if(did_signup_done){
            Thread.sleep(2000);
            System.out.println("\t\t\tAccount already exists plz try to login.");
        }else{
            //signup
            System.out.print("Enter user id : ");
            db_uid = sc.nextInt();

            System.out.print("Enter password : ");
            db_pwd = sc.nextInt();

            System.out.print("Enter contact number : ");
            db_cno = sc.nextLong();

            did_signup_done = true;
            System.out.println("\t\t\tProcessing...");
            Thread.sleep(3000);
            System.out.println("\t\t\tAccount created successfully... :)");
        }
    }//end of signup.

    public static void login()throws Exception{
        //login
        if(does_not_exists()){
            System.out.print("Enter userid : ");
        int uid = sc.nextInt();

        System.out.print("Enter password : ");
        int pwd = sc.nextInt();

        if(db_uid == uid && db_pwd == pwd){
            System.out.println("\t\t\tWelcome to Student portal...");
            Thread.sleep(3000);
            boolean flag = true;
            do{
                System.out.println("\t\t\tSelect the features...");
                System.out.println("1.Number Programming\n2.Pattern Programing\n3.Swiggy Project\n4.Exit");
                int input = sc.nextInt();
                switch(input){
                    case 1:{
                        NumberProgramming.NumberProg();
                        break;}
                    case 2:{
                        patternProgramming.patternProg();
                        break;}
                    case 3:{
                        break;}
                    case 4:{
                        flag = false;
                        break;}
                    default:{
                        System.out.println("\t\t\tInvalid selection...");
                    }

                }

            }while(flag);
            System.out.println("\t\t\tRedirecting to Welcome page...");
            Thread.sleep(3000);
        }
        else{
            System.out.println("\t\t\tInvalid login credentials.");
        }
        }
        else{
            System.out.println("\t\t\tCreate an account to login...!");
        }
    }//end of login.

    public static boolean does_not_exists(){
        return did_signup_done;
    }

    public static void forgettenCredentials() throws Exception{
        if(does_not_exists()){
            System.out.println("\t\t\tEnter the registered contact : ");
            long user_cno = sc.nextLong();

            if(db_cno == user_cno){
                System.out.println("\t\t\t Plz wait a few seconds to receice a otp...");
                int sys_otp = (int)(Math.random()*9999+9999);
                System.out.println(sys_otp);

                System.out.print("\t\t\tEnter the otp : ");
                int user_enter_otp = sc.nextInt();

                if(sys_otp == user_enter_otp){
                    System.out.print("\t\t\tEnter the new userid : ");
                    db_uid = sc.nextInt();

                    System.out.println("\t\t\tEnter the new password : ");
                    db_pwd = sc.nextInt();

                    System.out.println("\t\t\tProcessing...");
                    Thread.sleep(3000);
                    System.out.println("\t\t\tAccount was changed successfully...:)");
                    did_signup_done = true;
                }
            }else{
                System.out.println("\t\t\tInvalid contact number...");
            }
        }else{
            System.out.println("\t\t\tYou dont have to access this feature...");
        }
    }
}

class NumberProgramming{
    static Scanner sc = new Scanner(System.in);
    public static void NumberProg() throws Exception{
        boolean flag = true;
        do{
            System.out.println("\t\t\tWelcome to Number Programmings...");
            System.out.println("1.isPrime\n2.isArmstrong\n3.Reverse number\n4.Find factorial\n5.Fibonacci series\n6.isPalindrome\n7.Exit");
            int input = sc.nextInt();
            switch(input){
                case 1:{
                    System.out.print("Enter the number : ");
                    System.out.println((isPrime(sc.nextInt())?"Prime":"Not prime"));
                    Thread.sleep(2000);
                    break;}
                case 2:{
                    System.out.print("Enter the number");
                    System.out.println((isArmstrong(sc.nextInt())?"Armstrong":"Not Armstrong"));
                    Thread.sleep(2000);
                    break;}
                case 3:{
                    System.out.print("Enter the number : ");
                    System.out.println((reverseNumber(sc.nextInt())));
                    Thread.sleep(2000);

                    break;}
                case 4:{
                    System.out.print("Enter the number : ");
                    System.out.println((findFactorial(sc.nextInt())));
                    Thread.sleep(2000);
                    break;}
                /*case 5:{
                    System.out.print("Enter the size : ");
                    System.out.print(fibonacciSeries(sc.nextInt()));
                    break;}*/
                case 6:{
                    System.out.print("Enter the number");
                    System.out.println((isPalindrome(sc.nextInt())?"Palindrome":"Not Palindrome"));
                    Thread.sleep(2000);
                    break;}
                case 7:{
                    flag = false;
                    break;}
                default:{
                    System.out.println("Invalid option...");
                    Thread.sleep(2000);

                }
            }
            
        }while(flag);
        System.out.println("\t\t\tRedirecting...");
        Thread.sleep(3000);
    } 
    public static boolean isPrime(int num){
        if(num == 0 || num == 1){
            return false;
        }
        else{
            for(int i = 2;i<num;i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    public static boolean isArmstrong(int num){
        int rem;
        int sum = 0;
        int temp = num;
        while(num > 0){
            rem = num % 10;
            sum += (rem*rem*rem);
            num/=10;
        }
        if(sum == temp)
            return true;
        else
            return false;
    }
    public static int reverseNumber(int num){
        int rev= 0,rem;
        while(num > 0){
            rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev;
    }
    public static int findFactorial(int num){
        int fact = 1;
        for(int i = 2;i<=num;i++){
            fact = fact * i;
        }
        return fact;
    }
    public static void fibonacciSeries(int size){
        int f1 = 0,f2 = 1,f3;
        while(size > 0){
            f3 = f1 + f2;
            System.out.print(f1 +" ");
            size--;
            f1 = f2;
            f2 = f3;
        }
        
    }
    public static boolean isPalindrome(int num){
        if(num == reverseNumber(num))
            return true;
        else
            return false;
    }


}

class patternProgramming{
    static Scanner sc = new Scanner(System.in);
    public static void patternProg() throws Exception{
        boolean flag = true;
        do{
            Thread.sleep(2000);
            System.out.println("\t\t\tWelcome to pattern programmmig...");
            System.out.println("\t\t\tSelect the Program.");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1.Right half Triangle\n2.Left half Triangle\n3.Triangle\n4.Square\n5.Number triangle\n6.Exit");
            int input = sc.nextInt();
            switch(input){
                case 1:{
                    System.out.print("Enter the size : ");
                    rightHalf(sc.nextInt());
                    Thread.sleep(2000);
                    break;
                }
                case 2:{
                    System.out.print("Enter the size : ");
                    leftHalf(sc.nextInt());
                    Thread.sleep(2000);
                    break;
                }
                case 3:{
                    System.out.print("Enter the size : ");
                    Triangle(sc.nextInt());
                    Thread.sleep(2000);      
                      break;
                }
                case 4:{
                    System.out.print("Enter the size : ");
                    square(sc.nextInt());
                    Thread.sleep(2000);
                    break;
                }
                case 5:{
                    System.out.print("Enter the size : ");
                    numberTriangle(sc.nextInt());
                    Thread.sleep(2000);
                    break;
                }
                case 6:{
                    flag = false;
                    Thread.sleep(2000);
                    break;
                }
                default:{
                    System.out.println("\t\t\tInvalid option...");
                    break;
                }
            }
        }while(flag);
        System.out.println("\t\t\tThank you...!");
        System.out.println("\t\t\tRedirecting to Home");
        Thread.sleep(3000);
    }
    public static void rightHalf(int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i>=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }System.out.println();
        }

    }
    public static void leftHalf(int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i<=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }System.out.println();
        }

    }
    public static void Triangle(int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i<=j && i>=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }System.out.println();
        }

    }
    public static void square(int n){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i==0 || i == n-1 || j==0 || j == n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }System.out.println();
        }

    }
    public static void numberTriangle(int n){
        int k = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i>=j)
                    System.out.print(k++ + " ");
                else
                    System.out.print("  ");
            }System.out.println();
        }

    }
    

}

class Welcome{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        boolean flag = true;
        do{
            System.out.println("\t\t\tStudent Portal..:)");
            System.out.println("------------------------------");
            System.out.println("\t\t\tSelect the feature:");
            System.out.println("1.Signup\n2.Login\n3.Forgotten\n4.Exit.");
            int input = sc.nextInt();
        switch(input){
            case 1:{
                Credentials.signup();
                break;
            }
            case 2:{
                Credentials.login();
                break;
            }
            case 3:{
                Credentials.forgettenCredentials();
                break;
            }
            case 4:{
                flag = false;
                break;
            }
            default:{
                System.out.println("\t\t\tInvalid option...");
                break;
            }
        }

        }while(flag);
        System.out.println("\t\t\tThanks for using application...!");
    }
}       