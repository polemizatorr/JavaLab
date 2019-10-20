import java.util.ArrayList;
import java.util.List;
public class Calculator implements ICalc
{
    @Override
    public double Calculate(String input)
    {
        double value;
        int i, j, ops = 0;

        for (i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'|| input.charAt(i) == '/') ops++;
        }

        String str = "";
        List<String> numbers = new ArrayList<>();
        List<Double> Double_numbers = new ArrayList<>();
        char[] operators = new char[ops + 1];

        j = 0;
        for (i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '*' && input.charAt(i) != '/')
            {
                str += input.charAt(i);
            }
            else
            {
                numbers.add(str);
                str = "";
                operators[j++] = input.charAt(i);
            }
        }
        numbers.add(str);

        for (String z: numbers)
        {
            Double_numbers.add(Double.parseDouble(z));
        }

        System.out.println("Strings list: " + numbers);
        System.out.println("Doubles list: " + Double_numbers);
        System.out.println(operators);

        i = 0; j = 1;
        value = Double_numbers.get(0);
        for (i = 0; i <= ops; i++) // ops is array length
        {
            if (operators[i] == '+') value += Double_numbers.get(j++);
            else if (operators[i] == '-') value -= Double_numbers.get(j++);
            else if (operators[i] == '*') value *= Double_numbers.get(j++); // no math operations order implemented
            else if (operators[i] == '/') value /= Double_numbers.get(j++); // no math operations order implemented

        }

        return value;
    }
}
