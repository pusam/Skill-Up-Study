public class KeyPad
{
    public String solution(int[] numbers, String hand)
    {
        StringBuilder answer = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int number : numbers)
        {
            if (number == 0)
                number = 11;
            switch (number % 3)
            {
                case 0:
                    right = number;
                    answer.append("R");
                    break;
                case 1:
                    left = number;
                    answer.append("L");
                    break;
                case 2:
                    int leftLength = (Math.abs(number - left)) / 3 + (Math.abs(number - left)) % 3;
                    int rightLength = (Math.abs(number - right)) / 3 + (Math.abs(number - right)) % 3;

                    if (leftLength < rightLength)
                    {
                        left = number;
                        answer.append("L");
                        break;
                    }
                    else if (leftLength > rightLength)
                    {
                        right = number;
                        answer.append("R");
                        break;
                    }
                    else
                    {
                        if ("left".equals(hand))
                        {
                            left = number;
                            answer.append("L");
                        }
                        else
                        {
                            right = number;
                            answer.append("R");
                        }
                        break;
                    }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args)
    {
        KeyPad keyPad = new KeyPad();
        //keyPad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        keyPad.solution(new int[]{2, 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
    }
}
