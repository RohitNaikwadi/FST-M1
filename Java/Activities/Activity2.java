package Activities;

public class Activity2 {

    public  static void main(String args[])
    {
        int array []={10, 77, 10, 54, -11, 10};
        int temp=0;
        for (int i=0;i<array.length;i++)
        {
            if(array[i]==10)
            {
                temp+=array[i];

            }
        }
if(temp==30) {
    System.out.println(temp);
}
    }
}
