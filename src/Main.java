import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence ;
    public static int [] heroesHealth ={270, 280, 250, 300};
    public static int [] heroesDamage ={10, 15, 20, 0};
    public static String [] heroesAttackType ={"Physical", "Magical", "Kinetic", "Medic"};

    public static int roundNumber;


    public static void main(String[] args) {
       printStatistics();
       while (!isGameOver()){
         playRound();
}
    }
    public static void playRound(){
        roundNumber ++;
        chooseBossDefence();
        bossHits();
        heroesHits();
        medic();

        printStatistics();


    }
    public static void  chooseBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
    }
    public static void bossHits(){
        for (int i = 0; i < heroesHealth.length; i++) {
            if(heroesHealth[i] >0  ) {
                heroesHealth[i] = heroesHealth[i] - bossDamage;
                if(heroesHealth[i] < 0){
                    heroesHealth[i] = 0;
                }
            }
        }
    }
    public static void heroesHits(){
        for (int i = 0; i < heroesDamage.length; i++) {
            if(heroesHealth[i] > 0 && bossHealth >0) {
                int damage = heroesDamage[i];
                if(bossDefence == heroesAttackType[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9 ) + 2;
                    damage = heroesDamage[i] * coeff;
                    System.out.println("Critical damage" + damage);
                }
                bossHealth -= damage;
                if (bossHealth <0){
                    bossHealth = 0;
                }
            }
        }
    }
    public static boolean isGameOver(){
        if (bossHealth <=0){
            System.out.println("Heroes won");
            return true;

        }

//        if (heroesHealth[0]<= 0 && heroesHealth[1] <=0 && heroesHealth [2] <=0){
//            System.out.println("Boss won!!!");
//            return true;
//        }
//        return false;
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if(heroesHealth[i] >0){
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead){
            System.out.println("Boss won!!! ");
        }
          return allHeroesDead;
    }
    public static void printStatistics(){
        System.out.println("ROUND " + roundNumber + "----------------");
        String defence;
        if (bossDefence == null){
            defence = "No defence";
        }else {
            defence = bossDefence;
        }
        System.out.println(" Boss health:" + bossHealth + " Damage:" + bossDamage  +
                " Boss defence:" + defence);
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType [i] + " health:" + heroesHealth [i] + " Damage:" + heroesDamage[i]);

        }

    }
    private static void  medic(){
        for (int i = 0; i < heroesHealth.length; i++) {
            Random random1 = new Random();
            if (heroesHealth[i] >0 && heroesHealth[i] <100 && heroesHealth[3] >0){
                heroesHealth[i] = random1.nextInt(10)+ heroesHealth[i];
                break;
            } else if (heroesHealth[i] <= 0 && heroesHealth[3] <=0 && i == 3){
                boolean random = false;
            }

        }

    }
}