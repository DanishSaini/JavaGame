public class Enemies{
    //fields
    private static final String[] ENEMIES = {"Evil Knight", "Bandit", "Golem", "Goblin", };
    private int enemyDamage;
    private int enemyHealth;
    private String enemyName;

    //Constructor
    public Enemies(int enemyDamage, int enemyHealth, String enemyName){
        this.enemyDamage = enemyDamage;
        this.enemyHealth = enemyHealth;
        this.enemyName = enemyName;
    }   

    //Default Constructor
    public Enemies(){
        this((int)(Math.random()*39) + 1 , (int)(Math.random ()*75 + 25), ENEMIES[(int)(3*Math.random())]);
    }

    //Setters
    public void setEnemyDamage(int enemyDamage){
        this.enemyDamage = enemyDamage;
    }

    public void setEnemyHealth(int enemyHealth){
        this.enemyHealth = enemyHealth;
    }
    //We are not setting the name for enemyName, we are just getting a random enemy from the array

    //getters
    public int getEnemyDamage(){
        return enemyDamage;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public String getEnemyName(){
        return enemyName;
    }

}
