package Activities;

public class Activity4 {

    public static void main(String args[])
    {
        int inputArray[]={3,6,1,5,9};

        System.out.println("Before sort");
        for (int element : inputArray)

            System.out.print(element + " ");

        for (int i=0;i<inputArray.length;i++)
        {
            for (int j=i+1;j<(inputArray.length-1);j++)
            {
                if(inputArray[i]>inputArray[j])
                {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j];

                    inputArray[j] = temp;
                }
            }
        }

        System.out.println("\nAfter sort");
        for (int element : inputArray)

            System.out.print(element + " ");

    }
}
