import java.util.Random;
import java.util.Scanner;

public class Safari 
{
    @SuppressWarnings({"StringEquality", "UnusedAssignment"})
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int event, eventCount, points = 0, area, dayPoints = 0, life = 5;
        String areaString;
        boolean survive = false;

        System.out.println("🌄 Welcome to Safari Adventure!");
        System.out.println("");
    
        for (int day = 1; day <= 5; day++)
        {
            System.out.println("Day " + day + ":");
            
            do
            {
                System.out.println("Where would you like to explore? (1 = Jungle, 2 = River, 3 = Desert, 4 = Mountains): ");
                area = scanner.nextInt();
                scanner.nextLine();
                if (area < 1 || area > 4)
                {
                    System.out.println("Invalid area. Please choose again.");
                }
            }
            while (area < 1 || area > 4);

            switch (area)
            {
                case 1:
                    areaString = "Jungle";
                    System.out.println("Exploring " + areaString + "...");
                    break;
                case 2:
                    areaString = "River";
                    System.out.println("Exploring " + areaString + "...");
                    break;
                case 3:
                    areaString = "Desert";
                    System.out.println("Exploring " + areaString + "...");
                    break;
                case 4:
                    areaString = "Mountains";
                    System.out.println("Exploring " + areaString + "...");
                    break;
                default:
                    System.out.println("Invalid area. Please choose again");
            }

            eventCount = 1;
            while (eventCount <= 3)
            {
                dayPoints = 0;
                event = rand.nextInt(5);
                System.out.print("Event " + eventCount + ":");

                if (event == 0)
                {
                    System.out.println("You spotted a bird. 🐦");
                    System.out.println("(Too small to track. Moving on.)");
                    eventCount++;
                    continue;
                }
                else if (event == 1)
                {
                    System.out.println("You found edible berries! (+ 15 points)");
                    dayPoints += 15;
                    eventCount++;
                    continue;
                }
                else if (event == 2)
                {
                    System.out.println("A strom approaches, where will you hide? (1 = Tree, 2 = Cave, 3 = None): ");
                    int hidingSpot = scanner.nextInt();
                    if (hidingSpot == 1)
                    {
                        int lightning = rand.nextInt(11);
                        if (lightning == 7)
                        {
                            System.out.println("Luck is on your side, you weathered the storm. (+50 points)");
                            dayPoints += 50;
                            eventCount++;
                            continue;
                        }
                        else
                        {
                            System.out.println("You were struck by lightning. (-10 points)");
                            dayPoints -= 10;
                            life -= 1;
                            break;
                        }
                    }
                    if (hidingSpot == 2)
                    {
                        System.out.println("The cave stinks of death and the air inside feels tense, but nonetheless you avoid the storm. (+10 points)");
                        dayPoints += 10;
                        eventCount++;
                        continue;
                    }
                    if (hidingSpot == 3)
                    {
                        int death = rand.nextInt(101);
                        if (death == 77)
                        {
                            System.out.println("Despite it all, you are still standing. (+100 points)");
                            dayPoints += 100;
                            survive = true;
                            eventCount++;
                            continue;
                        }
                        if (death == 25)
                        {
                            System.out.println("As rain poured down, the tree tried to shade you as much as it could. However you became drenched and cold. Leaving you defenseless for what is to come. (-10 points)");
                            dayPoints -= 10;
                            life -= 1;
                            break;
                        }
                        if (death == 50)
                        {
                            System.out.println("As you waited, you unknowingly began to slowly sink. Following the storm, you had to dig yourself out, ruining a lot of your resources. (-25 points)");
                            dayPoints -= 25;
                            life -= 1;
                            break;
                        }
                        if (death == 100)
                        {
                            System.out.println("You were struck by lightning. (-10 points)");
                            dayPoints -= 10;
                            life -= 1;
                            break;
                        }
                    }
                }
                else if (event == 3)
                {
                    System.out.println("A crocodile appears! 😱");
                    System.err.println("Type 'run' to escape: ");
                    String str1 = "run";
                    String str2 = scanner.nextLine();
                    if (str1 == str2)
                    {
                        System.out.println("You escaped safely, ending the day early.");
                        survive = true;
                        break;
                    }
                    else
                    {
                        System.out.println("You couldn't escape! The crocodile took a big bite out of you! (-25 points)");
                        dayPoints -= 25;
                        life -= 1;
                        break;
                    }
                }
                else if (event == 4)
                {
                    System.out.println("A lion appears! 🦁");
                    System.out.println("Type 1 to escape or 2 to gamble your life away: ");
                    int runOrFight = scanner.nextInt();
                    scanner.nextLine();
                    if (runOrFight == 1)
                    {
                        System.out.println("You escaped safely, ending the day early.");
                        break;
                    }
                    else if (runOrFight == 2)
                    {
                        int lionSurvive = rand.nextInt(2);
                        if (lionSurvive == 0)
                        {
                            System.out.println("This was not how you expected your day to go, beating a lion back with nothing but your hands and the resources in your bad, nonetheless you manage to survive the lions attack but not without you losing yourself in the process. (+50 points)");
                            dayPoints += 50;
                            break;
                        }
                        else
                        {
                            System.out.println("While it felt like hours as the lion clawed and bit at your body before you passed out from blood loss. You wake up the next day, mangled but still able to explore.");
                            life -= 1;
                            break;
                        }
                    }
                }
                points += dayPoints;
            }
            System.out.println("Day Summary: " + dayPoints + " points earned.");
            points += dayPoints;
        }
        if (points >= 65)
        {
        System.out.println("🎉 Safari Complete! You collected " + points + " points!");
        System.out.println("You survived and completed the adventure!");
        }
        else
        {
            if (life < 1)
            {
                System.out.println("Safari Failed. You collected " + points + " points.");
                System.out.println("You did not survive.");
            }
            else
            {
                survive = true;
                System.out.println("Safari Failed. You collected " + points + " points.");
                System.out.println("You survived but failed to complete the adventure");
            }
        }
    }
}

